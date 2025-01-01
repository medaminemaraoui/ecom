package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Customer.class);

            customerRepository.saveAll(
                    List.of(
                            Customer.builder().name("hassan").email("Hassangmail.com").build(),
                            Customer.builder().name("amine").email("aminegmail.com").build(),
                            Customer.builder().name("hajar").email("Hajargmail.com").build()
                    )

            );
            customerRepository.findAll().forEach(c->
            {
                System.out.println(c);
            });
        };
    }

}
