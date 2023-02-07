package com.shahed.shop.dto.common;

import lombok.Getter;

import java.util.List;

/**
 * @author m.mohabbati on 2/7/2023
 */
@Getter
public class ServiceResultBuilder<T> {
    private String message = "";
    private List<T> result;
    private T singleResult;

    public ServiceResultBuilder<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public ServiceResultBuilder<T> setResult(List<T> result) {
        this.result = result;
        return this;
    }

    public ServiceResultBuilder<T> setSingleResult(T singleResult) {
        this.singleResult = singleResult;
        return this;
    }

    public ServiceResult<T> build() {
        return new ServiceResult<>( message, result, singleResult);
    }
}
