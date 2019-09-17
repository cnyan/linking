package com.yan.linking.repository;

import com.yan.linking.entity.UserGrade;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppraiseUserGradeRepository extends CrudRepository<UserGrade,Integer> {

    public List<UserGrade> findUserGradeByUserId(int id);

}
