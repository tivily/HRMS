package kodlamaio.HRMS.entities.concretes.employeeConfirms;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="employee_confirms_employers")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class EmployeeConfirmEmployer extends EmployeeConfirm{
	@Id
	@GeneratedValue()
	@Column(name="id")
	private int id;
	@Column(name="employer_id")
	private int employerId;

	
}
