package com.qunchuang.carmall.controller;


import com.qunchuang.carmall.domain.CarBrandIcon;
import com.qunchuang.carmall.graphql.annotation.GraphqlController;
import com.qunchuang.carmall.graphql.annotation.GraphqlMutation;
import com.qunchuang.carmall.graphql.annotation.SchemaDocumentation;
import com.qunchuang.carmall.service.CarBrandIconService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Curtain
 * @date 2019/1/30 10:12
 */
@GraphqlController("carBrandIcon")
public class CarBrandIconController {

    @Autowired
    private CarBrandIconService carBrandIconService;

    @SchemaDocumentation("增加一条车辆品牌信息")
    @GraphqlMutation(path = "/addCarBrandIcon")
    public CarBrandIcon addCarBrandIcon(CarBrandIcon carBrandIcon) {
        return carBrandIconService.save(carBrandIcon);
    }

    @SchemaDocumentation("保存所有已选车辆品牌信息")
    @GraphqlMutation(path = "/saveAllCarBrandIcon")
    public List<CarBrandIcon> saveAllCarBrandIcon(List<CarBrandIcon> carBrandIcons) {
        return carBrandIconService.saveAll(carBrandIcons);
    }
}
