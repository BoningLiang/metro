package com.burnie.vo;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by liangboning on 2019/7/9.
 */
public class VolumeVO {

    private LocalDate date;

    private double volume;

    private double kilometer;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getKilometer() {
        return kilometer;
    }

    public void setKilometer(double kilometer) {
        this.kilometer = kilometer;
    }
}
