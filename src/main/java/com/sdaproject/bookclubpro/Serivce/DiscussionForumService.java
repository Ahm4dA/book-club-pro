package com.sdaproject.bookclubpro.Serivce;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sdaproject.bookclubpro.Entity.DiscussionForum;
import com.sdaproject.bookclubpro.Repository.DiscussionForumRepository;

@Service
public class DiscussionForumService {

    DiscussionForumRepository discussionForumRepository;

    public DiscussionForumService(DiscussionForumRepository discussionForumRepository) {
        this.discussionForumRepository = discussionForumRepository;
    }

    public List<DiscussionForum> getAllMessages(Long clubid) {
        return discussionForumRepository.getAllMessages(clubid);
    }

    public void postMessage(DiscussionForum df) {
        discussionForumRepository.save(df);
    }
}
