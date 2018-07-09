package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.QuestionDao;
import com.example.entity.Answer;
import com.example.entity.Question;
import com.example.model.AnswerDTO;
import com.example.model.QuestionDTO;
import com.example.service.QuestionService;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	QuestionDao questionDao;
	@Override
	public List<QuestionDTO> getAllQuestionDTO() {
		List<Question> questions=questionDao.getAllQuestion();
		List<QuestionDTO> questionDTOs=new ArrayList<QuestionDTO>();
		questions.forEach(question->{
			QuestionDTO questionDTO=new QuestionDTO();
			questionDTO.setId(question.getId());
			questionDTO.setContent(question.getContent());
			List<AnswerDTO> answerDTOs=new ArrayList<AnswerDTO>();
			question.getListAnswers().forEach(answer->{
				AnswerDTO answerDTO=new AnswerDTO();
				answerDTO.setAnswer(answer.getAnswer());
				answerDTO.setId(answer.getId());
				answerDTO.setIs_correct(answer.isIs_correct());
				
				answerDTOs.add(answerDTO);
			});
			questionDTO.setListAnswerDTOs(answerDTOs);
			questionDTOs.add(questionDTO);
		});
		
		return questionDTOs;
	}

	@Override
	public QuestionDTO getQuestionById(int id) {
		Question question=questionDao.getQuestionById(id);
		QuestionDTO questionDTO=new QuestionDTO();
		questionDTO.setId(question.getId());
		questionDTO.setContent(question.getContent());
		List<AnswerDTO> answerDTOs=new ArrayList<AnswerDTO>();
		question.getListAnswers().forEach(answer->{
			AnswerDTO answerDTO=new AnswerDTO();
			answerDTO.setId(answer.getId());
			answerDTO.setAnswer(answer.getAnswer());
			answerDTO.setIs_correct(answer.isIs_correct());
			answerDTOs.add(answerDTO);
		});
		questionDTO.setListAnswerDTOs(answerDTOs);
		return questionDTO;
	}

	@Override
	public void deleteQuestion(int id) {
		Question question=questionDao.getQuestionById(id);
		if(question!=null) {
			questionDao.deleteQuestion(question);
		}
		
	}

	@Override
	public void updateQuestion(QuestionDTO questionDTO) {
		Question question=questionDao.getQuestionById(questionDTO.getId());
		if(question!=null) {
			question.getListAnswers().clear();
			question.setContent(questionDTO.getContent());
			List<Answer> answers=new ArrayList<Answer>();
			questionDTO.getListAnswerDTOs().forEach(answerDTO->{
				Answer answer=new Answer();
				answer.setAnswer(answerDTO.getAnswer());
				answer.setIs_correct(answerDTO.isIs_correct());
				answer.setQuestion(question);
				answers.add(answer);
			});
			question.getListAnswers().addAll(answers);
			questionDao.updateQuestion(question);
		}
		
	}

	@Override
	public void addQuestion(QuestionDTO questionDTO) {
		Question question=new Question();
		question.setContent(questionDTO.getContent());
		List<AnswerDTO> answerDTOs=questionDTO.getListAnswerDTOs();
		List<Answer> answers=new ArrayList<Answer>();
		answerDTOs.forEach(answerDTO->{
			Answer answer=new Answer();
			answer.setAnswer(answerDTO.getAnswer());
			answer.setIs_correct(answerDTO.isIs_correct());
			answer.setQuestion(question);
			answers.add(answer);
		});
		question.setListAnswers(answers);
		questionDao.addQuestion(question);
	}

	@Override
	public List<QuestionDTO> getQuestionByListId(List<Integer> id) {
		List<Question> questions=questionDao.getQuestionByListId(id);
		List<QuestionDTO> questionDTOs=new ArrayList<QuestionDTO>();
		questions.forEach(question->{
			QuestionDTO questionDTO=new QuestionDTO();
			questionDTO.setId(question.getId());
			questionDTO.setContent(question.getContent());
			List<AnswerDTO> answerDTOs=new ArrayList<AnswerDTO>();
			question.getListAnswers().forEach(answer->{
				AnswerDTO answerDTO=new AnswerDTO();
				answerDTO.setAnswer(answer.getAnswer());
				answerDTO.setId(answer.getId());
				answerDTO.setIs_correct(answer.isIs_correct());
				
				answerDTOs.add(answerDTO);
			});
			questionDTO.setListAnswerDTOs(answerDTOs);
			questionDTOs.add(questionDTO);
		});
		
		return questionDTOs;
	}

}
