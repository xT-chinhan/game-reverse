package com.byazt.zp;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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
@com.byazt.vzx.pr(pr = {0, 1, 1229, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static void pr(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static File pr(File file, String str) throws Throwable {
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
                                pr(zipOutputStream2, file3);
                                zipOutputStream2.closeEntry();
                            }
                            zipOutputStream2.flush();
                            zipOutputStream = zipOutputStream2;
                        } catch (IOException e) {
                            zipOutputStream = zipOutputStream2;
                        } catch (Throwable th) {
                            th = th;
                            zipOutputStream = zipOutputStream2;
                            pr(zipOutputStream);
                            throw th;
                        }
                    }
                } catch (IOException e2) {
                }
            } catch (IOException e3) {
                file2 = null;
            }
            pr(zipOutputStream);
            return file2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean pr(String str, File file) throws Throwable {
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
                pr(bufferedWriter2);
                return true;
            } catch (FileNotFoundException e) {
                bufferedWriter = bufferedWriter2;
                pr(bufferedWriter);
                return false;
            } catch (IOException e2) {
                bufferedWriter = bufferedWriter2;
                pr(bufferedWriter);
                return false;
            } catch (Throwable th) {
                th = th;
                bufferedWriter = bufferedWriter2;
                pr(bufferedWriter);
                throw th;
            }
        } catch (FileNotFoundException e3) {
        } catch (IOException e4) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String pr(File file) {
        if (file == null || !file.exists() || !file.isFile()) {
            return null;
        }
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
                    return null;
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
        } catch (Exception e) {
            return null;
        }
    }

    public static void pr(OutputStream outputStream, File file) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1048576];
                while (true) {
                    int i = fileInputStream2.read(bArr);
                    if (i == -1) {
                        pr(fileInputStream2);
                        return;
                    }
                    outputStream.write(bArr, 0, i);
                }
            } catch (FileNotFoundException e) {
                fileInputStream = fileInputStream2;
                pr(fileInputStream);
            } catch (IOException e2) {
                fileInputStream = fileInputStream2;
                pr(fileInputStream);
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                pr(fileInputStream);
                throw th;
            }
        } catch (FileNotFoundException e3) {
        } catch (IOException e4) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void hw(File file) {
        if (file.isDirectory()) {
            hn(file);
        } else {
            file.delete();
        }
    }

    private static void hn(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                hw(file2);
            }
        }
    }
}
