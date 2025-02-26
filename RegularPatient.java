package ilstu.edu;

public class RegularPatient extends Patient
{
	private String mainSymptom;

	// Constructor that uses super constructor as well as instantiates mainSymptom
	public RegularPatient(int id, String fName, String lName, int age, String mainSymptom)
	{
		super(id, fName, lName, age);
		this.mainSymptom = mainSymptom;
	}

	@Override
	// Determine the type of treatment based on the main symptom
	public String treat()
	{
		if (mainSymptom.equalsIgnoreCase("coughing") || mainSymptom.equalsIgnoreCase("runny nose")
				|| mainSymptom.equalsIgnoreCase("stuffy nose"))
		{
			return ("Amoxicillin");

		} else if (mainSymptom.equalsIgnoreCase("hypertension"))
		{
			return ("ACE inhibitors");
		} else
		{
			return ("IV fluids");
		}
	}

	@Override
	// Basic toString for regular patient information
	public String toString()
	{
		return ("ID: " + getId() + "\n Full Name: " + getfName() + " " + getlName() + "\n Age: " + getAge()
				+ "\n Main Symptom: " + mainSymptom + "\n PCR test result: " + isPcr() + "\n Treatment: " + treat());

	}

}
