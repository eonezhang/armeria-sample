package me.eone.mall.mapper;

import java.util.List;
import me.eone.mall.model.PmsMemberPrice;
import me.eone.mall.model.PmsMemberPriceExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PmsMemberPriceMapper {
    long countByExample(PmsMemberPriceExample example);

    int deleteByExample(PmsMemberPriceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsMemberPrice record);

    int insertSelective(PmsMemberPrice record);

    List<PmsMemberPrice> selectByExample(PmsMemberPriceExample example);

    PmsMemberPrice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsMemberPrice record, @Param("example") PmsMemberPriceExample example);

    int updateByExample(@Param("record") PmsMemberPrice record, @Param("example") PmsMemberPriceExample example);

    int updateByPrimaryKeySelective(PmsMemberPrice record);

    int updateByPrimaryKey(PmsMemberPrice record);
}