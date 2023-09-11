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

import es.MueblesCastilla.MueblesCastilla.domain.dto.DetalleCompraPojo;
import es.MueblesCastilla.MueblesCastilla.domain.service.IDetalleCompraService;
import lombok.RequiredArgsConstructor;

/**
 * Controlador rest de DetalleCompraC(Rest es para que devuelva JSON o XML, a
 * diferencia de controller que devuelve HTML).
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/detallecompra")
public class DetalleCompraController {

	private final IDetalleCompraService iDetalleCompraService;

	/**
	 * Devuelve lista de DetalleCompra
	 * 
	 * @return HttpCode Ok con lista de DetalleCompra
	 */
	@GetMapping()
	public ResponseEntity<List<DetalleCompraPojo>> getAll() {

		return ResponseEntity.status(HttpStatus.OK).body(iDetalleCompraService.getAll());
	}

	/**
	 * Devuelve un DetalleCompra dado su id
	 * 
	 * @param id de DetalleCompra a buscar
	 * @return Htttpcode ok si la encuentra, Httpcode not found.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<DetalleCompraPojo> getDetalleCompraById(@PathVariable Integer id) {

		return ResponseEntity.of(iDetalleCompraService.getDetalleCompraById(id));
	}

	/**
	 * Crea un nuevo DetalleCompra
	 * 
	 * @param DetalleCompraNew DetalleCompra nuevo
	 * @return Http created si la guarda correctamente, de lo contrrario Http bad
	 *         request
	 */
	@PostMapping()
	public ResponseEntity<DetalleCompraPojo> save(@RequestBody DetalleCompraPojo detalleCompraNew) {

		try {

			return ResponseEntity.status(HttpStatus.CREATED).body(iDetalleCompraService.save(detalleCompraNew));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	/**
	 * Edita un DetalleCompra
	 * 
	 * @param DetalleCompraEditado DetalleCompra a editar
	 * @return HttpCode ok si la actualiza correctamente
	 */
	@PatchMapping()
	public ResponseEntity<DetalleCompraPojo> update(@RequestBody DetalleCompraPojo detalleCompraEditado) {

		return ResponseEntity.of(iDetalleCompraService.update(detalleCompraEditado));
	}

	/**
	 * Elimina un DetalleCompra
	 * 
	 * @param id DetalleCompra a eliminar
	 * @return HttpCode ok si la elimina, HttpCode not found
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<DetalleCompraPojo> delete(@PathVariable Integer id) {

		return new ResponseEntity<>(this.iDetalleCompraService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);// Si es
																											// cierto me
																											// devuelves
																											// un ok, si
																											// no es
																											// cierto un
																											// not
																											// found.
	}

}