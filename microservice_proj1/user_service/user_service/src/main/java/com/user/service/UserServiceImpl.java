package com.user.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    //user list
    List<User> list=List.of(
            new User(1,"Nausheen","9847569348"),
            new User(2,"Anwar","9847545948"),
            new User(3,"Palak","9847545948")
    );
    @Override
    public User getUser(Long id) {
        return list.stream().filter(user->user.getUserId().equals(id)).findAny().orElse(null);
    }
}
