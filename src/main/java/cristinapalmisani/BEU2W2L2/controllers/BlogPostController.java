package cristinapalmisani.BEU2W2L2.controllers;

import cristinapalmisani.BEU2W2L2.entities.BlogPost;
import cristinapalmisani.BEU2W2L2.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    // GET lista blog
    @GetMapping
    public List<BlogPost> getBlog(){
        return blogPostService.getBlog();
    }

    // GET singolo blog
    @GetMapping("/{id}")
    public BlogPost findById(@PathVariable long id) {
        return blogPostService.findById(id);
    }

    // POST nuovo blog
    @PostMapping
    public BlogPost saveBlog(@RequestBody BlogPost body) {
        return blogPostService.save(body);
    }

    //PUT modifica il blogPost
    @PutMapping("/{id}")
    public BlogPost findByAndUpdate(@PathVariable long id, @RequestBody BlogPost body) {
        return this.blogPostService.findByIdAndUpdate(id, body);}

    //DELETE elimina post
    public void findByIdAndDelete(@PathVariable long id){
        this.blogPostService.findByIdAndDelete(id);
    }
}
