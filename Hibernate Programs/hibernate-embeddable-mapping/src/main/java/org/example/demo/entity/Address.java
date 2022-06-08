package org.example.demo.entity;
import javax.persistence.Embeddable;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class Address {
private String city;
private String street;
private String zipcode;
@Override
public String toString() {
	return "Address [city=" + city + ", street=" + street + ", zipcode=" + zipcode + "]";
}

}
