package com.kurtfinancial.payload;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginDto {
    private String password;
    private String username;
}
