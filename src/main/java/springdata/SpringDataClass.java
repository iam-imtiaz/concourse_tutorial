package springdata;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import hibernate.AppConf;
import hibernate.DeptServ;

public class SpringDataClass {
public static void main(String[] args) {
	ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConf.class);
	Employee e = (Employee) ctx.getBean("emp");
	
	hibernate.Department d = (hibernate.Department)ctx.getBean("hib_dept");
//	
//	System.out.println(e);
//	System.out.println(d);
//	
	d.setDeptId("D002X");
	d.setDeptName("HRXXX");
//	
//	AppService serv = ctx.getBean(AppService.class);
////	serv.saveDept1(d);
//	System.out.println(serv.getDepts());
//	System.out.println(serv.getDepts().get(0).get("dname"));
	
//	System.out.println(serv.getOneDepts("D001").getDeptName());
	OrderService osrv = ctx.getBean(OrderService.class);
//	osrv.saveOrders("O003", "Desc", "C003", "P003", "I003");
	
	DeptServ ds = ctx.getBean(DeptServ.class);
	ds.saveDept(d);
	
	
}
}
