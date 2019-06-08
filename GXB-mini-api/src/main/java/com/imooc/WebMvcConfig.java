package com.imooc;



import com.imooc.Controller.interceptor.MiniInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**")
		.addResourceLocations("classpath:/META-INF/resources/")
				.addResourceLocations("file:C:/imooc_videos_dev/");
	}
	@Bean
	public MiniInterceptor miniInterceptor() {

		return new MiniInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(miniInterceptor()).addPathPatterns("/user/uploadFace","/user/query"
		,"/user/order","/user/reportUser")
				.addPathPatterns("/oderform/saveComment")
				.excludePathPatterns("/user/queryPublisher");
		super.addInterceptors(registry);
	}


}
