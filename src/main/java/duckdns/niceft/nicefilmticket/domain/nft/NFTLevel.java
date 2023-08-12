package duckdns.niceft.nicefilmticket.domain.nft;

import lombok.Getter;

@Getter
public enum NFTLevel {
    NORMAL("일반"),//없음
    RARE("희귀"),//없음
    LEGEND("전설"); //시리얼번호 + 메시지

    private final String message;
    NFTLevel(String message) {
        this.message = message;
    }
}
