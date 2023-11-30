import java.util.ArrayList;
//Samantha Dominguez, Spring 2021

public class HeartTransplant {
    private Patient[] patients;
    private SurvivabilityByAge survivabilityByAge;
    private SurvivabilityByCause survivabilityByCause;

    public HeartTransplant() {
        this.patients = null;
        this.survivabilityByAge = null;
        this.survivabilityByCause = null;
    }


    public Patient[] getPatients() {
        return patients;
     } 


    public SurvivabilityByAge getSurvivabilityByAge() {
        return survivabilityByAge;
    }

    public SurvivabilityByCause getSurvivabilityByCause() {
        return survivabilityByCause;
    }


    public void readPatients (int numberOfLines) {
        Patient [] patients = new Patient[numberOfLines];
        for(int i = 0; i < numberOfLines; i++){

            int id =StdIn.readInt();
            int ethnicity = StdIn.readInt();
            int gender = StdIn.readInt();
            int age = StdIn.readInt();
            int cause = StdIn.readInt();
            int urgency = StdIn.readInt();
            int stateOfHealth = StdIn.readInt();

            Patient patient = new Patient(id, ethnicity, gender, age, cause, urgency, stateOfHealth);
            
            patients[i] = patient;
        }
        this.patients = patients;
    }   


    public void readSurvivabilityByAge (int numberOfLines) {
        SurvivabilityByAge survivabilityByAges = new SurvivabilityByAge();
        for(int i = 0; i < numberOfLines; i++){
            int age = StdIn.readInt();
            int year = StdIn.readInt();
            double rate = StdIn.readDouble();
            survivabilityByAges.addData(age, year, rate);
        }
        this.survivabilityByAge = survivabilityByAges; 
    }

 
    public void readSurvivabilityByCause (int numberOfLines) {
        SurvivabilityByCause survivabilityByCause = new SurvivabilityByCause();
        for(int i = 0; i < numberOfLines; i++){
            int cause = StdIn.readInt();
            int year = StdIn.readInt();
            double rate = StdIn.readDouble();
            survivabilityByCause.addData(cause, year, rate);
        }
        this.survivabilityByCause = survivabilityByCause;
    }
    

    public Patient[] getPatientsWithAgeAbove(int age) {
        ArrayList<Patient> patientsaboveage = new ArrayList<Patient>();
        for(Patient patient : patients ){
            int target = patient.getAge();
            if(target > age){
                patientsaboveage.add(patient);
            }
        }
        int size = patientsaboveage.size();
        if(size == 0){
            return null;
        }
        else{
            Patient[] patients = new Patient[size];
            for(int i= 0; i < size; i++){
                patients[i] = patientsaboveage.get(i);
            }
            return patients;
        }
    }

    public Patient[] getPatientsByHeartConditionCause(int cause) {
        ArrayList<Patient> patientsbyheartcondition = new ArrayList<Patient>();
        for(Patient patient : patients){
            int target = patient.getCause();
            if(target == cause){
                patientsbyheartcondition.add(patient);
            }
        }
        int size = patientsbyheartcondition.size();
        if(size == 0){
            return null;
        }
        else{
            Patient[] patients = new Patient[size];
            for(int i = 0; i < size; i++){
                patients[i] = patientsbyheartcondition.get(i);
            }
            return patients;
        }
    }
    public Patient[] getPatientsByUrgency(int urgency) {
        ArrayList<Patient> patientsbyurgency = new ArrayList<Patient>();
        for(Patient patient : patients){
            int target = patient.getUrgency();
            if(target == urgency){
                patientsbyurgency.add(patient);
            }
        }
        int size = patientsbyurgency.size();
        if(size == 0){
            return null;
        }
        else{
            Patient[] patients = new Patient[size];
            for(int i = 0; i < size; i++){
                patients[i] = patientsbyurgency.get(i);
            }
            return patients;
        }
    }
  
    public Patient getPatientForTransplant (int cause) {
        double rateforpatients = this.survivabilityByCause.getRate(1,1);
        for(int i = 0; i < survivabilityByCause.size(); i++){
            
        }
    }
}
