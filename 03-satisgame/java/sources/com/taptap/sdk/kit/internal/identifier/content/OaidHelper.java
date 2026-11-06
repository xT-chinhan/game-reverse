package com.taptap.sdk.kit.internal.identifier.content;

import android.content.Context;
import android.text.TextUtils;
import com.taptap.sdk.kit.internal.TapLogger;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes3.dex */
class OaidHelper {
    private static volatile String OAID = "";
    private static final String TAG = "OaidHelper";
    private static volatile String certString = null;
    private static volatile boolean hasInit = false;
    private static Class<?> idSupplier;
    private static Class<?> identifyListener;
    private static Class<?> jLibrary;
    private static Method loadCertMethod;
    private static Class<?> midSDKHelper;

    OaidHelper() {
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        initInvokeListener();
        if (midSDKHelper == null || identifyListener == null || idSupplier == null) {
            TapLogger.logd(TAG, "OAID read class create failed");
            hasInit = true;
            return;
        }
        if (loadCertMethod != null) {
            try {
                String strLoadPemFromAssetFile = certString;
                if (TextUtils.isEmpty(strLoadPemFromAssetFile)) {
                    TapLogger.logd(TAG, "not set OAID certInfo before init, so try to load assets certInfo");
                    strLoadPemFromAssetFile = loadPemFromAssetFile(context);
                    if (TextUtils.isEmpty(strLoadPemFromAssetFile)) {
                        TapLogger.logd(TAG, "load OAID certInfo from asset is fail");
                    }
                }
                loadCertMethod.invoke(null, context, strLoadPemFromAssetFile);
            } catch (Exception e) {
                TapLogger.logd(TAG, "InitCert exception: " + e.getMessage());
            }
        }
        hasInit = true;
    }

