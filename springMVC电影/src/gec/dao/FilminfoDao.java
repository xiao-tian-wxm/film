package gec.dao;

import gec.entity.Filminfo;

import java.util.List;

public interface FilminfoDao extends BaseDao<Filminfo> {
    List<Filminfo> findAllInfo(Filminfo filminfo);
}
