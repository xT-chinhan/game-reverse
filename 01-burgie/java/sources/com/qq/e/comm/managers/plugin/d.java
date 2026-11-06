package com.qq.e.comm.managers.plugin;

import com.bumptech.glide.load.Key;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.umeng.analytics.pro.an;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
class d {
    private static final String[] a = {"0", "1", "2", GlobalSetting.SPLASH_AD, GlobalSetting.NATIVE_EXPRESS_AD, GlobalSetting.REWARD_VIDEO_AD, GlobalSetting.NATIVE_UNIFIED_AD, GlobalSetting.UNIFIED_BANNER_AD, GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD, GlobalSetting.UNIFIED_INTERSTITIAL_FS_AD, an.av, "b", an.aF, "d", "e", "f"};

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(a(b));
        }
        return stringBuffer.toString();
    }

    private static String a(byte b) {
        int i = b;
        if (b < 0) {
            i = b + 256;
        }
        int i2 = i / 16;
        StringBuilder sb = new StringBuilder();
        String[] strArr = a;
        return sb.append(strArr[i2]).append(strArr[i % 16]).toString();
    }

    public static String a(File file) throws Throwable {
        if (file != null && file.exists()) {
            FileInputStream fileInputStream = null;
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int i = fileInputStream2.read(bArr);
                        if (i <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i);
                    }
                    String strA = a(messageDigest.digest());
                    try {
                        fileInputStream2.close();
                    } catch (Exception e) {
                    }
                    return strA;
                } catch (Exception e2) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e3) {
                        }
                    }
                    return "";
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return "";
    }

    public static String a(String str) {
        try {
            String str2 = new String(str);
            try {
                return a(MessageDigest.getInstance("MD5").digest(str2.getBytes(Key.STRING_CHARSET_NAME)));
            } catch (Exception e) {
                return str2;
            }
        } catch (Exception e2) {
            return null;
        }
    }
}
