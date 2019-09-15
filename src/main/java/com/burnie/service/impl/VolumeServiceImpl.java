package com.burnie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.burnie.entity.Volume;
import com.burnie.mapper.VolumeMapper;
import com.burnie.service.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liangboning
 * @date 2019/7/17 12:06
 */
@Service
public class VolumeServiceImpl implements VolumeService {

    @Autowired
    private VolumeMapper volumeMapper;

    @Override
    public List<Volume> getAllVolumesByCityId(Long cityId) {
        QueryWrapper<Volume> volumeQueryWrapper = new QueryWrapper<>();
        volumeQueryWrapper.eq("cityId", cityId);
        volumeQueryWrapper.orderByAsc("date");
        return volumeMapper.selectList(volumeQueryWrapper);
    }

    @Override
    public void insertVolumes(List<Volume> volumes) {
        volumes.forEach(volumeMapper::insert);
    }
}
