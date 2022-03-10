package com.example.aop2;

import com.example.aop2.order.aop.AspectV1Advice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class Aop2Application {

	public static void main(String[] args) {
		SpringApplication.run(Aop2Application.class, args);
	}

}
