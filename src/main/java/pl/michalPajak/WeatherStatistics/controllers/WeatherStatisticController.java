package pl.michalPajak.WeatherStatistics.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.michalPajak.WeatherStatistics.models.AddWeatherDataForm;
import pl.michalPajak.WeatherStatistics.models.dto.WeatherDto;
import pl.michalPajak.WeatherStatistics.models.services.WeatherDatabaseService;
import pl.michalPajak.WeatherStatistics.models.services.WeatherStastisticService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class WeatherStatisticController {

    @Autowired
    WeatherDatabaseService weatherDatabaseService;
    @Autowired
    WeatherStastisticService weatherStastisticService;

    @GetMapping("/weather/view")
    public String showWeatherStaticticView(Model model) {

        weatherStastisticService.addDataToStatistic(weatherDatabaseService.getWeatherDtoList());

        model.addAttribute("theHighestTemperature", weatherDatabaseService.findTheHighestTemperature());
        model.addAttribute("theLowermostTemperature", weatherDatabaseService.findTheLowermostTemperature());
        model.addAttribute("theHighestHumidity", weatherDatabaseService.findTheHighestHumidity());
        model.addAttribute("averageTemperaturesForCities", weatherStastisticService.findTheHighestAverageTemperature());
        model.addAttribute("averageHumidityForCities", weatherStastisticService.findTheHighestAverageHumidity());

        return "weather_statistic_view";
    }

    @GetMapping("/weather/add")
    public String showAddWeatherDataForm(Model model) {

        model.addAttribute("addWeatherDataForm", new AddWeatherDataForm());

        return "add_weather_data_form";
    }

    @GetMapping("/weather/reset")
    public String resetAllWeatherData(Model model) {

        weatherDatabaseService.resetWeatherDatabase();

        return "redirect:/weather/view";
    }

    @GetMapping("/weather/sample")
    public String sampleWeatherData(Model model) {
        List<WeatherDto> sampleWeatherDtoList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            sampleWeatherDtoList.add(new WeatherDto(Integer.toString(ThreadLocalRandom.current().nextInt(5)),
                    ThreadLocalRandom.current().nextInt(-60,60),
                    ThreadLocalRandom.current().nextInt(0,100), LocalDateTime.now()));
        }

        weatherDatabaseService.setWeatherDtoList(sampleWeatherDtoList);

        return "redirect:/weather/view";
    }

    @PostMapping("/weather/add")
    public String addWeatherDataForm(@ModelAttribute AddWeatherDataForm weatherDataForm) {

        WeatherDto newWeather = new WeatherDto();
        newWeather.setCityName(weatherDataForm.getCityName());
        newWeather.setTemperature(weatherDataForm.getTemperature());
        newWeather.setHumidity(weatherDataForm.getHumidity());
        newWeather.setLocalDateTime(LocalDateTime.now());

        weatherDatabaseService.addNewWeatherToList(newWeather);

        return "redirect:/weather/add";
    }
}
