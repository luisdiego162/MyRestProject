package myproject.rest.exceptions;


/**
 * 
 * docme: RestServicesException
 *
 * @author <a href="mailto:luisdiego162@icloud.com">Luis Diego Larez</a>
 * @version $Rev$
 *
 */
public class RestServicesException extends Exception
{

  /**
   * docme: serialVersionUID
   */
  private static final long serialVersionUID = 6841140233242325275L;
  /**
   * docme: serialVersionUID
   */
  protected Throwable       throwable;
  protected int             code;

  public RestServicesException(String codeMessage)
  {
    super(codeMessage);

  }

/**
 * 
 * docme: RestServicesException()
 *
 * @param code
 * @param codeMessage
 * @param e
 */
  public RestServicesException(int code, String codeMessage, Exception e)
  {
    super(codeMessage, e);
    this.code = code;
  }

  /**
   * 
   * docme: RestServicesException()
   *
   * @param code
   * @param codeMessage
   */
  public RestServicesException(int code, String codeMessage)
  {
    super(codeMessage);
    this.code = code;
  }

  /**
   * 
   * docme: RestServicesException()
   *
   * @param message
   * @param throwable
   */
  public RestServicesException(String message, Throwable throwable)
  {
    super(message);
    this.throwable = throwable;
  }

  /**
   * Method 'getCause'
   * 
   * @return Throwable
   */
  @Override
  public Throwable getCause()
  {
    return throwable;
  }

  public int getCode()
  {
    return code;
  }

  public void setCode(int code)
  {
    this.code = code;
  }

  @Override
  public String toString()
  {
    return code + ": " + this.getMessage();
  }

}
