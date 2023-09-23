package com.codingdojo.date_time.date_time;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerDateTime {
    
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/date")
    public String date(Model model) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd 'of' MMMM , yyyy");
        String FormatDate = dateFormat.format(date);
        model.addAttribute("currentDate", FormatDate);
        return "date";
    } 

    @GetMapping("/time")
    public String time(Model model) {
        LocalTime time = LocalTime.now();
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm a");
        String FormatTime = time.format(timeFormat);
        model.addAttribute("currentTime", FormatTime);
        return "time";
    }
}
