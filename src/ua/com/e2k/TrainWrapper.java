package ua.com.e2k;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Created by User on 26.10.2016.
 */
@XmlRootElement(name = "trains")
public class TrainWrapper {

    private Saver saver;
    @XmlElement(name = "train")
    private ArrayList<Train> trains = new ArrayList<>();


    public TrainWrapper() {
    }

    public TrainWrapper(Saver saver)
    {
        this.saver=saver;
        trains = saver.load().trains;
    }

    public void addTrain(Train train)
    {
        trains.add(train);
        saver.save(this);

    }

    public void addNewTrain(int id, String from, String to, LocalDate date, LocalTime departure)
    {

        trains.add(new Train(id, from, to, date, departure));
        saver.save(this);
    }

    public void showTrainsTodayInInterval(LocalTime min, LocalTime max)
    {
//        Выведем все поезда отправляющиеся сегодня из заданного диапазона
        for (Train train: trains) {
            if (train.getDate().equals(LocalDate.now()))
            if (train.getDeparture().isAfter(min)&&train.getDeparture().isBefore(max)) System.out.println(train);

        }
    }

    @Override
    public String toString() {
        String result="";
        for (Train train: trains) {
            result+=train+System.lineSeparator();
        }


        return result;
    }



}
