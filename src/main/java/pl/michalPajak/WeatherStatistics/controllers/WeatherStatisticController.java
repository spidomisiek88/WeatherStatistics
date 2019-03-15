package pl.michalPajak.WeatherStatistics.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.michalPajak.WeatherStatistics.models.AddWeatherDataForm;
import pl.michalPajak.WeatherStatistics.models.services.WeatherDatabaseService;
import pl.michalPajak.WeatherStatistics.models.services.WeatherStastisticService;

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

    @PostMapping("/weather/add")
    public String addWeatherDataForm(@ModelAttribute AddWeatherDataForm weatherDataForm) {

        return "add_weather_data_form";
    }
}
