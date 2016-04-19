package myproject.rest.controller;

import java.security.Principal;

import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import myproject.rest.exceptions.RestServicesException;

public abstract class AbstractRestController
{

  /**
   * Method handle all exception in the each controller and generate a valid json string
   * 
   * docme: handleException()
   * 
   * @param principal
   * @param ex
   * @return
   */
  @ExceptionHandler(Exception.class)
  @ResponseBody
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public myproject.rest.exceptions.Error handleException(Principal principal, Exception ex)
  {

    //TODO: Save error messages in logs
    //logger.error(ex.getClass().toString());
    //logger.error(ex.getMessage());

    myproject.rest.exceptions.Error ec = new myproject.rest.exceptions.Error();
    ec.setErrorCode("00");
    ec.setErrorMessage("undefined exception");

    if ( ex.getClass().equals(RestServicesException.class) )
    {
      RestServicesException ce = (RestServicesException) ex;
      ec.setErrorCode(Integer.toString(ce.getCode()));
      ec.setErrorMessage(ce.getMessage());
    }

    if ( ex instanceof CannotCreateTransactionException )
    {
      //TODO:
      //good practice create logger and save all errors in the server, example:
      //logger.error(e.getMessage)
      ec.setErrorCode("01");
      ec.setErrorMessage("Error Connection to Database");

    }

    return ec;
  }

}
