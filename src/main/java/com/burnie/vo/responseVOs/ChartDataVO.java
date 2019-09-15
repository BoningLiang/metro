package com.burnie.vo.responseVOs;

import com.burnie.entity.City;
import lombok.Data;

import java.util.List;

/**
 * @author liangboning
 * @date 2019/7/22 16:47
 */
@Data
public class ChartDataVO {

    private City city;

    private List<VolumeVO> volumeVOs;

}
