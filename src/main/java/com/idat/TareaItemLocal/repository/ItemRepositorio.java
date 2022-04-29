package com.idat.TareaItemLocal.repository;

import java.util.List;

import com.idat.TareaItemLocal.modelo.Item;

public interface ItemRepositorio {
	
	public List<Item> listarItem();
	
	public void guardarItem (Item item);
	
	public void editarItem (Item item);
	
	public void eliminarItem (Integer id);
	
	public Item obtenerItemporId (Integer id);
	

}
