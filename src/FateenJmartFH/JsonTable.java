package FateenJmartFH;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Vector;

public class JsonTable<T> extends Vector {
    public final String filepath;
    private static final Gson gson = new Gson();

    public JsonTable(Class<T> clazz, String filepath) throws IOException {
        this.filepath = filepath;

        @SuppressWarnings("unchecked")
        Class<T[]> array = (Class<T[]>) Array.newInstance(clazz, 0).getClass();

        T[] result = JsonTable.readJson(array, this.filepath);
        Collections.addAll(this, result);
    }

    public static <T> T readJson(Class<T> clazz, String filepath) throws FileNotFoundException {
        T readerJson = null;
        try {
            final JsonReader readJson = new JsonReader(new FileReader(filepath));
            readerJson = gson.fromJson(readJson, clazz);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return readerJson;
    }

    public void writeJson() throws IOException {
        writeJson(this, this.filepath);
    }

    public static void writeJson(Object object, String filepath) throws IOException {
        final FileWriter fileWriter = new FileWriter(filepath);
        fileWriter.write(gson.toJson(object));
        fileWriter.close();
    }
}

