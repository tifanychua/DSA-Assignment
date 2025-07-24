import adt.ArrayList; 
import adt.PatientInterface;
import entity.Patient;

public class Test {
  public static void main(String[] args) {
    // 1. Create the list
    PatientInterface<Patient> patientList = new ArrayList<>();

    // 2. Add patients
    patientList.add(new Patient("990101-01-1234", "Ali Bin Abu", "S1234567", "0123456789", "01/01/1999", 
      "Male", "O", "Peanuts", "Asthma", "KL", "Appendix", "Hepatitis B", "Diabetes", 
      "22/07/2025", "Dr. Lim", "Student", "Single", "Islam", "No", 
      "Abu Bin Ali", "0191234567", "Father"));

    patientList.add(new Patient("991212-05-5678", "Siti Aminah", "S2234567", "0139876543", "12/12/1999", 
      "Female", "A", "None", "None", "PJ", "None", "Covid-19", "Hypertension", 
      "23/07/2025", "Dr. Tan", "Clerk", "Married", "Islam", "No", 
      "Mohd Ali", "0168889999", "Husband"));

    System.out.println("=== All Patients ===");
    System.out.println(patientList); // thanks to toString()

    // 3. Remove a patient (position is 1-based)
    System.out.println("=== Removing patient at position 1 ===");
    patientList.remove(1);

    System.out.println("=== After Removal ===");
    System.out.println(patientList);

    // 4. Edit a patient (replace at given position)
    System.out.println("=== Replacing patient at position 1 ===");
    Patient updatedPatient = new Patient("990101-01-1234", "Ali Bin Bakar", "S9999999", "0198765432", "01/01/1999", 
      "Male", "B", "None", "Flu", "New Address", "None", "None", "None", 
      "24/07/2025", "Dr. New", "Teacher", "Single", "Islam", "No", 
      "New Father", "0188888888", "Father");

    patientList.replace(1, updatedPatient);

    System.out.println("=== After Replacement ===");
    System.out.println(patientList);
  }
}