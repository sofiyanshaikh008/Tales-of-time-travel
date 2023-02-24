package com.masai.Service;

import java.util.List;

import com.masai.Exception.BusException;
import com.masai.Exception.FeedbackException;
import com.masai.Exception.UserException;
import com.masai.Entity.Feedback;

public interface IFeedbackService {

	public Feedback addFeedback( Integer busId, Feedback feedback,String key) throws FeedbackException, UserException, BusException;
	
	public Feedback updateFeedback(Feedback feedback,String key) throws FeedbackException,UserException;
	
	public Feedback viewFeedback(Integer feedbackId,String key) throws FeedbackException,UserException;
	
	public List<Feedback> viewAllFeedback(String key) throws FeedbackException,UserException;
}
