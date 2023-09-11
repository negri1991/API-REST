package es.MueblesCastilla.MueblesCastilla.persistance.entity;


	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.JoinColumn;
	import jakarta.persistence.ManyToOne;
	import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

	@Entity
	@Table(name="detalleCompra")
	@Getter
	@Setter
	public class DetalleCompra {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//Para generar autoincrementable
		private Integer id;
		private double precio;
		private double total;
		
		@ManyToOne
	    @JoinColumn(name = "compras_id", insertable = false, updatable = false) // Nombre de la columna que representa la relación
	    private Compra compra;
		
		@ManyToOne	
		@JoinColumn(name = "producto_id", insertable = false, updatable = false)
		private Producto producto;



		public DetalleCompra() {

		}

		public DetalleCompra(Integer id, double precio, double total, Compra compra, Producto producto) {
			super();
			this.id = id;
			this.precio = precio;
			this.total = total;
			this.compra = compra;
			this.producto = producto;
		}

	}

