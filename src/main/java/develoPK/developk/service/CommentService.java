package develoPK.developk.service;

import develoPK.developk.domain.Comment;
import develoPK.developk.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public Long createComment(Comment comment){
        commentRepository.save(comment);
        return comment.getId();
    }

    public List<Comment> findComment(){
        return commentRepository.findAll();
    }
}
