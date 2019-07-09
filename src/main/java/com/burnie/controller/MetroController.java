package com.burnie.controller;

import com.burnie.vo.AuTiger;
import com.burnie.vo.CityVO;
import com.burnie.vo.ResponseVO;
import com.burnie.vo.VolumeVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liangboning on 2019/7/9.
 *
 */
@RestController
@Slf4j
public class MetroController {

    @GetMapping("/AuTiger")
    public AuTiger test(){
        AuTiger auTiger = new AuTiger();
        auTiger.setName("Muzi");
        auTiger.setAge("18");
        auTiger.setHours("2");
        return auTiger;
    }

    @GetMapping("/volume/{cityname}")
    public ResponseVO volume(@PathVariable String cityname){
        VolumeVO volumeVO1 = new VolumeVO();
        volumeVO1.setVolume(23.01);
        LocalDate localDate1 = LocalDate.of(2019, 7, 1);
        volumeVO1.setDate(localDate1);
        volumeVO1.setKilometer(40);

        VolumeVO volumeVO2 = new VolumeVO();
        volumeVO2.setVolume(30.01);
        LocalDate localDate2 = LocalDate.of(2019, 7, 2);
        volumeVO2.setDate(localDate2);
        volumeVO2.setKilometer(40);

        CityVO cityVO = new CityVO();
        cityVO.setCityName(cityname);
        cityVO.setCurrentKilometer(50);
        List<VolumeVO> volumeVOList = new ArrayList<>();
        volumeVOList.add(volumeVO1);
        volumeVOList.add(volumeVO2);

        cityVO.setVolume(volumeVOList);

        ResponseVO responseVO = new ResponseVO();
        responseVO.setResultcode(0);
        responseVO.setMessage("success");
        responseVO.setData(cityVO);
        return responseVO;
    }

}
