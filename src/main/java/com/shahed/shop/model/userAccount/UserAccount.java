package com.shahed.shop.model.userAccount;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author m.mohabbati on 2/5/2023
 */
@Entity
@Table(name = "user_account")
@Getter
@Setter
@NoArgsConstructor
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen_user_account")
    @SequenceGenerator(name = "seq_user_account", sequenceName = "seq_gen_user_account", allocationSize = 1)
    private Long id;

    @Column(name = "created_date_time")
    private Timestamp createdDate;

    @Column(name = "userName",unique = true)
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_Name")
    private String firstName;

    @Column(name = "phone_Number")
    private String phoneNumber;

    @Column(name = "address", length = 2000)
    private String address;

    @Column(name = "sex")
    private boolean sex;

    @Column(name = "age")
    private Integer age;

}
