package dataModel;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "oid",
        "edi",
        "title",
        "slug",
        "description",
        "genres",
        "kijkwijzer",
        "cast",
        "director",
        "vue_url",
        "trailer_url_low",
        "trailer_url_high",
        "trailer_youtube_id",
        "image",
        "release_date",
        "special_category",
        "playingtime",
        "is_edited",
        "edit_date",
        "vue_created",
        "og_title",
        "og_description",
        "og_image",
        "image_relative",
        "image_missing",
        "full_title",
        "rating_average",
        "rating_count",
        "stills",
        "performances",
        "all_performances"
})
public class Movie {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("oid")
    private String oid;
    @JsonProperty("edi")
    private String edi;
    @JsonProperty("title")
    private String title;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("description")
    private String description;
    @JsonProperty("genres")
    private String genres;
    @JsonProperty("kijkwijzer")
    private String kijkwijzer;
    @JsonProperty("cast")
    private String cast;
    @JsonProperty("director")
    private String director;
    @JsonProperty("vue_url")
    private String vueUrl;
    @JsonProperty("trailer_url_low")
    private String trailerUrlLow;
    @JsonProperty("trailer_url_high")
    private String trailerUrlHigh;
    @JsonProperty("trailer_youtube_id")
    private String trailerYoutubeId;
    @JsonProperty("image")
    private String image;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("special_category")
    private String specialCategory;
    @JsonProperty("playingtime")
    private Integer playingtime;
    @JsonProperty("is_edited")
    private Integer isEdited;
    @JsonProperty("edit_date")
    private String editDate;
    @JsonProperty("vue_created")
    private Integer vueCreated;
    @JsonProperty("og_title")
    private String ogTitle;
    @JsonProperty("og_description")
    private String ogDescription;
    @JsonProperty("og_image")
    private String ogImage;
    @JsonProperty("image_relative")
    private String imageRelative;
    @JsonProperty("image_missing")
    private Object imageMissing;
    @JsonProperty("full_title")
    private Object fullTitle;
    @JsonProperty("rating_average")
    private Object ratingAverage;
    @JsonProperty("rating_count")
    private Object ratingCount;
    @JsonProperty("stills")
    private Object stills;
    @JsonProperty("performances")
    private List<Performance> performances = null;
    @JsonProperty("all_performances")
    private Object allPerformances;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Movie() {
    }

