
package com.exilant.training.spring.data;

import com.exilant.training.spring.mvc.model.Message;

public interface MessageRepository {

	Iterable<Message> findAll();

	Message save(Message message);

	Message findMessage(Long id);

	void deleteMessage(Long id);

}
