package kr.ac.mjc.todo_List.repository;

import kr.ac.mjc.todo_List.domain.Todo_list;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo_list,Long> {


}
