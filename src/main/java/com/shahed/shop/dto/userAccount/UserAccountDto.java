package com.shahed.shop.dto.userAccount;

import lombok.Getter;
import lombok.Setter;

/**
 * @author m.mohabbati on 2/7/2023
 */
@Getter
@Setter
public class UserAccountDto {

    private String userName;

    private String password;

    private String lastName;

    private String firstName;

    private String phoneNumber;

    private String address;

    private boolean sex;

    private Integer age;
}
