package com.boatclub.persistence;

import java.io.*;

public class Storage {

    private String storageName;

    public Storage (String storageName) {
        this.storageName = storageName + ".dat";
    }

    public void save (Object objectToStore) throws Exception {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(storageName));
        outputStream.writeObject(objectToStore);
        outputStream.close();
    }

    public Object read () throws Exception {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(storageName));
        Object result = inputStream.readObject();
        inputStream.close();

        return result;
    }

    public boolean exists() {
        File file = new File(storageName);
        return file.isFile() && file.canRead();
    }
}
