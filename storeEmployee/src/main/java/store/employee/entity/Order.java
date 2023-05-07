
package store.employee.entity;

import java.sql.Date;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import store.employee.dto.Item;

@Entity
@Table(name = "Order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date date;
	private cart Cart;


	public Order(Date date, cart cart, user user) {
		super();
		this.date = date;
		Cart = cart;
		User = user;
	}

	@OneToOne(cascade = CascadeType.ALL)

	@JoinColumn(name = "userName", referencedColumnName = "name")

	@LazyCollection(LazyCollectionOption.FALSE)
	private user User;

}
