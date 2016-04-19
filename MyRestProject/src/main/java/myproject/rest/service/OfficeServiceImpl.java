package myproject.rest.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTimeZone;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import myproject.rest.dao.OfficeDao;
import myproject.rest.exceptions.RestServicesException;
import myproject.rest.model.Office;

/**
 * 
 * docme: OfficeServiceImpl
 *
 * @author <a href="mailto:luisdiego162@icloud.com">Luis Diego Larez</a>
 * @version $Rev$
 *
 */
public class OfficeServiceImpl implements OfficeService
{

  public OfficeServiceImpl()
  {

  }

  @Autowired
  OfficeDao officeDao;

  /**
   * 
   * docme: createOffice()
   *
   * @param office
   * @return
   */
  public Office createOffice(Office office) throws RestServicesException
  {
    //check parameters

    office = checkParameters(office);

    return officeDao.createOffice(office);
  }

  /**
   * 
   * docme: getAllOffice()
   *
   * @return
   */
  public List<Office> getAllOffice() throws RestServicesException
  {

    return officeDao.getAllOffice();
  }

  /**
   * 
   * docme: getAllOfficeOpenNow()
   *
   * @return
   */
  public List<Office> getAllOfficeOpenNow() throws RestServicesException
  {

    List<Office> newListTemp = new ArrayList<Office>();

    List<Office> listOffice = officeDao.getAllOffice();

    //created new list with the office opened
    for ( Office office : listOffice )
    {
      if ( isOpen(office) )
        newListTemp.add(office);
    }

    return newListTemp;
  }

  /**
   * 
   * docme: getOfficeById()
   *
   * @param id
   * @return
   */
  public Office getOfficeById(String id) throws RestServicesException
  {

    return officeDao.getOfficeById(id);
  }

  /**
   * 
   * Method to check if the office is open now or not
   * 
   * docme: isOpen()
   *
   * @param office
   * @return
   */
  private boolean isOpen(Office office)
  {

    Calendar cal = Calendar.getInstance();
    cal.setTime(new Date());
    if ( office.getTimeDifference() == null || office.getOpenFrom() == null || office.getOpenUntil() == null )
    {
      //The office not content the times data to check if open or not
      return false;

    }

    else
    {

      LocalTime from = new LocalTime(office.getOpenFrom().toString("HH:mm"));
      LocalTime to = new LocalTime(office.getOpenUntil().toString("HH:mm"));

      //Get the local time form the office
      LocalTime officeLocalTime = LocalTime.now(DateTimeZone.UTC.forOffsetHours(office.getTimeDifference()));

      Boolean isAfter = officeLocalTime.isAfter(from);

      Boolean isBefore = officeLocalTime.isBefore(to);

      if ( isAfter && isBefore )
      {
        //The office is open
        return true;
      }

      else
        return false;

    }

  }

  /**
   * Method to check the parameter
   * 
   * 
   * docme: checkParameters()
   *
   * @param office
   * @throws RestServicesException
   */
  private Office checkParameters(Office office) throws RestServicesException
  {

    if ( office == null )
    {
      throw new RestServicesException(10, "The request not content Office to created");

    }

    if ( office.getId() == null || office.getId().isEmpty() )
    {
      throw new RestServicesException(11, "Not Office to created");

    }

    if ( office.getLocation() == null || office.getLocation().isEmpty() )
    {
      throw new RestServicesException(12, "The Office no contains Location parameter");

    }

    if ( office.getTimeDifference() == null )
    {
      throw new RestServicesException(13, "The Office  no contains Time Difference parameter");

    }

    if ( office.getOpenFrom() == null || office.getOpenUntil() == null )
    {
      throw new RestServicesException(14, "The Office no contains opening hours ");

    }

    return office;

  }

}
