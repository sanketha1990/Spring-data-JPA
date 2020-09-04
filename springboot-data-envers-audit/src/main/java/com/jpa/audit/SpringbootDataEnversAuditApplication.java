package com.jpa.audit;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.history.Revision;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.audit.model.Book;
import com.jpa.audit.repository.BookRepository;
import com.sun.el.stream.Optional;

@SpringBootApplication
@RestController
@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
public class SpringbootDataEnversAuditApplication {

	@Autowired
	private BookRepository repository;

	@PostMapping("/save")
	public Book saveBook(@RequestBody Book book) {
		return repository.save(book);
	}

	@PutMapping("/update/{id}/{pages}")
	public String updateBook(@PathVariable int id, @PathVariable int pages) {

		Book book = repository.findById(id).get();
		book.setPages(pages);
		repository.save(book);
		return "Book updated";
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		repository.deleteById(id);
		return "Book deleted";
	}
	
	@GetMapping("/getInfo/{id}")
	public java.util.Optional<Revision<Integer, Book>> getRevInfor(@PathVariable int id) {
		return repository.findLastChangeRevision(id);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDataEnversAuditApplication.class, args);
	}

}
