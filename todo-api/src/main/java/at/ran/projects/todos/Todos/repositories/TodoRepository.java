package at.ran.projects.todos.Todos.repositories;

import at.ran.projects.todos.Todos.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
