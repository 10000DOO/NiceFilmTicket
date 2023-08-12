package duckdns.niceft.nicefilmticket.domain.post;

import duckdns.niceft.nicefilmticket.domain.DateTime;
import duckdns.niceft.nicefilmticket.domain.member.Buyer;
import duckdns.niceft.nicefilmticket.domain.member.Publisher;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    private String postTitle;

    private String postContent;

    private int views;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @Embedded
    private DateTime dateTime;
}
