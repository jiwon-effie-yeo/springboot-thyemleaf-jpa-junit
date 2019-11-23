package boot.jpa.junit.dto;

import boot.jpa.junit.domain.hero.Hero;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
public class HeroSaveRequestDto {

    private  String name;
    private int age;
    private  String memo;

    public Hero toEntity() {
        return  Hero.builder()
                    .name(name)
                    .age(age)
                    .memo(memo)
                    .build();

    }

    @Builder
    public HeroSaveRequestDto(String name, int age, String memo) {
        this.name = name;
        this.age = age;
        this.memo = memo;
    }
}

