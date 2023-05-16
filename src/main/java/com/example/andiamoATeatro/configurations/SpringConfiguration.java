package com.example.andiamoATeatro.configurations;

import com.example.andiamoATeatro.interceptors.UtenteInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class SpringConfiguration implements WebMvcConfigurer {

    @Autowired
    private UtenteInterceptor utenteInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(utenteInterceptor);
    }
}
