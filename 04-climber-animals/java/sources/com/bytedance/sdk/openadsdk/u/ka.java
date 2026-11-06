package com.bytedance.sdk.openadsdk.u;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;
import com.bytedance.sdk.component.utils.sl;
import com.kuaishou.weapon.p0.g;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

/* JADX INFO: loaded from: classes2.dex */
public class ka {
    public static int ab = 1;
    protected static int ah = 1;
    public static int c = 0;
    public static int ch = 8;
    protected static int d = 30;
    public static int hi = 16;
    protected static long ka = 15360;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected static String f4200ms = "images";
    public static int ny = 4;
    public static int sl = 32;
    public static int x = 2;
    protected static String xr;

    protected static boolean ms(Context context, String str) {
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

    protected static File ms() {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), Environment.DIRECTORY_DCIM + File.separator + f4200ms);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "JPG_Playable_Photo.jpg");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            xr = file2.getAbsolutePath();
            return file2;
        } catch (IOException unused) {
            return null;
        }
    }

    protected static File ms(String str) {
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

    protected static Bitmap xr(String str) {
        byte[] bArrDecode = Base64.decode(str, 2);
        return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
    }

    protected static File ms(String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            File fileMs = ms(str);
            if (fileMs != null && fileMs.exists()) {
                byte[] bArrDecode = Base64.decode(str2, 2);
                fileOutputStream = new FileOutputStream(fileMs);
                try {
                    fileOutputStream.write(bArrDecode, 0, bArrDecode.length);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        sl.ms(e);
                    }
                    return fileMs;
                } catch (IOException unused) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2) {
                            sl.ms(e2);
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e3) {
                            sl.ms(e3);
                        }
                    }
                    throw th;
                }
            }
            return null;
        } catch (IOException unused2) {
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean ms(Context context, int i) {
        boolean zMs;
        boolean zMs2;
        if (c == 0) {
            if (Build.VERSION.SDK_INT >= 33) {
                zMs = ms(context, "android.permission.READ_MEDIA_IMAGES");
                zMs2 = true;
            } else {
                zMs = ms(context, g.i);
                zMs2 = ms(context, "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            boolean zMs3 = ms(context, "android.permission.CAMERA");
            boolean zMs4 = ms(context, "android.permission.RECORD_AUDIO");
            PackageManager packageManager = context.getPackageManager();
            if (zMs && zMs2) {
                c |= ab;
            }
            if (zMs3 && packageManager.hasSystemFeature("android.hardware.camera")) {
                c |= x;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.gyroscope")) {
                c |= ny;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.accelerometer")) {
                c |= ch;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.compass")) {
                c |= hi;
            }
            if (zMs4 && packageManager.hasSystemFeature("android.hardware.microphone")) {
                c |= sl;
            }
        }
        return (c & i) != 0;
    }

    public static boolean ms(Context context) {
        boolean z;
        boolean z2;
        if (Build.VERSION.SDK_INT >= 33) {
            z = context.checkSelfPermission("android.permission.READ_MEDIA_IMAGES") == 0;
        } else {
            z = context.checkSelfPermission(g.i) == 0;
            if (context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                z2 = false;
            }
            return !z2 && z;
        }
        z2 = true;
        if (z2) {
        }
    }

    public static boolean xr(Context context, String str) {
        return context.checkSelfPermission(str) == 0;
    }
}
