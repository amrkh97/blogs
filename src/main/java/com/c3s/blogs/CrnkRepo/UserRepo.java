package com.c3s.blogs.CrnkRepo;

import com.c3s.blogs.Entity.UserModel;
import io.crnk.data.jpa.JpaEntityRepositoryBase;
import org.springframework.stereotype.Component;


@Component
public class UserRepo extends JpaEntityRepositoryBase<UserModel,Long> {


    public UserRepo() {
        super(UserModel.class);
    }

    }

