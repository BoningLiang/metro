package com.burnie.vo.responseVOs;

import com.burnie.entity.City;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author liangboning
 * @date 2019/7/22 16:39
 */
@Data
public class VolumeVO {

    private String id;

    private LocalDate date;

    private Long volume;

    private Long meters;

    private Double average;

}
