package ch.my.config;
import java.lang.reflect.ParameterizedType;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig<T> {
  public SpringConfig()  {
	  ParameterizedType tyeps =  (ParameterizedType) this.getClass().getGenericSuperclass();
	  Class<?> classz;
	try {
		classz = Class.forName(tyeps.getActualTypeArguments()[0].getTypeName());
		System.out.println(classz);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	  
  }
  static class UUi extends SpringConfig<String>{
	  
  }
  public static void main(String[] args) {
	  UUi u = new UUi();
}
}
