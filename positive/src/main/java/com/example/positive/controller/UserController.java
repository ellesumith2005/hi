package com.example.positive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.positive.model.Users;
import com.example.positive.repository.UserRepository;

@Controller
public class UserController {
@Autowired
UserRepository ur;


@GetMapping("/update")
public String updatePage(){
    return "update";
}
@PostMapping("/verify-password")
public String verifyCredentials(String username,String password,Model model)
{
    Users user = this.ur.findByusername(username);
    if(user!=null && user.getPassword().equals(password))
{
    model.addAttribute("username",user.getName());
    model.addAttribute("email",user.getEmail());
    return "updateDetails";
}
else{
    model.addAttribute("errorMessage","Invalid username or password");
    return "update";
}
}
@PostMapping("/update-details")
public String updateUserDetails(String username,String email,String password,Model model){
    Users user=this.ur.findByusername(username);
    if(user!=null)
    {
        user.setEmail(email);
        user.setPassword(password);
        this.ur.save(user);
        model.addAttribute("successManager","User details updated successfully");
        return "updateSuccess";
    }else{
        model.addAttribute("errorMessage", "An error occured.Please try again");
        return "update";
    }
}
@GetMapping("/del")
String d1()
{
    return "delete";
}
@PostMapping("/delete")
String d2(String username,String password)
{
    Users user=this.ur.findByusername(username);
    if(user!=null && user.getPassword().equals(password))
    {
        this.ur.delete(user);
        return "deleteSuccess";
    }
    return "delete";
}
}