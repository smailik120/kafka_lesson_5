package kafka.controllers;

import kafka.entities.Notification;
import kafka.producers.KafkaProducer;
import kafka.producers.KafkaProducerJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private KafkaProducer kafkaProducer;
    @Autowired
    private KafkaProducerJson kafkaProducerJson;
    @GetMapping("/send")
    public ResponseEntity<String> send(@RequestParam String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message send");
    }

    @PostMapping("/sendJson")
    public ResponseEntity<String> sendJson(@RequestBody Notification notification) {
        kafkaProducerJson.sendMessage(notification);
        return ResponseEntity.ok("Message send");
    }

    @PostMapping("/testEndPoint")
    public ResponseEntity<String> testEndPoint(@RequestBody String body) {
        System.out.println(body);
        return ResponseEntity.ok(body);
    }
}
