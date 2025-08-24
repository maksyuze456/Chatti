package org.training.chatti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.chatti.repository.CommentRepository;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;





}
