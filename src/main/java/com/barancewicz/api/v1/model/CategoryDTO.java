package com.barancewicz.api.v1.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CategoryDTO {
    private Long id;
    @ApiModelProperty(value = "This is category name", required = true)
    private String name;
}
