package com.hza.controller;

import com.hza.dao.CourseDao;
import com.hza.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

/**
 * Create by hza
 * 2019-10-09 15:17
 */
@Controller
public class CourseController {

    @Autowired
    private CourseDao courseDao ;

    /**
     * 新增方法
     * @param course 新增的课程实体类
     * @return 重定向到查询全部页面
     */
    @PostMapping(value = "/add")
    public String add(Course course) {
        this.courseDao.add(course);
        return "redirect:/getAll" ;
    }

    /**
     * 查询全部课程
     * @return
     */
    @GetMapping(value = "/getAll")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView() ;
        modelAndView.setViewName("index");
        modelAndView.addObject("courses", this.courseDao.getAll()) ;
        return modelAndView ;
    }

    /**
     * 通过ID查询课程
     * @param id
     * @return
     */
    @GetMapping(value = "/getById/{id}")
    public ModelAndView getById(@PathVariable(value = "id") Integer id) {
        ModelAndView modelAndView = new ModelAndView() ;
        modelAndView.addObject("course", this.courseDao.getById(id)) ;
        modelAndView.setViewName("edit");
        return modelAndView ;
    }

    /**
     * 编辑课程
     * @param course
     * @return
     */
    @PutMapping(value = "/update")
    public String update(Course course) {
        this.courseDao.update(course);
        return "redirect:/getAll" ;
    }

    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable(value = "id") Integer id) {
        this.courseDao.deleteById(id);
        return "redirect:/getAll" ;
    }
}
