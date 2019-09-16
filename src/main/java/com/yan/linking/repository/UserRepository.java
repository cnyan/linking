package com.yan.linking.repository;

import com.yan.linking.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {


    @Modifying
    @Transactional
    @Query(value = "select * from user_table where  user_table.id = ?1 and  user_table.name = ?2", nativeQuery = true)
    public List<User> findUserByModify(int userId, String name);


    public List<User> findUserById(int userId);

}
