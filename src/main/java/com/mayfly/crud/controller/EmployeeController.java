package com.mayfly.crud.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mayfly.crud.bean.Employee;
import com.mayfly.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/*
* 处理员工CRUD请求
* */

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    /*查询所有员工分页查询*//*
    @RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn", defaultValue = "1")
                                      Integer pn, Model model) {

        //设置分页查询,
        //使用PageHelper，每次查询时候只需要调用，传入页码、以及每项大小
        PageHelper.startPage(pn, 5);
        //startPage紧跟着就是分页查询
        List<Employee> employeeList = employeeService.getAll();
        //使用PageInfo包装查询后的结果，只需要把PageInfo交给页面就行
        //封装了详细的分页信息，包括有我们查询出来的数据，传入连续显示的页数
        PageInfo pageInfo = new PageInfo(employeeList,5);
        model.addAttribute("pageInfo", pageInfo);
        return "list";
    }*/
    /*查询所有员工分页查询*/
    @RequestMapping("/emps")
    public ModelAndView getEmps(@RequestParam(value = "pn", defaultValue = "1")
                                  Integer pn, Model model) {

        ModelAndView mv = new ModelAndView();
        //设置分页查询,
        //使用PageHelper，每次查询时候只需要调用，传入页码、以及每项大小
        PageHelper.startPage(pn, 5);
        //startPage紧跟着就是分页查询
        List<Employee> employeeList = employeeService.getAll();
        //使用PageInfo包装查询后的结果，只需要把PageInfo交给页面就行
        //封装了详细的分页信息，包括有我们查询出来的数据，传入连续显示的页数
        PageInfo pageInfo = new PageInfo(employeeList,5);
        model.addAttribute("pageInfo", pageInfo);
        mv.setViewName("list");
        return mv;
    }

    @RequestMapping("/some")
    /*参数可以直接用。因为框架会自动赋值*/
    public ModelAndView doSome(
            HttpServletRequest request,
            HttpServletResponse Response,
            HttpSession session
    ) {
        ModelAndView mv = new ModelAndView();
        //mv.addObject("msg", "欢迎使用springmvc做web开发"+request.getParameter("name"));
        //mv.addObject("fun", "执行的是doSome方法");
        //mv.setViewName("/test.jsp");
        // show.jsp目录改变，视图目录也 需要改变
        //mv.setViewName("/WEB-INF/view/test.jsp");
        //使用框架提供的视图解析器设置目录
        //框架会自动使用视图解析器的前缀加后缀组成完整的路径
        mv.setViewName("test");
        return mv;
    }
}
