package com.anapioficeandfire.api.dto;


import com.anapioficeandfire.api.model.ApiResource;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HouseDto extends ApiResourceDto {
    String region;
    String coatOfArms;
    String words;
    List<String> titles;
    List<String> seats;
    String currentLord;
    String heir;
    String overlord;
    String founded;
    String founder;
    String diedOut;
    List<String> ancestralWeapons;
    List<String> cadetBranches;
    List<String> swornMembers;
}
