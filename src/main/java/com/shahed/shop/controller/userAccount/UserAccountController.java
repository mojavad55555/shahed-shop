package com.shahed.shop.controller.userAccount;

import com.shahed.shop.dto.userAccount.UserAccountDto;
import com.shahed.shop.model.userAccount.UserAccount;
import com.shahed.shop.service.userAccount.IUserAccountService;
import io.swagger.v3.oas.annotations.Operation;
import org.dozer.Mapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author m.mohabbati on 2/7/2023
 */
@RestController
@RequestMapping(value = "/api/user-account", produces = "application/json;charset=UTF-8")
public class UserAccountController {

    private final IUserAccountService iUserAccountService;
    private final Mapper mapper;

    public UserAccountController(IUserAccountService iUserAccountService, Mapper mapper) {
        this.iUserAccountService = iUserAccountService;
        this.mapper = mapper;
    }

    @PostMapping
    @Operation(tags = "user-account", description = "ثبت یوزر جدید", summary = "ثبت یوزر جدید")
    public Long save(@RequestBody UserAccountDto userAccountDto) throws Exception {
        return iUserAccountService.save(mapper.map(userAccountDto, UserAccount.class));
    }

    @PostMapping(value = "/login")
    @Operation(tags = "user-account", description = "لاگین", summary = "لاگین")
    public UserAccount login(String firstName, String lastName) {
        return iUserAccountService.login(firstName,lastName);
    }

    @GetMapping(value = "/id")
    @Operation(tags = "user-account", summary = "لود یوزر با شناسه")
    public UserAccount findById(Long id) {
        return iUserAccountService.findByIdEquals(id);
    }


    @GetMapping(value = "/firstName")
    @Operation(tags = "user-account", summary = "لود یوزر با نام")
    public List<UserAccount> findByFirstName(String firstName) {
        return iUserAccountService.findByFirstNameEquals(firstName);
    }

    @GetMapping(value = "/lastName")
    @Operation(tags = "user-account", summary = "لود یوزر با نام خانوادگی")
    public List<UserAccount> findByLastName(String lastname) {
        return iUserAccountService.findByLastNameEquals(lastname);
    }

    @GetMapping(value = "/fullName")
    @Operation(tags = "user-account", summary = "لود یوزر با نام و نام خانوادگی")
    public List<UserAccount> findByLastNameAndFirstName(String firstName, String lastName) {
        return iUserAccountService.findByLastNameAndFirstNameEquals(firstName,lastName);
    }

    @GetMapping
    @Operation(tags = "user-account", summary = "لود یوزرها")
    public List<UserAccount> getAll() {
        return iUserAccountService.getAll();
    }
}
