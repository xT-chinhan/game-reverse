package com.byazt.xu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 91, 8})
public class s {
    public static void n(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static File n(File file, String str) throws Throwable {
        File file2;
        ZipOutputStream zipOutputStream = null;
        try {
            try {
                file2 = new File(file.getParentFile(), str);
                try {
                    if (file.exists() && file.isDirectory()) {
                        ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(file2));
                        try {
                            for (File file3 : file.listFiles()) {
                                zipOutputStream2.putNextEntry(new ZipEntry(file3.getName()));
                                n(zipOutputStream2, file3);
                                zipOutputStream2.closeEntry();
                            }
                            zipOutputStream2.flush();
                        } catch (IOException unused) {
                        } catch (Throwable th) {
                            th = th;
                            zipOutputStream = zipOutputStream2;
                            n(zipOutputStream);
                            throw th;
                        }
                        zipOutputStream = zipOutputStream2;
                    }
                } catch (IOException unused2) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused3) {
            file2 = null;
        }
        n(zipOutputStream);
        return file2;
    }

    public static boolean n(String str, File file) throws Throwable {
        BufferedWriter bufferedWriter = null;
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
            try {
                bufferedWriter2.write(str);
                bufferedWriter2.flush();
                n(bufferedWriter2);
                return true;
            } catch (FileNotFoundException | IOException unused) {
                bufferedWriter = bufferedWriter2;
                n(bufferedWriter);
                return false;
            } catch (Throwable th) {
                th = th;
                bufferedWriter = bufferedWriter2;
                n(bufferedWriter);
                throw th;
            }
        } catch (FileNotFoundException | IOException unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String n(File file) {
        if (file != null && file.exists() && file.isFile()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                        sb.append(System.lineSeparator());
                    }
                    if (sb.length() > 0) {
                        sb.setLength(sb.length() - System.lineSeparator().length());
                    }
                    String strTrim = sb.toString().trim();
                    bufferedReader.close();
                    return strTrim;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static void n(OutputStream outputStream, File file) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1048576];
                while (true) {
                    int i = fileInputStream2.read(bArr);
                    if (i != -1) {
                        outputStream.write(bArr, 0, i);
                    } else {
                        n(fileInputStream2);
                        return;
                    }
                }
            } catch (FileNotFoundException unused) {
                fileInputStream = fileInputStream2;
                n(fileInputStream);
            } catch (IOException unused2) {
                fileInputStream = fileInputStream2;
                n(fileInputStream);
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                n(fileInputStream);
                throw th;
            }
        } catch (FileNotFoundException unused3) {
        } catch (IOException unused4) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void qg(File file) {
        if (file.isDirectory()) {
            s(file);
        } else {
            file.delete();
        }
    }

    private static void s(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                qg(file2);
            }
        }
    }
}
