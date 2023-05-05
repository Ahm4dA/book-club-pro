package com.sdaproject.bookclubpro.Serivce;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sdaproject.bookclubpro.Entity.Book;
import com.sdaproject.bookclubpro.Entity.Competition;
import com.sdaproject.bookclubpro.Repository.CompetitionRepository;

@Service
public class CompetitionService {

    CompetitionRepository competitionRepository;

    public CompetitionService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    public void createCompetition(Competition competition) {
        competitionRepository.save(competition);
    }

    public List<Competition> getAll() {
        return competitionRepository.getAll();
    }

    public void uploadComplete(Long userId, Long competitionId, Long bookId) {
        competitionRepository.uploadComplete(userId, competitionId, bookId);
    }

    public boolean checkIfAlreadyIn(Long userId, Long compId) {
        Long smh = competitionRepository.checkIfAlreadyIn(userId, compId);

        if (smh == null) {
            return false;
        }

        return true;
    }

    public List<Competition> getByJudge(Long id) {
        return competitionRepository.getByJudge(id);
    }

    public void updateScore(Long userid, Long compid, Long bookid, Float score) {
        competitionRepository.updateScore(userid, compid, bookid, score);
    }
}
