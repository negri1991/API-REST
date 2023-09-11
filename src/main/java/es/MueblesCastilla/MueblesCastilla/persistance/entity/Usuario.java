package es.MueblesCastilla.MueblesCastilla.persistance.entity;



	import java.util.List;



	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.OneToMany;
	import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


	@Entity//entidad
	@Table(name = "usuarios")
	@Getter
	@Setter
	public class Usuario {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
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
		
		@OneToMany(mappedBy = "usuario")//relacion de uno a muchos.(un usuario puede tener muchas compras)
		private List<Compra> ordenes;
		public Usuario() {

		}

		public Usuario(Integer id, String nombre, String username, String email, String direccion, String telefono,
				String tipo, String password) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.username = username;
			this.email = email;
			this.direccion = direccion;
			this.telefono = telefono;
			this.tipo = tipo;
			this.password = password;
		}

		@Override
		public String toString() {
			return "Usuario [id=" + id + ", nombre=" + nombre + ", username=" + username + ", email=" + email
					+ ", direccion=" + direccion + ", telefono=" + telefono + ", tipo=" + tipo + ", password=" + password
					+ "]";
		}

		public List<Producto> getProductos() {
			return productos;
		}

		public void setProductos(List<Producto> productos) {
			this.productos = productos;
		}
		

	}



