package de.javengers.addressbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("de.javengers.addressbook.entity")
public class AddressbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressbookApplication.class, args);
	}

}
