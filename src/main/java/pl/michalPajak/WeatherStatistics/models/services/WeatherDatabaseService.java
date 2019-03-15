package pl.michalPajak.WeatherStatistics.models.services;

import org.springframework.stereotype.Service;
import pl.michalPajak.WeatherStatistics.models.dto.WeatherDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class WeatherDatabaseService {

    private List<WeatherDto> weatherDtoList;

    public WeatherDatabaseService() {
        this.weatherDtoList = new ArrayList<>();
    }

    public List<WeatherDto> getWeatherDtoList() {
        return weatherDtoList;
    }

    public void setWeatherDtoList(List<WeatherDto> weatherDtoList) {
        this.weatherDtoList = weatherDtoList;
    }

    public void addNewWeatherToList(WeatherDto weatherDto) {
        weatherDtoList.add(weatherDto);
    }

    public void removeWeatherFromList(WeatherDto weatherDto) {
        this.weatherDtoList.remove(weatherDto);
    }

    public WeatherDto findTheHighestTemperature() {
        WeatherDto findetWeatherDto = null;
        for (WeatherDto element : weatherDtoList) {
            if (findetWeatherDto == null)
                findetWeatherDto = element;
            else if (findetWeatherDto.getTemperature() < element.getTemperature())
                findetWeatherDto = element;
        }

        return findetWeatherDto;
    }

    public WeatherDto findTheHighestHumidity() {
        WeatherDto findetWeatherDto = null;
        for (WeatherDto element : weatherDtoList) {
            if (findetWeatherDto == null)
                findetWeatherDto = element;
            else if (findetWeatherDto.getHumidity() < element.getHumidity())
                findetWeatherDto = element;
        }

        return findetWeatherDto;
    }

    public WeatherDto findTheLowermostTemperature() {
        WeatherDto findetWeatherDto = null;
        for (WeatherDto element : weatherDtoList) {
            if (findetWeatherDto == null)
                findetWeatherDto = element;
            else if (findetWeatherDto.getTemperature() > element.getTemperature())
                findetWeatherDto = element;
        }

        return findetWeatherDto;
    }

    private List<WeatherDto> findAllCitysByName(String cityName) {
        List<WeatherDto> findetCitys = new ArrayList<>();

        for (WeatherDto element : weatherDtoList) {
            if (cityName.equals(element.getCityName()))
                findetCitys.add(element);
        }

        return findetCitys;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeatherDatabaseService)) return false;
        WeatherDatabaseService that = (WeatherDatabaseService) o;
        return getWeatherDtoList().equals(that.getWeatherDtoList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWeatherDtoList());
    }

    @Override
    public String toString() {
        return "WeatherStastisticService{" +
                "weatherDtoList=" + weatherDtoList +
                '}';
    }
}
