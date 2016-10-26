package ua.com.e2k;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by User on 26.10.2016.
 */
@XmlRootElement(name = "train")
public class Train {
    @XmlAttribute
    private int id;
    @XmlElement
    private String from;
    @XmlElement
    private String to;
    @XmlElement
    @XmlJavaTypeAdapter(TrainDateAdapter.class)
    private LocalDate date;
    @XmlElement
    @XmlJavaTypeAdapter(TrainTimeAdapter.class)
    private LocalTime departure;

    public Train() {
    }

    public Train(int id, String from, String to, LocalDate date, LocalTime departure) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.date = date;
        this.departure = departure;
    }

    public int getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getDeparture() {
        return departure;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date='" + date + '\'' +
                ", departure='" + departure + '\'' +
                '}';
    }
}
