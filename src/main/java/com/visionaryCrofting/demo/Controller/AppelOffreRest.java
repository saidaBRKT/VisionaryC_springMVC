package com.visionaryCrofting.demo.Controller;


import com.visionaryCrofting.demo.entity.AppelOffre;
import com.visionaryCrofting.demo.service.AppelOffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("${api.endpoint}/appel-offre")
public class AppelOffreRest {

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return appelOffreService.deleteByRef(ref);
    }

    @GetMapping("/ref/{ref}")
    public AppelOffre findByRefsLike(@PathVariable String ref) {
        return appelOffreService.findByRef(ref);
    }

    @GetMapping("/id/{id}")
    public AppelOffre getOne(@PathVariable("id") Long id) {
        return appelOffreService.getOne(id);
    }

    @PostMapping("/")
    public AppelOffre save(@RequestBody AppelOffre appelOffre) {
        return appelOffreService.save(appelOffre);
    }

    @GetMapping("/")
    public List<AppelOffre> findAll() {
        return appelOffreService.findAll();
    }

    @PutMapping("/")
    public AppelOffre update(@RequestBody AppelOffre appelOffre) {
        return appelOffreService.update(appelOffre);
    }

    @Autowired
    private AppelOffreService appelOffreService;
}
