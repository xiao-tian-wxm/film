package gec.service;

import gec.entity.Filminfo;

import java.util.List;

public interface FilmInfoService {
    List<Filminfo> findAllInfo(Filminfo filminfo);

    void save(Filminfo filminfo);
}
