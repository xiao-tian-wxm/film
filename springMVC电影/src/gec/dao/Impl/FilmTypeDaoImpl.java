package gec.dao.Impl;

import gec.dao.FilmTypeDao;
import gec.entity.Filmtype;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("filmTypeDao")
public class FilmTypeDaoImpl extends BaseDaoImpl<Filmtype> implements FilmTypeDao {
}
