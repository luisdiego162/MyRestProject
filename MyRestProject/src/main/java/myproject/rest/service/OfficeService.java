package myproject.rest.service;

import java.util.List;

import myproject.rest.exceptions.RestServicesException;
import myproject.rest.model.Office;

/**
 * 
 * docme: OfficeService
 *
 * @author <a href="mailto:luisdiego162@icloud.com">Luis Diego Larez</a>
 * @version $Rev$
 *
 */
public interface OfficeService
{

  public Office getOfficeById(String id) throws RestServicesException;

  public List<Office> getAllOfficeOpenNow() throws RestServicesException;

  public Office createOffice(Office office) throws RestServicesException;

  public List<Office> getAllOffice() throws RestServicesException;

}
