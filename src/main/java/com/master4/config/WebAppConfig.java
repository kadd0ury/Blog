package com.master4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


import com.master4.Interceptors.LogInterceptor;
import com.master4.Interceptors.PermissionInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.master4" })
public class WebAppConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver resolver(){
        InternalResourceViewResolver resolvers =new InternalResourceViewResolver();
        resolvers.setViewClass(JstlView.class);
        resolvers.setPrefix("/WEB-INF/views/");
        resolvers.setSuffix(".jsp");
        return resolvers;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }
    

    
    @Override
    public void addInterceptors (InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .addPathPatterns(new String[]{
         "/*","/article/*","/tag/*","/user/*"
                }).excludePathPatterns("/login");
        
        
        registry.addInterceptor(new PermissionInterceptor()).addPathPatterns(new String[]{
        		
        		"/article/add","/article/delete/*/*","/article/add/*",
        		"/tag/add","/tag/add/*","/user/add","/user/add/*",
        		
        		
               // "/article/add/*","/article/save/*","/article/delete/*"
        });
        
        
        
        
        

    }
    
    
    
    
    
    
    
    
    
    
    

}
