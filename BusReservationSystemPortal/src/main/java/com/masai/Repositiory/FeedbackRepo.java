package com.masai.Repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entity.Feedback;

public interface FeedbackRepo extends JpaRepository<Feedback, Integer>{

}
