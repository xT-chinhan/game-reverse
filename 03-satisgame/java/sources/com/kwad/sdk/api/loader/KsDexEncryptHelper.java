package com.kwad.sdk.api.loader;

import android.content.Context;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes3.dex */
public class KsDexEncryptHelper {
    public static final int DECRYPT_ERROR_IO = -102;
    public static final int DECRYPT_ERROR_WRITE_FILE = -104;
    public static final int DECRYPT_ERROR_WRITE_HEAD = -103;
    public static final int DECRYPT_RESULT_SUCCESS = 1;

    public static String getDexAesKey(Context context) {
        KsLiteApi api = KsLiteApiManager.getApi();
        if (api != null) {
            return api.getAESKey(context);
        }
        return null;
    }

    public static int decryptDexFile(Context context, String str, InputStream inputStream, String str2) throws Throwable {
        byte[] encryptedByteArray = readEncryptedByteArray(inputStream);
        try {
            boolean zWriteEncryptedByteToFile = writeEncryptedByteToFile(str, KsDexAESUtil.decrypt(str2.getBytes("UTF-8"), encryptedByteArray));
            boolean zWriteOriginalToFile = writeOriginalToFile(inputStream, str, encryptedByteArray.length + 4, true);
            if (zWriteEncryptedByteToFile && zWriteOriginalToFile) {
                return 1;
            }
            return zWriteEncryptedByteToFile ? DECRYPT_ERROR_WRITE_FILE : DECRYPT_ERROR_WRITE_HEAD;
        } catch (UnsupportedEncodingException e) {
            ApiLogger.printStackTrace(e);
            return DECRYPT_ERROR_IO;
        }
    }

    private static byte[] readEncryptedByteArray(InputStream inputStream) {
        try {
            byte[] bArr = new byte[4];
            inputStream.read(bArr, 0, 4);
            int iByteArrayToInt = byteArrayToInt(bArr);
            byte[] bArr2 = new byte[iByteArrayToInt];
            int i = inputStream.read(bArr2, 0, iByteArrayToInt);
            if (i > 0) {
                System.out.println("readEncryptedByteArray bytes content: " + i);
                return bArr2;
            }
            System.out.println("readEncryptedByteArray File is empty.");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean writeEncryptedByteToFile(String str, byte[] bArr) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                file.setWritable(true);
                file.setReadable(true);
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                try {
                    fileOutputStream2.write(bArr);
                    System.out.println("writeEncryptedByteToFile successfully.");
                    closeQuietly(fileOutputStream2);
                    return true;
                } catch (IOException e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    closeQuietly(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    private static boolean writeOriginalToFile(InputStream inputStream, String str, int i, boolean z) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(str, z);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i2 = inputStream.read(bArr);
                        if (i2 != -1) {
                            fileOutputStream2.write(bArr, 0, i2);
                        } else {
                            System.out.println("File copied successfully.");
                            closeQuietly(fileOutputStream2);
                            return true;
                        }
                    }
                } catch (IOException e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    closeQuietly(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static int byteArrayToInt(byte[] bArr) {
        int i = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).getInt();
        System.out.println("Converted int: " + Integer.toHexString(i));
        return i;
    }

    private static byte[] intToByteArray(int i) {
        byte[] bArrArray = ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(i).array();
        System.out.println("Byte array: " + ((int) bArrArray[0]) + ", " + ((int) bArrArray[1]) + ", " + ((int) bArrArray[2]) + ", " + ((int) bArrArray[3]));
        return bArrArray;
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
