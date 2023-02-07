package com.shahed.shop.controller.categoreis;

import com.shahed.shop.controller.common.BaseController;
import com.shahed.shop.dto.categories.CategoriesDto;
import com.shahed.shop.dto.common.ServiceResult;
import com.shahed.shop.model.categories.Categories;
import com.shahed.shop.service.categories.ICategoriesService;
import io.swagger.v3.oas.annotations.Operation;
import org.dozer.Mapper;
import org.springframework.web.bind.annotation.*;

/**
 * @author m.mohabbati on 2/6/2023
 */
@RestController
@RequestMapping(value = "/api/categories", produces = "application/json;charset=UTF-8")
public class CategoriesController extends BaseController {

    private final ICategoriesService iCategoriesService;
    private final Mapper mapper;

    public CategoriesController(ICategoriesService iCategoriesService, Mapper mapper) {
        this.iCategoriesService = iCategoriesService;
        this.mapper = mapper;
    }

    @PostMapping
    @Operation(tags = "categories", description = "ثبت دسته بندی", summary = "ثبت دسته بندی")
    public ServiceResult<Long> save(@RequestBody CategoriesDto categoriesDto) {
        return iCategoriesService.save(mapper.map(categoriesDto, Categories.class));
    }

    @PutMapping
    @Operation(tags = "categories", description = "ویرایش دسته بندی", summary = "ویرایش دسته بندی")
    public ServiceResult<Long> save(@RequestBody Categories categories) {
        return iCategoriesService.save(categories);
    }

    @GetMapping(value = "/code")
    @Operation(tags = "categories", summary = "لود دسته بندی با کد")
    public Categories findByCode(String code) {
        return iCategoriesService.findByCode(code);
    }

    @GetMapping
    @Operation(tags = "categories", summary = "لود دسته بندی ها")
    public ServiceResult<Categories> getAll() {
        return iCategoriesService.getAll();
    }
}
