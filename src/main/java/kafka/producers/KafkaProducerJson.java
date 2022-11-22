package kafka.producers;

import kafka.entities.Notification;
import kafka.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerJson {

    private KafkaTemplate<String, Notification> template;

    public KafkaProducerJson(KafkaTemplate<String, Notification> template) {
        this.template = template;
    }

    public void sendMessage(Notification notification) {
        System.out.println(
                String.format("сообщение:%s отправлено", notification)
        );
        Message<Notification> message = MessageBuilder
                .withPayload(notification)
                .setHeader(KafkaHeaders.TOPIC, "newTestTopic")
                .build();
        template.send(message);
    }
}
