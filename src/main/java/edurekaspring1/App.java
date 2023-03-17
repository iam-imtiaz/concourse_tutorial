package edurekaspring1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {

	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		ItDepartment itdept = (ItDepartment) ctx.getBean("itdepartment");
		itdept.setDeptName("IT");
		System.out.println("------------------------------------------------------");
		Employee emp = (Employee) ctx.getBean("employee");
		emp.setEmpId("E101");
		emp.setEmpName("Samir Datta");
		System.out.println(emp.hashCode());
		System.out.println("------------------------------------------------------");
		Employee emp1 = (Employee) ctx.getBean("employee");
		System.out.println(emp1.hashCode());
		
		System.out.println(emp);
		ctx.close();
	}

}
