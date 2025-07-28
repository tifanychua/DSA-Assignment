package control;

import adt.ArrayQueue;
import adt.QueueInterface;
import entity.PatientQueueEntry;

public class QueueControl {

    private static QueueControl instance; 
    private QueueInterface<PatientQueueEntry> patientQueue;
    private int queueCounter = 1;

    private QueueControl() { 
        patientQueue = new ArrayQueue<>();
    }

    public static QueueControl getInstance() {
        if (instance == null) {
            instance = new QueueControl();
        }
        return instance;
    }
    private String generateQueueNumber() {
        return String.format("Q%03d", queueCounter++);
    }

    public boolean addPatient(String ic, String name, String entryBy) {
        String queueNum = generateQueueNumber();
        PatientQueueEntry newPatient = new PatientQueueEntry(queueNum, ic, name, entryBy);

        return patientQueue.enqueue(newPatient);
    }

    public PatientQueueEntry callNextPatient() {
        return patientQueue.dequeue();
    }

    public PatientQueueEntry peekNextPatient() {
        return patientQueue.getFront();
    }

    public boolean isQueueEmpty() {
        return patientQueue.isEmpty();
    }

    public String displayQueue() {
         System.out.println(patientQueue.toString());
        return patientQueue.toString();
        
    }
    
    
    public String[][] getAllQueue() {
    if (!(patientQueue instanceof ArrayQueue)) {
        return new String[0][];
    }

    ArrayQueue<?> queue = (ArrayQueue<?>) patientQueue;

    Object[] arr = queue.getInternalArray();
    int front = queue.getFrontIndex();
    int size = queue.size();
    int arrayLength = arr.length;

    String[][] data = new String[size][5];

    for (int i = 0; i < size; i++) {
        Object obj = arr[(front + i) % arrayLength];
        if (obj instanceof PatientQueueEntry) {
            PatientQueueEntry p = (PatientQueueEntry) obj;

            data[i][0] = p.getQueueNumber();
            data[i][1] = p.getIC();
            data[i][2] = p.getName();
            data[i][3] = p.getEntryBy();
            data[i][4] = p.getStatus();
        }
    }

    return data;
}
}
