package store.admin.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

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
	private employeeReg employee;
}