    public static String getOAID(Context context) {
        try {
            if (!hasInit) {
                init(context);
            }
            if (midSDKHelper != null && identifyListener != null && idSupplier != null) {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                if (TextUtils.isEmpty(OAID)) {
                    getOAIDReflect(context, 2, countDownLatch);
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        TapLogger.logd(TAG, "CountDownLatch await exception: " + e.getMessage());
                    }
                    TapLogger.logd(TAG, "CountDownLatch await");
                    return OAID;
                }
                return OAID;
            }
            TapLogger.logd(TAG, "OAID 读取类创建失败");
            return "";
        } catch (Throwable th) {
            TapLogger.logd(TAG, "getOAID exception: " + th.getMessage());
            return "";
        }
    }

    private static void getOAIDReflect(Context context, int i, final CountDownLatch countDownLatch) {
        if (i == 0) {
            return;
        }
        try {
            Class<?> cls = jLibrary;
            if (cls != null) {
                cls.getDeclaredMethod("InitEntry", Context.class).invoke(null, context);
            }
            int iIntValue = ((Integer) midSDKHelper.getDeclaredMethod("InitSdk", Context.class, Boolean.TYPE, identifyListener).invoke(null, context, true, Proxy.newProxyInstance(context.getClassLoader(), new Class[]{identifyListener}, new IdentifyListenerHandler(countDownLatch)))).intValue();
            TapLogger.logd(TAG, "MdidSdkHelper ResultCode : " + iIntValue);
            if (iIntValue != 1008614 && iIntValue != 1008610) {
                int i2 = i - 1;
                getOAIDReflect(context, i2, countDownLatch);
                if (i2 == 0) {
                    countDownLatch.countDown();
                    return;
                }
                return;
            }
            new Thread(new Runnable() { // from class: com.taptap.sdk.kit.internal.identifier.content.OaidHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Thread.sleep(5000L);
                    } catch (InterruptedException unused) {
                    }
                    countDownLatch.countDown();
                }
            }).start();
        } catch (Throwable th) {
            TapLogger.logd(TAG, "getOAIDReflect exception: " + th.getMessage());
            int i3 = i - 1;
            getOAIDReflect(context, i3, countDownLatch);
            if (i3 == 0) {
                countDownLatch.countDown();
            }
        }
    }

    static class IdentifyListenerHandler implements InvocationHandler {
        private final CountDownLatch countDownLatch;

        public IdentifyListenerHandler(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                if ("OnSupport".equals(method.getName())) {
                    if (((Boolean) objArr[0]).booleanValue()) {
                        String unused = OaidHelper.OAID = (String) OaidHelper.idSupplier.getDeclaredMethod("getOAID", new Class[0]).invoke(objArr[1], new Object[0]);
                        TapLogger.logd(OaidHelper.TAG, "oaid:" + OaidHelper.OAID);
                    }
                    this.countDownLatch.countDown();
                    return null;
                }
                if (!"onSupport".equals(method.getName())) {
                    return null;
                }
                String unused2 = OaidHelper.OAID = (String) OaidHelper.idSupplier.getDeclaredMethod("getOAID", new Class[0]).invoke(objArr[0], new Object[0]);
                TapLogger.logd(OaidHelper.TAG, "oaid:" + OaidHelper.OAID);
                this.countDownLatch.countDown();
                return null;
            } catch (Throwable th) {
                TapLogger.logd(OaidHelper.TAG, "IdentifyListenerHandler invoke exception: " + th.getMessage());
                this.countDownLatch.countDown();
                return null;
            }
        }
    }

    private static void initInvokeListener() {
        try {
            TapLogger.logd(TAG, "start load msaoaidsec");
            System.loadLibrary("msaoaidsec");
        } catch (Throwable th) {
            TapLogger.logd(TAG, "Load msaoaidsec failed, error: " + th.getMessage());
        }
        try {
            TapLogger.logd(TAG, "start reflection MdidSdkHelper");
            Class<?> cls = Class.forName("com.bun.miitmdid.core.MdidSdkHelper");
            midSDKHelper = cls;
            try {
                loadCertMethod = cls.getMethod("InitCert", Context.class, String.class);
            } catch (NoSuchMethodException unused) {
                TapLogger.logd(TAG, "not found InitCert method, so not need load cert");
            }
            try {
                identifyListener = Class.forName("com.bun.miitmdid.interfaces.IIdentifierListener");
                idSupplier = Class.forName("com.bun.miitmdid.interfaces.IdSupplier");
            } catch (Exception unused2) {
                TapLogger.logd(TAG, "1.0.22/23 version not found");
                try {
                    identifyListener = Class.forName("com.bun.supplier.IIdentifierListener");
                    idSupplier = Class.forName("com.bun.supplier.IdSupplier");
                    jLibrary = Class.forName("com.bun.miitmdid.core.JLibrary");
                } catch (Exception unused3) {
                    TapLogger.logd(TAG, "1.0.13 - 1.0.21 version not found");
                    try {
                        identifyListener = Class.forName("com.bun.miitmdid.core.IIdentifierListener");
                        idSupplier = Class.forName("com.bun.miitmdid.supplier.IdSupplier");
                        jLibrary = Class.forName("com.bun.miitmdid.core.JLibrary");
                    } catch (Exception unused4) {
                        TapLogger.logd(TAG, "1.0.5 - 1.0.13 version not found");
                    }
                }
            }
        } catch (Throwable th2) {
            TapLogger.logd(TAG, "reflection MdidSdkHelper failed, error: " + th2.getMessage());
        }
    }

    public static String loadPemFromAssetFile(Context context) {
        try {
            TapLogger.logd(TAG, "start loadPemFromAssetFile");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(context.getPackageName() + ".cert.pem")));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                    sb.append('\n');
                } else {
                    return sb.toString();
                }
            }
        } catch (Exception e) {
            TapLogger.logd(TAG, "loadPemFromAssetFile failed, error: " + e.getMessage());
            return "";
        }
    }

    public static void setCertString(String str) {
        certString = str;
    }
}
