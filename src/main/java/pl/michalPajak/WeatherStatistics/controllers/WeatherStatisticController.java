package pl.michalPajak.WeatherStatistics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.michalPajak.WeatherStatistics.models.AddWeatherDataForm;

@Controller
public class WeatherStatisticController {

    @GetMapping("/weather/view")
    public String showWeatherStaticticView(Model model) {

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
