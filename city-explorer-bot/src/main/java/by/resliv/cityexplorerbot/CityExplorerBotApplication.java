package by.resliv.cityexplorerbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "by.resliv")
public class CityExplorerBotApplication {
    public static void main(String[] args) {
        SpringApplication.run(CityExplorerBotApplication.class, args);
    }

}
