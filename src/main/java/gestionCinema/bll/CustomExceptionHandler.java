package gestionCinema.bll;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(ReservationException.class)
	public ResponseEntity<String> reservationException(ReservationException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.OK);
	}

}
