package com.xiaoxiang.elasticdemo.controller;

import com.xiaoxiang.elasticdemo.entity.Book;
import com.xiaoxiang.elasticdemo.repository.BookRepository;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.index.engine.Engine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author lhw<br>
 * @version 1.0<br>
 * @Description <Description> <br>
 * @taskId: <br>
 * @createDate 2019/11/12 14:33 <br>
 * @see com.xiaoxiang.elasticdemo.controller <br>
 */
@RestController
@RequestMapping("es")
public class ElasticSearchController {

	@Resource
	private BookRepository bookRepository;
	Logger log = LoggerFactory.getLogger(ElasticSearchController.class);

	@GetMapping("test")
	public Book testEs(){
		log.info("log======");
		Book book = new Book();
		book.setBookName("西游记");
		return book;
	}

	@PostMapping("addbook")
	public String add(@RequestBody Book book){
		bookRepository.save(book);
		return "ok";
	}

	public Book getById(@PathVariable Integer id){
		Optional<Book> bookOp = bookRepository.findById(id);
		if(bookOp.isPresent()){
			Book book = bookOp.get();
			return  book;
		}
		return null;
	}

	@GetMapping("all")
	public List<Book> getAll(){
		Iterable<Book> bookRepositoryAll = bookRepository.findAll();//PageRequest.of(0,5)
		ArrayList<Book> bookArrayList = new ArrayList<>();
		bookRepositoryAll.forEach(bookArrayList::add);
		log.info("dataNum="+bookArrayList.size());
		return bookArrayList;
	}

	@PostMapping("update")
		public String updateById(@RequestBody Book book){
		bookRepository.save(book);
		return "ok";
		}

		@PostMapping("delete/{id}")
	public String deleteById(@PathVariable Integer id){
		bookRepository.deleteById(id);
		return "ok";
		}

	@PostMapping("likeName")
	public List<Book> findLikeName(String name){
		List<Book> bookList = bookRepository.findByBookNameLike(name);
		log.info("resultNum="+bookList.size());
		return  bookList;
	}

	@PostMapping("findByName")
	public Page<Book>findByName(String name){
		Page<Book> bookPage = bookRepository.findByBookName(name, PageRequest.of(0, 3));

		return bookPage;
	}
}
