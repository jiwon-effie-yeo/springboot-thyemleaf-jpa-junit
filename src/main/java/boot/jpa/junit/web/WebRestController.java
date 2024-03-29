package boot.jpa.junit.web;

import boot.jpa.junit.dto.HeroFindByIdResponseDto;
import boot.jpa.junit.dto.HeroSaveRequestDto;
import boot.jpa.junit.dto.HeroUpdateRequestDto;
import boot.jpa.junit.service.HeroService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class WebRestController {

    private HeroService heroService;

    @PostMapping("/save")
    public Long HeroSaveRequest(@RequestBody HeroSaveRequestDto dto){
        System.out.println("Hello World" + dto.getMemo());
        return heroService.HeroSaveRequest(dto);
    }

    @PostMapping("/find")
    public HeroFindByIdResponseDto HeroFindByResponse(@RequestBody Long id){
        return heroService.HeroFindByIdResponse(id);
    }

    @PutMapping("/update")
    public Long HeroUpdateRequest(@RequestBody HeroUpdateRequestDto dto){
        return heroService.HeroUpdateRequest(dto);
    }

    @DeleteMapping("/delete")
    public Long HeroDeleteByIdRequest(@RequestBody Long id){
        heroService.HeroDeleteByIdRequest(id);
        return id;
    }

}
