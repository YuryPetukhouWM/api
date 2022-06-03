package com.anapioficeandfire.api.dto;

import com.anapioficeandfire.api.model.ApiResource;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CharacterDto extends ApiResourceDto {
    String gender;
    String culture;
    String born;
    String died;
    List<String> titles;
    List<String> aliases;
    String father;
    String mother;
    List<String> spouse;
    List<String> allegiances;
    List<String> books;
    List<String> povBooks;
    List<String> tvSeries;
    List<String> playedBy;
}
