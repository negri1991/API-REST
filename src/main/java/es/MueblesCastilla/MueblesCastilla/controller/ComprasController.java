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

import es.MueblesCastilla.MueblesCastilla.domain.dto.CompraPojo;
import es.MueblesCastilla.MueblesCastilla.domain.service.ICompraService;
import lombok.RequiredArgsConstructor;

/**
 * Controlador rest de compras(Rest es para que devuelva JSON o XML, a
 * diferencia de controller que devuelve HTML).
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/compras")
public class ComprasController {

	private final ICompraService iCompraService;

	/**
	 * Devuelve lista de compras
	 * 
	 * @return HttpCode Ok con lista de compras
	 */
	@GetMapping()
	public ResponseEntity<List<CompraPojo>> getAll() {

		return ResponseEntity.status(HttpStatus.OK).body(iCompraService.getAll());
	}

	/**
	 * Devuelve una compra dado su id
	 * 
	 * @param id de compra a buscar
	 * @return Htttpcode ok si la encuentra, Httpcode not found.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<CompraPojo> getCompraById(@PathVariable Integer id) {

		return ResponseEntity.of(iCompraService.getCompraById(id));
	}

	/**
	 * Crea un nuevo compra
	 * 
	 * @param compraNew compra nueva
	 * @return Http created si la guarda correctamente, de lo contrrario Http bad
	 *         request
	 */
	@PostMapping()
	public ResponseEntity<CompraPojo> save(@RequestBody CompraPojo compraNew) {

		try {

			return ResponseEntity.status(HttpStatus.CREATED).body(iCompraService.save(compraNew));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	/**
	 * Edita una compra
	 * 
	 * @param compraEditada compra a editar
	 * @return HttpCode ok si la actualiza correctamente
	 */
	@PatchMapping()
	public ResponseEntity<CompraPojo> update(@RequestBody CompraPojo compraEditada) {

		return ResponseEntity.of(iCompraService.update(compraEditada));
	}

	/**
	 * Elimina un usuario
	 * 
	 * @param id usuario a eliminar
	 * @return HttpCode ok si la elimina, HttpCode not found
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<CompraPojo> delete(@PathVariable Integer id) {

		return new ResponseEntity<>(this.iCompraService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);// Si es
																											// cierto me
																											// devuelves
																											// un ok, si
																											// no es
																											// cierto un
	} // not
		// found.
}