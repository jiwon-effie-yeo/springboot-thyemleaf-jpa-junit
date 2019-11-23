package boot.jpa.junit.domain.hero;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeroRepositoryTest {

    @Autowired
    HeroRepository heroRepository;

    @After
    public void cleanup() {
        heroRepository.deleteAll();
    }

    @Test
    public void JpaAuditingTest(){
        //given
        LocalDateTime now = LocalDateTime.parse("2019-11-23T00:00:00");

        Hero input = Hero.builder()
                .name("github.com/jiwon-effie-yeo")
                .age(25)
                .memo("github.com/jiwon-effie-yeo")
                .build();

        //when
        Hero output = heroRepository.save(input);
        //then
        assertTrue(output.getCratedDate().isAfter(now));
        assertTrue(output.getModifiedDate().isAfter(now));
    }

    @Test
    public void HeroSaveRequestTest(){
        Hero input = Hero.builder()
                .name("github.com/jiwon-effie-yeo")
                .age(25)
                .memo("github.com/jiwon-effie-yeo")
                .build();

        Hero output = heroRepository.save(input);

        assertThat(input, is(output));

    }

}
