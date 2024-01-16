package cristinapalmisani.BEU2W2L2.services;

import cristinapalmisani.BEU2W2L2.entities.BlogPost;
import cristinapalmisani.BEU2W2L2.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostService {
    private List<BlogPost> blogs = new ArrayList<>();

    public List<BlogPost> getUsers() {
        return this.blogs;
    }

    public BlogPost save(BlogPost body) {
        Random rndm = new Random();
        body.setId(rndm.nextInt(1, 2000));
        this.blogs.add(body);
        return body;
    }

    public BlogPost findById(long id) {
        BlogPost found = null;
        for (BlogPost user : this.blogs) {
            if (user.getId() == id) {
                found = user;
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;
    }

    public void findByIdAndDelete(long id) {
        Iterator<BlogPost> iterator = this.blogs.iterator();
        while (iterator.hasNext()) {
            BlogPost current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
    }

    public BlogPost findByIdAndUpdate(long id, BlogPost body) {
        BlogPost found = null;
        for (BlogPost user : this.blogs) {
            if (user.getId() == id) {
                found = user;
                found.setReadingTime(body.getReadingTime());
                found.setCategory(body.getCategory());
                found.setContent(body.getContent());
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;
    }
}
