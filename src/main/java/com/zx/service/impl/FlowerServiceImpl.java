package com.zx.service.impl;

import com.zx.domain.FlowerSystem;
import com.zx.mapper.FlowerSystemMapper;
import com.zx.service.FlowerService;

import java.util.List;

public class FlowerServiceImpl implements FlowerService {

    private FlowerSystemMapper flowerSystemMapper;

    @Override
    public List<FlowerSystem> findAll() {
        List<FlowerSystem> list = flowerSystemMapper.selectAll();
        return list;
    }

    @Override
    public int save(FlowerSystem flowerSystem) {
        int res = flowerSystemMapper.insert(flowerSystem);
        return res;
    }

    public FlowerSystemMapper getFlowerSystemMapper(){
        return flowerSystemMapper;
    }

    public void setFlowerSystemMapper(FlowerSystemMapper flowerSystemMapper) {
        this.flowerSystemMapper = flowerSystemMapper;
    }
}
