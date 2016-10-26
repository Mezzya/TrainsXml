package ua.com.e2k;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.sql.Time;
import java.time.LocalTime;

/**
 * Created by User on 26.10.2016.
 */
public class TrainTimeAdapter extends XmlAdapter<String,LocalTime> {
    @Override
    public LocalTime unmarshal(String v) throws Exception {

        LocalTime time = LocalTime.parse(v);

        return time;
    }

    @Override
    public String marshal(LocalTime v) throws Exception {

        return v.toString();
    }
}
