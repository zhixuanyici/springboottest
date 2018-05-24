package hello;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ConfigurationProperties(prefix="a")
public class MySchoolController {
	
	private String key1;
	private String key2;

	@GetMapping("/schoolName")
	public String getSchoolName(HttpServletRequest request){
		
		request.setAttribute("schoolName","My School Name is Lingbao San gao" + key1);
		
		return "mySchool";
	}
	
	
	@GetMapping("/schoolAddress")
	public String getSchoolAddress(HttpServletRequest request){
		
		request.setAttribute("schoolAddress","My school address is <h1>测试标签</h1>" + key2);
		
		return "mySchool";
	}
	
	
	

	public void setKey1(String key1) {
		this.key1 = key1;
	}

	public void setKey2(String key2) {
		this.key2 = key2;
	}
	
	
	
}
