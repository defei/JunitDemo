package org.codelogger.tutorial.business;

import java.util.Arrays;
import java.util.List;
import org.codelogger.tutorial.data.api.TodoService;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class TodoBusinessImplMockitoTest {

    @Test
    public void usingMockito() {
        List<String> allTodos = Arrays.asList("学习Junit",
                "学习Mockito", "学习PowerMock");

        //撒气方法调用及返回
        TodoService todoService = mock(TodoService.class);
        when(todoService.retrieveTodoList("Defei")).thenReturn(allTodos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        List<String> todos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Defei");

        assertEquals(2, todos.size());
    }

    @Test
    public void usingMockito_UsingBDD() {
        List<String> allTodos = Arrays.asList("学习Junit",
                "学习Mockito", "学习PowerMock");

        //模拟
        TodoService todoService = mock(TodoService.class);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        given(todoService.retrieveTodoList("Defei")).willReturn(allTodos);

        //执行
        List<String> todos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Defei");

        //断言
        assertThat(todos.size(), is(2));
    }

    @Test
    public void letsTestDeleteNow() {

        TodoService todoService = mock(TodoService.class);

        List<String> allTodos = Arrays.asList("学习Junit",
                "学习Mockito", "学习PowerMock");

        when(todoService.retrieveTodoList("Defei")).thenReturn(allTodos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

        todoBusinessImpl.deleteTodosNotRelatedToSpring("Defei");

        verify(todoService).deleteTodo("学习Junit");

        verify(todoService, Mockito.never()).deleteTodo("学习Mockito");

        verify(todoService, Mockito.never()).deleteTodo("学习PowerMock");

        verify(todoService, Mockito.times(1)).deleteTodo("学习Junit");
        // Mockito.atLeastOnce, Mockito.atLeast 也可以用于判断至少调用了多少次

    }

    /**
     * 获取模拟方法调用时传的参数
     */
    @Test
    public void captureArgument() {

        List<String> allTodos = Arrays.asList("学习Junit",
                "学习Mockito", "学习PowerMock");

        //模拟
        TodoService todoService = mock(TodoService.class);
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor
                .forClass(String.class);
        Mockito.when(todoService.retrieveTodoList("Defei")).thenReturn(allTodos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Defei");

        //验证
        Mockito.verify(todoService).deleteTodo(argumentCaptor.capture());

        //断言
        assertEquals("学习Junit", argumentCaptor.getValue());
    }
}
