package ilstu.edu;

public class Covid19Patient extends Patient
{
	private double temperature;

	// Constructor that uses super constructor as well as instantiates temperature
	public Covid19Patient(int id, String fName, String lName, int age, double temp)
	{
		super(id, fName, lName, age);
		this.temperature = temp;

	}

	// Returns the temperature
	public double getTemp()
	{
		return temperature;
	}

	// Sets the temperature
	public void setTemp(double temperature)
	{
		this.temperature = temperature;
	}

	@Override
	// Treat the Covid patient based on age and temperature
	public String treat()
	{
		if (getAge() > 63 && temperature > 38.5)
		{
			return ("Remdesivir");
		} else if (temperature > 42)
		{
			return ("Dexamethasone");
		} else
		{
			return ("Fluids and Tylenol");
		}
	}

	@Override
	// Basic toString used for Covid patients
	public String toString()
	{
		return ("ID: " + getId() + "\n Full Name: " + getfName() + " " + getlName() + "\n Age: " + getAge()
				+ "\n Temperature: " + temperature + "\n PCR test result: " + isPcr() + "\n Treatment: " + treat());
	}

}
