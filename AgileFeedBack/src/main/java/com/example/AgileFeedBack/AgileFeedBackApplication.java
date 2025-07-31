package com.example.AgileFeedBack;


import agilefeedback.model.Enum.RoleType;
import agilefeedback.model.User;
import agilefeedback.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("agilefeedback")  // Scanne les composants comme les services et contrôleurs
@EnableJpaRepositories("agilefeedback.repository")  // Scanne les repositories
@EntityScan("agilefeedback.model")  // Scanne les entités JPA
public class AgileFeedBackApplication {
	public static void main(String[] args) {
		SpringApplication.run(AgileFeedBackApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			if (userRepository.findByEmail("admin").isEmpty()) {
				User admin = new User();
				admin.setEmail("admin");
				admin.setPassword("admin");
				admin.setRole(RoleType.ADMIN);
				userRepository.save(admin);
				System.out.println("Admin par défaut créé !");
			}
		};
	}
}