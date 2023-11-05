package ir.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import infra.model.BaseEntity;
import ir.dto.ActressActorsDto;
import ir.dto.MovieDto;
import ir.enums.Genre;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "movies")
public class Movie extends BaseEntity<Long, MovieDto, Movie> {


    @Column(name = "movie_name", columnDefinition = "nvarchar(50) default''")
    private String movieName;

    @Column(name = "director_name", columnDefinition = "nvarchar(50) default''")
    private String directorName;

    @Column(name = "place_built", columnDefinition = "nvarchar(50) default''")
    private String placeBuilt;

    @Column(name = "designer", columnDefinition = "nvarchar(50) default''")
    private String designer;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private Genre genre;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "built_year")
    private LocalDateTime builtYear;


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ActressActors.class)
    @JoinColumn(name = "actress_actors_Id", foreignKey = @ForeignKey(name = "fk_actress_actors_Id"))
    private ActressActors actressActorsId;


    @Override
    public MovieDto convert(Class<MovieDto> clazz) {
        return super.convert(clazz)
                .setActressActorsId(getActressActorsId() != null ? getActressActorsId().convert(ActressActorsDto.class): null)
                .setMovieName(getMovieName())
                .setDirectorName(getDirectorName())
                .setDesigner(getDesigner())
                .setPlaceBuilt(getPlaceBuilt())
                .setBuiltYear(getBuiltYear())
                .setGenre(getGenre());
    }

}
