package enums;

public enum Cinema {
    ALKMAAR(1),
    ALPHEN_AD_RIJN(2),
    AMERSFOORT(3),
    APELDOORN(4),
    ARNHEM(5),
    DEN_BOSCH(6),
    DEVENTER(7),
    DOETINCHEM(8),
    EINDHOVEN(23),
    GORINCHEM(9),
    HEERHUGOWAARD(10),
    HILVERSUM(12),
    HOOGEVEEN(13),
    HOOGEZAND(14),
    HOORN(22),
    KERKRADE(15),
    NIJMEGEN_PLEIN(18),
    NIJMEGEN_WALSTRAAT(17),
    PURMEREND(19),
    STEENWIJK(20),
    VLAARDINGEN(21);

    private final int cinemaId;

    Cinema(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public int cinemaId() {
        return this.cinemaId;
    }
}
