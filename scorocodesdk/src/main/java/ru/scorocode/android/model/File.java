package ru.scorocode.android.model;

import java.io.InputStream;
import java.util.Scanner;

import ru.scorocode.android.main.SCCallback;
import ru.scorocode.android.manager.FileManager;

public class File {

    public void save(SCCallback<String> callback, String acc, String sess, String coll, String doc, String field, InputStream contentStream) {
        FileManager fileManager = new FileManager();
        String contentString = convertStreamToString(contentStream);
        fileManager.upload(callback, acc, sess, coll, doc, field, contentString);
    }

    public static String convertStreamToString(InputStream is) {
        Scanner s = new Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

}
