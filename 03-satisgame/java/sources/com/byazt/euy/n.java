package com.byazt.euy;

import com.byazt.nf.rv;
import com.byazt.tk.w;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1567, 19})
public final class n {
    public static byte[] n(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            return n(new FileInputStream(file));
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean n(InputStream inputStream, String str, String str2, long j) throws Throwable {
        File file;
        File file2;
        if (inputStream == null) {
            return false;
        }
        long j2 = j != -2147483648L ? j * 1048576 : 1099511627776L;
        FileOutputStream fileOutputStream = null;
        long j3 = 0;
        try {
            File file3 = new File(str);
            if (!file3.exists() && !file3.mkdirs()) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            file2 = new File(file3, str2);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, i);
                        j3 += (long) i;
                    }
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    inputStream.close();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused2) {
                            return true;
                        }
                    }
                    if (j == -2147483648L || j3 <= j2) {
                        return true;
                    }
                    file2.delete();
                    return false;
                } catch (Exception unused3) {
                    fileOutputStream = fileOutputStream2;
                } catch (Throwable th) {
                    file = file2;
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused4) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused5) {
                            throw th;
                        }
                    }
                    if (j == -2147483648L || j3 <= j2 || file == null) {
                        throw th;
                    }
                    file.delete();
                    return false;
                }
            } catch (Exception unused6) {
            } catch (Throwable th2) {
                file = file2;
                th = th2;
            }
        } catch (Exception unused7) {
            file2 = null;
        } catch (Throwable th3) {
            th = th3;
            file = null;
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception unused8) {
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
                if (j != -2147483648L && j3 > j2 && file2 != null) {
                    file2.delete();
                }
            } catch (Exception unused9) {
            }
        } else if (j != -2147483648L) {
            file2.delete();
        }
        return false;
    }

    public static void qg(String str) throws Exception {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            int length = fileArrListFiles.length;
            for (int i = 0; i < length; i++) {
                if (fileArrListFiles[i].isDirectory()) {
                    qg(fileArrListFiles[i].getAbsolutePath());
                } else {
                    fileArrListFiles[i].delete();
                }
            }
            file.delete();
        }
    }

    public static byte[] n(InputStream inputStream) {
        if (inputStream == null) {
            return new byte[0];
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                n(bufferedInputStream, byteArrayOutputStream, 2048);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    bufferedInputStream.close();
                    byteArrayOutputStream.close();
                } catch (Exception unused) {
                }
                return byteArray;
            } catch (Exception unused2) {
                return new byte[0];
            }
        } catch (IOException unused3) {
            bufferedInputStream.close();
            byteArrayOutputStream.close();
            return new byte[0];
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
                byteArrayOutputStream.close();
            } catch (Exception unused4) {
            }
            throw th;
        }
    }

    private static long n(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = inputStream.read(bArr);
        long j = 0;
        while (i2 >= 0) {
            outputStream.write(bArr, 0, i2);
            j += (long) i2;
            i2 = inputStream.read(bArr);
        }
        return j;
    }

    public static JSONObject s(String str) {
        File fileQ = w.q(rv.getContext(), false, null);
        if (fileQ != null) {
            File file = new File(fileQ, str);
            if (file.exists()) {
                try {
                    return new JSONObject(new String(n(new FileInputStream(file.getAbsoluteFile()))));
                } catch (Exception unused) {
                }
            }
        }
        return null;
    }
}
