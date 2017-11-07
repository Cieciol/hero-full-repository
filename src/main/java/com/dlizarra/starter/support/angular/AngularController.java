package com.dlizarra.starter.support.angular;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//enabling reload of the sites in angular
@Controller
public class AngularController {

    @RequestMapping(value = {
            "/dashboard",
            "/heroes"
            //"/heroes/*"
    })
    public String getAngularSite(){
        return "index.html";
    }


}
