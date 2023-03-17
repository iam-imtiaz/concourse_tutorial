package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
public static void main(String[] args) throws Exception {
	ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConf.class);
	Service s = ctx.getBean(Service.class);
	s.addAccount();
	System.out.println("_____________________________");
	s.getBalance();
	s.meth();
	
  }
}

