package com.shahed.shop.dao.userAccount;

import com.shahed.shop.model.userAccount.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author m.mohabbati on 2/5/2023
 */
public interface IUserAccountRepository extends JpaRepository<UserAccount, Long> {

    UserAccount findByIdEquals(Long id);

    List<UserAccount> findBySexEquals(boolean sex);

    List<UserAccount> findByFirstNameEquals(String firstName);

    List<UserAccount> findByLastNameEquals(String lastName);

    List<UserAccount> findByLastNameAndFirstNameEquals(String firstName,String lastName);

}
