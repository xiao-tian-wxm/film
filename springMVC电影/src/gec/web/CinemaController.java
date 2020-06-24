package gec.web;

import gec.entity.Filmtype;
import gec.service.FilmTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CinemaController {
    @Autowired
    private FilmTypeService filmTypeService;

    List<Filmtype> allFilmType;

    @RequestMapping("/toCinema")
    public ModelAndView toCinema(){
        allFilmType=filmTypeService.findAllTypes();

        ModelAndView mv=new ModelAndView();
        mv.setViewName("cinema");

        mv.addObject("allFilmType",allFilmType);
        return mv;
    }
}
