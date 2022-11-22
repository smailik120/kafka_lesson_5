package kafka.entities;

import lombok.*;

import java.util.Collection;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    private Collection<User> users;
    private String message;
}