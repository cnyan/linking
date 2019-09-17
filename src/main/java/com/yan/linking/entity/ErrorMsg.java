package com.yan.linking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ErrorMsg {

    private String name;
    private String message;

    public ErrorMsg() {

    }

}
