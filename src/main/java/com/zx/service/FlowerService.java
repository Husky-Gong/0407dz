package com.zx.service;

import com.zx.domain.FlowerSystem;

import java.util.List;

public interface FlowerService {
    List<FlowerSystem> findAll();

    int save(FlowerSystem flowerSystem);
}
