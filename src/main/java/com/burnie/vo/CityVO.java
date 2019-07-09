package com.burnie.vo;

import java.util.List;

/**
 * Created by liangboning on 2019/7/9.
 *
 */
public class CityVO {

    private String cityName;

    private double currentKilometer;

    private List<VolumeVO> volume;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getCurrentKilometer() {
        return currentKilometer;
    }

    public void setCurrentKilometer(double currentKilometer) {
        this.currentKilometer = currentKilometer;
    }

    public List<VolumeVO> getVolume() {
        return volume;
    }

    public void setVolume(List<VolumeVO> volume) {
        this.volume = volume;
    }
}
