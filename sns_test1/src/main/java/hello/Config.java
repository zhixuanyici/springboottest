package hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootConfiguration
@PropertySource(value={"classpath:a.properties","classpath:config/b.properties"})
public class Config {

	@Bean
	public String nimenhao(){
		return "nimenhao";
	}
	
	@Bean
	public String helloOne(){
		return "Hello one hello";
	}
	
	@Value(value="key1")
	public String key1;

	@Value(value="key2")
	public String key2;
	
	
	@Value(value="key3")
	public String key3;
	
	@Value(value="result1")
	public String result1;
	
	
}
