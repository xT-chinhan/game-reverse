package com.bykv.vk.component.ttvideo.utils;

import android.content.Context;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class AVCrashUtil {
    public static void deleteCrashFile(Context context, String str) {
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static boolean existsCrashFile(Context context, String str) {
        if (context == null && str == null) {
            return false;
        }
        return new File(str).exists();
    }

    public static String getBase64SampleCrash(String str) {
        return Base64.encodeToString(str.getBytes(), 0);
    }

    public static String getCrashFileContext(Context context, String str, StringBuilder sb) {
        FileInputStream fileInputStream;
        if (context == null || str == null) {
            sb.append("context or path is null.\r\n");
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            sb.append("file not exist.path:").append(str).append("\r\n");
            return null;
        }
        if (file.length() == 0) {
            sb.append("file size is zore.\r\n");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            fileInputStream = new FileInputStream(file);
            try {
                compress(fileInputStream, byteArrayOutputStream);
                fileInputStream.close();
                String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                byteArrayOutputStream.close();
                return strEncodeToString;
            } catch (Exception e) {
                e = e;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                }
                sb.append("gzip file is error.error:").append(e.getMessage());
                return null;
            }
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
        }
    }

    public static void compress(InputStream inputStream, OutputStream outputStream) throws Exception {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        byte[] bArr = new byte[10240];
        while (true) {
            int i = inputStream.read(bArr, 0, 10240);
            if (i != -1) {
                gZIPOutputStream.write(bArr, 0, i);
            } else {
                gZIPOutputStream.flush();
                gZIPOutputStream.finish();
                gZIPOutputStream.close();
                return;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:52:0x008b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x008d A[Catch: IOException -> 0x0089, TRY_LEAVE, TryCatch #7 {IOException -> 0x0089, blocks: (B:49:0x0085, B:53:0x008d), top: B:82:0x0085 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x009e A[Catch: IOException -> 0x009a, TRY_LEAVE, TryCatch #0 {IOException -> 0x009a, blocks: (B:59:0x0096, B:63:0x009e), top: B:76:0x0096 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x00af A[Catch: IOException -> 0x00ab, TRY_LEAVE, TryCatch #6 {IOException -> 0x00ab, blocks: (B:69:0x00a7, B:73:0x00af), top: B:80:0x00a7 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static final boolean copyFile(String str, String str2, boolean z, boolean z2) throws Throwable {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        File file = new File(str2);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        File file2 = new File(str);
        if (file2.exists()) {
            if (z) {
                new File(str).delete();
            }
        } else if (!file2.getParentFile().exists() && !file2.getParentFile().mkdirs()) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, i);
                    }
                    fileOutputStream.close();
                    fileInputStream.close();
                    if (z2) {
                        file.delete();
                    }
                    try {
                        fileOutputStream.close();
                        fileInputStream.close();
                        return true;
                    } catch (IOException e) {
                        return true;
                    }
                } catch (FileNotFoundException e2) {
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                        } catch (IOException e3) {
                            return false;
                        }
                    } else if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return false;
                } catch (IOException e4) {
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                        } catch (IOException e5) {
                            return false;
                        }
                    } else if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                        } catch (IOException e6) {
                            throw th;
                        }
                    } else if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (FileNotFoundException e7) {
            } catch (IOException e8) {
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                th = th;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                } else if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (FileNotFoundException e9) {
            fileInputStream = null;
        } catch (IOException e10) {
            fileInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            fileOutputStream = null;
        }
    }

    public static final boolean moveFile(String str, String str2, boolean z) {
        return copyFile(str, str2, z, true);
    }
}
