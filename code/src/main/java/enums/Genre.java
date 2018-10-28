package enums;

public enum Genre {
    ACTIE("Actie"),
    ANIMATIE("Animatie"),
    AVONTUUR("Avontuur"),
    BIOGRAFISCH("Biografisch"),
    DOCUMENTAIRE("Documentaire"),
    DRAMA("Drama"),
    FAMILIEFILM("Familiefilm"),
    HISTORISCH("Historisch"),
    HORROR("Horror"),
    JEUGD("Jeugd"),
    KINDERFILM("Kinderfilm"),
    KOMEDIE("Komedie"),
    MISDAAD("Misdaad"),
    MYSTERIE("Mysterie"),
    NATUURFILM("Natuurfilm"),
    OORLOG("Oorlog"),
    ROMANTIEK("Romantiek"),
    SCIENCEFICTION("Sciencefiction"),
    SPORT("Sport"),
    THRILLER("Thriller");

    private final String genre;

    Genre(String genre) {
        this.genre = genre;
    }

    public String genre() {
        return this.genre;
    }
}

