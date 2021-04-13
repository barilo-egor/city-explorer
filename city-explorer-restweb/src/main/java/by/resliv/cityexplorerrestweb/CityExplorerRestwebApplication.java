package by.resliv.cityexplorerrestweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan("by.resliv")
@PropertySource("classpath:restweb.properties")
public class CityExplorerRestwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CityExplorerRestwebApplication.class, args);
    }

}
