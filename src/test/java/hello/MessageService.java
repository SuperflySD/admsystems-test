package hello;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public interface MessageService {
    String getMessage();
}