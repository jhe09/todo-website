package at.ran.projects.todos.Todos.repositories;

import at.ran.projects.todos.Todos.model.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TodoRepositoryTests {

    @Autowired
    TodoRepository todoRepository;

    @Test
    public void countTodosTest() {
       List<Todo> todoList = todoRepository.findAll();
       assertThat(todoList.size()).isGreaterThan(0);
       assertThat(todoList.size()).isLessThan(10);
    }
}
