package com.hza.dao;

import com.hza.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by hza
 * 2019-10-09 15:11
 */
@Repository
public class CourseDao {

    private Map<Integer, Course> courses = new HashMap<>() ;

    /**
     * 新增课程
     * @param course
     */
    public void add(Course course) {
        this.courses.put(course.getId(), course) ;
    }

    /**
     * 查询全部课程
     * @return
     */
    public Collection<Course> getAll() {
        return this.courses.values() ;
    }

    /**
     * 根据id查询课程
     * @param id
     * @return
     */
    public Course getById(Integer id) {
        return this.courses.get(id) ;
    }

    /**
     * 修改课程
     * @param course
     */
    public void update(Course course) {
        this.courses.put(course.getId(),course) ;
    }

    /**
     * 删除课程
     * @param id
     */
    public void deleteById(Integer id) {
        this.courses.remove(id);
    }

}
