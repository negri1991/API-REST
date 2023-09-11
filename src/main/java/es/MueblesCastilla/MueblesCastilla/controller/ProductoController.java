package es.MueblesCastilla.MueblesCastilla.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.MueblesCastilla.MueblesCastilla.domain.dto.ProductoPojo;
import es.MueblesCastilla.MueblesCastilla.domain.service.IProductoService;
import lombok.RequiredArgsConstructor;

/**
 * Controlador rest de producto(Rest es para que devuelva JSON o XML, a
 * diferencia de controller que devuelve HTML).
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/producto")
public class ProductoController {

	private final IProductoService iProductoService;

	/**
	 * Devuelve lista de productos
	 * 
	 * @return HttpCode Ok con lista de productos
	 */
	@GetMapping()
	public ResponseEntity<List<ProductoPojo>> getAll() {

		return ResponseEntity.status(HttpStatus.OK).body(iProductoService.getAll());
	}

	/**
	 * Devuelve un producto dado su id
	 * 
	 * @param id de producto a buscar
	 * @return Htttpcode ok si la encuentra, Httpcode not found.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<ProductoPojo> getProductoById(@PathVariable Integer id) {

		return ResponseEntity.of(iProductoService.getProductoById(id));
	}

	

	/**
	 * Crea un nuevo producto
	 * 
	 * @param productoNew producto nuevo
	 * @return Http created si la guarda correctamente, de lo contrrario Http bad
	 *         request
	 */
	@PostMapping()
	public ResponseEntity<ProductoPojo> save(@RequestBody ProductoPojo productoNew) {

		try {

			return ResponseEntity.status(HttpStatus.CREATED).body(iProductoService.save(productoNew));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	/**
	 * Edita un producto
	 * 
	 * @param productoEditado producto a editar
	 * @return HttpCode ok si la actualiza correctamente
	 */
	@PatchMapping()
	public ResponseEntity<ProductoPojo> update(@RequestBody ProductoPojo productoEditado) {

		return ResponseEntity.of(iProductoService.update(productoEditado));
	}

	/**
	 * Elimina un producto
	 * 
	 * @param id producto a eliminar
	 * @return HttpCode ok si la elimina, HttpCode not found
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<ProductoPojo> delete(@PathVariable Integer id) {

		return new ResponseEntity<>(this.iProductoService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);// Si es
																											// cierto me
																											// devuelves
																											// un ok, si
																											// no es
																											// cierto un
																											// not
																											// found.
	}

}