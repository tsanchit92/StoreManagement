
package store.employee.entity;

import java.util.List;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "User")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class user {

	@Id
	private long phone;
	private String name;
	private String email;
	private String billingPoints;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderId", referencedColumnName = "id")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Order> order;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "houseNo", referencedColumnName = "houseNo")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Address address;
	

}
