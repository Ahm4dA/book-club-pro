package com.sdaproject.bookclubpro.Serivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdaproject.bookclubpro.Entity.Club;
import com.sdaproject.bookclubpro.Repository.ClubRepository;

@Service
public class ClubService {

    ClubRepository clubRepository;

    @Autowired
    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public void createClub(Club club) {
        clubRepository.save(club);
    }

    public List<Club> findByName(String name) {
        return clubRepository.findByNameR(name);
    }

    public List<Club> getAllClub() {
        return clubRepository.findAll();
    }

    public void saveMemberOnCreate(Long userid, Long clubid) {
        clubRepository.saveMemberOnCreate(userid, clubid);
    }

    public Club getByName(String name) {
        return clubRepository.getByNameR(name);
    }

    public List<Long> checkIfUserInClub(Long userid) {
        return clubRepository.checkIfUserInClubR(userid);
    }

    public Club getById(Long id) {
        return clubRepository.getByIdR(id);
    }
}
