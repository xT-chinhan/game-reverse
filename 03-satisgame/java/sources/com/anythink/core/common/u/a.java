package com.anythink.core.common.u;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final int a = 4096;
    private static final String b = "ATUnzipUtility";

    private static void a(ZipInputStream zipInputStream, String str) throws Throwable {
        File file = new File(str);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i = zipInputStream.read(bArr);
                        if (i != -1) {
                            bufferedOutputStream2.write(bArr, 0, i);
                        } else {
                            bufferedOutputStream2.close();
                            return;
                        }
                    }
                } catch (IOException e) {
                    e = e;
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    public static int a(String str, String str2) {
        FileOutputStream fileOutputStream;
        String canonicalPath;
        if (str == null || str2 == null) {
            return -1;
        }
        if (!str2.endsWith("/")) {
            str2 = str2 + "/";
        }
        File file = new File(str);
        if (!file.exists()) {
            return 1;
        }
        InputStream inputStream = null;
        try {
            ZipFile zipFile = new ZipFile(file);
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            FileOutputStream fileOutputStream2 = null;
            while (enumerationEntries.hasMoreElements()) {
                try {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    if (zipEntryNextElement == null) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused) {
                            }
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        return 2;
                    }
                    String name = zipEntryNextElement.getName();
                    if (!TextUtils.isEmpty(name) && !name.startsWith("..") && !name.startsWith("../")) {
                        File file2 = new File(str2 + name);
                        try {
                            canonicalPath = file2.getCanonicalPath();
                        } catch (IOException unused3) {
                            canonicalPath = "";
                        }
                        if (!TextUtils.isEmpty(canonicalPath) && canonicalPath.startsWith(str2) && !canonicalPath.startsWith("..") && !canonicalPath.startsWith("../")) {
                            if (zipEntryNextElement.isDirectory()) {
                                file2.mkdirs();
                            } else {
                                if (!file2.getParentFile().exists()) {
                                    file2.getParentFile().mkdirs();
                                }
                                fileOutputStream = new FileOutputStream(file2);
                                try {
                                    inputStream = zipFile.getInputStream(zipEntryNextElement);
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int i = inputStream.read(bArr, 0, 1024);
                                        if (i == -1) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, i);
                                        fileOutputStream.flush();
                                    }
                                    fileOutputStream2 = fileOutputStream;
                                } catch (Throwable unused4) {
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable unused5) {
                                        }
                                    }
                                    if (fileOutputStream == null) {
                                        return 3;
                                    }
                                    try {
                                        fileOutputStream.close();
                                        return 3;
                                    } catch (Throwable unused6) {
                                        return 3;
                                    }
                                }
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused7) {
                            }
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (Throwable unused8) {
                            }
                        }
                        return 2;
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused9) {
                        }
                    }
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Throwable unused10) {
                        }
                    }
                    return 2;
                } catch (Throwable unused11) {
                    fileOutputStream = fileOutputStream2;
                }
            }
            zipFile.close();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable unused12) {
                }
            }
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Throwable unused13) {
                }
            }
            return 0;
        } catch (Throwable unused14) {
            fileOutputStream = null;
        }
    }
}
