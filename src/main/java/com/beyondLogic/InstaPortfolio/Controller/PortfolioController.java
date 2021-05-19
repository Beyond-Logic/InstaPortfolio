package com.beyondLogic.InstaPortfolio.Controller;


import com.beyondLogic.InstaPortfolio.Exception.DuplicateTitleException;
import com.beyondLogic.InstaPortfolio.Model.PortfolioItem;
import com.beyondLogic.InstaPortfolio.Service.PortfolioItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class PortfolioController {

     private PortfolioItemService portfolioItemService;

     @Autowired
    public PortfolioController(PortfolioItemService portfolioItemService) {
        this.portfolioItemService = portfolioItemService;
    }

    @GetMapping("/portfolioItemForm")
    public ModelAndView showPortfolioItemForm(@RequestParam(required = false) Integer id ){
        String viewName = "portfolioItemForm";
        Map<String, Object> model = new HashMap<String,Object>();
        PortfolioItem portfolioItem = portfolioItemService.findPortfolioItemById(id);

        if(portfolioItem == null) {
            model.put("portfolioItem", new PortfolioItem());
        } else {
            model.put("portfolioItem", portfolioItem);
        }

        return new ModelAndView(viewName,model);

    }

    @PostMapping("/portfolioItemForm")
    public ModelAndView submitPortfolioItemForm(@Valid PortfolioItem portfolioItem, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return new ModelAndView("portfolioItemForm");
        }

        try {
            portfolioItemService.addOrUpdatePortfolioItem(portfolioItem);
        } catch (DuplicateTitleException e) {
            bindingResult.rejectValue("title", "", "This title already exist in your portfolio");
            return new ModelAndView("portfolioItemForm");
        }


        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/portfolio");

        return new ModelAndView(redirectView);

    }

    @GetMapping("/portfolio")
    public ModelAndView getPortfolioPage() {

        String viewName = "portfolio";

        Map<String,Object> model = new HashMap<String,Object>();

        model.put("portfolioItemLists", portfolioItemService.getPortfolioItemList());
        model.put("numberOfItems", portfolioItemService.getPortfolioItemListSize());
        return new ModelAndView(viewName,model);
    }

}
