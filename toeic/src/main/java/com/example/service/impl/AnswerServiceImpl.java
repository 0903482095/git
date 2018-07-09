package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.AnswerDao;
import com.example.entity.Answer;
import com.example.model.AnswerDTO;
import com.example.service.AnswerService;

@Transactional
@Service
public class AnswerServiceImpl implements AnswerService {
	@Autowired
	AnswerDao answerDao;

	@Override
	public List<AnswerDTO> getAllAnswer() {
		List<Answer> listAnswers = answerDao.getAllAnswer();
		List<AnswerDTO> listAnswerDTOs = new ArrayList<AnswerDTO>();
		listAnswers.forEach(answer -> {
			AnswerDTO answerDTO = new AnswerDTO();
			answerDTO.setId(answer.getId());
			answerDTO.setAnswer(answer.getAnswer());
			answerDTO.setIs_correct(answer.isIs_correct());
			answerDTO.setId_question(answer.getQuestion().getId());

			listAnswerDTOs.add(answerDTO);
		});
		return listAnswerDTOs;
	}

	@Override
	public void addAnswer(AnswerDTO answerDTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAnswer(AnswerDTO answerDTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAnswer(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<AnswerDTO> getAnswerByIdQuestion(int id) {
		List<Answer> listAnswers = answerDao.getAnswerByIdQuestion(id);
		List<AnswerDTO> listAnswerDTOs = new ArrayList<AnswerDTO>();
		listAnswers.forEach(answer -> {
			AnswerDTO answerDTO = new AnswerDTO();
			answerDTO.setId(answer.getId());
			answerDTO.setAnswer(answer.getAnswer());
			answerDTO.setIs_correct(answer.isIs_correct());
			answerDTO.setId_question(answer.getQuestion().getId());

			listAnswerDTOs.add(answerDTO);
		});
		return listAnswerDTOs;
	}

}
