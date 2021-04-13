package com.example.infra;

import com.example.domain.model.Host;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HostRepository {
  void register(Host host);
}
