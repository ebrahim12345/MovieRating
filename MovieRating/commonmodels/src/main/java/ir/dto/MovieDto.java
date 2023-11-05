package ir.dto;

import infra.dto.BaseDto;
import ir.enums.Genre;
import ir.model.ActressActors;
import ir.model.Movie;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
public class MovieDto extends BaseDto<Long, MovieDto, Movie> {

private String movieName;
private String directorName;
private String placeBuilt;
private String designer;
private Genre genre;
private LocalDateTime builtYear;
private ActressActorsDto actressActorsId;


        @Override
        public Movie convert(Class<Movie> clazz) {
                return super.convert(clazz)
                        .setActressActorsId(getActressActorsId() != null ? getActressActorsId().convert(ActressActors.class): null)
                        .setMovieName(getMovieName())
                        .setDirectorName(getDirectorName())
                        .setDesigner(getDesigner())
                        .setPlaceBuilt(getPlaceBuilt())
                        .setBuiltYear(getBuiltYear())
                        .setGenre(getGenre());
        }
}
