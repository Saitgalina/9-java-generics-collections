package com.example.task02;

import java.io.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class SavedList<E extends Serializable> extends AbstractList<E> {
    private List<E> elements;
    private File file;

    public SavedList(File file) {
        this.file = file;
        if (!file.exists())
            elements = new ArrayList<>();
        else {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
                elements = (List<E>) objectInputStream.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void write(){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))){
            objectOutputStream.writeObject(elements);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public E get(int index) {
        return elements.get(index);
    }

    @Override
    public E set(int index, E element) {
        E elem = elements.set(index,element);
        write();
        return elem;
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public void add(int index, E element) {
        elements.add(index,element);
        write();
    }

    @Override
    public E remove(int index) {
        E elem = elements.remove(index);
        write();
        return elem;
    }
}
