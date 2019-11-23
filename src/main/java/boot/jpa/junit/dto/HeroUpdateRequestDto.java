package boot.jpa.junit.dto;

import boot.jpa.junit.domain.hero.Hero;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HeroUpdateRequestDto {

    private Long id;
    private String name;
    private int age;
    private String  memo;

    public Hero toEntity(){
        return Hero.builder()
                .id(id)
                .name(name)
                .age(age)
                .memo(memo)
                .build();
    }

    @Builder
    public HeroUpdateRequestDto(Long id, String name, int age, String memo) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.memo = memo;
    }
}
