package com.masai.Repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entity.Feedback;

public interface FeedbackDao extends JpaRepository<Feedback, Integer>{

}
