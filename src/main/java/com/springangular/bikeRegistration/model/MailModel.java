package com.springangular.bikeRegistration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MailModel {
    private String from;
    private String to;
    private String cc;
    private String name;
    private String subject;
    private String content;
    private String location;
    private Map<String, String> model;
}
