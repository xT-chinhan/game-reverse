package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.os.Build;
import com.bumptech.glide.load.Key;
import com.qq.e.comm.util.GDTLogger;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* JADX INFO: loaded from: classes2.dex */
class h {
    private static String a = i.a("e_qq_com_plugin");
    private static String b = i.a("e_qq_com_dex");

    public static boolean a(InputStream inputStream, File file) throws Throwable {
        if (inputStream == null || file == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                GDTLogger.e("parent dir not exists " + parentFile.getAbsolutePath());
                a(inputStream);
                a((Closeable) null);
                return false;
            }
            if (!file.canWrite()) {
                file.setWritable(true);
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i <= 0) {
                        a(inputStream);
                        a(fileOutputStream2);
                        return true;
                    }
                    fileOutputStream2.write(bArr, 0, i);
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                try {
                    GDTLogger.e("Exception while copy from InputStream to File", th);
                    throw th;
                } catch (Throwable th2) {
                    a(inputStream);
                    a(fileOutputStream);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    static String b() {
        return "gdtadv2.jar";
    }

    static File c(Context context) {
        return new File(d(context), "gdt_plugin.next.sig");
    }

    static File d(Context context) {
        return context.getDir(a, 0);
    }

    static File e(Context context) {
        return new File(d(context), "gdt_plugin.jar.sig");
    }

    static String a() {
        return "gdt_plugin";
    }

    static File b(Context context) {
        return new File(d(context), "gdt_plugin.next");
    }

    static File a(Context context) {
        return context.getDir(b, 0);
    }

    static File a(Context context, int i) {
        File file = a(i) ? new File(d(context), String.valueOf(i)) : d(context);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, "gdt_plugin.jar");
    }

    private static boolean a(int i) {
        return i > 0 && i < 10000;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v4 */
    static String a(File file) throws Throwable {
        if (file != 0) {
            try {
                if (file.exists()) {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream((File) file), Key.STRING_CHARSET_NAME));
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                sb.append(line);
                            }
                            String string = sb.toString();
                            try {
                                bufferedReader.close();
                            } catch (Exception e) {
                            }
                            return string;
                        } catch (IOException e2) {
                            throw e2;
                        }
                    } catch (IOException e3) {
                        throw e3;
                    } catch (Throwable th) {
                        th = th;
                        file = 0;
                        if (file != 0) {
                            try {
                                file.close();
                            } catch (Exception e4) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    public static boolean a(File file, File file2, Context context, boolean z) {
        if (file == null || file2 == null || !file.exists()) {
            return false;
        }
        if (file.renameTo(file2)) {
            if (z) {
                return a(file2, context);
            }
            return true;
        }
        try {
            boolean zA = a(new FileInputStream(file), file2);
            if (z) {
                return zA && a(file2, context);
            }
            return zA;
        } catch (Throwable th) {
            return false;
        }
    }

    static boolean a(File file, Context context) {
        if (Build.VERSION.SDK_INT < 34 || context == null || context.getApplicationInfo() == null || context.getApplicationInfo().targetSdkVersion < 34) {
            return true;
        }
        return file.setReadOnly();
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }

    static void a(String str, File file) throws Throwable {
        if (file == null) {
            throw new IOException("Target File Can not be null in StringUtil.writeTo");
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        OutputStreamWriter outputStreamWriter = null;
        try {
            OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(file), Key.STRING_CHARSET_NAME);
            try {
                outputStreamWriter2.write(str);
                a(outputStreamWriter2);
            } catch (Throwable th) {
                th = th;
                outputStreamWriter = outputStreamWriter2;
                a(outputStreamWriter);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
