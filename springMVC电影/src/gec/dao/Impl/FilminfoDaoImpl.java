package gec.dao.Impl;

import gec.dao.FilminfoDao;
import gec.entity.Filminfo;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilminfoDaoImpl extends BaseDaoImpl<Filminfo> implements FilminfoDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Filminfo> findAllInfo(Filminfo filminfo) {
//查询条件
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Filminfo.class);
        //各种判断
        if(StringUtils.isNotEmpty(filminfo.getFilmname())){
            criteria.add(Restrictions.like("filmname","%"+filminfo.getFilmname()+"%"));
        }

        if(StringUtils.isNotEmpty(filminfo.getActor())){
            criteria.add(Restrictions.like("actor","%"+filminfo.getActor()+"%"));
        }

        if(StringUtils.isNotEmpty(filminfo.getDirector())){
            criteria.add(Restrictions.like("director","%"+filminfo.getDirector()+"%"));
        }

        if(filminfo.getFilmType().getTypeid() != null){
            criteria.add(Restrictions.eq("filmType.typeid",filminfo.getFilmType().getTypeid()));
        }

        if(filminfo.getSmallprice() != null){
            criteria.add(Restrictions.ge("ticketprice",filminfo.getSmallprice()));
        }

        if(filminfo.getBigprice() != null){
            criteria.add(Restrictions.le("ticketprice",filminfo.getBigprice()));
        }


        return criteria.list();
    }
}
