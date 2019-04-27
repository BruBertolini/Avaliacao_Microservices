package br.com.fiap.transaction.bean;
import lombok.*;
import io.swagger.annotations.ApiModelProperty;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

	@ApiModelProperty(notes = "Transaction ID", required = "true")
	private long id;
	
	@ApiModelProperty(notes = "Transaction timestamp", required = "true")
	private long timestamp;
	
	@ApiModelProperty(notes = "Transaction amout", required = "true")
	private double amount;
	
}
