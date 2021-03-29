package com.example.controllers;

import com.example.model.Customer;
import com.example.service.CustomerServiceImplement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class HomeController {
    private CustomerServiceImplement customerService = new CustomerServiceImplement();
    @GetMapping("/")
    public String home(Model model){
        List customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "home";
    }

    @GetMapping("/customer/create")
    public String create(Model model){
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/customer/save")
    public String save(Customer customer) {
        customer.setId((int)(Math.random() * 10000));
        customerService.save(customer);
        return "redirect:/";
    }

    @GetMapping("/customer/{id}/edit")
    public String edit(@PathVariable("id") int id,Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "edit";
    }
    @PostMapping("/customer/update")
    public String update(Customer customer){
        customerService.update(customer.getId(),customer);
        return "redirect:/";
    }
    @GetMapping("customer/{id}/delete")
    public String delete(@PathVariable("id")int id){
        customerService.remove(id);
        return "redirect:/";
    }
}
