
package com.exilant.training.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

import com.exilant.training.spring.data.H2MessageRepository;
import com.exilant.training.spring.data.MessageRepository;
import com.exilant.training.spring.mvc.model.Message;

@SpringBootApplication
public class SpringTrainingApp {

	@Bean
	public MessageRepository messageRepository() {
		return new H2MessageRepository();
	}

	@Bean
	public Converter<String, Message> messageConverter() {
		return new Converter<String, Message>() {
			@Override
			public Message convert(String id) {
				return messageRepository().findMessage(Long.valueOf(id));
			}
		};
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringTrainingApp.class, args);
	}

}
