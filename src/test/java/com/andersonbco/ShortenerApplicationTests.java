package com.andersonbco;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.andersonbco.shortener.ShortenerApplication;
import com.andersonbco.shortener.domain.Shortener;
import com.andersonbco.shortener.domain.Statistics;
import com.andersonbco.shortener.resources.ShortenerResources;
import com.andersonbco.shortener.services.ShortenerService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShortenerApplication.class)
@WebAppConfiguration
public class ShortenerApplicationTests {

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	
	private MockMvc mockMvc;
	
	@Mock
	private ShortenerService shortenerService;
	
	@InjectMocks
	private ShortenerResources shortenerResources;
	
	@Before
	public void init() {
		
		MockitoAnnotations.initMocks(this);
		
		mockMvc = MockMvcBuilders.standaloneSetup(shortenerResources).build();							
	}
	
	@Test
	public void getTopTenSuccess() throws Exception {
		
		List<Shortener> shorteners = Arrays.asList( new Shortener("http://www.bemobi.com", "BEMOBI", new Statistics()),
													new Shortener("https://www.google.com.br", "GOOGLE", new Statistics()));
		
		Mockito.when(shortenerService.listTopTen()).thenReturn(shorteners);
		
		mockMvc.perform(MockMvcRequestBuilders.get(""))
				.andExpect(MockMvcResultMatchers.status().isFound())
				.andExpect(MockMvcResultMatchers.content().contentType(contentType))
				.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));
		
		Mockito.verify(shortenerService, Mockito.times(1)).listTopTen();
		Mockito.verifyNoMoreInteractions(shortenerService);
		
		Assert.assertNotNull(mockMvc);
	}
}
