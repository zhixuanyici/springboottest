package hello.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.test.dao.ScoreDao;
import hello.test.entity.Account;
import hello.test.service.ScoreService;

@Service
public class ScoreServiceImpl implements ScoreService {
	
	@Autowired
	private ScoreDao scoreDao;

	@Override
	public String getScore() {
		
		List<Account> lists = scoreDao.getScore();
		String name = "";
		for (Account account : lists) {
			
			name = account.getAccoutName();
		}
		return name;
	}

}
