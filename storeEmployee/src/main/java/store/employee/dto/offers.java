package store.employee.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class offers {

	private String name;
	private int validityAmt;
	private int discount;
	private Date startDate;
	private Date expiryDate;
}
