package ru.students.test_rest_servise_lr1.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.students.test_rest_servise_lr1.model.Request;

@Service
public class ModifyRequestSystemTime implements ModifyRequestService {


    @Override
    public void modifyRq(Request request) {

    }

    @Override
    public void modify(Request request) {

    request.setSystemTime("test");
    HttpEntity<Request> httpEntityp = new HttpEntity<>(request);

    new RestTemplate().exchange("http://localhost:8082/feedback",
                                HttpMethod.POST,
                                httpEntityp,
                                new ParameterizedTypeReference<>() {

    });

}
}
