package codingforlove.community.Advice;

import codingforlove.community.DTO.ResultDTO;
import codingforlove.community.Exception.CustomizeErrorCode;
import codingforlove.community.Exception.CustomizeException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    Object handle(Throwable ex, Model model, HttpServletRequest request) {
        String contentType = request.getContentType();
        if("application/json".equals(contentType)){
            if (ex instanceof CustomizeException){
                return ResultDTO.errorOf((CustomizeException) ex);
            }else {
                return ResultDTO.errorOf(CustomizeErrorCode.SYS_ERROR);
            }
        }else {
            if (ex instanceof CustomizeException){
                model.addAttribute("message",ex.getMessage());
            }else {
                model.addAttribute("message",CustomizeErrorCode.SYS_ERROR.getMessage());
            }
            return new ModelAndView("error");
        }

    }
}
