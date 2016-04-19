package myproject.rest.controller;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import myproject.rest.exceptions.RestServicesException;
import myproject.rest.model.Office;
import myproject.rest.service.OfficeService;

/**
 * 
 * docme: RestOfficeController
 *
 * @author <a href="mailto:luisdiego162@icloud.com">Luis Diego Larez</a>
 * @version $Rev$
 *
 */
@RestController
@RequestMapping("/office")
public class RestOfficeController extends AbstractRestController
{

  @Autowired
  OfficeService officeService;

  /**
   * 
   * docme: createOffice()
   *
   * @param office
   * @return
   */
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  @ResponseBody
  @Produces(MediaType.APPLICATION_JSON)
  public Response createOffice(Office office) throws RestServicesException
  {

    Office officeCreated = officeService.createOffice(office);

    if ( officeCreated != null )
    {
      String officeId = officeCreated.getId();

      return Response
          .status(Response.Status.OK)
          .entity("A new office has been created with new id: " + officeId)
          .build();
    }

    else

    {

      return Response.status(Response.Status.EXPECTATION_FAILED).entity("Error created new Office ").build();

    }

  }

  /**
   * 
   * docme: getAllOffices()
   *
   * @return
   */
  @RequestMapping(value = "/getAll", method = RequestMethod.GET)
  @ResponseBody
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllOffices() throws RestServicesException
  {
    List<Office> listOffices = officeService.getAllOffice();

    return Response.ok(listOffices, MediaType.APPLICATION_JSON).build();

    //return listOffices;
  }

  /**
   * 
   * docme: getAllOpenOffices()
   *
   * @return
   */
  @RequestMapping(value = "/getAllOpen", method = RequestMethod.GET)
  @ResponseBody
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllOpenOffices() throws RestServicesException
  {
    List<Office> listOffices = officeService.getAllOfficeOpenNow();

    return Response.ok(listOffices, MediaType.APPLICATION_JSON).build();

  }

  /**
   * 
   * docme: getAllOpenById()
   *
   * @param officeId
   * @return
   */
  @RequestMapping(value = "/getOfficeDetails/{officeId}", method = RequestMethod.GET)
  @ResponseBody
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllOpenById(@PathVariable(value = "officeId") String officeId) throws RestServicesException
  {

    Office office = officeService.getOfficeById(officeId);

    if ( office == null )
    {
      //TODO:
      //good practice create logger and save all info in the server, example:
      //logger.info(Office not found for id number: " + officeId)

      return Response
          .status(Response.Status.NOT_FOUND)
          .entity("Office not found for id number: " + officeId)
          .build();

    }

    return Response.ok(office, MediaType.APPLICATION_JSON).build();

  }

}
