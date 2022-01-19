package gestionCinema.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface CrudREST<O> {

	@GetMapping
	public List<O> getAll();

	@GetMapping("/{id}")
	public O getById(@PathVariable("id") Integer id);

	@PostMapping
	public O insert(@RequestBody O objectToInsert);

	@PutMapping("/{id}")
	public O update(@PathVariable("id") Integer id, @RequestBody O objectToUpdate);

	@DeleteMapping("/{id}")
	public O deleteById(@PathVariable("id") Integer id);

}
