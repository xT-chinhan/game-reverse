package com.tapsdk.tapad.internal.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class l {
    private static final String a = "OaidExtention";
    private static volatile String b = "";
    private static Class<?> c = null;
    private static Class<?> d = null;
    private static Class<?> e = null;
    private static Class<?> f = null;
    private static Method g = null;
    private static volatile boolean h = false;
    private static volatile String i;
    private static volatile CountDownLatch j;

    static class a implements InvocationHandler {
        a() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                if ("OnSupport".equals(method.getName())) {
                    if (((Boolean) objArr[0]).booleanValue()) {
                        String unused = l.b = (String) l.d.getDeclaredMethod("getOAID", new Class[0]).invoke(objArr[1], new Object[0]);
                        TapADLogger.d("OaidExtentionIdentifyListenerHandler oaid0:" + l.b);
                    }
                } else {
                    if (!"onSupport".equals(method.getName())) {
                        return null;
                    }
                    String unused2 = l.b = (String) l.d.getDeclaredMethod("getOAID", new Class[0]).invoke(objArr[0], new Object[0]);
                    TapADLogger.d("OaidExtention IdentifyListenerHandler oaid1:" + l.b);
                }
                l.j.countDown();
                return null;
            } catch (Throwable th) {
                TapADLogger.e(th.toString());
                l.j.countDown();
                return null;
            }
        }
    }

    public static String a(Context context, boolean z) {
        int i2 = z ? 1 : 3;
        TapADLogger.d("OaidExtention===== getOaid start =====");
        try {
            if (!h) {
                a(context);
            }
            if (f != null && c != null && d != null) {
                j = new CountDownLatch(1);
                if (!TextUtils.isEmpty(b)) {
                    return b;
                }
                a(context, i2);
                try {
                    j.await(5L, TimeUnit.SECONDS);
                } catch (InterruptedException e2) {
                    TapADLogger.e(e2.toString());
                }
                TapADLogger.d("OaidExtention===== getOaid end ===== oaid:" + b);
                return b;
            }
            TapADLogger.d("OAID 读取类创建失败");
            return "";
        } catch (Throwable th) {
            TapADLogger.e(th.toString());
            return "";
        }
    }

    public static void a(Context context) {
        String str;
        if (context == null) {
            return;
        }
        TapADLogger.d("OaidExtention ===== 初始化 start =====");
        d();
        if (f == null || c == null || d == null) {
            str = "OaidExtention OAID 读取类创建失败 ";
        } else {
            if (g != null) {
                try {
                    String strB = i;
                    if (TextUtils.isEmpty(strB)) {
                        TapADLogger.d("OaidExtention not set OAID certInfo before init, so try to load assets certInfo");
                        strB = b(context);
                        if (TextUtils.isEmpty(strB)) {
                            TapADLogger.d("OaidExtention load OAID certInfo from asset is fail");
                        }
                    }
                    g.invoke(null, context, strB);
                } catch (Throwable th) {
                    TapADLogger.d("OaidExtention not set OAID certInfo before init, so try to load assets certInfo");
                    TapADLogger.e(th.toString());
                }
            }
            str = "OaidExtention ===== 初始化 end =====";
        }
        TapADLogger.d(str);
        h = true;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0127 A[PHI: r15
      0x0127: PHI (r15v5 int) = (r15v4 int), (r15v0 int) binds: [B:40:0x0125, B:30:0x00ea] A[DONT_GENERATE, DONT_INLINE]] */
    private static void a(Context context, int i2) {
        String strA = q.a(' ', Math.max(3 - i2, 0) * 2);
        TapADLogger.d(a + strA + " ===== getOAIDReflect start ===== retryCount:" + i2);
        if (i2 == 0) {
            if (j != null) {
                j.countDown();
                return;
            }
            return;
        }
        try {
            Class<?> cls = e;
            if (cls != null) {
                cls.getDeclaredMethod("InitEntry", Context.class).invoke(null, context);
            }
            int iIntValue = ((Integer) f.getDeclaredMethod("InitSdk", Context.class, Boolean.TYPE, c).invoke(null, context, Boolean.TRUE, Proxy.newProxyInstance(context.getClassLoader(), new Class[]{c}, new a()))).intValue();
            TapADLogger.d("MdidSdkHelper ResultCode : " + iIntValue);
            if (iIntValue != 1008614 && iIntValue != 1008610) {
                i2--;
                a(context, i2);
                if (i2 == 0 && j != null) {
                    j.countDown();
                }
                TapADLogger.d(a + strA + " ===== getOAIDReflect end ===== retryCount:" + i2 + ",fail");
                if (j != null) {
                    j.countDown();
                    return;
                }
                return;
            }
            if (j != null) {
                j.countDown();
            }
        } catch (Throwable th) {
            try {
                TapADLogger.e(th.toString());
                i2--;
                a(context, i2);
                if (i2 == 0 && j != null) {
                    j.countDown();
                }
                TapADLogger.d(a + strA + " ===== getOAIDReflect end ===== retryCount:" + i2 + ",exception");
                if (j != null) {
                    j.countDown();
                }
            } catch (Throwable th2) {
                if (j != null) {
                    j.countDown();
                }
                throw th2;
            }
        }
        TapADLogger.d(a + strA + " ===== getOAIDReflect end ===== retryCount:" + i2);
    }

    public static String b(Context context) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(context.getPackageName() + ".cert.pem")));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return sb.toString();
                }
                sb.append(line);
                sb.append('\n');
            }
        } catch (Exception unused) {
            TapADLogger.e("loadPemFromAssetFile failed");
            return "";
        }
    }

    private static void d() {
        try {
            Class<?> cls = Class.forName("com.bun.miitmdid.core.MdidSdkHelper");
            f = cls;
            try {
                g = cls.getMethod("InitCert", Context.class, String.class);
            } catch (NoSuchMethodException unused) {
                TapADLogger.d("TapDB don't need load cert");
            }
            try {
                try {
                    try {
                        c = Class.forName("com.bun.miitmdid.interfaces.IIdentifierListener");
                        d = Class.forName("com.bun.miitmdid.interfaces.IdSupplier");
                    } catch (Exception unused2) {
                        c = Class.forName("com.bun.miitmdid.core.IIdentifierListener");
                        d = Class.forName("com.bun.miitmdid.supplier.IdSupplier");
                        e = Class.forName("com.bun.miitmdid.core.JLibrary");
                    }
                } catch (Exception unused3) {
                    c = Class.forName("com.bun.supplier.IIdentifierListener");
                    d = Class.forName("com.bun.supplier.IdSupplier");
                    e = Class.forName("com.bun.miitmdid.core.JLibrary");
                }
            } catch (Exception unused4) {
            }
        } catch (Throwable th) {
            TapADLogger.e(th.toString());
        }
    }
}
