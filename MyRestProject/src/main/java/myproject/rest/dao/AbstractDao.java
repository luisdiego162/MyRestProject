package myproject.rest.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * docme: AbstractDao
 *
 * @author <a href="mailto:luisdiego162@icloud.com">Luis Diego Larez</a>
 * @version $Rev$
 *
 */
public abstract class AbstractDao
{

  private SessionFactory sessionFactory;

  public SessionFactory getSessionFactory()
  {
    return sessionFactory;
  }

  @Autowired
  public void setSessionFactory(SessionFactory sessionFactory)
  {
    this.sessionFactory = sessionFactory;
  }

}
