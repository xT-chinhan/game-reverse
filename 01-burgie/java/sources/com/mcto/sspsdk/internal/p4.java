package com.mcto.sspsdk.internal;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p4 {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static File b(File file) {
        new StringBuilder("findHtmlFile:file=").append(file);
        if (file == null) {
            return null;
        }
        if (file.getName().equals("index.html")) {
            return file;
        }
        if (file.isDirectory() && file.listFiles() != null) {
            for (File file2 : file.listFiles()) {
                File fileB = b(file2);
                if (fileB != null) {
                    return fileB;
                }
            }
        }
        return null;
    }

    public static boolean a(File file) {
        if (file == null) {
            return true;
        }
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (!a(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }
}
