package dio.desafiopadroesprojeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DesafioPadroesProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioPadroesProjetoApplication.class, args);
	}

}
