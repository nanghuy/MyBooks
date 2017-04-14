package huy.my_books.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import huy.my_books.dao.CatelogyDAO;
import huy.my_books.mode.CatelogyBooks;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
        
        CatelogyDAO catelogyDAO = (CatelogyDAO)context.getBean("catelogyDAO");
//        CatelogyBooks catelogyBooks = catelogyDAO.findCatelogyName(2);
        
//        CatelogyBooks customer = new CatelogyBooks(5,"Trinh Thám");
//        catelogyDAO.insert(customer);
        
        List<CatelogyBooks> list = catelogyDAO.selectLitsCatelogy();
        
        for (CatelogyBooks item : list) {
			System.out.println(item.getNameCatelogy());
		}
        
//        System.out.println("Demo: "+catelogyBooks.getNameCatelogy());    	
    
//        SpringApplication.run(Application.class, args);
        
        SpringApplication.run(App.class, args);

    }
}
