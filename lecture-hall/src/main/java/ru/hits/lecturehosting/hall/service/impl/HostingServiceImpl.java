package ru.hits.lecturehosting.hall.service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.hits.lecturehosting.hall.properties.HostingProperties;
import ru.hits.lecturehosting.hall.service.HostingService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HostingServiceImpl implements HostingService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final HostingProperties properties;

    @Override
    public String generateVideoUploadUrl(String vkUploadUrl) {
        String innerUrl = properties.getInnerUrl() + "/video/upload";
        String outerUrl = properties.getOuterUrl() + "/video/upload";

        HttpEntity<String> entity = new HttpEntity<>(vkUploadUrl, new HttpHeaders());

        UUID id = restTemplate.postForEntity(
                innerUrl + "?access_token=" + properties.getAccessToken(),
                entity,
                UUID.class
        ).getBody();

        return outerUrl + "/" + id;
    }
}
