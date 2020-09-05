package org.example.service;

import org.apache.dubbo.config.annotation.Service;
import org.example.api.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Service
@org.springframework.stereotype.Service
public class UserServiceImpl implements UserService {
    private final List<String> users = new ArrayList<>();

    public UserServiceImpl() {
        this.users.add("陶江航");
        this.users.add("李宁");
        this.users.add("程一飞");
    }

    @Override
    public String get(Integer userId) {

        if (userId >= users.size()) {
            return null;
        }
        return users.get(userId);
    }
}
