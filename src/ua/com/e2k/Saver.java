package ua.com.e2k;

/**
 * Created by User on 26.10.2016.
 */
public interface Saver {

    public void save(TrainWrapper tw);
    TrainWrapper load();
}
