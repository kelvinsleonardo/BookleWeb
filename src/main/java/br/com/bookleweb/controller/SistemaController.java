package br.com.bookleweb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Kélvin Santiago
 *
 */

@Controller
@ControllerAdvice
public class SistemaController {

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String requestHandlingNoHandlerFound(HttpServletRequest req, NoHandlerFoundException ex) {
		return "publico/errors/404";
	}

}
