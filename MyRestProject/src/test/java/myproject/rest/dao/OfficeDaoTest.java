package myproject.rest.dao;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myproject.rest.model.Office;

/**
 * 
 * docme: OfficeDaoTest
 *
 * @author <a href="mailto:luisdiego162@icloud.com">Luis Diego Larez</a>
 * @version $Rev$
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/META-INF/spring/module-test-my-rest-project-dao.xml"})
public class OfficeDaoTest
{

  @Autowired
  OfficeDao officeDao;

  @Test
  public void testConnectionDB()
  {

    Configuration configuration = new Configuration().configure();
    StandardServiceRegistryBuilder builder =
      new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    SessionFactory factory = configuration.buildSessionFactory(builder.build());
    Session session = factory.openSession();
    Office office = new Office("Test_location");
    office.setId("test3");
    office.setName("Berlin_Office");

    session.beginTransaction();
    session.save(office);
    session.getTransaction().commit();

  }

  /**
   * 
   * docme: createOffice()
   *
   */
  @Test
  public void createOffice()
  {
    Random randomGenerator = new Random();

    //Arrange
    Office office = new Office("Melbourne");
    office.setId("aus0" + randomGenerator.nextInt(1000));
    office.setName("Melbourne_Office");

    DateTime timeOpen = new DateTime(2015, 1, 1, 8, 0);

    office.setOpenFrom(timeOpen);

    DateTime timeUntil = new DateTime(2015, 1, 1, 18, 0);

    office.setOpenUntil(timeUntil);

    office.setTimeDifference(randomGenerator.nextInt(10));

    //Act

    Office officeCreated = officeDao.createOffice(office);

    //Assert

    assertNotNull(officeCreated);

  }

  /**
   * 
   * docme: getAllOffice()
   *
   */
  @Test
  public void getAllOffice()
  {

    //Arrange
    Office office = new Office("Test_location");
    office.setId("test2");
    office.setName("Berlin_Office");

    //Act

    List<Office> officeCreated = officeDao.getAllOffice();

    //Assert

    assertNotNull(officeCreated);

  }

  /**
   * 
   * docme: getOfficeById()
   *
   */
  @Test
  public void getOfficeById()
  {

    //Arrange

    String id = "test3";

    //Act

    Office officeFounded = officeDao.getOfficeById(id);

    //Assert

    assertNotNull(officeFounded);

  }

}
