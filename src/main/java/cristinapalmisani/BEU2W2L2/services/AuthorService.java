package cristinapalmisani.BEU2W2L2.services;

import cristinapalmisani.BEU2W2L2.entities.Author;
import cristinapalmisani.BEU2W2L2.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class AuthorService {
    private List<Author> authors = new ArrayList<>();

    public List<Author> getAuthor() {
        return this.authors;
    }

    public Author save(Author body) {
        Random rndm = new Random();
        body.setId(rndm.nextInt(1, 2000));
        this.authors.add(body);
        return body;
    }

    public Author findById(long id) {
        Author found = null;
        for (Author user : this.authors) {
            if (user.getId() == id) {
                found = user;
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;
    }

    public void findByIdAndDelete(long id) {
        Iterator<Author> iterator = this.authors.iterator();
        while (iterator.hasNext()) {
            Author current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
    }

    public Author findByIdAndUpdate(long id, Author body) {
        Author found = null;
        for (Author author : this.authors) {
            if (author.getId() == id) {
                found = author;
                found.setId(id);
                found.setName(body.getName());
                found.setSurname(body.getSurname());
                found.setBirthDate(body.getBirthDate());
                found.setEmail(body.getEmail());
                found.setAvatar(body.getAvatar());
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;
    }
}
