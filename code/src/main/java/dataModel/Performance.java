package dataModel;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "oid",
        "cinema_id",
        "movie_id",
        "auditorium_id",
        "has_2d",
        "has_3d",
        "has_dbox",
        "has_xd",
        "has_atmos",
        "has_dolbycinema",
        "has_ov",
        "has_nl",
        "start",
        "end",
        "has_break",
        "visible",
        "disabled",
        "is_edited",
        "price",
        "full_price",
        "reservation_fee",
        "ticket_fee",
        "has_rental_3d_glasses",
        "cinema",
        "cinema_name",
        "auditorium_name",
        "special_category",
        "prices"
})
public class Performance {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("oid")
    private String oid;
    @JsonProperty("cinema_id")
    private Integer cinemaId;
    @JsonProperty("movie_id")
    private Integer movieId;
    @JsonProperty("auditorium_id")
    private Integer auditoriumId;
    @JsonProperty("has_2d")
    private Integer has2d;
    @JsonProperty("has_3d")
    private Integer has3d;
    @JsonProperty("has_dbox")
    private Integer hasDbox;
    @JsonProperty("has_xd")
    private Integer hasXd;
    @JsonProperty("has_atmos")
    private Integer hasAtmos;
    @JsonProperty("has_dolbycinema")
    private Integer hasDolbycinema;
    @JsonProperty("has_ov")
    private Integer hasOv;
    @JsonProperty("has_nl")
    private Integer hasNl;
    @JsonProperty("start")
    private String start;
    @JsonProperty("end")
    private String end;
    @JsonProperty("has_break")
    private Integer hasBreak;
    @JsonProperty("visible")
    private Integer visible;
    @JsonProperty("disabled")
    private Integer disabled;
    @JsonProperty("is_edited")
    private Integer isEdited;
    @JsonProperty("price")
    private Object price;
    @JsonProperty("full_price")
    private Object fullPrice;
    @JsonProperty("reservation_fee")
    private Object reservationFee;
    @JsonProperty("ticket_fee")
    private Object ticketFee;
    @JsonProperty("has_rental_3d_glasses")
    private Object hasRental3dGlasses;
    @JsonProperty("cinema")
    private Object cinema;
    @JsonProperty("cinema_name")
    private Object cinemaName;
    @JsonProperty("auditorium_name")
    private Object auditoriumName;
    @JsonProperty("special_category")
    private Object specialCategory;
    @JsonProperty("prices")
    private Object prices;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Performance() {
    }

    /**
     *
     * @param has3d
     * @param movieId
     * @param isEdited
     * @param hasRental3dGlasses
     * @param cinemaId
     * @param visible
     * @param cinemaName
     * @param hasOv
     * @param reservationFee
     * @param id
     * @param oid
     * @param end
     * @param hasXd
     * @param hasDbox
     * @param has2d
     * @param hasNl
     * @param hasBreak
     * @param ticketFee
     * @param hasAtmos
     * @param price
     * @param start
     * @param cinema
     * @param prices
     * @param hasDolbycinema
     * @param auditoriumId
     * @param fullPrice
     * @param auditoriumName
     * @param disabled
     * @param specialCategory
     */
    public Performance(Integer id, String oid, Integer cinemaId, Integer movieId, Integer auditoriumId, Integer has2d, Integer has3d, Integer hasDbox, Integer hasXd, Integer hasAtmos, Integer hasDolbycinema, Integer hasOv, Integer hasNl, String start, String end, Integer hasBreak, Integer visible, Integer disabled, Integer isEdited, Object price, Object fullPrice, Object reservationFee, Object ticketFee, Object hasRental3dGlasses, Object cinema, Object cinemaName, Object auditoriumName, Object specialCategory, Object prices) {
        super();
        this.id = id;
        this.oid = oid;
        this.cinemaId = cinemaId;
        this.movieId = movieId;
        this.auditoriumId = auditoriumId;
        this.has2d = has2d;
        this.has3d = has3d;
        this.hasDbox = hasDbox;
        this.hasXd = hasXd;
        this.hasAtmos = hasAtmos;
        this.hasDolbycinema = hasDolbycinema;
        this.hasOv = hasOv;
        this.hasNl = hasNl;
        this.start = start;
        this.end = end;
        this.hasBreak = hasBreak;
        this.visible = visible;
        this.disabled = disabled;
        this.isEdited = isEdited;
        this.price = price;
        this.fullPrice = fullPrice;
        this.reservationFee = reservationFee;
        this.ticketFee = ticketFee;
        this.hasRental3dGlasses = hasRental3dGlasses;
        this.cinema = cinema;
        this.cinemaName = cinemaName;
        this.auditoriumName = auditoriumName;
        this.specialCategory = specialCategory;
        this.prices = prices;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    public dataModel.Performance withId(Integer id) {
        this.id = id;
        return this;
    }

    @JsonProperty("oid")
    public String getOid() {
        return oid;
    }

    @JsonProperty("oid")
    public void setOid(String oid) {
        this.oid = oid;
    }

    public dataModel.Performance withOid(String oid) {
        this.oid = oid;
        return this;
    }

    @JsonProperty("cinema_id")
    public Integer getCinemaId() {
        return cinemaId;
    }

    @JsonProperty("cinema_id")
    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public dataModel.Performance withCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
        return this;
    }

