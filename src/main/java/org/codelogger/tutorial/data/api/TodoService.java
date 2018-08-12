package org.codelogger.tutorial.data.api;

import java.util.List;

/**
 * 待办事项service
 *
 * @author defei
 */
public interface TodoService {

    /**
     * 获取待办列表
     *
     * @param user 用户
     * @return 待办列表
     */
    List<String> retrieveTodoList(String user);

    /**
     * 移除待办事项
     * @param todo 待办事项
     */
    void deleteTodo(String todo);

}