package es.MueblesCastilla.MueblesCastilla.persistance.entity;



	import java.util.List;



import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.OneToMany;
	import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;


	@Entity//entidad
	@Table(name = "usuarios")
	@Getter
	@Setter
	public class Usuario {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//Para generar autoincrementable
		private Integer id;
		@Column(name ="nombreCompleto")//cambiar nombre de campo en la BD.
		private String nombre;
		private String username;
		private String email;
		private String direccion;
		private String telefono;
		private String tipo;
		private String password;
		
		@OneToMany(mappedBy = "usuario")//relacion de uno a muchos.
		private List<Producto> productos;
		
	    @OneToMany(mappedBy = "usuario")
	    private List<Compra> compras;
		public Usuario() {

		}
		public Usuario(Integer id, String nombre, String username, String email, String direccion, String telefono,
				String tipo, String password, List<Producto> productos, List<Compra> compras) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.username = username;
			this.email = email;
			this.direccion = direccion;
			this.telefono = telefono;
			this.tipo = tipo;
			this.password = password;
			this.productos = productos;
			this.compras = compras;
		}


	}



