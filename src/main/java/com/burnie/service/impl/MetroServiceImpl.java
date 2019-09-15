package com.burnie.service.impl;

import com.burnie.entity.City;
import com.burnie.entity.Volume;
import com.burnie.exception.FileFormatException;
import com.burnie.service.CityService;
import com.burnie.service.MetroService;
import com.burnie.service.VolumeService;
import com.burnie.utils.ExtractUtil;
import com.burnie.vo.requestVOs.AddVolumeVO;
import com.burnie.vo.responseVOs.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liangboning on 2019/7/12.
 */
@Service
@AllArgsConstructor
public class MetroServiceImpl implements MetroService {

    @Autowired
    private CityService cityService;
    @Autowired
    private VolumeService volumeService;

    @Override
    public BaseResponseVO<CityVolumeVO> getAllVolumesByCityCode(String citycode) {
        BaseResponseVO<CityVolumeVO> response = new BaseResponseVO<>();
        City city = cityService.getCityByCityCode(citycode);
        if (city == null) {
            response.setResultcode("0001");
            response.setMessage("no such city");
            return response;
        }else {
            List<Volume> volumes = volumeService.getAllVolumesByCityId(city.getId());
            CityVolumeVO cityVolumeVO = new CityVolumeVO();
            cityVolumeVO.setCity(city);
            cityVolumeVO.setVolumes(volumes);
            response.setData(cityVolumeVO);
            if (volumes == null || volumes.size()==0) {
                response.setResultcode("0002");
                response.setMessage("no volume data");
                return response;
            }else {
                response.setResultcode("0000");
                response.setMessage("success");
                return response;
            }
        }
    }

    @Override
    public BaseResponseVO<EChartsDataVO> getEchartsVolumeByCityCode(String citycode) {
        BaseResponseVO<EChartsDataVO> response = new BaseResponseVO<>();
        City city = cityService.getCityByCityCode(citycode);
        if (city == null) {
            response.setResultcode("0001");
            response.setMessage("no such city");
            return response;
        }else {
            List<Volume> volumes = volumeService.getAllVolumesByCityId(city.getId());
            EChartsDataVO eChartsDataVO = new EChartsDataVO();
            EChartsOptionVO<String> xAxis = new EChartsOptionVO<>();
            EChartsOptionVO<String> yAxis = new EChartsOptionVO<>();
            EChartsOptionVO<Long> series = new EChartsOptionVO<>();
            List<EChartsOptionVO<Long>> seriesList = new LinkedList<>();
            xAxis.setType("category");
            yAxis.setType("value");
            series.setType("line");
            List<String> dateList = new LinkedList<>();
            List<Long> dataList = new LinkedList<>();
            volumes.forEach(volume -> {
                dateList.add(volume.getDate().toString());
                dataList.add(volume.getVolume());
            });
            xAxis.setData(dateList);
            series.setData(dataList);
            seriesList.add(series);

            eChartsDataVO.setXAxis(xAxis);
            eChartsDataVO.setYAxis(yAxis);
            eChartsDataVO.setSeries(seriesList);

            response.setData(eChartsDataVO);
            if (volumes == null || volumes.size()==0) {
                response.setResultcode("0002");
                response.setMessage("no volume data");
                return response;
            }else {
                response.setResultcode("0000");
                response.setMessage("success");
                return response;
            }
        }
    }

    @Override
    public BaseResponseVO addVolumes(AddVolumeVO addVolumeVO) {
        volumeService.insertVolumes(addVolumeVO.getVolumes());
        BaseResponseVO baseResponseVO = new BaseResponseVO();
        baseResponseVO.setResultcode("0000");
        baseResponseVO.setMessage("success");
        return baseResponseVO;
    }

    @Override
    public BaseResponseVO addVolumesFromFile(MultipartFile file) throws FileFormatException {
        AddVolumeVO addVolumeVO = ExtractUtil.extractContent(file, cityService);
        volumeService.insertVolumes(addVolumeVO.getVolumes());
        BaseResponseVO baseResponseVO = new BaseResponseVO();
        baseResponseVO.setResultcode("0000");
        baseResponseVO.setMessage("success");
        return baseResponseVO;
    }

    @Override
    public BaseResponseVO getChartDataByCityCode(String citycode) {
        BaseResponseVO<ChartDataVO> response = new BaseResponseVO<>();
        City city = cityService.getCityByCityCode(citycode);
        if (city == null) {
            response.setResultcode("0001");
            response.setMessage("no such city");
            return response;
        }else {
            List<Volume> volumes = volumeService.getAllVolumesByCityId(city.getId());
            List<VolumeVO> volumeVOs = ExtractUtil.convertVolumeToVolumeVO(volumes);
            ChartDataVO chartDataVO = new ChartDataVO();
            chartDataVO.setCity(city);
            chartDataVO.setVolumeVOs(volumeVOs);
            response.setData(chartDataVO);
            if (volumes == null || volumes.size()==0) {
                response.setResultcode("0002");
                response.setMessage("no volume data");
                return response;
            }else {
                response.setResultcode("0000");
                response.setMessage("success");
                return response;
            }
        }
    }

    @Override
    public BaseResponseVO getCityByCityName(String cityName) {
        City city = cityService.getCityByCityName(cityName);
        BaseResponseVO<City> cityBaseResponseVO = new BaseResponseVO<>();
        cityBaseResponseVO.setData(city);
        return cityBaseResponseVO;
    }
}
