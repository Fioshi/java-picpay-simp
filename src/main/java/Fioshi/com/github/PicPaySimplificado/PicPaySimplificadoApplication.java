package Fioshi.com.github.PicPaySimplificado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableAsync
@SpringBootApplication
public class PicPaySimplificadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicPaySimplificadoApplication.class, args);
	}

}
