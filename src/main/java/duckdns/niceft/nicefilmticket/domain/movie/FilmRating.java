package duckdns.niceft.nicefilmticket.domain.movie;

public enum FilmRating {
    G_RATED("전체관람가"),
    PG12("12세 이상 관람가"),
    PG_15("15세 이상 관람가"),
    PG_18("18세 이상 관람가");

    private final String level;

    FilmRating(String level) {
        this.level = level;
    }
}
