package org.codelogger.tutorial.data.stub;

import java.util.Arrays;
import java.util.List;
import org.codelogger.tutorial.data.api.TodoService;


public class TodoServiceStub implements TodoService {

    public List<String> retrieveTodoList(String user) {

        return Arrays.asList("学习Junit", "学习Mockito",
                "学习PowerMock");
    }

    public void deleteTodo(String todo) {

    }
}