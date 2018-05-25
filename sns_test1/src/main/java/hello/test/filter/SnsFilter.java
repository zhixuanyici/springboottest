package hello.test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hello.test.listener.SnsListener;

public class SnsFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(SnsListener.class);

	@Override
	public void destroy() {
		logger.info("销毁过滤器");

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		long start = System.currentTimeMillis();
		arg2.doFilter(arg0, arg1);
		logger.info("filter 耗时：" + (System.currentTimeMillis() - start));

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		logger.info("初始化过滤器");

	}

}
