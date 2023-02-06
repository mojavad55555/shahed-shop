package com.shahed.shop.service.userAccount;

import com.shahed.shop.model.userAccount.UserAccount;

import java.util.List;

/**
 * @author m.mohabbati on 2/5/2023
 */
public interface IUserAccountService {

    Long save(UserAccount userAccount);

    List<UserAccount> getAll();

    UserAccount findByIdEquals(Long id);

    List<UserAccount> findBySexEquals(boolean sex);

    List<UserAccount> findByFirstNameEquals(String firstName);

    List<UserAccount> findByLastNameEquals(String lastName);

    List<UserAccount> findByLastNameAndFirstNameEquals(String firstName,String lastName);
}
