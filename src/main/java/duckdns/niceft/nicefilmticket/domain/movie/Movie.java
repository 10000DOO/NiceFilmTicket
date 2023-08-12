package duckdns.niceft.nicefilmticket.domain.movie;

import duckdns.niceft.nicefilmticket.domain.media.Media;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long id;

    private String movieTitle;

    private String description;

    private String releaseDate;

    @Enumerated(EnumType.STRING)
    private FilmRating filmRating;

    private int runTime;

    private String director;

    private String actor;

    @OneToMany(mappedBy = "movie")
    private List<Media> mediaList;
}
