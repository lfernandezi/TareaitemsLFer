package com.idat.TareaItemLocal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.TareaItemLocal.modelo.Item;
import com.idat.TareaItemLocal.repository.ItemRepositorio;

@Service
public class ItemServiceImp implements ItemServicio{
 
	@Autowired
	private ItemRepositorio repositorio;

	@Override
	public List<Item> listarItem() {
		// TODO Auto-generated method stub
		
		return repositorio.listarItem();
		
	}

	@Override
	public void guardarItem(Item item) {
		// TODO Auto-generated method stub
		repositorio.guardarItem(item);
	}

	@Override
	public void editarItem(Item item) {
		// TODO Auto-generated method stub
		repositorio.editarItem(item);
	}

	@Override
	public void eliminarItem(Integer id) {
		// TODO Auto-generated method stub
		repositorio.eliminarItem(id);
	}

	@Override
	public Item obtenerItemporId(Integer id) {
		// TODO Auto-generated method stub
		
		return repositorio.obtenerItemporId(id);
	}
	
	
}
