package com.app.controller.user;

import com.app.constant.StatusConstant;
import com.app.entity.Dish;
import com.app.result.Result;
import com.app.service.DishService;
import com.app.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("userDishController")
@RequestMapping("/user/dish")
@Slf4j
@Api(tags = "C端-菜品浏览接口")
public class DishController {
    @Autowired
    private DishService dishService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 根据分类id查询菜品
     *
     * @param categoryId
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("根据分类id查询菜品")
    public Result<List<DishVO>> list(Long categoryId) {
        String key = "dish_" + categoryId;
        //查询redis中是否存在菜品数据
        List<DishVO> list = (List<DishVO>) redisTemplate.opsForValue().get(key);
        if (list != null && list.size() > 0) {
            //如果存在直接返回
            return Result.success(list);
        }

        //如果不存在则查询数据库
        Dish dish = new Dish();
        dish.setCategoryId(categoryId);
        //查询起售中的菜品
        dish.setStatus(StatusConstant.ENABLE);

        list = dishService.listWithFlavor(dish);
        //将数据缓存到redis
        redisTemplate.opsForValue().set(key, list);

        return Result.success(list);
    }

}
