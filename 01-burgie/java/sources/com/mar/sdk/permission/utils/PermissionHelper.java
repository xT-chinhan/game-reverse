package com.mar.sdk.permission.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.database.Cursor;
import android.hardware.Camera;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Environment;
import android.provider.ContactsContract;
import android.telephony.TelephonyManager;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.mar.sdk.log.Log;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.ar;
import com.umeng.analytics.pro.cc;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionHelper {
    public static boolean checkSelfPermission(Activity context, String permission) {
        return selfPermissionGranted(context, permission);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static boolean fuckSpecialOSPermission(Activity context, String permission) {
        Log.d("MARSDK", "check permission with special method." + permission);
        byte b = -1;
        switch (permission.hashCode()) {
            case -2062386608:
                if (permission.equals("android.permission.READ_SMS")) {
                    b = 19;
                }
                break;
            case -1928411001:
                if (permission.equals("android.permission.READ_CALENDAR")) {
                    b = 3;
                }
                break;
            case -1921431796:
                if (permission.equals("android.permission.READ_CALL_LOG")) {
                    b = 12;
                }
                break;
            case -1888586689:
                if (permission.equals("android.permission.ACCESS_FINE_LOCATION")) {
                    b = 8;
                }
                break;
            case -1479758289:
                if (permission.equals("android.permission.RECEIVE_WAP_PUSH")) {
                    b = 20;
                }
                break;
            case -1238066820:
                if (permission.equals("android.permission.BODY_SENSORS")) {
                    b = 2;
                }
                break;
            case -895679497:
                if (permission.equals("android.permission.RECEIVE_MMS")) {
                    b = 21;
                }
                break;
            case -895673731:
                if (permission.equals("android.permission.RECEIVE_SMS")) {
                    b = 18;
                }
                break;
            case -406040016:
                if (permission.equals("android.permission.READ_EXTERNAL_STORAGE")) {
                    b = 22;
                }
                break;
            case -63024214:
                if (permission.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                    b = 9;
                }
                break;
            case -5573545:
                if (permission.equals("android.permission.READ_PHONE_STATE")) {
                    b = 10;
                }
                break;
            case 52602690:
                if (permission.equals("android.permission.SEND_SMS")) {
                    b = 17;
                }
                break;
            case 112197485:
                if (permission.equals("android.permission.CALL_PHONE")) {
                    b = 11;
                }
                break;
            case 214526995:
                if (permission.equals("android.permission.WRITE_CONTACTS")) {
                    b = 6;
                }
                break;
            case 463403621:
                if (permission.equals("android.permission.CAMERA")) {
                    b = 0;
                }
                break;
            case 603653886:
                if (permission.equals("android.permission.WRITE_CALENDAR")) {
                    b = 4;
                }
                break;
            case 610633091:
                if (permission.equals("android.permission.WRITE_CALL_LOG")) {
                    b = cc.k;
                }
                break;
            case 784519842:
                if (permission.equals("android.permission.USE_SIP")) {
                    b = cc.m;
                }
                break;
            case 952819282:
                if (permission.equals("android.permission.PROCESS_OUTGOING_CALLS")) {
                    b = cc.n;
                }
                break;
            case 1271781903:
                if (permission.equals("android.permission.GET_ACCOUNTS")) {
                    b = 7;
                }
                break;
            case 1365911975:
                if (permission.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                    b = 23;
                }
                break;
            case 1831139720:
                if (permission.equals("android.permission.RECORD_AUDIO")) {
                    b = 1;
                }
                break;
            case 1977429404:
                if (permission.equals("android.permission.READ_CONTACTS")) {
                    b = 5;
                }
                break;
            case 2133799037:
                if (permission.equals("com.android.voicemail.permission.ADD_VOICEMAIL")) {
                    b = cc.l;
                }
                break;
        }
        switch (b) {
            case 0:
                return checkCameraPermissions(context);
            case 1:
                return checkAudioPermission(context, permission);
            case 2:
                return checkSensorsPermission(context, permission);
            case 3:
            case 4:
                return checkCalanderPermission(context, permission);
            case 5:
            case 6:
            case 7:
                return checkContactsPermission(context, permission);
            case 8:
            case 9:
                return checkLocationsPermission(context, permission);
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                return checkReadPhoneStatePermission(context, permission);
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                return checkSMSPermission(context, permission);
            case 22:
            case 23:
                return checkWritePermission(context, permission);
            default:
                return selfPermissionGranted(context, permission);
        }
    }

    @SuppressLint({"MissingPermission"})
    private static boolean checkReadPhoneStatePermission(Activity context, String permission) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService("phone");
        try {
            tm.getDeviceId();
            return selfPermissionGranted(context, permission);
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean checkWritePermission(Activity context, String permission) {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "check_permission.dxt");
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.flush();
            outputStream.close();
            file.delete();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return selfPermissionGranted(context, permission);
    }

    private static boolean checkCalanderPermission(Activity context, String permission) {
        Cursor cursor = null;
        try {
            Uri uri = Uri.parse("content://com.android.calendar/events");
            cursor = context.getContentResolver().query(uri, null, null, null, null);
            return selfPermissionGranted(context, permission);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private static boolean checkCameraPermissions(Activity context) {
        Camera mCamera = null;
        try {
            Camera mCamera2 = Camera.open();
            Camera.Parameters mParameters = mCamera2.getParameters();
            mCamera2.setParameters(mParameters);
            if (mCamera2 == null) {
                mCamera2 = Camera.open();
            }
            Field fieldPassword = mCamera2.getClass().getDeclaredField("mHasPermission");
            fieldPassword.setAccessible(true);
            Boolean result = (Boolean) fieldPassword.get(mCamera2);
            if (mCamera2 != null) {
                mCamera2.release();
            }
            mCamera = null;
            return result.booleanValue();
        } catch (Exception e) {
            if (mCamera != null) {
                mCamera.release();
            }
            e.printStackTrace();
            return selfPermissionGranted(context, "android.permission.CAMERA");
        }
    }

    private static boolean checkContactsPermission(Activity context, String permission) {
        boolean zSelfPermissionGranted;
        Cursor cursor = null;
        try {
            try {
                cursor = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
                if (cursor != null) {
                    cursor.close();
                }
                zSelfPermissionGranted = selfPermissionGranted(context, permission);
            } catch (Exception e) {
                e.printStackTrace();
                zSelfPermissionGranted = false;
                if (0 != 0) {
                    cursor.close();
                }
            }
            return zSelfPermissionGranted;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private static boolean checkLocationsPermission(Activity context, String permission) {
        try {
            LocationManager lm = (LocationManager) context.getSystemService("location");
            lm.getAllProviders();
            return selfPermissionGranted(context, permission);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean checkAudioPermission(Activity context, String permission) {
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService(MediaFormat.KEY_AUDIO);
            audioManager.getMode();
            return selfPermissionGranted(context, permission);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean checkSensorsPermission(Activity context, String permission) {
        try {
            SensorManager sorMgr = (SensorManager) context.getSystemService(an.ac);
            sorMgr.getDefaultSensor(1);
            return selfPermissionGranted(context, permission);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean checkSMSPermission(Activity context, String permission) {
        Cursor cursor = null;
        try {
            Uri uri = Uri.parse("content://sms/failed");
            String[] projection = {ar.d, "address", "person", "body", "date", "type"};
            cursor = context.getContentResolver().query(uri, projection, null, null, "date desc");
            return selfPermissionGranted(context, permission);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @TargetApi(23)
    private static boolean selfPermissionGranted(Activity context, String permission) {
        return context.checkSelfPermission(permission) == 0;
    }
}