    @JsonProperty("movie_id")
    public Integer getMovieId() {
        return movieId;
    }

    @JsonProperty("movie_id")
    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public dataModel.Performance withMovieId(Integer movieId) {
        this.movieId = movieId;
        return this;
    }

    @JsonProperty("auditorium_id")
    public Integer getAuditoriumId() {
        return auditoriumId;
    }

    @JsonProperty("auditorium_id")
    public void setAuditoriumId(Integer auditoriumId) {
        this.auditoriumId = auditoriumId;
    }

    public dataModel.Performance withAuditoriumId(Integer auditoriumId) {
        this.auditoriumId = auditoriumId;
        return this;
    }

    @JsonProperty("has_2d")
    public Integer getHas2d() {
        return has2d;
    }

    @JsonProperty("has_2d")
    public void setHas2d(Integer has2d) {
        this.has2d = has2d;
    }

    public dataModel.Performance withHas2d(Integer has2d) {
        this.has2d = has2d;
        return this;
    }

    @JsonProperty("has_3d")
    public Integer getHas3d() {
        return has3d;
    }

    @JsonProperty("has_3d")
    public void setHas3d(Integer has3d) {
        this.has3d = has3d;
    }

    public dataModel.Performance withHas3d(Integer has3d) {
        this.has3d = has3d;
        return this;
    }

    @JsonProperty("has_dbox")
    public Integer getHasDbox() {
        return hasDbox;
    }

    @JsonProperty("has_dbox")
    public void setHasDbox(Integer hasDbox) {
        this.hasDbox = hasDbox;
    }

    public dataModel.Performance withHasDbox(Integer hasDbox) {
        this.hasDbox = hasDbox;
        return this;
    }

    @JsonProperty("has_xd")
    public Integer getHasXd() {
        return hasXd;
    }

    @JsonProperty("has_xd")
    public void setHasXd(Integer hasXd) {
        this.hasXd = hasXd;
    }

    public dataModel.Performance withHasXd(Integer hasXd) {
        this.hasXd = hasXd;
        return this;
    }

    @JsonProperty("has_atmos")
    public Integer getHasAtmos() {
        return hasAtmos;
    }

    @JsonProperty("has_atmos")
    public void setHasAtmos(Integer hasAtmos) {
        this.hasAtmos = hasAtmos;
    }

    public dataModel.Performance withHasAtmos(Integer hasAtmos) {
        this.hasAtmos = hasAtmos;
        return this;
    }

    @JsonProperty("has_dolbycinema")
    public Integer getHasDolbycinema() {
        return hasDolbycinema;
    }

    @JsonProperty("has_dolbycinema")
    public void setHasDolbycinema(Integer hasDolbycinema) {
        this.hasDolbycinema = hasDolbycinema;
    }

    public dataModel.Performance withHasDolbycinema(Integer hasDolbycinema) {
        this.hasDolbycinema = hasDolbycinema;
        return this;
    }

    @JsonProperty("has_ov")
    public Integer getHasOv() {
        return hasOv;
    }

    @JsonProperty("has_ov")
    public void setHasOv(Integer hasOv) {
        this.hasOv = hasOv;
    }

    public dataModel.Performance withHasOv(Integer hasOv) {
        this.hasOv = hasOv;
        return this;
    }

    @JsonProperty("has_nl")
    public Integer getHasNl() {
        return hasNl;
    }

    @JsonProperty("has_nl")
    public void setHasNl(Integer hasNl) {
        this.hasNl = hasNl;
    }

    public dataModel.Performance withHasNl(Integer hasNl) {
        this.hasNl = hasNl;
        return this;
    }

    @JsonProperty("start")
    public String getStart() {
        return start;
    }

    @JsonProperty("start")
    public void setStart(String start) {
        this.start = start;
    }

    public dataModel.Performance withStart(String start) {
        this.start = start;
        return this;
    }

    @JsonProperty("end")
    public String getEnd() {
        return end;
    }

    @JsonProperty("end")
    public void setEnd(String end) {
        this.end = end;
    }

    public dataModel.Performance withEnd(String end) {
        this.end = end;
        return this;
    }

    @JsonProperty("has_break")
    public Integer getHasBreak() {
        return hasBreak;
    }

