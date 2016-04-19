package myproject.rest.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import myproject.rest.model.Office;

/**
 * 
 * docme: OfficeDaoImpl
 *
 * @author <a href="mailto:luisdiego162@icloud.com">Luis Diego Larez</a>
 * @version $Rev$
 *
 */
@Transactional
public class OfficeDaoImpl extends AbstractDao implements OfficeDao
{

  public OfficeDaoImpl()
  {

  }

  /**
   * 
   * docme: createOffice()
   *
   * @param office
   * @return
   */

  public Office createOffice(Office office)
  {

    if ( office == null )
    {
      // return exception
    }

    Session session = getSessionFactory().getCurrentSession();

    office.setCreationDate(new Date());

    session.persist(office);

    return office;
  }

  /**
   * 
   * docme: getAllOffice()
   *
   * @return
   */
  @Transactional
  public List<Office> getAllOffice()
  {

    Session session = getSessionFactory().getCurrentSession();

    Criteria criteria = session.createCriteria(Office.class);

    List<Office> listOffice = criteria.list();

    return listOffice;
  }

 

  /**
   * 
   * docme: getOfficeById()
   *
   * @param id
   * @return
   */
  public Office getOfficeById(String id)
  {
    Session session = getSessionFactory().getCurrentSession();

    Criteria criteria = session.createCriteria(Office.class);

    criteria.add(Restrictions.eq("id", id));

    return (Office) criteria.uniqueResult();

  }

  

}
