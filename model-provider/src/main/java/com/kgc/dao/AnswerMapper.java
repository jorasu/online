package com.kgc.dao;

import com.kgc.vo.Answers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by jora on 2019/6/4.
 */
@Repository
public interface AnswerMapper {
    /**
     *
     D. 查询指定问题的所有答案信息
     E. 保存新答案
     */

    /**根据问题外键ID查询回答表的信息*/
    List<Map<String ,Object>> queryAllAnswer(int id);

    int addAnswer(Answers a);
}
