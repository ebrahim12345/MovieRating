package ir.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import infra.model.BaseEntity;
import ir.dto.ActressActorsDto;
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
@Table(name = "actress_actors")
public class ActressActors extends BaseEntity<Long, ActressActorsDto, ActressActors> {


    @Column(name = "first_name", columnDefinition = "nvarchar(50) default''")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "nvarchar(50) default''")
    private String lastName;

    @Column(name = "nationality", columnDefinition = "nvarchar(50) default''")
    private String nationality;

    @Column(name = "age")
    private Integer age;

    @Column(name = "number_of_children")
    private Integer numberOfChildren;

    @Column(name = "spouse", columnDefinition = "nvarchar(50) default''")
    private String spouse;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "birth_date")
    private LocalDateTime birthDate;


    @Override
    public ActressActorsDto convert(Class<ActressActorsDto> clazz) {
        return super.convert(clazz)
                .setFirstName(getFirstName())
                .setLastName(getLastName())
                .setNationality(getNationality())
                .setAge(getAge())
                .setNumberOfChildren(getNumberOfChildren())
                .setSpouse(getSpouse());
    }
}
