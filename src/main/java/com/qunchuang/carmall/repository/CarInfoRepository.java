package com.qunchuang.carmall.repository;

import com.qunchuang.carmall.domain.CarInfo;
import org.hibernate.boot.model.source.spi.JpaCallbackSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Curtain
 * @date 2019/1/15 14:10
 */
@Repository
public interface CarInfoRepository extends JpaRepository<CarInfo,String>{
}
