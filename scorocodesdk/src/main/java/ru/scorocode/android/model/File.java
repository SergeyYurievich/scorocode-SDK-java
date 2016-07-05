package ru.scorocode.android.model;

import android.util.Base64;

import java.io.InputStream;
import java.util.Scanner;

import ru.scorocode.android.main.SCCallback;
import ru.scorocode.android.manager.FileManager;

public class File {

    public void save(SCCallback<String> callback, String fileName, String coll, String doc, String field, InputStream contentStream) {
        FileManager fileManager = new FileManager();
        String contentString = convertStreamToString(contentStream);
        fileManager.upload(callback, fileName, coll, doc, field, contentString);
    }

    public static String convertStreamToString(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
        String result = scanner.hasNext() ? scanner.next() : "";
        byte[] bytesEncoded = Base64.encode(result.getBytes(), Base64.DEFAULT);
        return new String(bytesEncoded);
    }

}
