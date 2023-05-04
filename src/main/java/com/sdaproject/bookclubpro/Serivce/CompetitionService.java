package com.sdaproject.bookclubpro.Serivce;

import java.util.List;

import org.springframework.stereotype.Service;

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
}
