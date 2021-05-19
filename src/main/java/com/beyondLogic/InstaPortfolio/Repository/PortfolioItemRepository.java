package com.beyondLogic.InstaPortfolio.Repository;

import com.beyondLogic.InstaPortfolio.Model.PortfolioItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PortfolioItemRepository {

    private List<PortfolioItem> portfolioItemLists = new ArrayList<PortfolioItem>();
    private static int index = 1;

    public List<PortfolioItem> getList(){
        return portfolioItemLists;
    }

    public void addItem(PortfolioItem portfolioItem) {
        portfolioItem.setId(index++);
        portfolioItemLists.add(portfolioItem);
    }

    public PortfolioItem findById(Integer id){
        for(PortfolioItem portfolioItem : portfolioItemLists) {
             if(portfolioItem.getId().equals(id)){
                 return portfolioItem;
             }
        }
        return null;
    }

    public PortfolioItem findByTitle(String title) {

        for(PortfolioItem portfolioItem : portfolioItemLists) {
            if(portfolioItem.getTitle().equals(title)){
                return portfolioItem;
            }
        } 
        return null;

    }
}



