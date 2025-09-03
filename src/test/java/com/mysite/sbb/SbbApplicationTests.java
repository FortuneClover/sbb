package com.mysite.sbb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class SbbApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    void questionInsertTest() {
        Question q1 = new Question();
        q1.setSubject("sbb이 무엇인가요?");
        q1.setContent("sbb에 대해서 알고 싶습니다.");
        q1.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q1);

        Question q2 = new Question();
        q2.setSubject("스프링부트 모델 질문입니다.");
        q2.setContent("id는 자동으로 생성되나요?");
        q2.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q2);
    }

    @Test
    void questionFindAllTest() {
        List<Question> all = this.questionRepository.findAll();
        assertEquals(4, all.size());

        Question q = all.get(0);
        assertEquals("sbb이 무엇인가요?", q.getSubject());
    }

    @Test
    void questionFindByIdTest() {
        Optional<Question> oq = this.questionRepository.findById(1);

        if (oq.isPresent()) {
            Question q = oq.get();
            assertEquals("sbb이 무엇인가요?", q.getSubject());
        }
    }

    @Test
    void questionFindBySubjectLikeTest() {
        List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");

        Question q = qList.get(0);
        assertEquals("sbb이 무엇인가요?", q.getSubject());
    }
}
