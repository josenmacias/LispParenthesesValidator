package org.jose.lispvalidator;

import lombok.extern.slf4j.Slf4j;
import org.jose.lispvalidator.logic.ParenthesesValidator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ListParenthesesValidatorApplication implements CommandLineRunner {

    public static void main(String[] args) {
        log.info("Starting the Application");
        SpringApplication.run(ListParenthesesValidatorApplication.class, args);
        log.info("Application Ended");
    }

    @Override
    public void run(String... args) throws Exception {
//        String lispContents = "{()}[]";
        String lispContents = """
                {}
                ({}(
                ){})
                (())
                """;
        boolean isValid = ParenthesesValidator.validate(lispContents);
        if (isValid) {
            System.out.println("Is Valid");
        } else {
            System.out.println("Is Not Valid");
        }
    }
}
