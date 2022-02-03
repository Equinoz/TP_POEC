package gestionCinema.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins = "http://localhost:4200")
public interface CrudREST<O> {

	@GetMapping
	public List<O> getAll();

	@GetMapping("/{id}")
	public O getById(@PathVariable("id") Integer id);

	@PostMapping
	public O insert(@Valid @RequestBody O objectToInsert) throws Exception;

	@PutMapping("/{id}")
	public O update(@PathVariable("id") Integer id, @Valid @RequestBody O objectToUpdate) throws Exception;

	@DeleteMapping("/{id}")
	public O deleteById(@PathVariable("id") Integer id);

}
