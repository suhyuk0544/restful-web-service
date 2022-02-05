package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserDaoService {
    private static final List<User> users = new ArrayList<>();

    private static int userCount = 3;

    static {
        users.add(new User(1,"su",new Date()));
        users.add(new User(2,"suh",new Date()));
        users.add(new User(3,"um",new Date()));

    }
    
    

    public List<User> findAll(){

        return users;
    }
    
    

    public User save(User user){
        if (user.getId() == null){
            user.setId(++userCount);
        }
        if (user.getJoinDate() == null){
            user.setJoinDate(new Date());
        }
        users.add(user);
        return user;
    }
    
    

    public User findone(int id) {
        for (User user: users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
//    public User

}
