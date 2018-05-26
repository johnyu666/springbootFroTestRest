package hello;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import pojo.Book;

@Controller
@EnableAutoConfiguration
@ComponentScan(basePackageClasses= {CorsFilter.class})
public class SampleController {
	private Map<Integer, Book> data;
	private int maxId=0;
	public SampleController() {
		data=new ConcurrentHashMap<Integer, Book>();
		for(maxId=0;maxId<10;maxId++) {
			Book book=new Book(maxId,"book"+maxId,30*maxId);
			data.put(maxId, book);
		}
	}
	
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
    
    @RequestMapping(value="/books",method=RequestMethod.GET)
    @ResponseBody
    Collection<Book> findAllBooks() {
        return data.values();
    }
    @RequestMapping(value="/books/{id}",method=RequestMethod.DELETE)
    @ResponseBody
    Book deleteBook(@PathVariable int id){
    		data.remove(id);
    		return null;
    }
    @RequestMapping(value="/books",method=RequestMethod.POST)
    @ResponseBody
    Book addBook(@RequestBody Book book) {
    		Book b=new Book(maxId++, book.getBname(), book.getPrice());
    		data.put(maxId, b);
    		return b;
    }
    
    @RequestMapping(value="/books/{id}",method=RequestMethod.PUT)
    @ResponseBody
    Book updateBook(@PathVariable int id,@RequestBody Book book) {
    		book.setId(id);
    		data.put(id, book);
    		return book;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}