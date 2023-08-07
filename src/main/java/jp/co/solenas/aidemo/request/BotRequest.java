package jp.co.solenas.aidemo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix="open.ai")
public class BotRequest {
    private String model;
    private List<Message> messages;
    private int n;
    private double temperature;
    private int max_tokens;
}