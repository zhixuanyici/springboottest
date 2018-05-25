package hello;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//mybatis reload xml
@MapperScan("hello.test.dao")
public class Run {

	public static void main(String[] args) {
		SpringApplication.run(Run.class, args);
	}
}
