package com.burnie.controller;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.burnie.exception.FileFormatException;
import com.burnie.service.CityService;
import com.burnie.service.MetroService;
import com.burnie.utils.ExtractUtil;
import com.burnie.vo.AuTiger;
import com.burnie.vo.CityVO;
import com.burnie.vo.ResponseVO;
import com.burnie.vo.VolumeVO;
import com.burnie.vo.requestVOs.AddVolumeVO;
import com.burnie.vo.requestVOs.RequestCityVO;
import com.burnie.vo.responseVOs.BaseResponseVO;
import com.burnie.vo.responseVOs.CityVolumeVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liangboning on 2019/7/9.
 *
 */
@RestController
@Slf4j
@RequestMapping("/metro")
public class MetroController {

    @Autowired
    private MetroService metroService;

    @GetMapping("/volume/{citycode}")
    public BaseResponseVO volume(@PathVariable String citycode) {
        return metroService.getAllVolumesByCityCode(citycode);
    }

    @PostMapping("/addFromFile")
    public BaseResponseVO addFromFile(@RequestParam("file") MultipartFile file) throws FileFormatException {
        return metroService.addVolumesFromFile(file);
    }

    @PostMapping("/add")
    public BaseResponseVO add(AddVolumeVO addVolumeVO) {
        return metroService.addVolumes(addVolumeVO);
    }

    @GetMapping("/data/{citycode}")
    public BaseResponseVO data(@PathVariable String citycode) {
        return metroService.getChartDataByCityCode(citycode);
    }

    @PostMapping("/city")
    public BaseResponseVO city(RequestCityVO requestCityVO) {
        return metroService.getCityByCityName(requestCityVO.getCityName());
    }
}