package hello.test.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hello.test.entity.Account;

@Repository
public class ScoreDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	
	public List<Account> getScore() {
		
		List<Account> list = jdbcTemplate.query("select * from account where id = ?", new Object[]{1}, new BeanPropertyRowMapper(Account.class));
        
		return list;
		
//		String sql = "SELECT app_id,app_secret FROM t_sns_oauth_user WHERE app_id = ?";
//		String sql = "select * from account where id = ?";
//		Object[] params = new Object[]{"1"};
//		return jdbcTemplate.queryForList(sql,params);
	}
	
	
}
