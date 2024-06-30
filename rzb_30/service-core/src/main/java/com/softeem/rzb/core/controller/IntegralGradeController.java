package com.softeem.rzb.core.controller;


import com.softeem.rzb.core.service.IntegralGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 积分等级表 前端控制器
 * </p>
 *
 * @author sjj
 * @since 2024-06-30
 */
@RestController
@RequestMapping("/integralGrade")
public class IntegralGradeController {

    @Autowired
    private IntegralGradeService integralGradeService;
    @RequestMapping("/showList")
    public Object showList() {
        return integralGradeService.list();
    }
}

