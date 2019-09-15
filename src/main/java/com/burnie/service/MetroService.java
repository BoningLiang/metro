package com.burnie.service;

import com.burnie.exception.FileFormatException;
import com.burnie.vo.requestVOs.AddVolumeVO;
import com.burnie.vo.responseVOs.BaseResponseVO;
import com.burnie.vo.responseVOs.CityVolumeVO;
import com.burnie.vo.responseVOs.EChartsDataVO;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by liangboning on 2019/7/12.
 */
public interface MetroService {

    BaseResponseVO<CityVolumeVO> getAllVolumesByCityCode(String citycode);

    BaseResponseVO<EChartsDataVO> getEchartsVolumeByCityCode(String citycode);

    BaseResponseVO addVolumes(AddVolumeVO addVolumeVO);

    BaseResponseVO addVolumesFromFile(MultipartFile file) throws FileFormatException;

    BaseResponseVO getChartDataByCityCode(String citycode);

    BaseResponseVO getCityByCityName(String cityName);

}
