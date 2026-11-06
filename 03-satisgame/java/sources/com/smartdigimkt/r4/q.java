package com.smartdigimkt.r4;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public abstract class q {
    /* JADX WARN: Code duplicated, block: B:49:0x0100 A[PHI: r3
      0x0100: PHI (r3v2 java.io.File) = (r3v1 java.io.File), (r3v1 java.io.File), (r3v10 java.io.File) binds: [B:29:0x0065, B:31:0x006b, B:48:0x00fe] A[DONT_GENERATE, DONT_INLINE]] */
    public static File a(Context context) {
        File absoluteFile;
        File file;
        if (context == null) {
            return new File("");
        }
        try {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                File file2 = new File(externalFilesDir, UUID.randomUUID() + "");
                if (file2.exists()) {
                    file2.delete();
                }
                if (file2.mkdirs()) {
                    file2.delete();
                    absoluteFile = externalFilesDir.getAbsoluteFile();
                } else {
                    absoluteFile = null;
                }
                if (absoluteFile != null) {
                    try {
                        String path = absoluteFile.getPath();
                        if (path != null && !path.isEmpty()) {
                            File file3 = new File(absoluteFile, "sdm_adx_rp_files");
                            if (!file3.exists()) {
                                file3.mkdirs();
                            }
                            return file3;
                        }
                        return absoluteFile;
                    } catch (Throwable unused) {
                    }
                }
            } else {
                absoluteFile = null;
            }
        } catch (Throwable unused2) {
        }
        if (absoluteFile == null && b(context)) {
            File file4 = new File(Environment.getExternalStorageDirectory().getPath() + File.separator + context.getPackageName());
            File file5 = new File(file4, UUID.randomUUID() + "");
            if (file5.exists()) {
                file5.delete();
            }
            if (file5.mkdirs()) {
                file5.delete();
                absoluteFile = file4.getAbsoluteFile();
            } else {
                absoluteFile = null;
            }
            long availableBlocks = 0;
            if ("mounted".equals(Environment.getExternalStorageState()) && b(context)) {
                try {
                    StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                    availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
                } catch (Error unused3) {
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            file = availableBlocks > 31457280 ? absoluteFile : null;
        }
        if (file == null) {
            File filesDir = context.getFilesDir();
            if (filesDir == null) {
                return new File("");
            }
            file = new File(filesDir.getAbsoluteFile().getAbsolutePath());
        }
        String path2 = file.getPath();
        if (path2 == null || path2.isEmpty()) {
            return file;
        }
        File file6 = new File(file, "sdm_adx_rp_files");
        if (!file6.exists()) {
            file6.mkdirs();
        }
        return file6;
    }

    public static boolean b(Context context) {
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

    /* JADX WARN: Code duplicated, block: B:25:0x0049  */
    /* JADX WARN: Code duplicated, block: B:27:0x004e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    public static String c(File file) throws Throwable {
        IOException e;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                try {
                    try {
                        file = new StringBuffer();
                        while (true) {
                            try {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                file.append(line + "\n");
                            } catch (IOException e2) {
                                e = e2;
                                try {
                                    e.printStackTrace();
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                        file = file;
                                    }
                                    if (file != 0) {
                                        return file.toString();
                                    }
                                    return null;
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedReader2 = bufferedReader;
                                    bufferedReader = bufferedReader2;
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException unused) {
                                        }
                                    }
                                    throw th;
                                }
                            }
                        }
                        bufferedReader.close();
                        file = file;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    file = 0;
                }
            } catch (IOException unused2) {
            }
        } catch (IOException e4) {
            e = e4;
            file = 0;
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = bufferedReader2;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
        if (file != 0) {
            return file.toString();
        }
        return null;
    }

    public static long b(File file) throws Throwable {
        long jA;
        File[] fileArrListFiles = file.listFiles();
        long j = 0;
        if (fileArrListFiles != null) {
            for (int i = 0; i < fileArrListFiles.length; i++) {
                if (fileArrListFiles[i].isDirectory()) {
                    jA = b(fileArrListFiles[i]);
                } else {
                    jA = a(fileArrListFiles[i]);
                }
                j = jA + j;
            }
        }
        return j;
    }

    public static long a(File file) throws Throwable {
        FileInputStream fileInputStream;
        long jAvailable = 0;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    if (file.exists()) {
                        fileInputStream = new FileInputStream(file);
                        try {
                            jAvailable = fileInputStream.available();
                            fileInputStream2 = fileInputStream;
                        } catch (Exception e) {
                            e = e;
                            fileInputStream2 = fileInputStream;
                            e.printStackTrace();
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            return jAvailable;
                        } catch (Throwable th) {
                            th = th;
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
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            } catch (Exception e4) {
                e = e4;
            }
            return jAvailable;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static void a(byte[] bArr, File file) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (file.getParentFile() != null && !file.exists()) {
                    file.getParentFile().mkdirs();
                }
                fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(bArr);
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream2 = fileOutputStream;
                    e.printStackTrace();
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
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
            fileOutputStream = fileOutputStream2;
        }
    }
}
