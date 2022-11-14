package io.fluentqa.todo.api;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-11-14T16:29:29.158062+08:00[Asia/Shanghai]")
@Controller
@RequestMapping("${openapi.todos.base-path:}")
public class ReadyApiController implements ReadyApi {

    private final NativeWebRequest request;

    @Autowired
    public ReadyApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
