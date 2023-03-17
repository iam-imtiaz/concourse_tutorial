package springdata;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppService {

	@Autowired
	public AppDao dao;

	public int saveDept(Department d) {
		return dao.saveDepartment(d);
	}
	public int saveDept1(Department d) {
		return dao.saveDepartmentUsingNamedParam(d);
	}
	public List<Map<String, Object>> getDepts() {
		return dao.getDepts();
	}

	public Department getOneDepts(String id) {
		return dao.getOneDepts(id);
	}
}
