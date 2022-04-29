package com.idat.TareaItemLocal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.TareaItemLocal.modelo.Item;
import com.idat.TareaItemLocal.service.ItemServicio;

@RestController
@RequestMapping("item/v1")
public class ItemController {
	
	@Autowired
	private ItemServicio servicio;

	@RequestMapping(path="/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Item>>  listarItem(){
		
		return  new ResponseEntity <List<Item>>(servicio.listarItem(),HttpStatus.OK);
	}
	
	@RequestMapping(path="/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Item item){
		servicio.guardarItem(item);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path="/listar/{id}",method = RequestMethod.GET)
	public ResponseEntity<Item> listarPorId(@PathVariable Integer id){
		Item it= servicio.obtenerItemporId(id);
		
		if (it!=null) {
			return new ResponseEntity<Item>(it,HttpStatus.OK);
		}else {
			return new ResponseEntity<Item>(it,HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path="/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Item item){
		
		Item it= servicio.obtenerItemporId(item.getIdItem());
		if (it!=null) {
			servicio.editarItem(item);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	
	}
	
	@RequestMapping(path="/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Item it= servicio.obtenerItemporId(id);
		if (it!=null) {
			servicio.eliminarItem(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	
	}
	
}
