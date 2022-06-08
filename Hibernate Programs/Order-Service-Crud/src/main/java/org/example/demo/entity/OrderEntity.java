package org.example.demo.entity;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name="OrderEntity")
@Table(name="order_table")
public class OrderEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
private int orderId;
	@Column(name="name")
private String orderName;
	@Override
	public String toString() {
		return "orderId=" + orderId + ", orderName=" + orderName ;
	}
}
