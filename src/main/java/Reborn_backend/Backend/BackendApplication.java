package Reborn_backend.Backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

@SpringBootApplication
public class BackendApplication {
	private static final Logger logger = LoggerFactory.getLogger(BackendApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	CommandLineRunner mostrarServidor(Environment env) {
		return args -> {
			InetAddress ip = InetAddress.getLocalHost();
			String puerto = env.getProperty("local.server.port");

			logger.info("========================================");
			logger.info("        REBORN BACKEND INICIADO");
			logger.info("========================================");
			logger.info("IP:     {}", ip.getHostAddress());
			logger.info("Puerto: {}", puerto);
			logger.info("URL:    http://{}:{}", ip.getHostAddress(), puerto);
			logger.info("========================================");
		};
	}

}
