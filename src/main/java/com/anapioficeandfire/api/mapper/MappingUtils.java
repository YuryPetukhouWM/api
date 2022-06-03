package com.anapioficeandfire.api.mapper;

import com.anapioficeandfire.api.model.ApiResource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

public class MappingUtils {
    public static List<String> parseArray(String arrayString) {
        return StringUtils.isEmpty(arrayString)
                ? Collections.emptyList()
                : Arrays.stream(arrayString
                        .replace("[", "")
                        .replace("]", "")
                        .split(","))
                .map(String::trim)
                .toList();
    }

    public static String getResourceUrl (ApiResource resource) {
        return Objects.isNull(resource) ? "" : resource.getUrl();
    }
}
