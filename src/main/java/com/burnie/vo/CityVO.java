package com.burnie.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by liangboning on 2019/7/9.
 *
 */
@Data
public class CityVO {

    private String cityName;

    private double currentMeter;

    private List<VolumeVO> volume;
}
