package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@EnableAutoConfiguration
@RequestMapping(value="/test")
@ConfigurationProperties(prefix="b")
public class TestController {
	
	@Autowired
	String nimenhao;
	
	@Value("${b.result1}")
	private String result2;
	
	private String result1;
	
	@RequestMapping("/nihao")
	@ResponseBody
	String nihao(){
		return "nihao"+result2;
	}
	
	
	
	@RequestMapping(value="/nimenhao")
	@ResponseBody
	String nimenhaoResu(){
		return nimenhao+result1;
	}


	public void setResult1(String result1) {
		this.result1 = result1;
	}
	
//	public static void main(String[] args) {
//		SpringApplication.run(TestController.class, args);
//	}
	
	

}
