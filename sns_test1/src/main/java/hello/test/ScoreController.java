package hello.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.test.service.ScoreService;

@RestController
@RequestMapping("/score")
public class ScoreController {
	
	@Autowired
	ScoreService scoreService;

	@GetMapping("scoreInfo")
	public String getScore(){
		return scoreService.getScore();
	}
}
