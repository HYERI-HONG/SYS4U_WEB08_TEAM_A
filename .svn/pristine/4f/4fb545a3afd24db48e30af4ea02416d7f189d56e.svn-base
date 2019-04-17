package kr.sys4u.spring.instagram.web.controller.advisor;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvisor {
	protected static final Logger LOGGER = LoggerFactory.getLogger(ExceptionAdvisor.class);
	
	@ExceptionHandler(Exception.class)
	public String handleException(HttpServletRequest request, Exception exception) {
		String xRequestedWith = request.getHeader("X-Requested-With");
	    boolean isAjax = xRequestedWith != null && xRequestedWith.equals("XMLHttpRequest");
	    request.setAttribute("exception", exception);
	    if(isAjax) {
	    	return "common/error/ajaxError";
	    }
	    
		return "common/error/500";
	}
	
}
