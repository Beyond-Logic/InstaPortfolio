package com.beyondLogic.InstaPortfolio;

import com.beyondLogic.InstaPortfolio.Model.PortfolioItem;
import com.beyondLogic.InstaPortfolio.Repository.PortfolioItemRepository;
import com.beyondLogic.InstaPortfolio.Service.PortfolioItemService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PortfolioItemServiceTest {

    @Mock
    private PortfolioItemRepository portfolioItemRepositoryMock;

    @InjectMocks
    private PortfolioItemService portfolioItemService;

    @Test
    public void testGetPortfolioItemsReturnsAllItemFromRepository() {
        //Arrange
        PortfolioItem portfolioItem1 =
                new PortfolioItem(1, "project Name","description","url","frontend","adobe xd","Java");
        PortfolioItem portfolioItem2 =
                new PortfolioItem(2, "project Name2","description2","url2","frontend2","adobe xd2","Java2");

        List<PortfolioItem> mockItems = Arrays.asList(portfolioItem1,portfolioItem2);

        Mockito.when(portfolioItemRepositoryMock.getList()).thenReturn((mockItems));


        //Act

        List<PortfolioItem> result = portfolioItemService.getPortfolioItemList();

        //Assert
        Assert.assertEquals(2, result.size());
        Assert.assertEquals("project Name", result.get(0).getTitle());
        Assert.assertEquals("project Name2", result.get(1).getTitle());
    }
}
