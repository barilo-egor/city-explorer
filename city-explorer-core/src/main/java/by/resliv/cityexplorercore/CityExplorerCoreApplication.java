package by.resliv.cityexplorercore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class CityExplorerCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CityExplorerCoreApplication.class, args);
    }

}
