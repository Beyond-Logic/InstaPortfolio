//package com.beyondLogic.InstaPortfolio.Backup;
//
//
//import com.beyondLogic.InstaPortfolio.Exception.DuplicateTitleException;
//import com.beyondLogic.InstaPortfolio.Model.User;
//import com.beyondLogic.InstaPortfolio.Service.ProfileService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.view.RedirectView;
//
//import javax.validation.Valid;
//import java.util.HashMap;
//import java.util.Map;
//
//@Controller
//public class ProfileController {
//
//    private ProfileService profileService;
//
//    @Autowired
//    public ProfileController(ProfileService profileService) {
//        this.profileService = profileService;
//    }
//
//    @GetMapping("/registerUserForm")
//    public ModelAndView showRegisterUserForm(@RequestParam(required = false) Integer id ){
//        String viewName = "registerUserForm";
//        Map<String, Object> model = new HashMap<String,Object>();
//        User user = profileService.findUserById(id);
//
//        if(user == null) {
//            model.put("user", new User());
//        } else {
//            model.put("user", user);
//        }
//
//        return new ModelAndView(viewName,model);
//
//    }
//
//    @PostMapping("/registerUserForm")
//    public ModelAndView submitRegisterUserForm(@Valid User user, BindingResult bindingResult){
//        if(bindingResult.hasErrors()) {
//            return new ModelAndView("registration");
//        }
//
//        try {
//            profileService.RegisterOrUpdateUserProfile(user);
//        } catch (DuplicateUsernameException | DuplicateTitleException e) {
//            bindingResult.rejectValue("userName", "", "This userName already exist");
//            return new ModelAndView("registration");
//        }
//
//
//        RedirectView redirectView = new RedirectView();
//        redirectView.setUrl("/profile");
//
//        return new ModelAndView(redirectView);
//
//    }
//
//    @GetMapping("/profile")
//    public ModelAndView getUserProfilePage() {
//
//        String viewName = "profile";
//
//        Map<String,Object> model = new HashMap<String,Object>();
//
//        model.put("userList", profileService.getUserList());
//        model.put("numberOfItems", profileService.getUserListSize());
//        return new ModelAndView(viewName,model);
//    }
//}
