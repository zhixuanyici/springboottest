package hello.test.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import hello.test.filter.SnsFilter;
import hello.test.interceptor.SnsInterceptor;
import hello.test.listener.SnsListener;

@Configuration
public class InitConfig extends WebMvcConfigurerAdapter {

	// 注册过滤器
	@Bean
	public FilterRegistrationBean InitFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		SnsFilter timeFilter = new SnsFilter();
		registrationBean.setFilter(timeFilter);
		List<String> urls = new ArrayList<>();
		urls.add("/*");
		registrationBean.setUrlPatterns(urls);
		return registrationBean;
	}

	// 注册监听器
	@Bean
	public ServletListenerRegistrationBean<SnsListener> servletListenerRegistrationBean() {
		return new ServletListenerRegistrationBean<SnsListener>(new SnsListener());
	}

	// 注册拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 多个拦截器组成一个拦截器链
		// addPathPatterns 用于添加拦截规则
		// excludePathPatterns 用户排除拦截
		registry.addInterceptor(new SnsInterceptor()).addPathPatterns("/**");
		// registry.addInterceptor(new
		// snsInterceptor2()).addPathPatterns("/**");
	}

}
