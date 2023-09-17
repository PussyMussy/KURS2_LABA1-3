package ru.students.test_rest_servise_lr1.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;


import javax.validation.constraints.Max;

@Data
@Builder

public class Request {

    @NotBlank
    @Size(max = 32)
    private String Uid;

    @NotBlank
    @Size(max = 32)
    private String operationUid;

    private String systemName;

    @NotBlank
    private String  systemTime;

    private String source;

    private Integer communicationId;
    private Integer templateId;

    @Max(7)
    private Integer productCode;

    @Max(5)
    private Integer smsCode;
}
