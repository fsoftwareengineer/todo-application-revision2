package com.example.demo.persistence;

import com.example.demo.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {
  List<TodoEntity> findByUserId(String userId);

  @Query("SELECT t FROM TodoEntity t WHERE t.userId = ?1")
  TodoEntity findByUserIdQuery(String userId);

}
