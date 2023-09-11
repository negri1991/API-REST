package es.MueblesCastilla.MueblesCastilla.persistance.entity;


	
	

	import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

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
		
		@ManyToOne//Muchos a uno
		private Usuario usuario;
		
		
		@ManyToMany
		@JoinTable(
				name = "detalle_compra2",
		        joinColumns = @JoinColumn(name = "producto_id"),
		        inverseJoinColumns = @JoinColumn(name = "compra_id")
		    )
		private Set<Compra> compras = new HashSet<>();

		public Producto() {

		}

		public Producto(Integer id, String nombre, String imagen, double precio, int cantidad, String descripcion,
				Usuario usuario, Producto producto, Set<Compra> compras) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.imagen = imagen;
			this.precio = precio;
			this.cantidad = cantidad;
			this.descripcion = descripcion;
			this.usuario = usuario;
			this.compras = compras;
		}

	

}
