package com.rosyoki.spring.boot.sample.app.mapper;

import com.rosyoki.spring.boot.sample.app.entity.PostZipData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface PostZipDataMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(PostZipData record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(PostZipData record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    PostZipData selectByPrimaryKey(Long id);

    PostZipData selectByNewCode(String newCode);

    List<PostZipData> selectByCity(String city);

    PostZipData selectByCityTown(@Param("city") String city, @Param("town") String town);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(PostZipData record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeyWithBLOBs(PostZipData record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(PostZipData record);
}