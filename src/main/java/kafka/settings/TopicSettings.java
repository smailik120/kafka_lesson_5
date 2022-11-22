package kafka.settings;

import kafka.templates.TopicSetting;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix="spring.kafka")
public class TopicSettings {
    private List<TopicSetting> topics;
    private String servers;

    public String getServers() {
        return servers;
    }

    public void setServers(String servers) {
        this.servers = servers;
    }

    public List<TopicSetting> getTopics() {
        return topics;
    }

    public void setTopics(List<TopicSetting> topics) {
        this.topics = topics;
    }
}
