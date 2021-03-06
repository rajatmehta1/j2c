package j2c;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.support.SpringBootServletInitializer;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableCaching
@EnableAsync
@ComponentScan(basePackages = {"j2c.controllers","j2c.daos","j2c.test", "j2c.algo"})
public class J2CWebApplication  extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(J2CWebApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(J2CWebApplication.class, args);
    }

}
