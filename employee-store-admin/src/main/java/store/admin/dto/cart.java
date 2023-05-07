package store.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class cart {

	public Item item;
	public int Quantity;
	public int Price;
	public int finalprice;

}
