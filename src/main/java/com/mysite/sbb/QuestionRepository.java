package com.mysite.sbb;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findBySubject(String Subject);
    Question findByContent(String Content);
    Question findBySubjectAndContent(String Subject, String Content);
    List<Question> findBySubjectLike(String Subject);
}
