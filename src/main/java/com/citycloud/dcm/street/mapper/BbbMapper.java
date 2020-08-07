package com.citycloud.dcm.street.mapper;

import com.citycloud.dcm.street.param.bbb;

public interface bbbMapper {
    int deleteByPrimaryKey(Long id);

    int insert(bbb record);

    int insertSelective(bbb record);

    bbb selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(bbb record);

    int updateByPrimaryKey(bbb record);
}