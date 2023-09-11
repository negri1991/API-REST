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

import es.MueblesCastilla.MueblesCastilla.domain.dto.UsuarioPojo;
import es.MueblesCastilla.MueblesCastilla.domain.userCase.IUsuarioUseCase;
import lombok.RequiredArgsConstructor;

/**
 * Controlador rest de usuario(Rest es para que devuelva JSON o XML, a
 * diferencia de controller que devuelve HTML).
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	private final IUsuarioUseCase iUsuarioService;

	/**
	 * Devuelve lista de usuarios
	 * 
	 * @return HttpCode Ok con lista de usuarios
	 */
	@GetMapping()
	public ResponseEntity<List<UsuarioPojo>> getAll() {

		return ResponseEntity.status(HttpStatus.OK).body(iUsuarioService.getAll());
	}

	/**
	 * Devuelve un usuario dado su id
	 * 
	 * @param id de usuario a buscar
	 * @return Htttpcode ok si la encuentra, Httpcode not found.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioPojo> getUsuarioById(@PathVariable Integer id) {

		return ResponseEntity.of(iUsuarioService.getUsuarioById(id));
	}

	/**
	 * Devuelve un usuario dado su email
	 * 
	 * @param email de usuario a buscar
	 * @return Htttpcode ok si la encuentra, Httpcode not found.
	 */
	@GetMapping("/email/{email}")
	public ResponseEntity<UsuarioPojo> getUsuarioByEmail(@PathVariable String email) {

		return ResponseEntity.of(iUsuarioService.getUsuarioByEmail(email));
	}

	/**
	 * Crea un nuevo usuario
	 * 
	 * @param usuarioNew Usuario nuevo
	 * @return Http created si la guarda correctamente, de lo contrrario Http bad
	 *         request
	 */
	@PostMapping()
	public ResponseEntity<UsuarioPojo> save(@RequestBody UsuarioPojo usuarioNew) {

	

			return ResponseEntity.status(HttpStatus.CREATED).body(iUsuarioService.save(usuarioNew));
	

	}

	/**
	 * Edita un usuario
	 * 
	 * @param usuarioEditado usuario a editar
	 * @return HttpCode ok si la actualiza correctamente
	 */
	@PatchMapping()
	public ResponseEntity<UsuarioPojo> update(@RequestBody UsuarioPojo usuarioEditado) {

		return ResponseEntity.of(iUsuarioService.update(usuarioEditado));
	}

	/**
	 * Elimina un usuario
	 * 
	 * @param id usuario a eliminar
	 * @return HttpCode ok si la elimina, HttpCode not found
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<UsuarioPojo> delete(@PathVariable Integer id) {

		return new ResponseEntity<>(this.iUsuarioService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);// Si es
																											// cierto me
																											// devuelves
																											// un ok, si
																											// no es
																											// cierto un
																											// not
																											// found.
	}

}
