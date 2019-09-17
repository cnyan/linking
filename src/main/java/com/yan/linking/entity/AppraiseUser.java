package com.yan.linking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@Table(name = "appraise_user_table")
public class AppraiseUser {


    @Id
    private int id;
    
    private String name;
    /**
     * 类别，0本校，1顺德，2毕节
     */
    private int category;

    /**
     * 是否评分，0代表为评分，1代表已经评分
     */
    private int isApprise;

    public AppraiseUser() {
    }
}