    @JsonProperty("has_break")
    public void setHasBreak(Integer hasBreak) {
        this.hasBreak = hasBreak;
    }

    public dataModel.Performance withHasBreak(Integer hasBreak) {
        this.hasBreak = hasBreak;
        return this;
    }

    @JsonProperty("visible")
    public Integer getVisible() {
        return visible;
    }

    @JsonProperty("visible")
    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public dataModel.Performance withVisible(Integer visible) {
        this.visible = visible;
        return this;
    }

    @JsonProperty("disabled")
    public Integer getDisabled() {
        return disabled;
    }

    @JsonProperty("disabled")
    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }

    public dataModel.Performance withDisabled(Integer disabled) {
        this.disabled = disabled;
        return this;
    }

    @JsonProperty("is_edited")
    public Integer getIsEdited() {
        return isEdited;
    }

    @JsonProperty("is_edited")
    public void setIsEdited(Integer isEdited) {
        this.isEdited = isEdited;
    }

    public dataModel.Performance withIsEdited(Integer isEdited) {
        this.isEdited = isEdited;
        return this;
    }

    @JsonProperty("price")
    public Object getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Object price) {
        this.price = price;
    }

    public dataModel.Performance withPrice(Object price) {
        this.price = price;
        return this;
    }

    @JsonProperty("full_price")
    public Object getFullPrice() {
        return fullPrice;
    }

    @JsonProperty("full_price")
    public void setFullPrice(Object fullPrice) {
        this.fullPrice = fullPrice;
    }

    public dataModel.Performance withFullPrice(Object fullPrice) {
        this.fullPrice = fullPrice;
        return this;
    }

    @JsonProperty("reservation_fee")
    public Object getReservationFee() {
        return reservationFee;
    }

    @JsonProperty("reservation_fee")
    public void setReservationFee(Object reservationFee) {
        this.reservationFee = reservationFee;
    }

    public dataModel.Performance withReservationFee(Object reservationFee) {
        this.reservationFee = reservationFee;
        return this;
    }

    @JsonProperty("ticket_fee")
    public Object getTicketFee() {
        return ticketFee;
    }

    @JsonProperty("ticket_fee")
    public void setTicketFee(Object ticketFee) {
        this.ticketFee = ticketFee;
    }

    public dataModel.Performance withTicketFee(Object ticketFee) {
        this.ticketFee = ticketFee;
        return this;
    }

    @JsonProperty("has_rental_3d_glasses")
    public Object getHasRental3dGlasses() {
        return hasRental3dGlasses;
    }

    @JsonProperty("has_rental_3d_glasses")
    public void setHasRental3dGlasses(Object hasRental3dGlasses) {
        this.hasRental3dGlasses = hasRental3dGlasses;
    }

    public dataModel.Performance withHasRental3dGlasses(Object hasRental3dGlasses) {
        this.hasRental3dGlasses = hasRental3dGlasses;
        return this;
    }

    @JsonProperty("cinema")
    public Object getCinema() {
        return cinema;
    }

    @JsonProperty("cinema")
    public void setCinema(Object cinema) {
        this.cinema = cinema;
    }

    public dataModel.Performance withCinema(Object cinema) {
        this.cinema = cinema;
        return this;
    }

    @JsonProperty("cinema_name")
    public Object getCinemaName() {
        return cinemaName;
    }

    @JsonProperty("cinema_name")
    public void setCinemaName(Object cinemaName) {
        this.cinemaName = cinemaName;
    }

    public dataModel.Performance withCinemaName(Object cinemaName) {
        this.cinemaName = cinemaName;
        return this;
    }

    @JsonProperty("auditorium_name")
    public Object getAuditoriumName() {
        return auditoriumName;
    }

    @JsonProperty("auditorium_name")
    public void setAuditoriumName(Object auditoriumName) {
        this.auditoriumName = auditoriumName;
    }

    public dataModel.Performance withAuditoriumName(Object auditoriumName) {
        this.auditoriumName = auditoriumName;
        return this;
    }

    @JsonProperty("special_category")
    public Object getSpecialCategory() {
        return specialCategory;
    }

    @JsonProperty("special_category")
    public void setSpecialCategory(Object specialCategory) {
        this.specialCategory = specialCategory;
    }

    public dataModel.Performance withSpecialCategory(Object specialCategory) {
        this.specialCategory = specialCategory;
        return this;
    }

    @JsonProperty("prices")
    public Object getPrices() {
        return prices;
    }

    @JsonProperty("prices")
    public void setPrices(Object prices) {
        this.prices = prices;
    }

    public dataModel.Performance withPrices(Object prices) {
        this.prices = prices;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public dataModel.Performance withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("movieId", movieId).append("start", start).append("end", end).toString();
    }

}