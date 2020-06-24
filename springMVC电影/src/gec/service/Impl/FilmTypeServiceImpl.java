package gec.service.Impl;

import gec.dao.FilmTypeDao;
import gec.dao.FilminfoDao;
import gec.entity.Filmtype;
import gec.service.FilmTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class FilmTypeServiceImpl implements FilmTypeService {
    @Autowired
    private FilmTypeDao filmTypeDao;

    @Autowired
    private FilminfoDao filminfoDao;

    @Override
    public List<Filmtype> findAllTypes() {
        List<Filmtype> types=filmTypeDao.getListByHQL("from Filmtype");
        return types;
    }

    @Transactional("required")
    public void delete(Integer filminfoId){
        //先删除跟子类有关系的所有数据
        //filminfoDao.deleteFilm(filminfoId);

        //再删除主表的数据
        //filmTypeDao.delete(filminfoId);
    }
}
