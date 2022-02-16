package com.example.restfulwebservice.user;



import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {
    private static final List<User> users = new ArrayList<>();

    private static int userCount = 3;

    static {
        users.add(new User(1, "su", new Date()));
        users.add(new User(2, "suh", new Date()));
        users.add(new User(3, "um", new Date()));

    }
    
    


    public List<User> findAll() {

        if (users.isEmpty()){
            return null;
        }

        return users;
    }
    
    

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        } else if (user.getJoinDate() == null) {
            user.setJoinDate(new Date());
        }
        users.add(user);
        return user;
    }
    
    

    public User findone(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User deleteuser(int id) {

        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {

            User user = iterator.next();

            if (user.getId() == id) {

                iterator.remove();

                return user;
            }
        }
        return null;
    }

    public List<User> findName(){


        return users;
    }


}
//        for (User user : users){
//
//            if (user.getId() == id) {
//
//                users.remove(--id);
//                return user;
//            }
//        }




