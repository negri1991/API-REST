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

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public double getPrecio() {
			return precio;
		}

		public void setPrecio(double precio) {
			this.precio = precio;
		}

		public double getTotal() {
			return total;
		}

		public void setTotal(double total) {
			this.total = total;
		}

		public Compra getCompra() {
			return compra;
		}

		public void setCompra(Compra compra) {
			this.compra = compra;
		}

		public Producto getProducto() {
			return producto;
		}

		public void setProducto(Producto producto) {
			this.producto = producto;
		}
		
	}

