package com.burnie.vo.requestVOs;

import com.burnie.entity.City;
import com.burnie.entity.Volume;
import lombok.Data;

import java.util.List;

/**
 * @author liangboning
 * @date 2019/7/17 15:31
 */
@Data
public class AddVolumeVO {
    private City city;
    private List<Volume> volumes;
}
