package ua.com.e2k;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
	// write your code here


        SaverXML saverXML = new SaverXML();
        TrainWrapper tw = new TrainWrapper(saverXML);
        System.out.println(tw);


//        Так можно добавлять поезда
//        tw.addNewTrain(2,"Kiev", "Poltava", LocalDate.of(2016,12,26),LocalTime.of(11,15));

        System.out.println("Сегодняшние поезда отправляющиеся с 10:00 - 14:00");
        tw.showTrainsTodayInInterval(LocalTime.of(10,00),LocalTime.of(14,00));



    }
}
