package duckdns.niceft.nicefilmticket.domain.presentHistory;

import duckdns.niceft.nicefilmticket.domain.DateTime;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PresentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "present_history_id")
    private Long id;

    private Long senderId;

    private Long receiverId;

    private Long nftId;

    @Embedded
    private DateTime dateTime;
}
