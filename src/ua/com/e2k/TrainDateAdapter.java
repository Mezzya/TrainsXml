package ua.com.e2k;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by User on 26.10.2016.
 */
public class TrainDateAdapter extends XmlAdapter<String,LocalDate> {
    @Override
    public LocalDate unmarshal(String v) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDate = LocalDate.parse(v, dtf);

        return localDate;
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        return v.getDayOfMonth()+"."+v.getMonthValue()+"."+v.getYear();
    }
}