    /**
     * @param imageRelative
     * @param isEdited
     * @param genres
     * @param edi
     * @param ratingAverage
     * @param editDate
     * @param id
     * @param imageMissing
     * @param kijkwijzer
     * @param title
     * @param releaseDate
     * @param ogTitle
     * @param description
     * @param oid
     * @param trailerYoutubeId
     * @param trailerUrlHigh
     * @param vueUrl
     * @param ratingCount
     * @param image
     * @param ogDescription
     * @param director
     * @param stills
     * @param cast
     * @param ogImage
     * @param allPerformances
     * @param playingtime
     * @param vueCreated
     * @param fullTitle
     * @param trailerUrlLow
     * @param performances
     * @param slug
     * @param specialCategory
     */
    public Movie(Integer id, String oid, String edi, String title, String slug, String description, String genres, String kijkwijzer, String cast, String director, String vueUrl, String trailerUrlLow, String trailerUrlHigh, String trailerYoutubeId, String image, String releaseDate, String specialCategory, Integer playingtime, Integer isEdited, String editDate, Integer vueCreated, String ogTitle, String ogDescription, String ogImage, String imageRelative, Object imageMissing, Object fullTitle, Object ratingAverage, Object ratingCount, Object stills, List<Performance> performances, Object allPerformances) {
        super();
        this.id = id;
        this.oid = oid;
        this.edi = edi;
        this.title = title;
        this.slug = slug;
        this.description = description;
        this.genres = genres;
        this.kijkwijzer = kijkwijzer;
        this.cast = cast;
        this.director = director;
        this.vueUrl = vueUrl;
        this.trailerUrlLow = trailerUrlLow;
        this.trailerUrlHigh = trailerUrlHigh;
        this.trailerYoutubeId = trailerYoutubeId;
        this.image = image;
        this.releaseDate = releaseDate;
        this.specialCategory = specialCategory;
        this.playingtime = playingtime;
        this.isEdited = isEdited;
        this.editDate = editDate;
        this.vueCreated = vueCreated;
        this.ogTitle = ogTitle;
        this.ogDescription = ogDescription;
        this.ogImage = ogImage;
        this.imageRelative = imageRelative;
        this.imageMissing = imageMissing;
        this.fullTitle = fullTitle;
        this.ratingAverage = ratingAverage;
        this.ratingCount = ratingCount;
        this.stills = stills;
        this.performances = performances;
        this.allPerformances = allPerformances;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    public Movie withId(Integer id) {
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

    public Movie withOid(String oid) {
        this.oid = oid;
        return this;
    }

    @JsonProperty("edi")
    public String getEdi() {
        return edi;
    }

    @JsonProperty("edi")
    public void setEdi(String edi) {
        this.edi = edi;
    }

    public Movie withEdi(String edi) {
        this.edi = edi;
        return this;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public Movie withTitle(String title) {
        this.title = title;
        return this;
    }

    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    @JsonProperty("slug")
    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Movie withSlug(String slug) {
        this.slug = slug;
        return this;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public Movie withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("genres")
    public String getGenres() {
        return genres;
    }

    @JsonProperty("genres")
    public void setGenres(String genres) {
        this.genres = genres;
    }

    public Movie withGenres(String genres) {
        this.genres = genres;
        return this;
    }

    @JsonProperty("kijkwijzer")
    public String getKijkwijzer() {
        return kijkwijzer;
    }

    @JsonProperty("kijkwijzer")
    public void setKijkwijzer(String kijkwijzer) {
        this.kijkwijzer = kijkwijzer;
    }

    public Movie withKijkwijzer(String kijkwijzer) {
        this.kijkwijzer = kijkwijzer;
        return this;
    }

    @JsonProperty("cast")
    public String getCast() {
        return cast;
    }

    @JsonProperty("cast")
    public void setCast(String cast) {
        this.cast = cast;
    }

    public Movie withCast(String cast) {
        this.cast = cast;
        return this;
    }

    @JsonProperty("director")
    public String getDirector() {
        return director;
    }

    @JsonProperty("director")
    public void setDirector(String director) {
        this.director = director;
    }

    public Movie withDirector(String director) {
        this.director = director;
        return this;
    }

    @JsonProperty("vue_url")
    public String getVueUrl() {
        return vueUrl;
    }

    @JsonProperty("vue_url")
    public void setVueUrl(String vueUrl) {
        this.vueUrl = vueUrl;
    }

    public Movie withVueUrl(String vueUrl) {
        this.vueUrl = vueUrl;
        return this;
    }

    @JsonProperty("trailer_url_low")
    public String getTrailerUrlLow() {
        return trailerUrlLow;
    }

    @JsonProperty("trailer_url_low")
    public void setTrailerUrlLow(String trailerUrlLow) {
        this.trailerUrlLow = trailerUrlLow;
    }

    public Movie withTrailerUrlLow(String trailerUrlLow) {
        this.trailerUrlLow = trailerUrlLow;
        return this;
    }

    @JsonProperty("trailer_url_high")
    public String getTrailerUrlHigh() {
        return trailerUrlHigh;
    }

    @JsonProperty("trailer_url_high")
    public void setTrailerUrlHigh(String trailerUrlHigh) {
        this.trailerUrlHigh = trailerUrlHigh;
    }

    public Movie withTrailerUrlHigh(String trailerUrlHigh) {
        this.trailerUrlHigh = trailerUrlHigh;
        return this;
    }

    @JsonProperty("trailer_youtube_id")
    public String getTrailerYoutubeId() {
        return trailerYoutubeId;
    }

    @JsonProperty("trailer_youtube_id")
    public void setTrailerYoutubeId(String trailerYoutubeId) {
        this.trailerYoutubeId = trailerYoutubeId;
    }

    public Movie withTrailerYoutubeId(String trailerYoutubeId) {
        this.trailerYoutubeId = trailerYoutubeId;
        return this;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    public Movie withImage(String image) {
        this.image = image;
        return this;
    }

    @JsonProperty("release_date")
    public String getReleaseDate() {
        return releaseDate;
    }

    @JsonProperty("release_date")
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Movie withReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    @JsonProperty("special_category")
    public String getSpecialCategory() {
        return specialCategory;
    }

    @JsonProperty("special_category")
    public void setSpecialCategory(String specialCategory) {
        this.specialCategory = specialCategory;
    }

    public Movie withSpecialCategory(String specialCategory) {
        this.specialCategory = specialCategory;
        return this;
    }

    @JsonProperty("playingtime")
    public Integer getPlayingtime() {
        return playingtime;
    }

    @JsonProperty("playingtime")
    public void setPlayingtime(Integer playingtime) {
        this.playingtime = playingtime;
    }

    public Movie withPlayingtime(Integer playingtime) {
        this.playingtime = playingtime;
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

    public Movie withIsEdited(Integer isEdited) {
        this.isEdited = isEdited;
        return this;
    }

    @JsonProperty("edit_date")
    public String getEditDate() {
        return editDate;
    }

    @JsonProperty("edit_date")
    public void setEditDate(String editDate) {
        this.editDate = editDate;
    }

    public Movie withEditDate(String editDate) {
        this.editDate = editDate;
        return this;
    }

    @JsonProperty("vue_created")
    public Integer getVueCreated() {
        return vueCreated;
    }

    @JsonProperty("vue_created")
    public void setVueCreated(Integer vueCreated) {
        this.vueCreated = vueCreated;
    }

    public Movie withVueCreated(Integer vueCreated) {
        this.vueCreated = vueCreated;
        return this;
    }

    @JsonProperty("og_title")
    public String getOgTitle() {
        return ogTitle;
    }

    @JsonProperty("og_title")
    public void setOgTitle(String ogTitle) {
        this.ogTitle = ogTitle;
    }

    public Movie withOgTitle(String ogTitle) {
        this.ogTitle = ogTitle;
        return this;
    }

    @JsonProperty("og_description")
    public String getOgDescription() {
        return ogDescription;
    }

    @JsonProperty("og_description")
    public void setOgDescription(String ogDescription) {
        this.ogDescription = ogDescription;
    }

    public Movie withOgDescription(String ogDescription) {
        this.ogDescription = ogDescription;
        return this;
    }

    @JsonProperty("og_image")
    public String getOgImage() {
        return ogImage;
    }

    @JsonProperty("og_image")
    public void setOgImage(String ogImage) {
        this.ogImage = ogImage;
    }

    public Movie withOgImage(String ogImage) {
        this.ogImage = ogImage;
        return this;
    }

    @JsonProperty("image_relative")
    public String getImageRelative() {
        return imageRelative;
    }

    @JsonProperty("image_relative")
    public void setImageRelative(String imageRelative) {
        this.imageRelative = imageRelative;
    }

    public Movie withImageRelative(String imageRelative) {
        this.imageRelative = imageRelative;
        return this;
    }

    @JsonProperty("image_missing")
    public Object getImageMissing() {
        return imageMissing;
    }

    @JsonProperty("image_missing")
    public void setImageMissing(Object imageMissing) {
        this.imageMissing = imageMissing;
    }

    public Movie withImageMissing(Object imageMissing) {
        this.imageMissing = imageMissing;
        return this;
    }

    @JsonProperty("full_title")
    public Object getFullTitle() {
        return fullTitle;
    }

    @JsonProperty("full_title")
    public void setFullTitle(Object fullTitle) {
        this.fullTitle = fullTitle;
    }

    public Movie withFullTitle(Object fullTitle) {
        this.fullTitle = fullTitle;
        return this;
    }

    @JsonProperty("rating_average")
    public Object getRatingAverage() {
        return ratingAverage;
    }

    @JsonProperty("rating_average")
    public void setRatingAverage(Object ratingAverage) {
        this.ratingAverage = ratingAverage;
    }

    public Movie withRatingAverage(Object ratingAverage) {
        this.ratingAverage = ratingAverage;
        return this;
    }

    @JsonProperty("rating_count")
    public Object getRatingCount() {
        return ratingCount;
    }

    @JsonProperty("rating_count")
    public void setRatingCount(Object ratingCount) {
        this.ratingCount = ratingCount;
    }

    public Movie withRatingCount(Object ratingCount) {
        this.ratingCount = ratingCount;
        return this;
    }

    @JsonProperty("stills")
    public Object getStills() {
        return stills;
    }

    @JsonProperty("stills")
    public void setStills(Object stills) {
        this.stills = stills;
    }

    public Movie withStills(Object stills) {
        this.stills = stills;
        return this;
    }

    @JsonProperty("performances")
    public List<Performance> getPerformances() {
        return performances;
    }

    @JsonProperty("performances")
    public void setPerformances(List<Performance> performances) {
        this.performances = performances;
    }

    public Movie withPerformances(List<Performance> performances) {
        this.performances = performances;
        return this;
    }

    @JsonProperty("all_performances")
    public Object getAllPerformances() {
        return allPerformances;
    }

    @JsonProperty("all_performances")
    public void setAllPerformances(Object allPerformances) {
        this.allPerformances = allPerformances;
    }

    public Movie withAllPerformances(Object allPerformances) {
        this.allPerformances = allPerformances;
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

    public Movie withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("title", title).append("genres", genres).append("kijkwijzer", kijkwijzer).append("performances", performances).toString();
    }

}