/*
 * Created on: Feb 7, 2023
 *
 * ULID: badavi4
 * Class: IT 168 
 */
package ilstu.edu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Program 2 IT 179 Hostpital Program
 *
 * @author <Brady Davidson>
 *
 */
public class MainClass
{

	public static void main(String[] args)
	{
		ArrayList<Patient> list = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		int choice = 0;
		String testResult;
		boolean result = false;

		while (choice != 6)
		{
			// Display the choices
			System.out.println("Please select one of the following options: ");
			System.out.println("1. Admit a patient.");
			System.out.println("2. Print patient information.");
			System.out.println("3. Submit a PCR test result.");
			System.out.println("4. Do rounds.");
			System.out.println("5. Discharge patient.");
			System.out.println("6. Exit");
			try
			{
				choice = input.nextInt();
			} catch (InputMismatchException e)
			{
				System.out.println("Mismatch Exception, enter an integer. ");
				choice = input.nextInt();
			}

			// Determine the choice and what to do
			if (choice == 1)
			{
				// Determine type of patient from PCR test
				System.out.println("Please enter the PCR test result(positive/negative).");
				testResult = input.next();
				if (testResult.equalsIgnoreCase("positive"))
				{
					result = true;
				} else if (testResult.equalsIgnoreCase("negative"))
				{
					result = false;
				} else
				{
					System.out.println("Please try again. Enter a valid choice. ");
				}
				// If they have covid ask Covid19Patient Questions and store values
				if (result == true)
				{
					int id, age = 0;
					double temp;
					String fName, lName;
					System.out.println("Please enter the patient's ID: ");
					id = input.nextInt();
					System.out.println("Please enter the Patient's first name");
					fName = input.next();
					System.out.println("Please enter the Patient's last name: ");
					lName = input.next();
					System.out.println("Please enter the Patient's age");
					age = input.nextInt();
					// Test if age is valid
					if (age < 0)
					{
						while (age < 0)
						{
							System.out.println("Enter a valid age: ");
							age = input.nextInt();
						}
					}
					System.out.println("Please enter the Patient's temperauture: ");
					temp = input.nextDouble();
					// Use constructor to create Covid19Patient Object
					Covid19Patient patient1 = new Covid19Patient(id, fName, lName, age, temp);
					patient1.setPcr(result);
					// Add the patient to the array List
					list.add(patient1);

					// If the patient does not have covid ask regular patient questions
				} else if (result == false && testResult.equalsIgnoreCase("negative"))
				{

					int id, age;
					String symptom;
					String fName, lName;
					System.out.println("Please enter the patient's ID: ");
					id = input.nextInt();
					System.out.println("Please enter the Patient's first name");
					fName = input.next();
					System.out.println("Please enter the Patient's last name: ");
					lName = input.next();
					System.out.println("Please enter the Patient's age");
					age = input.nextInt();
					System.out.println("Please enter the Patient's main symptom: ");
					symptom = input.nextLine();
					symptom = input.nextLine();
					// Regular Patient constructor that stores the values
					RegularPatient patient2 = new RegularPatient(id, fName, lName, age, symptom);
					patient2.setPcr(result);
					// Add the patient to the array list
					list.add(patient2);
				}
			} else if (choice == 2)
			{
				// Print the patient information
				int index = -1;
				int id;
				// Get the ID to determine what patient is being printed out
				System.out.println("Enter patient's ID: ");
				id = input.nextInt();
				// Use for loop to find the correct patient
				for (int i = 0; i < list.size(); i++)
				{
					// Avoid null pointer error
					if (list.get(i) != null)
					{
						// Check if the IDs match
						if (list.get(i).getId() == id)
						{
							index = i;
						}
					}
				}
				// Avoid index out of bounds error
				if (index != -1 && index < list.size())
					System.out.println(list.get(index).toString());

			} else if (choice == 3)
			{
				// Submit a PCR test result
				System.out.println("Please enter the patient ID: ");
				int id = input.nextInt();
				for (int i = 0; i < list.size(); i++)
				{
					if (list.get(i).getId() == id)
					{
						System.out.println("Enter the updated PCR result (positive/negative): ");
						String updatedTest = input.next();
						if (updatedTest.equals("positive"))
						{
							result = true;
							list.get(i).setPcr(result);
							System.out.println("Enter the patient's updated temp: ");
							double newTemp = input.nextDouble();
							Covid19Patient patient3 = new Covid19Patient(list.get(i).getId(), list.get(i).getfName(),
									list.get(i).getlName(), list.get(i).getAge(), newTemp);
							list.set(i, patient3);

						} else if (updatedTest.equals("negative"))
						{
							if (list.get(i) instanceof Covid19Patient)
							{
								System.out.println("Patient has been released.");
								list.remove(i);
							} else
							{
								result = false;
								list.get(i).setPcr(result);
								System.out.println("Enter the patient's main symptom: ");
								String symptom = input.nextLine();
								symptom = input.nextLine();
								input.next();
								RegularPatient patient4 = new RegularPatient(list.get(i).getId(),
										list.get(i).getfName(), list.get(i).getlName(), list.get(i).getAge(), symptom);
								list.set(i, patient4);
							}
						} else
						{
							System.out.println("Please try again. Enter a valid choice: ");
							updatedTest = input.next();

						}

					}
				}
			} else if (choice == 4)
			{
				// For loop to access each patient
				for (int i = 0; i < list.size(); i++)
				{
					// Get Covid patient's temperatures
					if (list.get(i).isPcr() == true)
					{
						System.out.println("Enter the current temperature: ");
						int t = input.nextInt();
						((Covid19Patient) list.get(i)).setTemp(t);
						// treat the patients
						list.get(i).treat();
					}
					// Print out each patient's ID and Treatment
					System.out.println("ID: " + list.get(i).getId() + " Treatment: " + list.get(i).treat());

				}

			} else if (choice == 5)
			{
				// Uses the ID to find the requested patient
				System.out.println("Enter the ID on the patient you want to be discharged: ");
				int id = input.nextInt();
				// Find the patient with the for loop
				for (int i = 0; i < list.size(); i++)
				{
					// check that IDs match
					if (id == list.get(i).getId())
					{
						// Check if patient has Covid still
						if (list.get(i).isPcr() == false)
						{
							list.remove(i);
							System.out.println("The patient has been removed");
						} else if (list.get(i).isPcr() == true)
						{
							System.out.println("The patient still has Covid-19");
						}
					} else
					{
						System.out.println("No matching ID number. ");
					}
				}

			} else if (choice != 6)
			// Catching all non-valid numbers
			{
				System.out.println("Please select a valid input. ");
			}
		}
		input.close();
	}

}
