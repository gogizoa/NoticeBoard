package com.mysite.sbb;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerService;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb.question.QuestionService;

@SpringBootTest
class SbbApplicationTests {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private UserService userService;

    @Test
    void testJpa() {
        for (int i = 1; i <= 100; i++) {
            Question q = this.questionService.getQuestion(1);
            String content = String.format("댓글:[%03d]", i);
            SiteUser siteUser = userService.getUser("hi123");
            this.answerService.create(q, content, siteUser);
        }
    }

//    @Test
//    void testJpa() {
//        for (int i = 1; i <= 300; i++) {
//            String subject = String.format("테스트 데이터입니다:[%03d]", i);
//            String content = "내용무";
//            this.questionService.create(subject, content, null);
//        }
//    }
}