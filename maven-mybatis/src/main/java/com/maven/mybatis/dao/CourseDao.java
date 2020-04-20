package com.maven.mybatis.dao;

import org.apache.ibatis.annotations.Delete;

public interface CourseDao {
    @Delete("delete from course where cno=#{cno}")
    void deleteCourse(String cno);
}
