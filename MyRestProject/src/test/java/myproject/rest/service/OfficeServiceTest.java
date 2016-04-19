package myproject.rest.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Random;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myproject.rest.exceptions.RestServicesException;
import myproject.rest.model.Office;

/**
 * 
 * docme: OfficeServiceTest
 *
 * @author <a href="mailto:luisdiego162@icloud.com">Luis Diego Larez</a>
 * @version $Rev$
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
  "classpath*:/META-INF/spring/module-test-my-rest-project-service.xml",
  "classpath*:/META-INF/spring/module-test-my-rest-project-dao.xml"})
public class OfficeServiceTest
{

  @Autowired
  OfficeService officeService;

  @Test
  public void createOffice()
  {

    Random randomGenerator = new Random();

    try
    {
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

      Office officeCreated = officeService.createOffice(office);

      //Assert

      assertNotNull(officeCreated);

    }

    catch (RestServicesException e)
    {
      e.getMessage();

    }
  }

  /**
   * 
   * docme: getAllOfficeOpenNow()
   *
   */
  @Test
  public void getAllOfficeOpenNow()
  {

    try
    {

      //Arrange

      //Act
      List<Office> listOfficeOpenNow = officeService.getAllOfficeOpenNow();

      //Assert

      assertNotNull(listOfficeOpenNow);
    }

    catch (RestServicesException e)
    {
      e.getMessage();

    }

  }

}
