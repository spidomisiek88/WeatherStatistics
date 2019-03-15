package pl.michalPajak.WeatherStatistics.models;

import java.util.Objects;

public class AddWeatherDataForm {
    private String cityName;
    private Integer temperature;
    private Integer humidity;

    public AddWeatherDataForm() {
        this.cityName = "";
        this.temperature = null;
        this.humidity = null;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddWeatherDataForm)) return false;
        AddWeatherDataForm that = (AddWeatherDataForm) o;
        return getCityName().equals(that.getCityName()) &&
                getTemperature().equals(that.getTemperature()) &&
                getHumidity().equals(that.getHumidity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCityName(), getTemperature(), getHumidity());
    }

    @Override
    public String toString() {
        return "AddWeatherDataForm{" +
                "cityName='" + cityName + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                '}';
    }
}
