//package com.beyondLogic.InstaPortfolio.Controller;
//
//import com.beyondLogic.InstaPortfolio.Repository.UserRepository;
//import com.beyondLogic.InstaPortfolio.Service.SecurityService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/")
//public class LoginController {
//
//    @Autowired
//    private SecurityService securityService;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @GetMapping("/login")
//    public String login(Model model, String error, String logout) {
//        if (securityService.isAuthenticated()) {
//            return "redirect:/";
//        }
//
//        if (error != null)
//            model.addAttribute("error", "Your username and password is invalid.");
//
//        if (logout != null)
//            model.addAttribute("message", "You have been logged out successfully.");
//
//        return "login";
//    }
//
//    @GetMapping({"/", "/home"})
//    public String welcome(Model model) {
//        return "home";
//    }
//
//}
