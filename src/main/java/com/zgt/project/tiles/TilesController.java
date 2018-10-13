package com.zgt.project.tiles;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/tiles")
public class TilesController {

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        return "home1";
    }

    @RequestMapping(value = { "/products"}, method = RequestMethod.GET)
    public String productsPage(ModelMap model) {
        return "products1";
    }

    @RequestMapping(value = { "/contactus"}, method = RequestMethod.GET)
    public String contactUsPage(ModelMap model) {
        return "contactus1";
    }
}
