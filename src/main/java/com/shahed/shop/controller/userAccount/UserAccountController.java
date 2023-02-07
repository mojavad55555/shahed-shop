package com.shahed.shop.controller.userAccount;

import com.shahed.shop.controller.common.BaseController;
import com.shahed.shop.dto.common.ServiceResult;
import com.shahed.shop.dto.userAccount.UserAccountDto;
import com.shahed.shop.model.userAccount.UserAccount;
import com.shahed.shop.service.userAccount.IUserAccountService;
import io.swagger.v3.oas.annotations.Operation;
import org.dozer.Mapper;
import org.springframework.web.bind.annotation.*;

/**
 * @author m.mohabbati on 2/7/2023
 */
@RestController
@RequestMapping(value = "/api/user-account", produces = "application/json;charset=UTF-8")
public class UserAccountController extends BaseController {

    private final IUserAccountService iUserAccountService;
    private final Mapper mapper;

    public UserAccountController(IUserAccountService iUserAccountService, Mapper mapper) {
        this.iUserAccountService = iUserAccountService;
        this.mapper = mapper;
    }

    @PostMapping
    @Operation(tags = "user-account", description = "ثبت یوزر جدید", summary = "ثبت یوزر جدید")
    public ServiceResult<Long> save(@RequestBody UserAccountDto userAccountDto) throws Exception {
        return iUserAccountService.save(mapper.map(userAccountDto, UserAccount.class));
    }

    @PostMapping(value = "/login")
    @Operation(tags = "user-account", description = "لاگین", summary = "لاگین")
    public ServiceResult<UserAccount> login(String firstName, String lastName) {
        return iUserAccountService.login(firstName,lastName);
    }

    @GetMapping(value = "/id/admin")
    @Operation(tags = "user-account", summary = "لود یوزر با شناسه")
    public UserAccount findById(Long id) {
        return iUserAccountService.findByIdEquals(id);
    }


    @GetMapping(value = "/firstName/admin")
    @Operation(tags = "user-account", summary = "لود یوزر با نام")
    public ServiceResult<UserAccount> findByFirstName(String firstName) {
        return iUserAccountService.findByFirstNameEquals(firstName);
    }

    @GetMapping(value = "/lastName/admin")
    @Operation(tags = "user-account", summary = "لود یوزر با نام خانوادگی")
    public ServiceResult<UserAccount> findByLastName(String lastname) {
        return iUserAccountService.findByLastNameEquals(lastname);
    }

    @GetMapping(value = "/fullName/admin")
    @Operation(tags = "user-account", summary = "لود یوزر با نام و نام خانوادگی")
    public ServiceResult<UserAccount> findByLastNameAndFirstName(String firstName, String lastName) {
        return iUserAccountService.findByLastNameAndFirstNameEquals(firstName,lastName);
    }

    @GetMapping(value = "/admin")
    @Operation(tags = "user-account", summary = "لود یوزرها")
    public ServiceResult<UserAccount> getAll() {
        return iUserAccountService.getAll();
    }
}
