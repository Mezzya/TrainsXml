package ua.com.e2k;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by User on 26.10.2016.
 */
public class SaverXML implements Saver {
    @Override
    public void save(TrainWrapper tw) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(tw.getClass());

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(tw,new File("d:\\temp\\trains.xml"));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public TrainWrapper load() {
        TrainWrapper trainWrapper = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(TrainWrapper.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            trainWrapper = (TrainWrapper) unmarshaller.unmarshal(new File("d:\\temp\\trains.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return (trainWrapper!=null)?trainWrapper:null;
    }
}
