
package store.employee.entity;

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

@Getter

@Setter

@AllArgsConstructor

@NoArgsConstructor

@Entity

@Table(name = "Address")
public class Address {

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	private int houseNo;
	private String street;
	private String city;
	private String state;
	private String Country;

	@OneToOne(cascade = CascadeType.ALL)

	@JoinColumn(name = "userName", referencedColumnName = "name")

	@LazyCollection(LazyCollectionOption.FALSE)
	private user User;
}
