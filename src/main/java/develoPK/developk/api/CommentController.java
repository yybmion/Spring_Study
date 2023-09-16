package develoPK.developk.api;

import develoPK.developk.domain.Comment;
import develoPK.developk.service.CommentService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comment")
    public List<Comment> commentV1(@RequestBody Comment comment){
        return commentService.findComment();
    }

    @PostMapping("/comment")
    public CreateCommentResponse saveCommentV1(@RequestBody Comment comment){
        Long id = commentService.createComment(comment);
        return new CreateCommentResponse(id);
    }

    @GetMapping("/comment/list")
    public List<Comment> commentList(){
        return commentService.findComment();
    }

    @Data
    static class CreateCommentResponse{
        private Long id;

        public CreateCommentResponse(Long id){
            this.id=id;
        }

    }
}
