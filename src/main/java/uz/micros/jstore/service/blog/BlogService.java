package uz.micros.jstore.service.blog;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import uz.micros.jstore.entity.blog.Blog;
import uz.micros.jstore.entity.blog.Post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {

    public Blog getBlog(){
        Blog blog = new Blog();
        blog.setTitle("jStore Corporate Blog!!!");

        List<Post> posts = new ArrayList<>();

        for(int k = 0; k < 3; k++){

            Post post = new Post();
            post.setId(k + 100);
            post.setSubject("Post " + (k + 1));
            post.setDate(new Date());
            post.setText("Украинских дипломатов информируют, что в МИД России поступили многочисленные обращения от граждан и организаций восточных регионов Украины с просьбой оказания гуманитарной помощи. В частности, речь идет о поставке медицинских препаратов.\n" +
                    "\n" +
                    "МИД России предложил согласовать поставки гуманитарной помощи по линии соответствующих ведомств России и Украины и рассчитывает на максимально оперативный ответ.\n" +
                    "\n" +
                    "Силовая операция на востоке Украины продолжается с апреля 2014 года. После президентских выборов 25 мая на Украине боевые действия в регионе вновь перешли в активную фазу. Тогда избранный глава государства Петр Порошенко высказался за продолжение силовой операции. А вице-премьер Дмитрий Ярема пообещал, что бои на востоке страны продлятся до тех пор, пока не будут уничтожены все ополченцы.");

            posts.add(post);
        }

        blog.setPosts(posts);

        return blog;
    }
}
