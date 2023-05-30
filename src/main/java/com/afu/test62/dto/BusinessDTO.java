package com.afu.test62.dto;

import com.afu.test62.model.Business;
import com.afu.test62.model.Region;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessDTO {
    List<Map<String, Object>> businesses;
    Region region;
    Integer total;
}
