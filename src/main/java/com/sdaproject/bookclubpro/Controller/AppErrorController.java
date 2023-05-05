package com.sdaproject.bookclubpro.Controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppErrorController implements ErrorController {

    @RequestMapping("/errorFound")
    public String errorPage(@ModelAttribute("ex") Exception ex, Model model) {

        model.addAttribute("ex", ex);

        return "error_page.html";
    }

    @RequestMapping("/error")
    public String errorPage2(Model model) {

        Exception ex = new Exception("ERROR 404 found");

        model.addAttribute("ex", ex);

        return "error_page.html";
    }

}
