package com.anythink.dlopt.common.c;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.anythink.core.common.d.t;
import com.anythink.dlopt.common.a.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    private static final String a = "anythink_myoffer_download";

    private static String c(String str) {
        return str;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x005b  */
    public static String a() {
        File fileB;
        if (e() == null) {
            return null;
        }
        if (g()) {
            if (!(c() > 104857600) || Build.VERSION.SDK_INT > 28) {
                fileB = null;
            } else {
                fileB = b(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + Environment.DIRECTORY_DOWNLOADS + File.separator + a));
            }
        } else {
            fileB = null;
        }
        if (fileB == null) {
            try {
                File externalFilesDir = e().getExternalFilesDir(null);
                if (externalFilesDir != null && (fileB = b(externalFilesDir)) != null) {
                    fileB = new File(fileB, a);
                }
            } catch (Throwable unused) {
            }
        }
        if (fileB == null) {
            fileB = new File(e().getFilesDir().getAbsoluteFile() + File.separator + a);
        }
        return fileB.getAbsolutePath();
    }

    private static File b(File file) {
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
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

    private static boolean b() {
        return c() > 104857600;
    }

    private static long d() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Error unused) {
            return 0L;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static String a(String str) {
        String strA = a();
        if (strA != null) {
            return strA + File.separator + str;
        }
        return null;
    }

    public static String b(String str) {
        return a(str) + com.anythink.dlopt.common.a.a.h;
    }

    public static String a(String str, int i) {
        return str + "_" + i;
    }

    private static Context e() {
        try {
            return t.b().g().getApplicationContext();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean f() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    private static boolean g() {
        Context contextE = e();
        if (contextE == null) {
            return false;
        }
        try {
            return contextE.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", contextE.getPackageName()) == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0053 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:37:0x0055 A[Catch: IOException -> 0x0051, TryCatch #6 {IOException -> 0x0051, blocks: (B:33:0x004d, B:37:0x0055, B:39:0x005a), top: B:62:0x004d }] */
    /* JADX WARN: Code duplicated, block: B:39:0x005a A[Catch: IOException -> 0x0051, TRY_LEAVE, TryCatch #6 {IOException -> 0x0051, blocks: (B:33:0x004d, B:37:0x0055, B:39:0x005a), top: B:62:0x004d }] */
    /* JADX WARN: Code duplicated, block: B:48:0x006b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x006d A[Catch: IOException -> 0x0069, TryCatch #0 {IOException -> 0x0069, blocks: (B:45:0x0065, B:49:0x006d, B:51:0x0072), top: B:55:0x0065 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0072 A[Catch: IOException -> 0x0069, TRY_LEAVE, TryCatch #0 {IOException -> 0x0069, blocks: (B:45:0x0065, B:49:0x006d, B:51:0x0072), top: B:55:0x0065 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r5v13, types: [java.io.InputStreamReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.io.InputStreamReader] */
    public static String a(File file) throws Throwable {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        Exception e;
        if (!file.exists()) {
            return "";
        }
        try {
            try {
                fileInputStream = new FileInputStream((File) file);
                try {
                    file = new InputStreamReader(fileInputStream);
                    try {
                        bufferedReader2 = new BufferedReader(file);
                        try {
                            String line = bufferedReader2.readLine();
                            try {
                                bufferedReader2.close();
                                file.close();
                                fileInputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            return line;
                        } catch (Exception e3) {
                            e = e3;
                            e.printStackTrace();
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                    if (file != 0) {
                                        file.close();
                                    }
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                    }
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                    return "";
                                }
                            } else {
                                if (file != 0) {
                                    file.close();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                            }
                            return "";
                        }
                    } catch (Exception e5) {
                        bufferedReader2 = null;
                        e = e5;
                    } catch (Throwable th) {
                        bufferedReader = null;
                        th = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                                if (file != 0) {
                                    file.close();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                            } catch (IOException e6) {
                                e6.printStackTrace();
                                throw th;
                            }
                        } else {
                            if (file != 0) {
                                file.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e7) {
                    e = e7;
                    bufferedReader2 = null;
                    e = e;
                    file = bufferedReader2;
                    e.printStackTrace();
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                        if (file != 0) {
                            file.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                    } else {
                        if (file != 0) {
                            file.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                    }
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                    th = th;
                    file = bufferedReader;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                        if (file != 0) {
                            file.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                    } else {
                        if (file != 0) {
                            file.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e8) {
            e = e8;
            fileInputStream = null;
            bufferedReader2 = null;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            bufferedReader = null;
        }
    }

    public static String a(long j, long j2, c.e eVar) {
        try {
            return j + "|" + j2 + "|" + eVar.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String[] d(String str) {
        return str.split("\\|");
    }

    private static long c() {
        if ("mounted".equals(Environment.getExternalStorageState())) {
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
