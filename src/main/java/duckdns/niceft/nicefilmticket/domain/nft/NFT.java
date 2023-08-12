package duckdns.niceft.nicefilmticket.domain.nft;

import duckdns.niceft.nicefilmticket.domain.DateTime;
import duckdns.niceft.nicefilmticket.domain.media.Media;
import duckdns.niceft.nicefilmticket.domain.member.Buyer;
import duckdns.niceft.nicefilmticket.domain.member.Publisher;
import duckdns.niceft.nicefilmticket.domain.movie.Movie;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NFT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nft_id")
    private Long id;

    private String nftSerialnum;

    @Enumerated(EnumType.STRING)
    private NFTLevel nftLevel;

    private int nftPrice;

    private String saleStartDate;

    private String saleEndDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "media_id")
    private Media media;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Embedded //생성일 수정일 삭제일
    private DateTime dateTime;
}
