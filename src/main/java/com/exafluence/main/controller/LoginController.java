package com.exafluence.main.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.exafluence.main.model.User;
import com.exafluence.main.services.CustomUserDetailsService;
import com.exafluence.main.services.ReCaptchaValidationService;

@Controller
public class LoginController {

    @Autowired
    private CustomUserDetailsService userService;

    

    @Autowired
    private ReCaptchaValidationService validator;


    
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
@RequestMapping(value="/loginUser",method=RequestMethod.POST)
public ModelAndView postLogin(User user) {
ModelAndView modelAndView= new ModelAndView();
User foundUser = userService.findUserByEmail(user.getEmail());
if (foundUser!= null) {
modelAndView.addObject("current User", user);
modelAndView.addObject("fullName", "Welcome " + user.getFullname());
modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
modelAndView.setViewName("dashboard");
}
else {
modelAndView.addObject("adminMessage", "cannot access");
modelAndView.setViewName("login");
}
return modelAndView;
}
    
    
    
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("signup");
        return modelAndView;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult, @RequestParam(name="g-recaptcha-response") String captcha) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if(validator.validateCaptcha(captcha)) {
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the username provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("signup");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("login");

        }        
        }
        else {
        	modelAndView.addObject("message", "plese validate recaptcha");
        	modelAndView.setViewName("signup");
        }
        
        return modelAndView;
    }

    
    
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashboard() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("currentUser", user);
        modelAndView.addObject("fullName", "Welcome " + user.getFullname());
        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }
    
    @RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }


    
    
    
}
