package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Station extends Model
{
    public String title;

    public Station (String title)
    {
        this.title = title;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();


    public List<Reading> getReadings()
    {
        return readings;
    }

    private Reading latestReading() {
        if (readings.size() > 0) {
            return readings.get(readings.size() - 1);
        } else {
            return new Reading(0,0,0,0,0);
        }
    }
    public int latestCode()
    {
        return latestReading().getReadingCode();
    }

    public String latestWeatherCode()
    {
        return latestReading().getWeatherCode();
    }
    public double latestTemperature()
    {
        return latestReading().getReadingTemperature();
    }
    public double latestFahrenheit()
    {
        return latestReading().getReadingFahrenheit();
    }

    public double latestWindSpeed()
    {
        return latestReading().getReadingWindSpeed();
    }
    public int latestBeaufort()
    {
        return latestReading().getBeaufort();
    }
    public String latestWindDirectionCompass()
    {
        return latestReading().getWindDirectionCompass();
    }
    public double latestWindChill()
    {
        return latestReading().getWindChill();
    }
    public int latestPressure()
    {
        return latestReading().getReadingPressure();
    }
}