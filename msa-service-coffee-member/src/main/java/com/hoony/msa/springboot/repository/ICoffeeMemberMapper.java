package com.hoony.msa.springboot.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ICoffeeMemberMapper {
    boolean existsByMemberName(@Param("memberName") String memberName);

    void createMemberTable();

    void insertMemberData();
}
