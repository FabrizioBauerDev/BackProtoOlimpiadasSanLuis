package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Permite todos los endpoints bajo "/"
                .allowedOrigins("http://localhost:3000")  // Reemplaza con el origen de tu frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Métodos HTTP permitidos
                .allowCredentials(true);  // Permite enviar credenciales (cookies, tokens, etc.)
    }
}

