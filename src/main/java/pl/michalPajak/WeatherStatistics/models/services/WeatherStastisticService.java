package pl.michalPajak.WeatherStatistics.models.services;

import org.springframework.stereotype.Service;
import pl.michalPajak.WeatherStatistics.models.dto.WeatherDto;

import javax.swing.text.html.parser.Entity;
import java.util.*;

@Service
public class WeatherStastisticService {

    private Map<String, Double> averageTemperaturesForCities;
    private Map<String, Double> averageHumidityForCities;

    public WeatherStastisticService() {
        this.averageTemperaturesForCities = new HashMap<>();
        this.averageHumidityForCities = new HashMap<>();
    }

    public Map<String, Double> getAverageTemperaturesForCities() {
        return averageTemperaturesForCities;
    }

    public void setAverageTemperaturesForCities(Map<String, Double> averageTemperaturesForCities) {
        this.averageTemperaturesForCities = averageTemperaturesForCities;
    }

    public Map<String, Double> getAverageHumidityForCities() {
        return averageHumidityForCities;
    }

    public void setAverageHumidityForCities(Map<String, Double> averageHumidityForCities) {
        this.averageHumidityForCities = averageHumidityForCities;
    }

    public void addDataToStatistic(List<WeatherDto> data) {

        String cityName = data.get(0).getCityName();

        averageTemperaturesForCities.put(cityName, calculationAverageTemperature(data));
        averageHumidityForCities.put(cityName, calculationAverageHumidity(data));
    }

    private double calculationAverageTemperature(List<WeatherDto> data) {
        double result = 0;

        for (WeatherDto weather : data) {
            result += weather.getTemperature();
        }

        result /= data.size();

        return result;
    }

    private double calculationAverageHumidity(List<WeatherDto> data) {
        double result = 0;

        for (WeatherDto weather : data) {
            result += weather.getHumidity();
        }

        result /= data.size();

        return result;
    }

    public Map.Entry<String, Double> findTheHighestAverageTemperature() {

        Map.Entry<String, Double> highestAverageTemperature = null;

        for (Map.Entry<String, Double> entry : averageTemperaturesForCities.entrySet()) {
            if (highestAverageTemperature == null)
                highestAverageTemperature = entry;
            else if (highestAverageTemperature.getValue() < entry.getValue())
                highestAverageTemperature = entry;
        }

        return highestAverageTemperature;
    }

    public  Map.Entry<String, Double>  findTheLowermostAverageTemperature() {

        Map.Entry<String, Double> highestAverageTemperature = null;

        for (Map.Entry<String, Double> entry : averageTemperaturesForCities.entrySet()) {
            if (highestAverageTemperature == null)
                highestAverageTemperature = entry;
            else if (highestAverageTemperature.getValue() > entry.getValue())
                highestAverageTemperature = entry;
        }

        return highestAverageTemperature;
    }

    public Map.Entry<String, Double> findTheHighestAverageHumidity() {

        Map.Entry<String, Double> highestAverageHumidity = null;

        for (Map.Entry<String, Double> entry : averageHumidityForCities.entrySet()) {
            if (highestAverageHumidity == null)
                highestAverageHumidity = entry;
            else if (highestAverageHumidity.getValue() < entry.getValue())
                highestAverageHumidity = entry;
        }

        return highestAverageHumidity;
    }

    public  Map.Entry<String, Double>  findTheLowermostAverageHumidity() {

        Map.Entry<String, Double> highestAverageHumidity = null;

        for (Map.Entry<String, Double> entry : averageHumidityForCities.entrySet()) {
            if (highestAverageHumidity == null)
                highestAverageHumidity = entry;
            else if (highestAverageHumidity.getValue() > entry.getValue())
                highestAverageHumidity = entry;
        }

        return highestAverageHumidity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeatherStastisticService)) return false;
        WeatherStastisticService that = (WeatherStastisticService) o;
        return getAverageTemperaturesForCities().equals(that.getAverageTemperaturesForCities()) &&
                getAverageHumidityForCities().equals(that.getAverageHumidityForCities());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAverageTemperaturesForCities(), getAverageHumidityForCities());
    }

    @Override
    public String toString() {
        return "WeatherStastisticService{" +
                "averageTemperaturesForCities=" + averageTemperaturesForCities +
                ", averageHumidityForCities=" + averageHumidityForCities +
                '}';
    }
}
