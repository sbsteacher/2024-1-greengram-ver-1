package com.green.greengram.user.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignInPostReq {
    private String uid;
    private String upw;
}
