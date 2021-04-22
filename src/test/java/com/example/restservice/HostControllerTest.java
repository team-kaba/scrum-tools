package com.example.restservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.controller.HostController;
import com.example.domain.service.HostService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class HostControllerTest {

  @Mock HostService hostService;
  private MockMvc mockMvc;
  @InjectMocks private HostController hostController;

  @Before
  public void setMockMvc() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(hostController).build();
  }

  @Test
  public void testCreate() throws Exception {
    mockMvc.perform(post("/create")).andExpect(status().isOk());
  }
}
