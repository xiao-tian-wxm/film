package gec.web;

import gec.entity.Filminfo;
import gec.entity.Filmtype;
import gec.service.FilmInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.transform.Result;
import java.util.List;

@Controller
public class FilmInfoController {
    @Autowired
    private FilmInfoService filmInfoService;
    private String filmname;
    private Integer typeid;
    private String actor;
    private String director;
    private Double smallprice;
    private Double bigprice;

    //票价
    private Double ticketprice;

    List<Filminfo> result;

    public List<Filminfo> getResult() {
        return result;
    }

    public void setResult(List<Filminfo> result) {
        this.result = result;
    }

    public String getFilmname() {
        return filmname;
    }

    public void setFilmname(String filmname) {
        this.filmname = filmname;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Double getSmallprice() {
        return smallprice;
    }

    public void setSmallprice(Double smallprice) {
        this.smallprice = smallprice;
    }

    public Double getBigprice() {
        return bigprice;
    }

    public void setBigprice(Double bigprice) {
        this.bigprice = bigprice;
    }

    public Double getTicketprice() {
        return ticketprice;
    }

    public void setTicketprice(Double ticketprice) {
        this.ticketprice = ticketprice;
    }

    @RequestMapping("/findFilms")
    public ModelAndView findFilms() throws Exception{
        Filmtype filmtype=new Filmtype();
        if (typeid!=0){
            filmtype.setTypeid(typeid);
        }

        Filminfo filminfo=new Filminfo(filmtype,filmname,actor,director,bigprice,smallprice);

        result=filmInfoService.findAllInfo(filminfo);
        ModelAndView mv=new ModelAndView();
        mv.addObject("result",result);
        mv.setViewName("page/result");
        return mv;
    }

    @RequestMapping("/FilmAddServlet")
    public String FilmAddServlet() throws Exception{
        Filmtype filmtype=new Filmtype();
        filmtype.setTypeid(typeid);

        Filminfo filminfo=new Filminfo(filmtype,filmname,actor,director,bigprice,smallprice);
        filminfo.setTicketprice(ticketprice);

        filmInfoService.save(filminfo);

        return "add";
    }
}
