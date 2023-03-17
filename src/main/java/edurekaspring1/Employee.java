package edurekaspring1;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("employee")
@Scope("prototype")
//@Lazy
public class Employee implements InitializingBean, BeanNameAware, ApplicationContextAware{

	private String empId;
	private String empName;
	@Autowired
	@Qualifier("itdepartment")
	private Department dept1;
	
//	public Employee(String empId, String empName, Department department) {
//		super();
//		this.empId = empId;
//		this.empName = empName;
//		this.department = department;
//	}
	
	public Employee() {
		System.out.println("Employee cons ........");
	}
	
	@PostConstruct
	public void postCons() {
		
		System.out.println("From post cons");
		
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Department getDept1() {
		return dept1;
	}
	public void setDept1(Department department) {
		this.dept1 = department;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", department=" + dept1 + "]";
	}


	public void afterPropertiesSet() throws Exception {
		System.out.println("After emp cons");
		
	}
	
	public void setBeanName(String name) {
		System.out.println("Bean name::: "+name);
		
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("applicationContext  aware:::"+applicationContext.containsBean("employee"));
	}
	
	
}
