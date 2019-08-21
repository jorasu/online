package com.kgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.dao.AnswerMapper;
import com.kgc.dao.QuestionsMapper;
import com.kgc.service.QuestionsService;
import com.kgc.vo.Answers;
import com.kgc.vo.Questions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jora on 2019/6/4.
 */
@Service
@Transactional
public class QuestionsServiceImpl implements QuestionsService {
    @Resource
    private QuestionsMapper questionsMapper;
    @Resource
    private AnswerMapper answerMapper;
    @Override
    public PageInfo<Map<String, Object>> queryAllByPage(Integer pNo,Integer pSize) {
        PageHelper.startPage(pNo,pSize);
        return new PageInfo<Map<String, Object>>(questionsMapper.queryAllQues());
    }

    @Override
    public int saveQuestions(Questions q) {
        return questionsMapper.addQuestion(q);
    }

    @Override
    public Map<String, Object> queryQA(int pid) {
        Map<String,Object> map=new HashMap<String,Object>();
        Map<String,Object> QuestionMap=questionsMapper.queryOneQuestion(pid);
        List<Map<String ,Object>> answersMap=answerMapper.queryAllAnswer(pid);
        map.put("answersMap",answersMap);
        map.put("QuestionMap",QuestionMap);
        return map;
    }

    @Override
    public int saveAnswer(Answers a) {
        int addRes=answerMapper.addAnswer(a);
        if(addRes>0){
            //当前问题的次数
            Map<String, Object> map=queryQA(a.getQid());
            Map<String,Object> mapQues= (Map<String, Object>) map.get("QuestionMap");
         //   Map<String,Object> mapQues=questionsMapper.queryOneQuestion(a.getQid());
            int answerCount= (int) mapQues.get("answerCount");
            Questions questions=new Questions();
            questions.setAnswercount(answerCount+1);
            questions.setId(a.getQid());
            int updateRes=questionsMapper.updateQuestion(questions);
            System.out.println(updateRes>0?"问题表更新成功":"更新失败");
        }
        return addRes;
    }
}
