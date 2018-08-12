package org.codelogger.tutorial.business;

import java.util.Arrays;
import java.util.List;
import org.codelogger.tutorial.data.api.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * 使用Mockito框架中的注解,必须使用{@link MockitoJUnitRunner} 或参考 {@link TodoBusinessImplMockitoRulesTest}
 * 指定Junit规则
 */
@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoInjectMocksTest {

    @Mock
    TodoService todoService;

    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @Test
    public void usingMockito() {
        List<String> allTodos = Arrays.asList("学习Junit",
                "学习Mockito", "学习PowerMock");

        when(todoService.retrieveTodoList("Defei")).thenReturn(allTodos);

        List<String> todos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Defei");

        assertEquals(2, todos.size());
    }

    @Test
    public void usingMockito_UsingBDD() {
        List<String> allTodos = Arrays.asList("学习Junit",
                "学习Mockito", "学习PowerMock");

        //given
        given(todoService.retrieveTodoList("Defei")).willReturn(allTodos);

        //when
        List<String> todos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Defei");

        //then
        assertThat(todos.size(), is(2));
    }

    @Test
    public void letsTestDeleteNow() {

        List<String> allTodos = Arrays.asList("学习Junit",
                "学习Mockito", "学习PowerMock");

        when(todoService.retrieveTodoList("Defei")).thenReturn(allTodos);

        todoBusinessImpl.deleteTodosNotRelatedToSpring("Defei");

        //verify验证调用，默认time为1
        verify(todoService).deleteTodo("学习Junit");

        verify(todoService, Mockito.never()).deleteTodo("学习PowerMock");

        verify(todoService, Mockito.never()).deleteTodo("学习Mockito");

        verify(todoService, Mockito.times(1)).deleteTodo("学习Junit");
        // atLeastOnce, atLeast

    }

    @Test
    public void captureArgument() {

        List<String> allTodos = Arrays.asList("学习Junit",
                "学习Mockito", "学习PowerMock");
        Mockito.when(todoService.retrieveTodoList("Defei")).thenReturn(allTodos);

        todoBusinessImpl.deleteTodosNotRelatedToSpring("Defei");
        Mockito.verify(todoService).deleteTodo(stringArgumentCaptor.capture());

        assertEquals("学习Junit", stringArgumentCaptor.getValue());
    }
}
