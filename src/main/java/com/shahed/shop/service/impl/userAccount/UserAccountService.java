package com.shahed.shop.service.impl.userAccount;

import com.shahed.shop.dao.userAccount.IUserAccountRepository;
import com.shahed.shop.dto.common.ServiceResult;
import com.shahed.shop.dto.common.ServiceResultBuilder;
import com.shahed.shop.model.userAccount.UserAccount;
import com.shahed.shop.service.userAccount.IUserAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
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
    public ServiceResult<Long> save(UserAccount userAccount) throws Exception {
        if (this.existsByUserName(userAccount.getUserName())) {
            throw new Exception("یوزر تکراری!");
        }
        userAccount.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        return new ServiceResultBuilder<Long>().setSingleResult(iUserAccountRepository.save(userAccount).getId()).setMessage("Status : ok").build();
    }

    @Override
    public ServiceResult<UserAccount> getAll() {
        return new ServiceResultBuilder<UserAccount>().setResult(iUserAccountRepository.findAll()).setMessage("Status : ok").build();
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
    public ServiceResult<UserAccount> findByFirstNameEquals(String firstName) {
        return new ServiceResultBuilder<UserAccount>().setResult(iUserAccountRepository.findByFirstNameEquals(firstName)).setMessage("Status : ok").build();
    }

    @Override
    public ServiceResult<UserAccount> findByLastNameEquals(String lastName) {
        return new ServiceResultBuilder<UserAccount>().setResult(iUserAccountRepository.findByLastNameEquals(lastName)).setMessage("Status : ok").build();
    }

    @Override
    public ServiceResult<UserAccount> findByLastNameAndFirstNameEquals(String firstName, String lastName) {
        return new ServiceResultBuilder<UserAccount>().setResult(iUserAccountRepository.findByLastNameAndFirstNameEquals(lastName, firstName)).setMessage("Status : ok").build();

    }

    @Override
    public boolean existsByUserName(String userName) {
        return iUserAccountRepository.existsByUserName(userName);
    }

    @Override
    public boolean existsByUserNameAndPassword(String userName, String password) {
        return iUserAccountRepository.existsByUserNameAndPassword(userName, password);
    }

    @Override
    public UserAccount findByUserNameAndPassword(String userName, String password) {
        return iUserAccountRepository.findByUserNameAndPassword(userName, password);
    }

    @Override
    public ServiceResult<UserAccount> login(String userName, String password) {
        if (this.existsByUserNameAndPassword(userName, password)) {
            return new ServiceResultBuilder<UserAccount>().setSingleResult(this.findByUserNameAndPassword(userName, password)).setMessage("Status : ok").build();

        } else {
            return new ServiceResultBuilder<UserAccount>().setSingleResult(null).setMessage("status : unSuccess").build();
        }
    }
}
