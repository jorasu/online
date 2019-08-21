package com.kgc.dao;

import com.kgc.vo.Questions;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by jora on 2019/6/4.
 */
@Repository
public interface QuestionsMapper {
    /**
     *  查询所有问题并按最后修改时间降序排序+分页
     */
    List<Map<String,Object>> queryAllQues();

    int addQuestion(Questions q);

    /**根据问题id查询问题信息*/
    Map<String,Object> queryOneQuestion(int id);

    /**修改问题表*/
    int updateQuestion(Questions q);


}
