package com.vegetable.practice.controller;


import com.vegetable.practice.DTO.CatDTO;
import com.vegetable.practice.entity.Cat;
import com.vegetable.practice.repository.CatRepository;
import com.vegetable.practice.service.MailSenderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "main_methods")
@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {

    private final CatRepository catRepository;
    private final MailSenderService mailSender;

    @Operation(
            summary = "Post new cat in DB",
            description = "Post DTO cat and build that and save entity in base"
    )
    @PostMapping("/api/add")
    public Cat addCat(@RequestBody CatDTO catDTO) {
        return catRepository.save(
                Cat.builder()
                        .age(catDTO.getAge())
                        .weight(catDTO.getWeight())
                        .name(catDTO.getName())
                        .build()
        );
    }

    @SneakyThrows
    @GetMapping("/api/all")
    public List<Cat> getAll() {
        return catRepository.findAll();
    }

    @GetMapping("/api")
    public Cat getCat(@RequestParam int id) {
        return catRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/api")
    public void deleteCat(@RequestParam int id) {
        catRepository.deleteById(id);
    }

    @PutMapping("/api/add")
    public String changeCat(@RequestBody Cat cat) {
        if(!catRepository.existsById(cat.getId())) {
            return "No such row";
        }
        return catRepository.save(cat).toString();
    }

    @GetMapping("/hello")
    public void sayHelloFromCat(@RequestParam int id){
        var cat = catRepository.findById(id).orElseThrow();

        mailSender.send(
                "dany.titoff2016@yandex.ru",
                "Hello From Kitten",
                "Hello, my name is " + cat.getName() + ". Have a nice day!!!"
        );
    }

}
