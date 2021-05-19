package com.beyondLogic.InstaPortfolio.Service;

import com.beyondLogic.InstaPortfolio.Exception.DuplicateTitleException;
import com.beyondLogic.InstaPortfolio.Model.PortfolioItem;
import com.beyondLogic.InstaPortfolio.Repository.PortfolioItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class PortfolioItemService {

    PortfolioItemRepository portfolioItemRepository;

    @Autowired
    public PortfolioItemService(PortfolioItemRepository portfolioItemRepository) {
        this.portfolioItemRepository = portfolioItemRepository;
    }

    public List<PortfolioItem> getPortfolioItemList(){
        return portfolioItemRepository.getList();
    }

    public int getPortfolioItemListSize() {
        return portfolioItemRepository.getList().size();
    }

    public PortfolioItem findPortfolioItemById(Integer id){
        return portfolioItemRepository.findById(id);
    }

    public void addOrUpdatePortfolioItem(PortfolioItem portfolioItem) throws DuplicateTitleException {
        PortfolioItem exitingItem = findPortfolioItemById(portfolioItem.getId());

        if(exitingItem == null) {
        if(portfolioItemRepository.findByTitle(portfolioItem.getTitle()) !=  null) {
            throw new DuplicateTitleException();
        }
        portfolioItemRepository.addItem(portfolioItem);
        }
        else {
            exitingItem.setTitle(portfolioItem.getTitle());
            exitingItem.setDescription(portfolioItem.getDescription());
            exitingItem.setProjectType(portfolioItem.getProjectType());
            exitingItem.setTools(portfolioItem.getTools());
            exitingItem.setProgrammingLanguage(portfolioItem.getProgrammingLanguage());

        }
    }
}
