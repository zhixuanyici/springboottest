package hello.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class SnsInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(SnsInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		logger.info("========afterCompletion=========");
		Long start = (Long) arg0.getAttribute("startTime");
		logger.info("耗时:" + (System.currentTimeMillis() - start));
		if(arg3!=null){
			logger.info(arg3.getMessage());
		}

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

		logger.info("========postHandle=========");
		Long start = (Long) arg0.getAttribute("startTime");
		logger.info("耗时:" + (System.currentTimeMillis() - start));

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		logger.info("========preHandle=========");
		logger.info(((HandlerMethod) arg2).getBean().getClass().getName());
		logger.info(((HandlerMethod) arg2).getMethod().getName());
		arg0.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}

}
