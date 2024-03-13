package coducation.petforum.service;

import coducation.petforum.exception.CustomException;
import coducation.petforum.utils.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;



@Service
@RequiredArgsConstructor
public class CommentService {

    private final MyUserRepository myUserRepository;
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private String regex = "(?iu)\\b(?:(?:(?:у|[нз]а|(?:хитро|не)?вз?" +
            "[ыьъ]|с[ьъ]|(?:и|ра)[зс]ъ?|(?:о[тб]|п[оа]д)[ьъ]?|(?:.\\B)" +
            "+?[оаеи-])-?)?(?:[её](?:б(?!о[рй]|рач)|п[уа](?:ц|тс))|и[пб]" +
            "[ае][тцд][ьъ]).*?|(?:(?:н[иеа]|ра[зс]|[зд]?[ао](?:т|дн[оа])" +
            "?|с(?:м[еи])?|а[пб]ч)-?)?ху(?:[яйиеёю]|л+и(?!ган)).*?|бл(?:" +
            "[эя]|еа?)(?:[дт][ьъ]?)?|\\S*?(?:п(?:[иеё]зд|ид[аое]?р|ед(?:" +
            "р(?!о)|[аое]р|ик)|охую)|бля(?:[дбц]|тс)|[ое]ху[яйиеё]|хуйн)." +
            "*?|(?:о[тб]?|про|на|вы)?м(?:анд(?:[ауеыи](?:л(?:и[сзщ])?[ауеиы]" +
            ")?|ой|[ао]в.*?|юк(?:ов|[ауи])?|е[нт]ь|ища)|уд(?:[яаиое].+?|е?н(" +
            "?:[ьюия]|ей))|[ао]л[ао]ф[ьъ](?:[яиюе]|[еёо]й))|елд[ауые].*?|ля[тд]ь|(?:[нз]а|по)х)\\b\n";
    public String createComment(int postId, String comment, int userId){
        if(comment.matches(regex)){
            return "Ваш комментарий не прошел модерацию нецензурных слов";
        }else {
            MyUserEntity userEntity = myUserRepository.findById(userId).get();
            PostEntity postEntity = postRepository.findById(postId).get();
            CommentEntity commentEntity = new CommentEntity();
            commentEntity.setPostEntity(postEntity);
            commentEntity.setComment(comment);
            commentEntity.setMyUserEntity(userEntity);
            commentEntity.setDate(LocalDate.now());
            postEntity.getCommentEntiyList().add(commentEntity);
            commentRepository.save(commentEntity);
            postRepository.save(postEntity);
            return "Комментарий успешно добавлен";
        }
    }

    public String setNewComment(int commentId, String newComment){
        if(newComment.matches(regex)){
            return "Новый комментарий не прошел модерацию нецензурных слов ";
        } else {
            CommentEntity commentEntity = commentRepository.findById(commentId).get();
            commentEntity.setComment(newComment);
            commentEntity.setDate(LocalDate.now());
            commentRepository.save(commentEntity);
        }
        return "Комментарий обновлен";
    }
    public void setLikeToComment(int commentId){
        CommentEntity commentEntity = commentRepository.findById(commentId).get();
        commentEntity.setLikeCount(commentEntity.getLikeCount()+1);
        commentRepository.save(commentEntity);
    }
    public String deleteComment(int commentId, int userId){
        CommentEntity commentEntity = commentRepository.findById(commentId).get();
        MyUserEntity myUserEntity = myUserRepository.findById(userId).get();
        if(commentEntity.getMyUserEntity().getLogin().equalsIgnoreCase(myUserEntity.getLogin())||
        myUserEntity.getRole().equals("ADMIN")||
                myUserEntity.getRole().equals("MODERATOR")) {
            commentRepository.delete(commentEntity);
            return "Комментарий удален";
        }else{
            return "Что-то пошло не так при удалении";
        }
    }
}