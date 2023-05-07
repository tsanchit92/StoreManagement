package store.admin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class employeeReg {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long phone;
	private String name;
	private String email;
	private Address address;
	private String designation;
	private int hours;
	private int payPerHours;

}
