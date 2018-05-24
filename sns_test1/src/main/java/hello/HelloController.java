package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/hello")
@ConfigurationProperties(prefix="s")
public class HelloController {
	
	@Autowired
	String helloOne;
	
	private String key3;

	@GetMapping("helloOne")
	public String getHelloOne(){
		return "hao     +" + helloOne + key3;
	}

	
	
	public void setKey3(String key3) {
		this.key3 = key3;
	}
	
	
	
	
}
