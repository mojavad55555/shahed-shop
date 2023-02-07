package com.shahed.shop.service.userAccount;

import com.shahed.shop.dto.common.ServiceResult;
import com.shahed.shop.model.userAccount.UserAccount;

import java.util.List;

/**
 * @author m.mohabbati on 2/5/2023
 */
public interface IUserAccountService {

    ServiceResult<Long> save(UserAccount userAccount) throws Exception;

    ServiceResult<UserAccount> getAll();

    UserAccount findByIdEquals(Long id);

    List<UserAccount> findBySexEquals(boolean sex);

    ServiceResult<UserAccount> findByFirstNameEquals(String firstName);

    ServiceResult<UserAccount> findByLastNameEquals(String lastName);

    ServiceResult<UserAccount> findByLastNameAndFirstNameEquals(String firstName, String lastName);

    boolean existsByUserName(String userName);

    boolean existsByUserNameAndPassword(String userName,String password);

    UserAccount findByUserNameAndPassword(String userName,String password);

    ServiceResult<UserAccount> login(String userName,String password);

}
