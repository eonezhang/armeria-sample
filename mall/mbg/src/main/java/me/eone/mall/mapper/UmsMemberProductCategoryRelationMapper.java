package me.eone.mall.mapper;

import java.util.List;
import me.eone.mall.model.UmsMemberProductCategoryRelation;
import me.eone.mall.model.UmsMemberProductCategoryRelationExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UmsMemberProductCategoryRelationMapper {
    long countByExample(UmsMemberProductCategoryRelationExample example);

    int deleteByExample(UmsMemberProductCategoryRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberProductCategoryRelation record);

    int insertSelective(UmsMemberProductCategoryRelation record);

    List<UmsMemberProductCategoryRelation> selectByExample(UmsMemberProductCategoryRelationExample example);

    UmsMemberProductCategoryRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsMemberProductCategoryRelation record, @Param("example") UmsMemberProductCategoryRelationExample example);

    int updateByExample(@Param("record") UmsMemberProductCategoryRelation record, @Param("example") UmsMemberProductCategoryRelationExample example);

    int updateByPrimaryKeySelective(UmsMemberProductCategoryRelation record);

    int updateByPrimaryKey(UmsMemberProductCategoryRelation record);
}