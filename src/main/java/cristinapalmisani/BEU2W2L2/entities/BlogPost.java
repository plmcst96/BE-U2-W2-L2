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
    private final String cover = "https://picsum.photos/200/300";
    private String content;
    private LocalTime readingTime;
}
