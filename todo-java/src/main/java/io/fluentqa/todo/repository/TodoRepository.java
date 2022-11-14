package io.fluentqa.todo.repository;


import io.fluentqa.todo.entity.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<ToDoEntity, Long> {
    @Transactional
    void deleteByState(String state);

    @Transactional
    Void deleteByUuid(String uuid);

    ToDoEntity findByUuid(String uuid);

    List<ToDoEntity> findByOwnerUuid(String ownerUuid);
}
