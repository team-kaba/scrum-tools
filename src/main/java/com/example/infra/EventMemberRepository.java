package com.example.infra;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EventMemberRepository {
  void register(String accountId);
}
