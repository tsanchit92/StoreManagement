package store.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import store.employee.entity.Address;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class employee {

	private String name;
	private String email;
	private Long phone;
	private Address address;
	private String designation;
	private int hours;
	
}
