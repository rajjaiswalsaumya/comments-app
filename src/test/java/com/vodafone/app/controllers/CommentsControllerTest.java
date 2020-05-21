package com.vodafone.app.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.vodafone.app.entities.Comment;
import com.vodafone.app.services.CommentsService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CommentsController.class)
public class CommentsControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CommentsService commentsService;

  @BeforeEach
  void setUp() {

  }

  @Test
  public void testGetCommentsShouldReturnCommentsList() throws Exception {
    // given
    List<Comment> comments = new ArrayList<Comment>() {{
      add(new Comment("Sample", new Date(), null));
      add(new Comment("Sample 2", new Date(), null));
    }};

    when(commentsService.getComments()).thenReturn(comments);
    this.mockMvc.perform(get("/comments")).andDo(print()).andExpect(status().isOk())
        .andExpect(content().string(containsString("Sample")));
  }


  @AfterEach
  void tearDown() {
  }
}