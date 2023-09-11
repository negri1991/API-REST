package es.MueblesCastilla.MueblesCastilla.persistance.entity;


	
	


import java.util.List;

import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

	@Entity
	@Table(name = "productos")//Para cambiar el nombre en BD
	@Getter
	@Setter
	public class Producto {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//Para generar autoincrementable
		private Integer id;
		private String nombre;
		private String imagen;
		private double precio;
		private int cantidad;
		private String descripcion;
		private Integer idUsuario;
		
		
		@OneToMany(mappedBy = "producto")
	    private List<DetalleCompra> detalleCompra;
		
		@ManyToOne
		@JoinColumn(name = "idUsuario", insertable = false, updatable = false)
		private Usuario usuario;

		public Producto() {

		}

		public Producto(Integer id, String nombre, String imagen, double precio, int cantidad, String descripcion,
				Integer idUsuario, List<DetalleCompra> detalleCompra, Usuario usuario) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.imagen = imagen;
			this.precio = precio;
			this.cantidad = cantidad;
			this.descripcion = descripcion;
			this.idUsuario = idUsuario;
			this.detalleCompra = detalleCompra;
			this.usuario = usuario;
		}



	

}
