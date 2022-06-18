package com.microservice.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.protocol.RequestContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ElapsedTimePreFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(ElapsedTimePreFilter.class);
	@Override
	public boolean shouldFilter() {
		
		//Validar cuando se debe ejecutar el filtro
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		log.info(String.format("%s request enrut A %s", request.getMethod(), request.getRequestURL().toString()));
		Long initTime = System.currentTimeMillis();
		request.setAttribute("initTime", initTime);
		return null;
	}

	@Override
	public String filterType() {
		
		//Se coloca el prefijo del filtro a definir pre o post
		return "pre";
	}

	@Override
	public int filterOrder() {
		
		return 1;
	}

}
