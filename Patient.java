/*
 * Created on: Feb 7, 2023
 *
 * ULID: badavi4
 * Class: IT 168 
 */
package ilstu.edu;

/**
 * Program 2 IT 179 Hostpital Program
 *
 * @author <Brady Davidson>
 *
 */
public abstract class Patient
{
	// Private variables
	private int id;
	private String fName;
	private String lName;
	private int age;
	private boolean pcr;

	// Parent Constructor
	public Patient(int id, String fName, String lName, int age)
	{
		this.age = age;
		this.id = id;
		this.fName = fName;
		this.lName = lName;
	}

	// Get the ID
	public int getId()
	{
		return id;
	}

	// Set the ID
	public void setId(int id)
	{
		this.id = id;
	}

	// Get the first name of the patient
	public String getfName()
	{
		return fName;
	}

	// Set the first name of the patient
	public void setfName(String fName)
	{
		this.fName = fName;
	}

	// Get the last name of the patient
	public String getlName()
	{
		return lName;
	}

	// Set the last name of the patient
	public void setlName(String lName)
	{
		this.lName = lName;
	}

	// Get the age of the patient
	public int getAge()
	{
		return age;
	}

	// Set the age of the patient
	public void setAge(int age)
	{
		this.age = age;
	}

	// Get the PCR result(Determines Covid Patients)
	public boolean isPcr()
	{
		return pcr;
	}

	// Set the PCR
	public void setPcr(boolean pcr)
	{
		this.pcr = pcr;
	}

	// Abstract method treat. This forces the other child classes to implement this
	// method with a corresponding body.
	public abstract String treat();

	@Override
	// Patient toString
	public String toString()
	{
		return "Patient [id=" + id + ", fName=" + fName + ", lName=" + lName + ", age=" + age + ", pcr=" + pcr + "]";
	}

}
