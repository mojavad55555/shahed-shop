package com.shahed.shop.service.impl.userAccount;

import com.shahed.shop.dao.userAccount.IUserAccountRepository;
import com.shahed.shop.model.userAccount.UserAccount;
import com.shahed.shop.service.userAccount.IUserAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author m.mohabbati on 2/5/2023
 */
@Service
public class UserAccountService implements IUserAccountService {

    private final IUserAccountRepository iUserAccountRepository;

    public UserAccountService(IUserAccountRepository iUserAccountRepository) {
        this.iUserAccountRepository = iUserAccountRepository;
    }

    @Override
    @Transactional
    public Long save(UserAccount userAccount) {
        return iUserAccountRepository.save(userAccount).getId();
    }

    @Override
    public List<UserAccount> getAll() {
        return iUserAccountRepository.findAll();
    }

    @Override
    public UserAccount findByIdEquals(Long id) {
        return iUserAccountRepository.findByIdEquals(id);
    }

    @Override
    public List<UserAccount> findBySexEquals(boolean sex) {
        return iUserAccountRepository.findBySexEquals(sex);
    }

    @Override
    public List<UserAccount> findByFirstNameEquals(String firstName) {
        return iUserAccountRepository.findByFirstNameEquals(firstName);
    }

    @Override
    public List<UserAccount> findByLastNameEquals(String lastName) {
        return iUserAccountRepository.findByLastNameEquals(lastName);
    }

    @Override
    public List<UserAccount> findByLastNameAndFirstNameEquals(String firstName, String lastName) {
        return iUserAccountRepository.findByLastNameAndFirstNameEquals(lastName,firstName);
    }
}
