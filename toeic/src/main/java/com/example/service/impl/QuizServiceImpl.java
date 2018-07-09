package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.dao.QuizDao;
import com.example.entity.Question;
import com.example.entity.Quiz;
import com.example.model.AnswerDTO;
import com.example.model.QuestionDTO;
import com.example.model.QuizDTO;
import com.example.service.QuizService;

@Transactional
@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	QuizDao quizDao;

	@Override
	public List<QuizDTO> getAllQuizDTO() {
		List<Quiz> listQuizs = quizDao.getAllQuiz();
		List<QuizDTO> listQuizDTOs = new ArrayList<QuizDTO>();
		listQuizs.forEach(quiz -> {
			QuizDTO quizDTO = new QuizDTO();
			quizDTO.setId(quiz.getId());
			quizDTO.setName(quiz.getName());

			listQuizDTOs.add(quizDTO);

		});
		return listQuizDTOs;
	}

	@Override
	public QuizDTO getQuizDTOById(int id) {
		Quiz quiz = quizDao.getQuizById(id);
		QuizDTO quizDTO = new QuizDTO();
		quizDTO.setId(quiz.getId());
		quizDTO.setName(quiz.getName());

		List<QuestionDTO> listQuestionDTOs = new ArrayList<QuestionDTO>();

		List<Question> listQuestions = quiz.getListQuestions();
		listQuestions.forEach(question -> {
			List<AnswerDTO> answerDTOs = new ArrayList<AnswerDTO>();
			
			QuestionDTO questionDTO = new QuestionDTO();
			questionDTO.setId(question.getId());
			questionDTO.setContent(question.getContent());
			question.getListAnswers().forEach(answer -> {
				
				AnswerDTO answerDTO=new AnswerDTO();
				
				answerDTO.setId(answer.getId());
				answerDTO.setAnswer(answer.getAnswer());
				answerDTO.setId_question(answer.getQuestion().getId());
				answerDTO.setIs_correct(answer.isIs_correct());
				
				answerDTOs.add(answerDTO);
				
				
			});
			
			questionDTO.setListAnswerDTOs(answerDTOs);
			
			listQuestionDTOs.add(questionDTO);
		});
		quizDTO.setListQuestionDTOs(listQuestionDTOs);

		return quizDTO;
	}

	@Override
	public void addQuiz(QuizDTO quizDTO) {
	}

	@Override
	public void updateQuiz(QuizDTO quizDTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteQuiz(int id) {
		// TODO Auto-generated method stub

	}

}
