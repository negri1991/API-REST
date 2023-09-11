package es.MueblesCastilla.MueblesCastilla.persistance.entity;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="facturas")
@Getter
@Setter
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Para generar autoincrementable
	private Integer id;
	private String numero;
	private Date fechaCreacion;
	private Date fechaRecibida;

	private double total;
	
	@ManyToOne//Muchas compras por un usuario.
	private Usuario usuario;
	

	@ManyToMany(mappedBy = "compras")
	private Set<Producto> productos = new HashSet<>();

	public Compra() {

	}


	public Compra(Integer id, String numero, Date fechaCreacion, Date fechaRecibida, double total, Usuario usuario,
			List<DetalleCompra> detalle, Set<Producto> productos) {
		super();
		this.id = id;
		this.numero = numero;
		this.fechaCreacion = fechaCreacion;
		this.fechaRecibida = fechaRecibida;
		this.total = total;
		this.usuario = usuario;
		this.productos = productos;
	}
}