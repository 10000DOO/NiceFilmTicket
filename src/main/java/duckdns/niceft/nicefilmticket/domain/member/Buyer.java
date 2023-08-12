package duckdns.niceft.nicefilmticket.domain.member;

import duckdns.niceft.nicefilmticket.domain.DateTime;
import duckdns.niceft.nicefilmticket.domain.media.Media;
import duckdns.niceft.nicefilmticket.domain.nft.NFT;
import duckdns.niceft.nicefilmticket.domain.post.Post;
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
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "buyer_id")
    private Long id;

    @Column(unique = true)
    @Size(max = 20)
    private String buyerName;

    private String buyerSerialnum;

    @OneToMany(mappedBy = "buyer")
    private List<NFT> nftList = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "media_id")
    private Media media;

    @OneToMany(mappedBy = "buyer")
    private List<Post> postList = new ArrayList<>();

    @Embedded //생성일 수정일 삭제일
    private DateTime dateTime;
}
