package com.example.server.Form;

import lombok.Data;

import java.util.List;

@Data
public class Form {
    private Integer id;
    private String name;
    private String description;
    private int lng;
    private int lat;
    private List<String>urls;
}
