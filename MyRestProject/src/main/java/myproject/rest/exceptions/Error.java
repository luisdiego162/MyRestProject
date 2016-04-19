package myproject.rest.exceptions;

/**
 * 
 * docme: Error
 *
 * @author <a href="mailto:luisdiego162@icloud.com">Luis Diego Larez</a>
 * @version $Rev$
 *
 */
public class Error
{
  protected String errorCode;
  protected String errorMessage;

  public String getErrorCode()
  {
    return errorCode;
  }

  public void setErrorCode(String errorCode)
  {
    this.errorCode = errorCode;
  }

  public String getErrorMessage()
  {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage)
  {
    this.errorMessage = errorMessage;
  }

}
