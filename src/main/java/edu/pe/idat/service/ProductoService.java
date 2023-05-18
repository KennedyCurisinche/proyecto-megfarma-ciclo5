package edu.pe.idat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.Producto;
import edu.pe.idat.model.sp.ProductoSp;
import edu.pe.idat.repository.ProductoRepository;
import edu.pe.idat.repository.ProductoSpRepository;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private ProductoSpRepository productoSpRepository;

	public List<ProductoSp> listarProductos() {
		return productoSpRepository.listarProducto();
	}

	public void registrarProducto(Producto producto) {
		if (producto.getId_producto() == 0) {
			productoRepository.registrarProducto(
					producto.getImagenproducto(),
					producto.getNombreproducto(),
					producto.getPrescripcion(),
					producto.getPresentacion(),
					producto.getPrecio(),
					producto.getPreciounitario(),
					producto.getStock(),
					producto.getIsactive(),
					producto.getIdcategoria(),
					producto.getIdmarca());
		} else {
			productoRepository.actualizarProducto(
					producto.getId_producto(),
					producto.getImagenproducto(),
					producto.getNombreproducto(),
					producto.getPrescripcion(),
					producto.getPresentacion(),
					producto.getPrecio(),
					producto.getPreciounitario(),
					producto.getStock(),
					producto.getIsactive(),
					producto.getIdcategoria(),
					producto.getIdmarca());
		}
	}

	public void eliminarProducto(Producto producto) {
		productoRepository.deleteById(producto.getId_producto());
	}
	
	public Optional<Producto> get(Integer id) {
		return productoRepository.findById(id);
	}
}
