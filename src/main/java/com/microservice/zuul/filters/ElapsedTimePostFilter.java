package com.microservice.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ElapsedTimePostFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(ElapsedTimePostFilter.class);
	@Override
	public boolean shouldFilter() {
		
		//Validar cuando se debe ejecutar el filtro
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		log.info("Entrando a Post");
		Long initTime = (Long) request.getAttribute("initTime");
		Long finalTime = System.currentTimeMillis();
		Long time = initTime - finalTime;

		log.info(String.format("Time: %s", time.doubleValue() / 1000.00));
		log.info(String.format("Time miliseconds: %s", time));
		return null;
	}

	@Override
	public String filterType() {
		
		//Se coloca el prefijo del filtro a definir pre o post
		return "post";
	}

	@Override
	public int filterOrder() {
		
		return 1;
	}

}
