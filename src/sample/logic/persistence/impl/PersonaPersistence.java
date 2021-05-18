package sample.logic.persistence.impl;

import sample.logic.entities.Persona;
import sample.logic.persistence.IpersonaPersistence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaPersistence implements IpersonaPersistence {

    public static final String PERSONAS_FILE_PATH = "personas.sabana";

    public PersonaPersistence() throws IOException {
        File file = new File(PERSONAS_FILE_PATH);
        if(file.createNewFile()){
            System.out.println("the file"+ file.getName() + "was created");
        }
    }

    @Override
    public void save(Persona persona) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(PERSONAS_FILE_PATH,true);
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
        //ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("personas.sabana"));
        out.writeObject(persona);
        out.close();
    }

    @Override
    public List<Persona> read() throws IOException, ClassNotFoundException {
        List<Persona> result = new ArrayList<>();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(PERSONAS_FILE_PATH));
        //result.add((Persona) in.readObject());

        Persona persona = (Persona) in.readObject();
        while(persona !=null){
            result.add(persona);
            persona = (Persona) in.readObject();
        }
        in.close();
        return result;
    }

    @Override
    public void export() throws IOException {

    }
}
