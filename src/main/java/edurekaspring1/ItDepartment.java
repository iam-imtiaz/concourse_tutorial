package edurekaspring1;

import org.springframework.stereotype.Component;

@Component("itdepartment")
public class ItDepartment implements Department {

	private String deptName;
	
	

//	public Department(String deptName) {
//		super();
//		this.deptName = deptName;
//	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Department [deptName=" + deptName + "]";
	}
	
}
