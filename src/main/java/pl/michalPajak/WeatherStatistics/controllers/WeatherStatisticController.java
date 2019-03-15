package pl.michalPajak.WeatherStatistics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.michalPajak.WeatherStatistics.models.AddWeatherDataForm;

@Controller
public class WeatherStatisticController {

    @GetMapping("/weatherStatisticView")
    public String showWeatherStaticticView(Model model) {

        return "weatherStatisticView";
    }

    @GetMapping("/addWeatherDataForm")
    public String showAddWeatherDataForm(Model model) {

        model.addAttribute("addWeatherDataForm", new AddWeatherDataForm());

        return "addWeatherDataForm";
    }

    @PostMapping("/addWeatherDataForm")
    public String addWeatherDataForm(@ModelAttribute AddWeatherDataForm weatherDataForm) {

        return "addWeatherDataForm";
    }
}
