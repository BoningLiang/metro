package com.burnie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.burnie.entity.City;
import com.burnie.mapper.CityMapper;
import com.burnie.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liangboning
 * @date 2019/7/17 12:06
 */
@Service
public class CityServiceImpl implements CityService{

    @Autowired
    private CityMapper cityMapper;

    @Override
    public City getCityByCityCode(String cityCode) {
        QueryWrapper<City> cityQueryWrapper = new QueryWrapper<>();
        cityQueryWrapper.eq("city_code", cityCode);
        return cityMapper.selectOne(cityQueryWrapper);
    }

    @Override
    public City getCityByCityName(String cityName) {
        QueryWrapper<City> cityQueryWrapper = new QueryWrapper<>();
        cityQueryWrapper.eq("name", cityName);
        return cityMapper.selectOne(cityQueryWrapper);
    }
}
