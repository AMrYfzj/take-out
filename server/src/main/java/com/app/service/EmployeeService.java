package com.app.service;

import com.app.dto.EmployeeDTO;
import com.app.dto.EmployeeLoginDTO;
import com.app.dto.EmployeePageQueryDTO;
import com.app.entity.Employee;
import com.app.result.PageResult;

public interface EmployeeService {

    /**
     * 员工登录
     *
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    /**
     * 新增员工
     *
     * @param employeeDTO
     */
    void save(EmployeeDTO employeeDTO);

    /**
     * 分页查询
     *
     * @param employeePageQueryDTO
     * @return
     */
    PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 启用禁用员工账号
     *
     * @param status
     * @param id
     */
    void startOrStop(Integer status, Long id);

    /**
     * 根据id查询员工消息
     *
     * @param id
     * @return
     */
    Employee getById(Long id);

    /**
     * 编辑员工消息
     *
     * @param employeeDTO
     */
    void update(EmployeeDTO employeeDTO);
}
