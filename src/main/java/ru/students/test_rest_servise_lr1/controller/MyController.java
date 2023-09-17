package ru.students.test_rest_servise_lr1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.students.test_rest_servise_lr1.model.Request;
import ru.students.test_rest_servise_lr1.model.Response;
import ru.students.test_rest_servise_lr1.service.ModifyRequestService;
import ru.students.test_rest_servise_lr1.service.MyModifyService;

@Slf4j
@RestController
public class MyController {

    private final MyModifyService myModifyService;
private final ModifyRequestService modifyRequestService;

    @Autowired
    public MyController(@Qualifier("ModifyErrorMessage") MyModifyService myModifyService,
                        ModifyRequestService modifyRequestService, ModifyRequestService modifyRequestService1) {
        this.myModifyService = myModifyService;
        this.modifyRequestService = modifyRequestService1;
    }




    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@RequestBody Request request){


        log.warn("Входящий request : " + String.valueOf(request));

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(request.getSystemTime())
                .code("success")
                .errorCode("")
                .errorMessage("")
                .build();


        Response responseAfterModify = myModifyService.modify(response);
        log.warn("Исходящий response : " + String.valueOf(response));
return new ResponseEntity<>(response, HttpStatus.OK);

}
}
