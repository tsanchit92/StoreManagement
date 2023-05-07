package store.admin.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

	private int id;
	private String name;
	private int price;
	private Date expiryDate;
	private Date manufacturingDate;
	private int quantityInStock;
	
}

