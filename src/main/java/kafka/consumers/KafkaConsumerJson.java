package kafka.consumers;

import kafka.entities.Notification;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;



@Service
public class KafkaConsumerJson {
    @KafkaListener(topics="newTestTopic", groupId="notificationGroup")
    public void consume(Notification notification) {
        System.out.println(notification);
    }
}
