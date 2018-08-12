package org.codelogger.tutorial.business;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.codelogger.tutorial.business.TodoBusinessImpl;
import org.codelogger.tutorial.data.api.TodoService;
import org.codelogger.tutorial.data.stub.TodoServiceStub;
import org.junit.Test;


public class TodoBusinessImplStubTest {

	@Test
	public void usingAStub() {

		TodoService todoService = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Defei");

		assertEquals(2, todos.size());
	}
}
