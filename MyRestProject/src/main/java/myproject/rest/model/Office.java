package myproject.rest.model;

import org.joda.time.DateTime;

/**
 * 
 * docme: Office
 *
 * @author <a href="mailto:luisdiego162@icloud.com">Luis Diego Larez</a>
 * @version $Rev$
 *
 */
public class Office extends AbstractDataModel
{

  private String name;

  private String location;

  private Integer timeDifference;

  private DateTime openFrom;

  private DateTime openUntil;

  public Office()
  {

  }

  public Office(String location)
  {

    this.location = location;

  }

  public Office(String name, String location)
  {

    this.name = name;
    this.location = location;

  }

  public String getLocation()
  {
    return location;
  }

  public void setLocation(String location)
  {
    this.location = location;
  }

  public Integer getTimeDifference()
  {
    return timeDifference;
  }

  public void setTimeDifference(Integer timeDifference)
  {
    this.timeDifference = timeDifference;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public DateTime getOpenFrom()
  {
    return openFrom;
  }

  public void setOpenFrom(DateTime openFrom)
  {
    this.openFrom = openFrom;
  }

  public DateTime getOpenUntil()
  {
    return openUntil;
  }

  public void setOpenUntil(DateTime openUntil)
  {
    this.openUntil = openUntil;
  }



}
