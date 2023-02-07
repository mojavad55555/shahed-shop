package com.shahed.shop.controller.categoreis;

import com.shahed.shop.dto.categories.CategoriesDto;
import com.shahed.shop.model.categories.Categories;
import com.shahed.shop.service.categories.ICategoriesService;
import io.swagger.v3.oas.annotations.Operation;
import org.dozer.Mapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author m.mohabbati on 2/6/2023
 */
@RestController
@RequestMapping(value = "/api/categories", produces = "application/json;charset=UTF-8")
public class CategoriesController {

    private final ICategoriesService iCategoriesService;
    private final Mapper mapper;

    public CategoriesController(ICategoriesService iCategoriesService, Mapper mapper) {
        this.iCategoriesService = iCategoriesService;
        this.mapper = mapper;
    }

    @PostMapping
    @Operation(tags = "categories", description = "ثبت دسته بندی", summary = "ثبت دسته بندی")
    public Long save(@RequestBody CategoriesDto categoriesDto) {
        return iCategoriesService.save(mapper.map(categoriesDto, Categories.class));
    }

    @GetMapping(value = "/code")
    @Operation(tags = "categories", summary = "لود دسته بندی با کد")
    public Categories findByCode(String code) {
        return iCategoriesService.findByCode(code);
    }

    @GetMapping
    @Operation(tags = "categories", summary = "لود دسته بندی ها")
    public List<Categories> getAll() {
        return iCategoriesService.getAll();
    }
}
