package myproject.rest.dao;

import java.util.List;

import myproject.rest.model.Office;

/**
 * 
 * docme: OfficeDao
 *
 * @author <a href="mailto:luisdiego162@icloud.com">Luis Diego Larez</a>
 * @version $Rev$
 *
 */
public interface OfficeDao
{

  Office getOfficeById(String id);

  Office createOffice(Office office);

  List<Office> getAllOffice();

}
