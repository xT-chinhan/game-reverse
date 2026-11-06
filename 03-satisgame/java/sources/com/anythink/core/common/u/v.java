package com.anythink.core.common.u;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class v {
    /* JADX WARN: Code duplicated, block: B:18:0x0054 A[PHI: r1
      0x0054: PHI (r1v2 java.io.File) = (r1v1 java.io.File), (r1v1 java.io.File), (r1v8 java.io.File) binds: [B:9:0x000f, B:11:0x0015, B:16:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
    public static File a(Context context) {
        File fileB;
        File file;
        try {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                fileB = b(externalFilesDir);
                if (fileB != null) {
                    return fileB;
                }
            } else {
                fileB = null;
            }
        } catch (Throwable unused) {
        }
        if (fileB == null && c(context)) {
            fileB = b(new File(Environment.getExternalStorageDirectory().getPath() + File.separator + context.getPackageName()));
            file = (e(context) > 31457280L ? 1 : (e(context) == 31457280L ? 0 : -1)) > 0 ? fileB : null;
        }
        return file == null ? new File(context.getFilesDir().getAbsoluteFile().getAbsolutePath()) : file;
    }

    private static File b(File file) {
        File file2 = new File(file, new StringBuilder().append(UUID.randomUUID()).toString());
        if (file2.exists()) {
            file2.delete();
        }
        if (!file2.mkdirs()) {
            return null;
        }
        file2.delete();
        return file.getAbsoluteFile();
    }

    private static boolean c(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().checkPermission(com.anythink.china.b.c.b, context.getPackageName()) == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean d(Context context) {
        return e(context) > 31457280;
    }

    private static boolean a() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    private static String b(String str) {
        return n.a(str);
    }

    public static long a(String str) {
        long jC = 0;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        File file = new File(str);
        if (!file.exists()) {
            return 0L;
        }
        try {
            if (file.isDirectory()) {
                jC = d(file);
            } else {
                jC = c(file);
            }
        } catch (Throwable unused) {
        }
        return jC;
    }

    private static long c(File file) throws Throwable {
        long jAvailable = 0;
        FileInputStream fileInputStream = null;
        try {
            try {
                try {
                    if (file.exists()) {
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        try {
                            jAvailable = fileInputStream2.available();
                            fileInputStream = fileInputStream2;
                        } catch (Exception e) {
                            e = e;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return jAvailable;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } else {
                        file.createNewFile();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            return jAvailable;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static long d(File file) throws Throwable {
        long jC;
        File[] fileArrListFiles = file.listFiles();
        long j = 0;
        if (fileArrListFiles != null) {
            for (int i = 0; i < fileArrListFiles.length; i++) {
                if (fileArrListFiles[i].isDirectory()) {
                    jC = d(fileArrListFiles[i]);
                } else {
                    jC = c(fileArrListFiles[i]);
                }
                j += jC;
            }
        }
        return j;
    }

    public static boolean a(byte[] bArr, File file) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (file.getParentFile() != null && !file.exists()) {
                    file.getParentFile().mkdirs();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    try {
                        fileOutputStream2.close();
                        return true;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return true;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream == null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0043  */
    /* JADX WARN: Code duplicated, block: B:25:0x0048 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String a(File file) throws Throwable {
        StringBuffer stringBuffer;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                try {
                    stringBuffer = new StringBuffer();
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            stringBuffer.append(line + "\n");
                        } catch (IOException e) {
                            e = e;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException unused) {
                                }
                            }
                            if (stringBuffer != null) {
                                return stringBuffer.toString();
                            }
                            return null;
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    stringBuffer = null;
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            stringBuffer = null;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw th;
        }
        bufferedReader.close();
        if (stringBuffer != null) {
            return stringBuffer.toString();
        }
        return null;
    }

    public static String b(Context context) {
        return context.getFilesDir().getAbsolutePath() + "/tktp/";
    }

    private static long e(Context context) {
        if ("mounted".equals(Environment.getExternalStorageState()) && c(context)) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            } catch (Error unused) {
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }
}
