package org.codelogger.tutorial.business;

import java.util.ArrayList;
import java.util.List;
import org.codelogger.tutorial.data.api.TodoService;


public class TodoBusinessImpl {

    private TodoService todoService;

    TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retrieveTodosRelatedToSpring(String user) {
        List<String> filteredTodos = new ArrayList<String>();
        List<String> allTodos = todoService.retrieveTodoList(user);
        for (String todo : allTodos) {
            if (todo.contains("Mock")) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public void deleteTodosNotRelatedToSpring(String user) {
        List<String> allTodos = todoService.retrieveTodoList(user);
        for (String todo : allTodos) {
            if (!todo.contains("Mock")) {
                todoService.deleteTodo(todo);
            }
        }
    }
}
