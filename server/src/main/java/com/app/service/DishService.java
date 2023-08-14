package com.app.service;

import com.app.dto.DishDTO;
import com.app.dto.DishPageQueryDTO;
import com.app.result.PageResult;
import com.app.vo.DishVO;

import java.util.List;

public interface DishService {

    /**
     * 新增菜品和对应口味
     *
     * @param dishDTO
     */
    void saveWithFlavor(DishDTO dishDTO);

    /**
     * 菜品分页查询
     *
     * @param dishPageQueryDTO
     * @return
     */
    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 菜品批量删除
     *
     * @param ids
     */
    void deleteBatch(List<Long> ids);

    /**
     * 根据id来查询菜品和对应口味
     *
     * @param id
     * @return
     */
    DishVO getByIdWithFlavor(Long id);

    /**
     * 修改菜品
     *
     * @param dishDTO
     */
    void updateWithFlavor(DishDTO dishDTO);
}
