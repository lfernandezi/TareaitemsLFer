package com.idat.TareaItemLocal.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.idat.TareaItemLocal.modelo.Item;

@Repository
public class ItemRepositoryImp implements ItemRepositorio{
	
	public List<Item> listaItems= new ArrayList<Item>();

	@Override
	public List<Item> listarItem() {
		// TODO Auto-generated method stub
		return listaItems;
	}

	@Override
	public void guardarItem(Item item) {
		// TODO Auto-generated method stub
		listaItems.add(item);
	}

	@Override
	public void editarItem(Item item) {
		// TODO Auto-generated method stub
		listaItems.remove(obtenerItemporId(item.getIdItem()));
		listaItems.add(item);
		
		
	}

	@Override
	public void eliminarItem(Integer id) {
		// TODO Auto-generated method stub
		listaItems.remove(obtenerItemporId(id));
	}


	@Override
	public Item obtenerItemporId(Integer id) {
		// TODO Auto-generated method stub
		return listaItems.stream().filter(it -> it.getIdItem() == id).findFirst().orElse(null);
	}


	
	
	

}
