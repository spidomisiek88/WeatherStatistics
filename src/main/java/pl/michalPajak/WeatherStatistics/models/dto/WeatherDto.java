package pl.michalPajak.WeatherStatistics.models.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class WeatherDto {
    private String cityName;
    private Integer temperature;
    private Integer humidity;
    private LocalDateTime localDateTime;

    public WeatherDto() {
        this.cityName = "";
        this.temperature = null;
        this.humidity = null;
        this.localDateTime = LocalDateTime.now();
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

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeatherDto)) return false;
        WeatherDto that = (WeatherDto) o;
        return getCityName().equals(that.getCityName()) &&
                getTemperature().equals(that.getTemperature()) &&
                getHumidity().equals(that.getHumidity()) &&
                getLocalDateTime().equals(that.getLocalDateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCityName(), getTemperature(), getHumidity(), getLocalDateTime());
    }

    @Override
    public String toString() {
        return "WeatherDto{" +
                "cityName='" + cityName + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
