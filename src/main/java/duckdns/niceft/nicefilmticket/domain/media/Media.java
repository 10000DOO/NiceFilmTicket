package duckdns.niceft.nicefilmticket.domain.media;

import duckdns.niceft.nicefilmticket.domain.DateTime;
import duckdns.niceft.nicefilmticket.domain.movie.Movie;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "media_id")
    private Long id;

    private String originalFilename;

    private String filename;

    private String filePath;

    @Embedded //생성일 수정일 삭제일
    private DateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie")
    private Movie movie;

    @Builder
    public Media(String originalFilename, String filename, String filePath, DateTime dateTime) {
        this.originalFilename = originalFilename;
        this.filename = filename;
        this.filePath = filePath;
        this.dateTime = dateTime;
    }
}
