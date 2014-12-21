package org.shop;


import org.shop.api.impl.SellerServiceImpl;
import org.shop.api.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The ShopLauncher class.
 */
public class ShopLauncher {
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-configuration.xml");
        SellerServiceImpl sellerService = context.getBean("sellerService", SellerServiceImpl.class);
        sellerService.getSellers();

        ProductInitializer productInitializer = (ProductInitializer) context.getBean("productInitializer");

        ProposalInitializer proposalInitializer = context.getBean("proposalInitializer", ProposalInitializer.class);
        proposalInitializer.initProposals();

        UserServiceImpl userService = context.getBean("new_userService", UserServiceImpl.class);


    }
}
