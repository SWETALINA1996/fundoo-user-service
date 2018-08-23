package com.bridgelabz.fundoonotes.user.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class LoggerInterceptor extends HandlerInterceptorAdapter{

	private static final Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);

	// DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	//  LocalDateTime now = LocalDateTime.now(); 
	  private long startTime;
	  private long endTime;

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception arg3)
			throws Exception {
		logger.info("Request for"+request.getRequestURI()+" is complete");
		endTime = endTime - startTime;
		logger.info("Time taken to complete the request " +endTime+" ms");
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object object, ModelAndView model)
			throws Exception {
		logger.info("Request for "+request.getRequestURI()+" after execution");
		endTime = System.currentTimeMillis();
		logger.info("EndTime" +endTime+" ms");
		/*endTime = endTime - startTime;
		logger.info("Time taken to complete the request " +endTime+" ms");*/
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object object) throws Exception {
		logger.info("Request before" +request.getRequestURI());
		startTime = System.currentTimeMillis();
		logger.info("StartTime" +startTime+" ms");
		return true;
	}
	
	
	
}
