package me.eone.mall.mapper;

import java.util.List;
import me.eone.mall.model.PmsProductFullReduction;
import me.eone.mall.model.PmsProductFullReductionExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PmsProductFullReductionMapper {
    long countByExample(PmsProductFullReductionExample example);

    int deleteByExample(PmsProductFullReductionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsProductFullReduction record);

    int insertSelective(PmsProductFullReduction record);

    List<PmsProductFullReduction> selectByExample(PmsProductFullReductionExample example);

    PmsProductFullReduction selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsProductFullReduction record, @Param("example") PmsProductFullReductionExample example);

    int updateByExample(@Param("record") PmsProductFullReduction record, @Param("example") PmsProductFullReductionExample example);

    int updateByPrimaryKeySelective(PmsProductFullReduction record);

    int updateByPrimaryKey(PmsProductFullReduction record);
}