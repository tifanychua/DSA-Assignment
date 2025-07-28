/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class PatientQueueEntry {
     private String queueNumber;
    private String ic;
    private String name;
    private String entryBy;
    private String status;

    public PatientQueueEntry(String queueNumber, String ic, String name, String entryBy) {
        this.queueNumber = queueNumber;
        this.ic = ic;
        this.name = name;
        this.entryBy = entryBy;
        this.status = "Waiting"; 
    }

    public String getQueueNumber() {
        return queueNumber;
    }

    public String getIC() {
        return ic;
    }

    public String getName() {
        return name;
    }

    public String getEntryBy() {
        return entryBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "[" + queueNumber + "] " + name + " (" + ic + "), Entry by: " + entryBy + ", Status: " + status;
    }

}
