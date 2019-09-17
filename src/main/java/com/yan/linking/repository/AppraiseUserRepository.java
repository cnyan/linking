package com.yan.linking.repository;

import com.yan.linking.entity.AppraiseUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppraiseUserRepository extends CrudRepository<AppraiseUser, Integer> {

    public List<AppraiseUser> findAppraiseUserById(int id);
    public List<AppraiseUser> findAppraiseUserByName(String name);


}
