package com.burnie.service;

import com.burnie.entity.City;

/**
 * @author liangboning
 * @date 2019/7/17 12:05
 */
public interface CityService {

    City getCityByCityCode(String cityCode);

    City getCityByCityName(String cityName);

}
