package com.shahed.shop.controller.common;

import com.shahed.shop.dto.common.ServiceResult;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author m.mohabbati on 2/7/2023
 */
@Slf4j
@RestController
public class BaseController {
    public static final String MESSAGE = "exception object is null!";

    @ExceptionHandler(Exception.class)
    public ServiceResult<String> handleUncaughtException(HttpServletResponse response, Exception ex) {
        String handledMessage = ex != null ? ex.getMessage() : MESSAGE;
        if (ex != null && ex.getMessage() != null && ex.getMessage().toLowerCase().contains("required"))
            response.setStatus(400);
        else
            response.setStatus(500);

        handledMessage += ex != null && ex.getStackTrace() != null && ex.getStackTrace().length > 0 && ex.getStackTrace()[0] != null ? " " + ex.getStackTrace()[0] : "";
        handledMessage = handledMessage.replaceAll("\"", "");
        MDC.put("responseStatusCode", response.getStatus() + "");
        log.error(handledMessage);
        return new ServiceResult<>( "exception", null, null);
    }
}
