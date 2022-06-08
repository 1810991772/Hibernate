package org.example.demo.entity;




import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="student_table")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int student_Id;
private String name;
private String email;
@Embedded
private Address homeAddress;
@Override
public String toString() {
	return "Student [student_Id=" + student_Id + ", name=" + name + ", email=" + email + ", homeAddress=" + homeAddress
			+ "]";
}

}
