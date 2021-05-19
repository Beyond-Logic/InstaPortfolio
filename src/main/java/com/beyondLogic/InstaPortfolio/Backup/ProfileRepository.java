//package com.beyondLogic.InstaPortfolio.Backup;
//
//
//import com.beyondLogic.InstaPortfolio.Model.PortfolioItem;
//import com.beyondLogic.InstaPortfolio.Model.User;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class ProfileRepository {
//
//    private List<User> userList = new ArrayList<User>();
//    private static int index = 1;
//
//    public List<User> getUserList(){
//        return userList;
//    }
//
//    public void registerUser(User user) {
//        user.setId(index);
//        userList.add(user);
//    }
//
//    public User findById(Integer id){
//        for(User user : userList) {
//            if(user.getId().equals(id)){
//                return user;
//            }
//        }
//        return null;
//    }
//
//    public User findByUsername(String userName) {
//
//        for(User user : userList) {
//            if(user.getUserName().equals(userName)){
//                return user;
//            }
//        }
//        return null;
//
//    }
//
//}
