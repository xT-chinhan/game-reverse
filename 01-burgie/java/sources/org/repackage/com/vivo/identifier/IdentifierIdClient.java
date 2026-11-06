package org.repackage.com.vivo.identifier;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class IdentifierIdClient {
    private static final String a = "VMS_IDLG_SDK_Client";
    private static final String b = "content://com.vivo.vms.IdProvider/IdentifierId";
    private static final String c = "persist.sys.identifierid.supported";
    private static final String d = "appid";
    private static final String e = "type";
    private static final String f = "OAID";
    private static final String g = "VAID";
    private static final String h = "AAID";
    private static final int i = 0;
    private static final int j = 1;
    private static final int k = 2;
    private static final int l = 4;
    private static final int m = 11;
    private static final int n = 2000;
    private static Context o;
    private static boolean p = false;
    private static IdentifierIdObserver q = null;
    private static IdentifierIdObserver r = null;
    private static IdentifierIdObserver s = null;
    private static Object t = new Object();
    private static HandlerThread u = null;
    private static Handler v = null;
    private static String w = null;
    private static String x = null;
    private static String y = null;
    private static String z = null;
    private static String A = null;
    private static volatile IdentifierIdClient B = null;
    private static volatile DataBaseOperation C = null;

    private IdentifierIdClient() {
    }

    public static IdentifierIdClient a(Context context) {
        if (B == null) {
            synchronized (IdentifierIdClient.class) {
                o = context.getApplicationContext();
                B = new IdentifierIdClient();
            }
        }
        if (C == null) {
            synchronized (IdentifierIdClient.class) {
                o = context.getApplicationContext();
                g();
                C = new DataBaseOperation(o);
                d();
            }
        }
        return B;
    }

    private static void g() {
        u = new HandlerThread("SqlWorkThread");
        u.start();
        v = new Handler(u.getLooper()) { // from class: org.repackage.com.vivo.identifier.IdentifierIdClient.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 11) {
                    String unused = IdentifierIdClient.w = IdentifierIdClient.C.a(message.getData().getInt("type"), message.getData().getString("appid"));
                    synchronized (IdentifierIdClient.t) {
                        IdentifierIdClient.t.notify();
                    }
                    return;
                }
                Log.e(IdentifierIdClient.a, "message type valid");
            }
        };
    }

    public boolean a() {
        return p;
    }

    public String b() {
        if (!a()) {
            return null;
        }
        if (x != null) {
            return x;
        }
        a(0, (String) null);
        if (q == null) {
            a(o, 0, null);
        }
        return x;
    }

    public String a(String str) {
        if (!a()) {
            return null;
        }
        if (y != null) {
            return y;
        }
        a(1, str);
        if (r == null && y != null) {
            a(o, 1, str);
        }
        return y;
    }

    public String b(String str) {
        if (!a()) {
            return null;
        }
        if (z != null) {
            return z;
        }
        a(2, str);
        if (s == null && z != null) {
            a(o, 2, str);
        }
        return z;
    }

    public String c() {
        if (!a()) {
            return null;
        }
        a(4, (String) null);
        return A;
    }

    public void a(int i2, String str) {
        synchronized (t) {
            b(i2, str);
            long jUptimeMillis = SystemClock.uptimeMillis();
            try {
                t.wait(2000L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (SystemClock.uptimeMillis() - jUptimeMillis < 2000) {
                if (i2 != 4) {
                    switch (i2) {
                        case 0:
                            x = w;
                            w = null;
                            break;
                        case 1:
                            if (w != null) {
                                y = w;
                                w = null;
                            } else {
                                Log.e(a, "get vaid failed");
                            }
                            break;
                        case 2:
                            if (w != null) {
                                z = w;
                                w = null;
                            } else {
                                Log.e(a, "get aaid failed");
                            }
                            A = w;
                            w = null;
                            break;
                    }
                } else {
                    A = w;
                    w = null;
                }
            } else {
                Log.d(a, "query timeout");
            }
        }
    }

    private void b(int i2, String str) {
        Message messageObtainMessage = v.obtainMessage();
        messageObtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i2);
        if (i2 == 1 || i2 == 2) {
            bundle.putString("appid", str);
        }
        messageObtainMessage.setData(bundle);
        v.sendMessage(messageObtainMessage);
    }

    public static void d() {
        p = "1".equals(a(c, "0"));
    }

    public static String a(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
            } catch (Exception e2) {
                e2.printStackTrace();
                return str2;
            }
        } catch (Throwable th) {
            return str2;
        }
    }

    private static void a(Context context, int i2, String str) {
        switch (i2) {
            case 0:
                q = new IdentifierIdObserver(B, 0, null);
                context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, q);
                break;
            case 1:
                r = new IdentifierIdObserver(B, 1, str);
                context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, r);
                break;
            case 2:
                s = new IdentifierIdObserver(B, 2, str);
                context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str), false, s);
                break;
        }
    }
}
