package hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springdata.AppDao;

@Component
public class DeptServ {

	@Autowired
	public AppDao appDao;
	
	public void saveDept(Department d) {
		appDao.saveDept(d);
	}
}
