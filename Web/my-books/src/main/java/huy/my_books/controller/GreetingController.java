package huy.my_books.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import huy.my_books.dao.CatelogyDAO;
import huy.my_books.dao.iplm.JdbcCatelogyDAO;
import huy.my_books.mode.CatelogyBooks;
import huy.my_books.mode.CatelogyList;
import huy.my_books.mode.Greeting;

@RestController
@RequestMapping(value = "/")
public class GreetingController {

	private static final String template = "aaa, %s!";
	private final AtomicLong counter = new AtomicLong();
	ObjectMapper mapper = new ObjectMapper();

	@RequestMapping(value = "greeting1", method = RequestMethod.GET)
	public Greeting greeting1(@RequestParam(value = "name", defaultValue = "Huy1") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping(value = "greeting2", method = RequestMethod.GET)
	public String testMyListMapperListWriter() throws JsonProcessingException {

		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

		CatelogyDAO catelogyDAO = (CatelogyDAO) context.getBean("catelogyDAO");

		List<CatelogyBooks> list = catelogyDAO.selectLitsCatelogy();

		CatelogyList<CatelogyBooks> pageList = new CatelogyList<CatelogyBooks>(list, list.size());

		try {
			System.out.println(mapper.writeValueAsString(pageList));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapper.writeValueAsString(pageList);
	}

	@RequestMapping(value = "greeting3", method = RequestMethod.POST)
	public String greeting3(@RequestParam Map<String, String> requestParams) throws Exception {

		String id = requestParams.get("id");
		String content = requestParams.get("content");
		Greeting pageList = new Greeting(Integer.parseInt(id)+100, content);
		return mapper.writeValueAsString(pageList);
	}

}