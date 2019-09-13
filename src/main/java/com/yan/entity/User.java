package com.yan.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Data
public class User {

    private String  name;

    private String  pwd;

}
