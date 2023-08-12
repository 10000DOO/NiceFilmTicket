package duckdns.niceft.nicefilmticket.domain.member;

import duckdns.niceft.nicefilmticket.domain.DateTime;
import duckdns.niceft.nicefilmticket.domain.event.Event;
import duckdns.niceft.nicefilmticket.domain.nft.NFT;
import duckdns.niceft.nicefilmticket.domain.post.Post;
import duckdns.niceft.nicefilmticket.domain.refreshToken.RefreshToken;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private Long id;

    @Column(unique = true)
    @Size(max = 20)
    private String publisherName;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "token_id")
    private RefreshToken refreshToken;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    @Size(min = 5, max = 20)
    private String loginId;

    private String password;

    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @OneToMany(mappedBy = "publisher")
    private List<NFT> nftList = new ArrayList<>();

    @OneToMany(mappedBy = "publisher")
    private List<Post> postList = new ArrayList<>();

    @OneToMany(mappedBy = "publisher")
    private List<Event> eventList = new ArrayList<>();

    @Embedded //생성일 수정일 삭제일
    private DateTime dateTime;
}
