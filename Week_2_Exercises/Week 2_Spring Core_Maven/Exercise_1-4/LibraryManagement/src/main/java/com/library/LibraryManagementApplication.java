package com.library;

import com.library.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class LibraryManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            ApplicationContext xmlContext = new ClassPathXmlApplicationContext("applicationContext.xml");
            BookService bookService = (BookService) xmlContext.getBean("bookService");
            // Print the BookService instance to verify it is correctly wired
            System.out.println("BookService instance from XML context: " + bookService);
            bookService.performService();
        };
    }
}
