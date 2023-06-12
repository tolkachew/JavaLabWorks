package laba4.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Entity implements Serializable {
    private Integer someData;
    public Integer getSomeData() {
        return someData;
    }
    public void setSomeData(Integer someData) {
        this.someData = someData;
    }
    @Override
    public String toString() {
        return someData.toString();
    }
}

public class Runner {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<Entity> entities;
        try {
            InputStream is = new FileInputStream("file.bin");
            ObjectInputStream ois = new ObjectInputStream(is);
            entities = (List<Entity>)ois.readObject();
            ois.close();
        } catch(IOException | ClassNotFoundException e) {
            entities = new ArrayList<>();
        }
        System.out.println(entities);
        Entity entity = new Entity();
        entity.setSomeData(new Random().nextInt(1000));
        entities.add(entity);
        System.out.println(entities);
        try {
            OutputStream os = new FileOutputStream("file.bin");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(entities);
            oos.close();
        } catch(IOException e) {
            System.out.println("Невозможно сохранить файл");
        }
    }
}