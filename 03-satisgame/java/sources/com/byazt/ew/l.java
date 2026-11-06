package com.byazt.ew;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;
import com.anythink.china.b.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE, 18})
public class l {
    public static int cp = 16;
    public static int d = 32;
    public static int fs = 2;
    public static long l = 15360;
    public static String n = "images";
    public static int q = 30;
    public static String qg = null;
    public static int rv = 4;
    public static int s = 1;
    public static int tj = 8;
    public static int w = 0;
    public static int x = 1;

    public static boolean n(Context context, String str) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr.length > 0) {
                for (String str2 : strArr) {
                    if (str.equals(str2)) {
                        return true;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static File n() {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), Environment.DIRECTORY_DCIM + File.separator + n);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "JPG_Playable_Photo.jpg");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            qg = file2.getAbsolutePath();
            return file2;
        } catch (IOException unused) {
            return null;
        }
    }

    public static File n(String str) {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), Environment.DIRECTORY_DCIM + File.separator + "Camera");
            if (!file.exists()) {
                file.mkdirs();
            }
            Calendar calendar = Calendar.getInstance();
            File file2 = new File(file, (calendar.get(12) + "_" + calendar.get(13) + "_" + calendar.get(14)) + "_" + str);
            if (!file2.exists()) {
                file2.createNewFile();
            }
            return file2;
        } catch (IOException unused) {
            return null;
        }
    }

    public static Bitmap qg(String str) {
        byte[] bArrDecode = Base64.decode(str, 2);
        return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
    }

    public static File n(String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            File fileN = n(str);
            if (fileN != null && fileN.exists()) {
                byte[] bArrDecode = Base64.decode(str2, 2);
                fileOutputStream = new FileOutputStream(fileN);
                try {
                    fileOutputStream.write(bArrDecode, 0, bArrDecode.length);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                    }
                    return fileN;
                } catch (IOException unused2) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            }
            return null;
        } catch (IOException unused5) {
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean n(Context context, int i) {
        boolean zN;
        boolean zN2;
        if (w == 0) {
            if (Build.VERSION.SDK_INT >= 33) {
                zN = n(context, "android.permission.READ_MEDIA_IMAGES");
                zN2 = true;
            } else {
                zN = n(context, "android.permission.READ_EXTERNAL_STORAGE");
                zN2 = n(context, c.b);
            }
            boolean zN3 = n(context, "android.permission.CAMERA");
            boolean zN4 = n(context, "android.permission.RECORD_AUDIO");
            PackageManager packageManager = context.getPackageManager();
            if (zN && zN2) {
                w |= x;
            }
            if (zN3 && packageManager.hasSystemFeature("android.hardware.camera")) {
                w |= fs;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.gyroscope")) {
                w |= rv;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.accelerometer")) {
                w |= tj;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.compass")) {
                w |= cp;
            }
            if (zN4 && packageManager.hasSystemFeature("android.hardware.microphone")) {
                w |= d;
            }
        }
        return (w & i) != 0;
    }

    public static boolean n(Context context) {
        boolean z;
        boolean z2;
        if (Build.VERSION.SDK_INT >= 33) {
            z = context.checkSelfPermission("android.permission.READ_MEDIA_IMAGES") == 0;
        } else {
            z = context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0;
            if (context.checkSelfPermission(c.b) != 0) {
                z2 = false;
            }
            return !z2 && z;
        }
        z2 = true;
        if (z2) {
        }
    }

    public static boolean qg(Context context, String str) {
        return context.checkSelfPermission(str) == 0;
    }
}
