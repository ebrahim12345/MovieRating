package ir.dto;


import infra.dto.BaseDto;
import ir.model.ActressActors;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
public class ActressActorsDto extends BaseDto<Long, ActressActorsDto, ActressActors> {

    private String firstName;
    private String lastName;
    private String nationality;
    private Integer age;
    private Integer numberOfChildren;
    private String spouse;
    private LocalDateTime birthDate;


    @Override
    public ActressActors convert(Class<ActressActors> clazz) {
        return super.convert(clazz)
                .setFirstName(getFirstName())
                .setLastName(getLastName())
                .setNationality(getNationality())
                .setAge(getAge())
                .setNumberOfChildren(getNumberOfChildren())
                .setSpouse(getSpouse());
    }
}
