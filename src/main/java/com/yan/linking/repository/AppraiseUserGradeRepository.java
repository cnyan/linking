package com.yan.linking.repository;

import com.yan.linking.entity.AppraiseUser;
import com.yan.linking.entity.UserGrade;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface AppraiseUserGradeRepository extends CrudRepository<UserGrade,Integer> {

    public List<UserGrade> findUserGradeByUserId(int id);

    @Modifying
    @Transactional
    @Query(value = "select * from appraise_user_grade_table where id=?1",nativeQuery = true)
    public List<UserGrade> findUserIdByUserGradeId(int id);  //通过记录ID查找用户

}
