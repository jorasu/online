package com.kgc.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.service.QuestionsService;
import com.kgc.vo.Answers;
import com.kgc.vo.Questions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by jora on 2019/6/4.
 */
@RestController
public class QuestionsController {
    @Resource
    private QuestionsService service;

    @RequestMapping("/queryAllByPage.do")
    PageInfo<Map<String,Object>> queryAllByPage(@RequestParam(defaultValue = "1") Integer pNo,
                                                @RequestParam (defaultValue = "3")Integer pSize){
        return service.queryAllByPage(pNo,pSize);
    };

    @RequestMapping("/saveQuestions.do")
    int saveQuestions(Questions q){
        return service.saveQuestions(q);
    };


    @RequestMapping("/queryQA.do")
    Map<String ,Object> queryQA(int pid){
        return service.queryQA(pid);
    };

    @RequestMapping("/saveAnswer.do")
    int saveAnswer(Answers a){
        return service.saveAnswer(a);
    };
}
