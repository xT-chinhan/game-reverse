package com.umeng.umcrash;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.uc.crashsdk.export.CrashApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public class UMCrashUtils {
    private static final int DEF_CLOSE_RATE = 0;
    private static final int MAX_TRACE_RATE = 100;
    public static final String UNKNOW = "";

    public static boolean random(int rate) {
        if (rate == 0) {
            return false;
        }
        if (rate == 100) {
            return true;
        }
        Random random = new Random();
        int next = random.nextInt(100);
        if (next > rate) {
            return false;
        }
        return true;
    }

    public static void saveInnerConfig(Context context, String key, Object value) {
        SharedPreferences sp;
        SharedPreferences.Editor editor;
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(key) && value != null && (sp = context.getSharedPreferences(UMCrashContent.KEY_SP_UMCRASH, 0)) != null && (editor = sp.edit()) != null) {
                    editor.putInt(key, Integer.parseInt(value.toString()));
                    editor.commit();
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    public static int getInnerConfig(Context context, String key, int defa) {
        SharedPreferences sp;
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(key) && (sp = context.getSharedPreferences(UMCrashContent.KEY_SP_UMCRASH, 0)) != null) {
                    return sp.getInt(key, defa);
                }
                return defa;
            } catch (Throwable e) {
                e.printStackTrace();
                return defa;
            }
        }
        return defa;
    }

    public static void setCommonTag(String key, String value) {
        Class<?> cls;
        Method method;
        try {
            Class<?> clazz = Class.forName("com.umeng.commonsdk.UMConfigure");
            if (clazz != null && (cls = Class.forName("com.umeng.commonsdk.UMConfigure$BS_TYPE")) != null && (method = clazz.getDeclaredMethod("setModuleTag", cls, String.class, String.class)) != null) {
                method.setAccessible(true);
                Enum[] enumConstants = (Enum[]) cls.getEnumConstants();
                for (Enum item : enumConstants) {
                    if (item != null && item.name().equals("APM")) {
                        method.invoke(clazz, item, key, value);
                    }
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static boolean isHarmony(Context context) {
        try {
            int id = Resources.getSystem().getIdentifier("config_os_brand", "string", "android");
            return context.getString(id).equals("harmony");
        } catch (Throwable th) {
            return false;
        }
    }

    public static String[] getActiveUser(Context context) throws NoSuchMethodException, ClassNotFoundException {
        if (context == null) {
            return null;
        }
        Class<?> mClass = null;
        try {
            mClass = Class.forName("com.umeng.commonsdk.utils.UMUtils");
        } catch (ClassNotFoundException e) {
        }
        if (mClass == null) {
            return null;
        }
        Method umConfigMethed = null;
        try {
            umConfigMethed = mClass.getMethod("getActiveUser", Context.class);
        } catch (NoSuchMethodException e2) {
        }
        if (umConfigMethed != null) {
            try {
                Object o = umConfigMethed.invoke(null, context);
                if (o == null) {
                    return null;
                }
                String[] activeUser = (String[]) o;
                return activeUser;
            } catch (IllegalAccessException e3) {
                return null;
            } catch (InvocationTargetException e4) {
                return null;
            }
        }
        return null;
    }

    public static void setPuidAndProvider(String puid, String provider) {
        if (CrashApi.getInstance() != null) {
            CrashApi.getInstance().addHeaderInfo(UMCrash.KEY_HEADER_PUID, puid);
            CrashApi.getInstance().addHeaderInfo(UMCrash.KEY_HEADER_PROVIDER, provider);
        }
        HashMap<String, String> params = new HashMap<>();
        params.put(UMCrash.KEY_HEADER_PUID, puid);
        params.put(UMCrash.KEY_HEADER_PROVIDER, provider);
        if (UMCrash.getReporter() != null) {
            UMCrash.getReporter().addPublicParams(params);
        }
    }

    public static void setIntegrationTesingParams(String debugKey) {
        if (CrashApi.getInstance() != null) {
            CrashApi.getInstance().addHeaderInfo("um_dk", debugKey);
        }
        if (UMCrash.getReporter() != null) {
            HashMap<String, String> params = new HashMap<>();
            params.put("um_dk", debugKey);
            UMCrash.getReporter().addPublicParams(params);
        }
    }

    public static String getNetworkOperatorName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            TelephonyManager tm = (TelephonyManager) context.getSystemService("phone");
            if (checkPermission(context, "android.permission.READ_PHONE_STATE") && tm != null) {
                return tm.getNetworkOperatorName();
            }
            return "";
        } catch (Throwable th) {
            return "";
        }
    }

    public static boolean checkPermission(Context context, String permission) {
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                Class<?> clazz = Class.forName("android.content.Context");
                Method method = clazz.getMethod("checkSelfPermission", String.class);
                int rest = ((Integer) method.invoke(context, permission)).intValue();
                if (rest == 0) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                return false;
            }
        }
        PackageManager pm = context.getPackageManager();
        if (pm.checkPermission(permission, context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    public static String splitByByte(String srcStr, int length) {
        StringBuffer sb = new StringBuffer(length);
        try {
            int srcLength = srcStr.length();
            int tempLength = 0;
            for (int i = 0; i < srcLength; i++) {
                String tempStr = String.valueOf(srcStr.charAt(i));
                byte[] b = tempStr.getBytes();
                tempLength += b.length;
                if (length < tempLength) {
                    break;
                }
                sb.append(tempStr);
            }
        } catch (Throwable th) {
        }
        return sb.toString();
    }
}
