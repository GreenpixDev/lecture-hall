package ru.hits.lecturehosting.hall.config;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VkConfiguration {

    @Bean
    public TransportClient transportClient() {
        return new HttpTransportClient();
    }

    @Bean
    public VkApiClient vkApiClient(TransportClient client) {
        return new VkApiClient(client);
    }

}
