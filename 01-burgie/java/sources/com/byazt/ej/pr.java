package com.byazt.ej;

import com.byazt.ca.uc;
import com.byazt.sd.a;
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
@com.byazt.vzx.pr(pr = {0, 1, 1888, 37})
public final class pr {
    public static byte[] pr(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            return pr(new FileInputStream(file));
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean pr(InputStream inputStream, String str, String str2, long j) throws Throwable {
        File file;
        File file2;
        if (inputStream == null) {
            return false;
        }
        long j2 = 0;
        long j3 = j != -2147483648L ? 1048576 * j : 1099511627776L;
        FileOutputStream fileOutputStream = null;
        try {
            File file3 = new File(str);
            if (!file3.exists() && !file3.mkdirs()) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e) {
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
                        j2 += (long) i;
                    }
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    inputStream.close();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e2) {
                            return true;
                        }
                    }
                    if (j == -2147483648L || j2 <= j3) {
                        return true;
                    }
                    file2.delete();
                    return false;
                } catch (Exception e3) {
                    fileOutputStream = fileOutputStream2;
                } catch (Throwable th) {
                    file = file2;
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e4) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e5) {
                            throw th;
                        }
                    }
                    if (j == -2147483648L || j2 <= j3 || file == null) {
                        throw th;
                    }
                    file.delete();
                    return false;
                }
            } catch (Exception e6) {
            } catch (Throwable th2) {
                file = file2;
                th = th2;
            }
        } catch (Exception e7) {
            file2 = null;
        } catch (Throwable th3) {
            th = th3;
            file = null;
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e8) {
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
                if (j != -2147483648L && j2 > j3 && file2 != null) {
                    file2.delete();
                    return false;
                }
            } catch (Exception e9) {
            }
        } else if (j != -2147483648L) {
            file2.delete();
            return false;
        }
        return false;
    }

    public static void hw(String str) throws Exception {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            int length = fileArrListFiles.length;
            for (int i = 0; i < length; i++) {
                if (fileArrListFiles[i].isDirectory()) {
                    hw(fileArrListFiles[i].getAbsolutePath());
                } else {
                    fileArrListFiles[i].delete();
                }
            }
            file.delete();
        }
    }

    public static byte[] pr(InputStream inputStream) {
        if (inputStream == null) {
            return new byte[0];
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            pr(bufferedInputStream, byteArrayOutputStream, 2048);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            return new byte[0];
        } finally {
            try {
                bufferedInputStream.close();
                byteArrayOutputStream.close();
            } catch (Exception e2) {
            }
        }
    }

    private static long pr(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
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

    public static JSONObject hn(String str) {
        File fileX = uc.x(a.getContext(), false, null);
        if (fileX != null) {
            File file = new File(fileX, str);
            if (file.exists()) {
                try {
                    return new JSONObject(new String(pr(new FileInputStream(file.getAbsoluteFile()))));
                } catch (Exception e) {
                }
            }
        }
        return null;
    }
}
