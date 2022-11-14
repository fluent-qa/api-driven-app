package io.fluentqa.todo.api;


import io.fluentqa.todo.entity.ToDoEntity;
import io.fluentqa.todo.model.Todo;
import io.fluentqa.todo.repository.TodoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-11-14T16:29:29.158062+08:00[Asia/Shanghai]")
@Controller
@RequestMapping("${openapi.todos.base-path:}")
public class ToDoV1ApiController implements ToDoApi {

    @Autowired
    private TodoRepository todoRepository;

    private final NativeWebRequest request;

    @Autowired
    public ToDoV1ApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Todo> createTodo(Todo todo) {
        System.out.println(this.request.getContextPath());
        ToDoEntity todoEntity = new ToDoEntity();
        BeanUtils.copyProperties(todo, todoEntity);
        todoEntity.setState(ToDoEntity.StateEnum.fromValue(todo.getState().getValue()));
        todoRepository.save(todoEntity);
        return ResponseEntity.ok(todo);
    }

    @Override
    public ResponseEntity<Void> deleteTodo(String todoUuid, String ownerUuid, Boolean hard) {

        return ResponseEntity.ok(todoRepository.deleteByUuid(todoUuid));
    }

    @Override
    public ResponseEntity<Todo> getTodo(String ownerUuid, String todoUuid) {
        ToDoEntity todoEntity = todoRepository.findByUuid(todoUuid);
        Todo todo = new Todo();
        BeanUtils.copyProperties(todoEntity, todo);
        return ResponseEntity.ok(todo);
    }

    @Override
    public ResponseEntity<List<Todo>> listTodos(String ownerUuid) {

        List<ToDoEntity> todos = todoRepository.findByOwnerUuid(ownerUuid);
        List<Todo> result = new ArrayList<>();
        todos.forEach(new Consumer<ToDoEntity>() {
            @Override
            public void accept(ToDoEntity toDoEntity) {
                Todo todoDto = new Todo();
                BeanUtils.copyProperties(toDoEntity, todoDto);
                result.add(todoDto);
            }
        });
//        for (ToDoEntity todo : todos) {
//            Todo todoDto = new Todo();
//            BeanUtils.copyProperties(todo,todoDto);
//            result.add(todoDto);
//        }
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Todo> updateTodo(String ownerUuid, String todoUuid, Todo todo) {
        ToDoEntity entity = todoRepository.findByUuid(todoUuid);
        entity.setDescription(todo.getDescription());
        entity.setState(ToDoEntity.StateEnum.fromValue(todo.getState().getValue()));
        todoRepository.save(entity);
        return ResponseEntity.ok(todo);
    }

}
