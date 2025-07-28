/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

/**
 *
 * @author Admin
 */
public interface PatientInterface <T>{
    boolean add(T newEnter);
    boolean add(int newPosition, T newEntry);
    T remove(int givenPosition);
    void clear();
    boolean replace(int givenPosition, T newEntry); 
    T getEntry(int givenPosition);
    boolean contains(T anEntry);
    int getNumberOfEntries();
    boolean isEmpty();
    boolean isFull();
}
