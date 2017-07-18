/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.configuration;

import java.util.HashSet;
import java.util.Set; 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import rashjz.info.com.az.util.StaticParams;

/**
 *
 * @author Rashad Javadov
 */
@EnableWebMvc
@Configuration
@ComponentScan({"rashjz.info.com.az"})
public class SpringWebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/uploads/**").addResourceLocations("file:" + StaticParams.UPLOAD_LOCATION);
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
        rb.setBasenames(new String[]{"messages/messages", "messages/validation", "application"});
        rb.setDefaultEncoding("UTF-8");
        return rb;
    }

//    @Bean
//    public LocaleResolver localeResolver() {
//        CookieLocaleResolver resolver = new CookieLocaleResolver();
//        resolver.setDefaultLocale(new Locale("en"));
//        resolver.setCookieName("bpLocaleCookie");
//        resolver.setCookieMaxAge(4800);
//        return resolver;
//    }
    @Override //?lang=en
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        registry.addInterceptor(interceptor);
    }

    //before add upload dependecies 
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver createMultipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("utf-8");
        return resolver;
    }

//      @Bean
//    public SimpleMappingExceptionResolver exceptionResolver() {
//        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
// 
//        Properties exceptionMappings = new Properties();
// 
//        exceptionMappings.put("java.lang.Exception", "error/error");
//        exceptionMappings.put("java.lang.RuntimeException", "error/error");
// 
//        exceptionResolver.setExceptionMappings(exceptionMappings);
// 
//        Properties statusCodes = new Properties();
// 
//        statusCodes.put("error/404", "404");
//        statusCodes.put("error/error", "500");
// 
//        exceptionResolver.setStatusCodes(statusCodes);
// 
//        return exceptionResolver;
//    }
}
