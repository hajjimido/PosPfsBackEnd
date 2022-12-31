package PosBackend;

import PosBackend.Domain.*;
import PosBackend.Repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PosBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosBackendApplication.class, args);
	}


	@Bean
	CommandLineRunner Start(EntrepriseRepository entrepriseRepository,
							EntrepotRepository entrepotRepository,
							ManagerRepository managerRepository,
							AdminRepository adminRepository,
							VendeurRepository vendeurRepository

							) {
		return args -> {
			Admin admin=new Admin("mehdi","hajji","mhajji805@gmail.com","hh","dd","dd",null);
			//adminRepository.save(admin);
			Entreprise entreprise=new Entreprise("1","2021","missimi","metier",admin,null);
			entrepriseRepository.save(entreprise);
			//Entrepot entrepot=new Entrepot("1","",null,entreprise,null);
			//entrepotRepository.save(entrepot);
			//Manager manager=new Manager("mehdi","hajji","ddee","dd","dd",entrepot,null);
			//managerRepository.save(manager);
			//Vendeur vendeur=new Vendeur("mehdi","hajji","ddee","dd","dd",manager);
			//vendeurRepository.save(vendeur);

		};
	}


}
