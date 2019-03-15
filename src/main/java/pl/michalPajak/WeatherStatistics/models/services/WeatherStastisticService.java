package pl.michalPajak.WeatherStatistics.models.services;

import org.springframework.stereotype.Service;
import pl.michalPajak.WeatherStatistics.models.dto.WeatherDto;

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
        List<Integer> temperatureList = new ArrayList<>();

        for (WeatherDto weather : data) {
            temperatureList.add(weather.getTemperature());
        }

        return calculationAverage(temperatureList);
    }

    private double calculationAverageHumidity(List<WeatherDto> data) {
        List<Integer> humidityList = new ArrayList<>();

        for (WeatherDto weather : data) {
            humidityList.add(weather.getHumidity());
        }

        return calculationAverage(humidityList);
    }

    private double calculationAverage(List<Integer> calculationData) {
        double result = 0;

        for (Integer element : calculationData) {
            result += element;
        }

         result /= calculationData.size();

        return result;
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
