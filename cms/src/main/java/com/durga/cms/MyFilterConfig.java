package com.durga.cms;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.durga.cms.filters.myNewFilter;

@Configuration
public class MyFilterConfig 
{
	      @Bean
          public FilterRegistrationBean<myNewFilter> filterRegistrationBean()
          {
        	  FilterRegistrationBean<myNewFilter> filterRegistrationBean=new FilterRegistrationBean<>();
        	  filterRegistrationBean.setFilter(new myNewFilter());
        	  filterRegistrationBean.addUrlPatterns("/customers/*");
        	  return filterRegistrationBean;
          }
}
