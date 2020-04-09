package com.zx.mapper;

import com.zx.domain.FlowerSystem;

import java.util.List;

public interface FlowerSystemMapper {
    int insert(FlowerSystem record);

    List<FlowerSystem> selectAll();
}