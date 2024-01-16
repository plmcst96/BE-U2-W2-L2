package cristinapalmisani.BEU2W2L2.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalTime;

@Getter
@Setter
@ToString
public class BlogPost {
    private int id;
    private String category;
    private String title;
    private String cover;
    private String content;
    private LocalTime readingTime;
}
