package com.example.server.vo;

import lombok.Data;

import java.util.List;

@Data
public class Poivo {
    private Integer id;
    private String name;
    private String description;
    private List pics;
}