package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.vo.Answers;
import com.kgc.vo.Questions;

import java.util.List;
import java.util.Map;

/**
 * Created by jora on 2019/6/4.
 */
public interface QuestionsService {
    /**
     A. 查询所有问题并按最后修改时间降序排序+分页
     B. 保存新问题
     C. 查询指定问题的信息
     D. 查询指定问题的所有答案信息
     E. 保存新答案
     F．修改指定问题的回答次数和最后修改时间
     */

    PageInfo<Map<String,Object>> queryAllByPage(Integer pNo, Integer pSize);

    int saveQuestions(Questions q);

  /*  //根据问题id查询问题信息
    Map<String,Object> queryOneQuestion(int id);

    //根据问题外键ID查询回答表的信息
    List<Map<String ,Object>> queryAllAnswer(int id);*/

    /**
     * 将根据问题id和根据问题外键id查询回答表的信息
     */
    Map<String ,Object> queryQA(int pid);

    /**
     * 保存新答案，保存成功，再更新问题表
     * @param a
     * @return
     */
    int saveAnswer(Answers a);

}
