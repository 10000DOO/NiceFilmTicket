package duckdns.niceft.nicefilmticket.domain.tradeHistory;

import duckdns.niceft.nicefilmticket.domain.DateTime;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TradeHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trade_history_id")
    private Long id;

    private Long buyerId;

    private Long publisherId;

    private Long nftId;

    @Embedded
    private DateTime dateTime;
}
