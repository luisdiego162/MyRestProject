package myproject.rest.model;

import java.util.Date;

import org.joda.time.DateTime;

/**
 * 
 * docme: AbstractDataModel
 *
 * @author <a href="mailto:luisdiego162@icloud.com">Luis Diego Larez</a>
 * @version $Rev$
 *
 */
public abstract class AbstractDataModel
{

  private String id;

  private Date creationDate;

  private Date changedDate;

  public Date getCreationDate()
  {
    return creationDate;
  }

  public void setCreationDate(Date creationDate)
  {
    this.creationDate = creationDate;
  }

  public Date getChangedDate()
  {
    return changedDate;
  }

  public void setChangedDate(Date changedDate)
  {
    this.changedDate = changedDate;
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

}
