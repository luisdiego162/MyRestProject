package myproject.rest.controller;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.Locale;
import java.util.Random;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import myproject.rest.model.Office;

@ContextConfiguration(locations = {"classpath*:/WEB-INF/spring-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class RestOfficeControllerTest
{

  @Autowired
  protected WebApplicationContext _wac;

  protected MockMvc _mockMvc;

  @Before
  public void setup() throws Exception
  {
    // logging
    System.out.println("Setup Office Controller test case");

    // set language
    LocaleContextHolder.setLocale(new Locale("en"));

    // Process mock annotations
    MockitoAnnotations.initMocks(this);

    // Setup Spring test in standalone mode
    _mockMvc = MockMvcBuilders.webAppContextSetup(_wac).build();

  }

  /**
   * 
   * docme: createOffice()
   *
   * @throws Exception
   */
  @Test
  public void createOffice() throws Exception
  {

    Office office = new Office();

    Random randomGenerator = new Random();
    int randomInt = randomGenerator.nextInt(1000);

    office.setId("test" + randomInt);

    ObjectMapper objectMapper = new ObjectMapper();

    byte[] bytes = objectMapper.writeValueAsBytes(office);

    // create a request
    ResultActions ra =
      _mockMvc.perform(post("/office/create").contentType(MediaType.APPLICATION_JSON).content(bytes));

    // get the response content
    String json = ra.andReturn().getResponse().getContentAsString();
    System.out.println(json);

    Office officeCreated =
      new ObjectMapper().setSerializationInclusion(Inclusion.NON_NULL).readValue(json, new TypeReference<Office>() {
      });
    System.out.println("TEST Office Create Id" + officeCreated.getId());

    assertTrue("Office created", officeCreated != null);

  }

  /**
   * 
   * docme: getAllOffice()
   *
   * @throws Exception
   */
  @Test
  public void getAllOffice() throws Exception
  {

    // create a request
    ResultActions ra = _mockMvc.perform(get("/office/getAll").contentType(MediaType.APPLICATION_JSON));

    // get the response content
    String json = ra.andReturn().getResponse().getContentAsString();
    System.out.println(json);


  }

}
