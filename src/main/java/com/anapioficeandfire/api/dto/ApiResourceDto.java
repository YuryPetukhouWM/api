package com.anapioficeandfire.api.dto;


import java.net.URL;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ApiResourceDto {
    String url;
    String name;
}
