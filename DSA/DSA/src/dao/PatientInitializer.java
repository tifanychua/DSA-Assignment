/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import adt.*;
import entity.Patient;
/**
 *
 * @author Admin
 */
public class PatientInitializer {
     public PatientInterface<Patient> initializePatients() {
    PatientInterface<Patient> pList = new ArrayList<>();
    pList.add(new Patient("990101-01-1234", "Ali Bin Abu", "S1234567", "0123456789", "01/01/1999", "Male", "O", "Peanuts", "Asthma", "No.1, Jalan Mawar, KL", "Appendix", "Hepatitis B", "Diabetes", "22/07/2025", "Dr. Lim", "Student", "Single", "Christianity", "No", "Abu Bin Ali", "0191234567", "Father",178.00,50.22));
    pList.add(new Patient("991212-05-5678", "Siti Aminah", "S2234567", "0139876543", "12/12/1999", "Female", "A", "None", "None", "No.12, Jalan Teratai, PJ", "None", "Covid-19", "Hypertension", "23/07/2025", "Dr. Tan", "Clerk", "Married", "Islam", "No", "Mohd Ali", "0168889999", "Husband",166.22,45.10));
    pList.add(new Patient("980505-02-3456", "Tan Ah Kow", "S3234567", "0176543210", "05/05/1998", "Male", "B", "Dust", "Diabetes", "No.5, Jalan Bunga, Penang", "Tonsils", "HPV", "Heart Disease", "24/07/2025", "Dr. Ong", "Engineer", "Divorced", "Buddhism", "Yes", "Tan Mei", "0145554321", "Sister",166.22,45.10));
    pList.add(new Patient("970707-03-1111", "Muthu Kumar", "S4234567", "0187654321", "07/07/1997", "Male", "AB", "Seafood", "None", "No.7, Taman Setia, Ipoh", "Appendix", "Hepatitis A", "None", "25/07/2025", "Dr. Krishnan", "Teacher", "Married", "Hindu", "No", "Anita", "0129988776", "Wife",166.22,45.10));
    pList.add(new Patient("950303-04-9999", "Liew Mei Yee", "S5234567", "0111234567", "03/03/1995", "Female", "O", "None", "Migraine", "No.3, Bukit Indah, JB", "None", "Covid-19", "None", "26/07/2025", "Dr. Wong", "Accountant", "Single", "Christian", "No", "Liew Ah Seng", "0137778888", "Brother",166.22,45.10));
    pList.add(new Patient("960606-06-8888", "Mohd Hafiz", "S6234567", "0102233445", "06/06/1996", "Male", "A", "Penicillin", "None", "No.6, Jalan Tasik, Shah Alam", "None", "Flu", "Asthma", "27/07/2025", "Dr. Nasir", "Technician", "Married", "Islam", "Yes", "Nur Aini", "0149996666", "Wife",166.22,45.10));
    pList.add(new Patient("940404-07-7777", "Lim Zhi Xuan", "S7234567", "0164443332", "04/04/1994", "Female", "B", "None", "Hypertension", "No.4, Taman Merah, Melaka", "Gallbladder", "DPT", "Hypertension", "28/07/2025", "Dr. Lee", "Manager", "Single", "Buddhism", "No", "Lim Chun", "0126665555", "Mother",166.22,45.10));
    pList.add(new Patient("930909-08-6666", "Ramesh Raj", "S8234567", "0133332221", "09/09/1993", "Male", "O", "None", "None", "No.9, Jalan Hijau, Seremban", "None", "Hepatitis B", "Heart Disease", "29/07/2025", "Dr. Bala", "Pharmacist", "Single", "Hindu", "Yes", "Ravi Raj", "0174449990", "Father",166.22,45.10));
    pList.add(new Patient("920202-09-5555", "Tan Sook Ling", "S9234567", "0121122334", "02/02/1992", "Female", "AB", "Latex", "Migraine", "No.2, Puchong Jaya, Selangor", "None", "Covid-19", "None", "30/07/2025", "Dr. Tan", "Designer", "Married", "Christian", "No", "Chong Wei", "0161122445", "Husband",166.22,45.10));
    pList.add(new Patient("900101-10-4444", "Cheah Soon Guan", "S1034567", "0199988776", "01/01/1990", "Male", "A", "Dust", "None", "No.10, Jalan Aman, KL", "None", "Flu", "None", "31/07/2025", "Dr. Goh", "Chef", "Divorced", "Buddhism", "Yes", "Cheah Mei", "0113322110", "Sister",166.22,45.10));

    pList.add(new Patient("891212-11-3333", "Norazlina Binti Ahmad", "S1134567", "0145566778", "12/12/1989", "Female", "O", "None", "Asthma", "No.11, Jalan Sentosa, KL", "Tonsils", "HPV", "Asthma", "01/08/2025", "Dr. Fatimah", "Nurse", "Married", "Islam", "No", "Ahmad Bin Ismail", "0177888999", "Husband",166.22,45.10));
    pList.add(new Patient("880808-12-2222", "Tee Jia Jun", "S1234567", "0156677889", "08/08/1988", "Male", "B", "Shellfish", "Hypertension", "No.8, Jalan Satu, Kajang", "None", "Covid-19", "Hypertension", "02/08/2025", "Dr. Ho", "Admin", "Single", "Buddhism", "Yes", "Tee Mei", "0149988776", "Mother",166.22,45.10));
    pList.add(new Patient("870707-13-1111", "Rajesh Kumar", "S1334567", "0165566770", "07/07/1987", "Male", "AB", "None", "None", "No.7, Jalan Dua, Klang", "None", "DPT", "Diabetes", "03/08/2025", "Dr. Devi", "Lawyer", "Married", "Hindu", "No", "Vijaya", "0187766554", "Wife",166.22,45.10));
    pList.add(new Patient("860606-14-0000", "Foo Wan Yee", "S1434567", "0178899001", "06/06/1986", "Female", "O", "Peanuts", "None", "No.6, Bandar Baru, Bangi", "Appendix", "Hepatitis A", "None", "04/08/2025", "Dr. Chee", "Scientist", "Single", "Christian", "No", "Foo Kok", "0156677880", "Brother",166.22,45.10));
    pList.add(new Patient("850505-15-9999", "Ahmad Faiz", "S1534567", "0189988776", "05/05/1985", "Male", "A", "None", "Heart Disease", "No.5, Jalan Besar, Rawang", "None", "Covid-19", "Heart Disease", "05/08/2025", "Dr. Khalid", "Salesman", "Married", "Islam", "Yes", "Aina", "0125566778", "Wife",166.22,45.10));
    pList.add(new Patient("840404-16-8888", "Chan Mei Lin", "S1634567", "0134455667", "04/04/1984", "Female", "B", "None", "None", "No.4, Kampung Baru, Penang", "None", "Flu", "None", "06/08/2025", "Dr. Lee", "Chef", "Single", "Buddhism", "No", "Chan Wai", "0146677880", "Sister",166.22,45.10));
    pList.add(new Patient("830303-17-7777", "Abdul Rahman", "S1734567", "0112233445", "03/03/1983", "Male", "O", "None", "Diabetes", "No.3, Jalan Merdeka, Kedah", "None", "HPV", "Diabetes", "07/08/2025", "Dr. Nordin", "Driver", "Widowed", "Sikhism", "Yes", "Rahim", "0163344556", "Brother",166.22,45.10));
    pList.add(new Patient("820202-18-6666", "Lim Boon Kiat", "S1834567", "0127766554", "02/02/1982", "Male", "AB", "None", "None", "No.2, Jalan Cempaka, Taiping", "None", "Covid-19", "None", "08/08/2025", "Dr. Liew", "Farmer", "Divorced", "Christian", "No", "Lim Ling", "0175566778", "Wife",166.22,45.10));
    pList.add(new Patient("810101-19-5555", "Saraswathy", "S1934567", "0136677889", "01/01/1981", "Female", "A", "Seafood", "Asthma", "No.1, Taman Bukit, Selangor", "None", "Flu", "Asthma", "09/08/2025", "Dr. Kumar", "Lecturer", "Married", "Hindu", "No", "Ravi", "0183344556", "Husband",166.22,45.10));
    pList.add(new Patient("800909-20-4444", "Teoh Kok Wai", "S2034567", "0194455667", "09/09/1980", "Male", "B", "Dust", "None", "No.9, Jalan Ilmu, Negeri Sembilan", "Tonsils", "DPT", "None", "10/08/2025", "Dr. Chia", "Scientist", "Single", "No Religion", "Yes", "Teoh Ling", "0129988771", "Sister",166.22,45.10));
    return pList;
  }

  public static void main(String[] args) {
    PatientInitializer initializer = new PatientInitializer();
    PatientInterface<Patient> patientList = initializer.initializePatients();
    System.out.println("\nPatient:\n" + patientList);
  }
}
