/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adt;

/**
 *
 * @author Alex Lee Chia Hau
 * @author Koh Yoke Yieng
 * @author Cham Yee
 * @author Tang Yi Jun
 */
public interface ListInterface<T> {

    public boolean add(T newEntry);

    public T remove(int givenPosition);

    public T getEntry(int givenPosition);

    public int getNumberOfEntries();

    public boolean isEmpty();
    
    public void clear();

    public boolean replace(int i, T anEntry);

    public void mergeSort();
}
