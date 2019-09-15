package com.burnie.service;

import com.burnie.entity.Volume;

import java.util.List;

/**
 * @author liangboning
 * @date 2019/7/17 12:05
 */
public interface VolumeService {

    List<Volume> getAllVolumesByCityId(Long cityId);

    void insertVolumes(List<Volume> volumes);

}
