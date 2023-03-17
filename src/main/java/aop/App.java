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
	
	try {
      File myObj = new File("version.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
}
