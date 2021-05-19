//package com.beyondLogic.InstaPortfolio.Service;
//
//import com.beyondLogic.InstaPortfolio.Exception.DuplicateTitleException;
//import com.beyondLogic.InstaPortfolio.Backup.DuplicateUsernameException;
//import com.beyondLogic.InstaPortfolio.Model.User;
//import com.beyondLogic.InstaPortfolio.Backup.ProfileRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//
//@Service
//public class ProfileService {
//    ProfileRepository profileRepository;
//
//    @Autowired
//    public ProfileService(ProfileRepository profileRepository) {
//        this.profileRepository = profileRepository;
//    }
//
//    public List<User> getUserList(){
//        return profileRepository.getUserList();
//    }
//
//    public int getUserListSize() {
//        return profileRepository.getUserList().size();
//    }
//
//    public User findUserById(Integer id){
//        return profileRepository.findById(id);
//    }
//
//    public void RegisterOrUpdateUserProfile(User user) throws DuplicateTitleException, DuplicateUsernameException {
//        User exitingUser = findUserById(user.getId());
//
//        if(exitingUser == null) {
//            if(profileRepository.findByUsername(user.getUsername()) !=  null) {
//                throw new DuplicateUsernameException();
//            }
//            profileRepository.registerUser(user);
//        }
//        else {
//            exitingUser.setFirstName(user.getFirstName());
//            exitingUser.setLastName(user.getLastName());
//            exitingUser.setUsername(user.getUsername());
//            exitingUser.setEmail(user.getEmail());
//            exitingUser.setPassword(user.getPassword());
//
//        }
//    }
//}
