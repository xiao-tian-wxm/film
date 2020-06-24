package gec.service.Impl;

import gec.dao.FilminfoDao;
import gec.entity.Filminfo;
import gec.service.FilmInfoService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class FilmInfoServiceImpl implements FilmInfoService {
    @Autowired
    private FilminfoDao filminfoDao;
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Filminfo> findAllInfo(Filminfo filminfo) {
        return filminfoDao.findAllInfo(filminfo);
    }
    @Transactional("required")
    @Override
    public void save(Filminfo filminfo) {
        filminfoDao.save(filminfo);
    }
}
