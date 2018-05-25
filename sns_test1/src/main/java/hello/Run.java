package hello;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//mybatis reload xml
@MapperScan("hello.test.dao")
public class Run{
	
	
//	/**
//	 * 可以将其项目达成war包只需:
//	 * 1.extends SpringBootServletInitializer
//	 * 2.重写configure
//	 * 3.修改pom.xml中的jar为war
//	 * @param application
//	 * @return
//	 */
//	//extends SpringBootServletInitializer
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//	return application.sources(Run.class);
//	}

	
	public static void main(String[] args) {
		SpringApplication.run(Run.class, args);
	}
}
