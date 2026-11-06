package com.byazt.eq;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 661, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static String pr = "images";
    public static String hw = null;
    public static int hn = 1;
    public static int x = 30;
    public static long c = 15360;
    public static int uc = 0;
    public static int fw = 1;
    public static int zo = 2;
    public static int aj = 4;
    public static int vk = 8;
    public static int w = 16;
    public static int k = 32;

    public static boolean pr(Context context, String str) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr.length > 0) {
                for (String str2 : strArr) {
                    if (str.equals(str2)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static File pr() {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), Environment.DIRECTORY_DCIM + File.separator + pr);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "JPG_Playable_Photo.jpg");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            hw = file2.getAbsolutePath();
            return file2;
        } catch (IOException e) {
            return null;
        }
    }

    public static File pr(String str) {
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
        } catch (IOException e) {
            return null;
        }
    }

    public static Bitmap hw(String str) {
        byte[] bArrDecode = Base64.decode(str, 2);
        return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
    }

    public static File pr(String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            File filePr = pr(str);
            if (filePr != null && filePr.exists()) {
                byte[] bArrDecode = Base64.decode(str2, 2);
                fileOutputStream = new FileOutputStream(filePr);
                try {
                    fileOutputStream.write(bArrDecode, 0, bArrDecode.length);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                    }
                    return filePr;
                } catch (IOException e2) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            }
            return null;
        } catch (IOException e5) {
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean pr(Context context, int i) {
        boolean zPr;
        boolean zPr2;
        if (uc == 0) {
            if (Build.VERSION.SDK_INT >= 33) {
                zPr = pr(context, "android.permission.READ_MEDIA_IMAGES");
                zPr2 = true;
            } else {
                zPr = pr(context, "android.permission.READ_EXTERNAL_STORAGE");
                zPr2 = pr(context, "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            boolean zPr3 = pr(context, "android.permission.CAMERA");
            boolean zPr4 = pr(context, "android.permission.RECORD_AUDIO");
            PackageManager packageManager = context.getPackageManager();
            if (zPr && zPr2) {
                uc |= fw;
            }
            if (zPr3 && packageManager.hasSystemFeature("android.hardware.camera")) {
                uc |= zo;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.gyroscope")) {
                uc |= aj;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.accelerometer")) {
                uc |= vk;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.compass")) {
                uc |= w;
            }
            if (zPr4 && packageManager.hasSystemFeature("android.hardware.microphone")) {
                uc |= k;
            }
        }
        return (uc & i) != 0;
    }

    public static boolean pr(Context context) {
        boolean z;
        boolean z2;
        if (Build.VERSION.SDK_INT >= 33) {
            z = context.checkSelfPermission("android.permission.READ_MEDIA_IMAGES") == 0;
            z2 = true;
        } else {
            z = context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0;
            z2 = context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
        }
        return z2 && z;
    }

    public static boolean hw(Context context, String str) {
        return context.checkSelfPermission(str) == 0;
    }
}
