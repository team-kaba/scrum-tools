package com.example.infra;

import com.example.domain.model.Guest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GuestRepository {

  Guest create(String accountId);
}
