package com.burnie.vo.responseVOs;

import com.burnie.entity.City;
import com.burnie.entity.Volume;
import lombok.Data;

import java.util.List;

/**
 * @author liangboning
 * @date 2019/7/17 12:13
 */
@Data
public class CityVolumeVO {

    private City city;

    private List<Volume> volumes;
}
