package com.zgt.project.my.pizza;

import com.zgt.project.my.pizza.entitys.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping(value = "/pizza_home")
@Scope("session")
public class PizzaController {

    @Autowired
    PizzaService service;

    private UserEntity user;


    @RequestMapping(value = "/singin", method = RequestMethod.POST)
    public String singin(@ModelAttribute(value = "singin") Singin singin, HttpServletRequest request, Model model, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()){
        }
        try {
            request.login(singin.getLogin(),singin.getPassword());

        } catch (ServletException e) {
            e.printStackTrace();
            System.out.println("ОШИБКА ВХ0ДА");
        }
        if (request.isUserInRole("ROLE_ADMIN")) {
            user = service.getUserById(1);
            model.addAttribute("user", user);
        }
        return "redirect:/pizza_home";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request)
    {
        try {
            request.logout();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        user=null;
        return "redirect:/pizza_home";
    }

    @RequestMapping({"",})
    public String startPage( Map<String, Object> model){
        model.put("itemPizza", service.getPizzaList());
        model.put("itemDrink", service.getDrinkList());
        model.put("cashFromCart",service.cashFromCart());
        if (user!=null)
            model.put("user",user);
        else {
            model.put("singin",new Singin());
        }

        return "pizzaMain";
    }

    @RequestMapping("/get_order")
    public String orderPage(Model model)
    {
        model.addAttribute("orderItems",service.getItemList());
        if (user!=null)
            model.addAttribute("user",user);
        return "pizzaOrder";
    }

    @RequestMapping(value = "/payment")
    public String paymentPage(Model model){


        model.addAttribute("user",service.getUser());

        return "pizzaPayment";
    }

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public String addUserDetails(@Valid UserEntity user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors())
        {
            System.out.println("KEK");
        }
        service.setUser(user);
        model.addAttribute("user", user);
        service.ZeroCash();
        return  "pizzaFinish";
    }

    @RequestMapping(value = "/finish")
    public String finishPage(Model model){
        System.out.println(service.getUser().getFirstName()+" : USER NAME");
        return "pizzaFinish";
    }
	
	@RequestMapping(value = "/drinks")
    public String drinks(Model model){
        return "pizza_home";
	}

}