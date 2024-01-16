package cristinapalmisani.BEU2W2L2.controllers;

import cristinapalmisani.BEU2W2L2.entities.Author;
import cristinapalmisani.BEU2W2L2.entities.BlogPost;
import cristinapalmisani.BEU2W2L2.services.AuthorService;
import cristinapalmisani.BEU2W2L2.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    // GET lista autori
    @GetMapping
    public List<Author> getAuthor(){
        return authorService.getAuthor();
    }

    // GET singolo autore
    @GetMapping("/{id}")
    public Author findById(@PathVariable long id) {
        return authorService.findById(id);
    }

    // POST nuovo autore
    @PostMapping
    public Author saveBlog(@RequestBody Author body) {
        return authorService.save(body);
    }

    //PUT modifica il autore
    @PutMapping("/{id}")
    public Author findByAndUpdate(@PathVariable long id, @RequestBody Author body) {
        return this.authorService.findByIdAndUpdate(id, body);}

    //DELETE elimina autore
    public void findByIdAndDelete(@PathVariable long id){
        this.authorService.findByIdAndDelete(id);
    }
}
