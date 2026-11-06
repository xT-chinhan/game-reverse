package com.anythink.core.common.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Base64;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
public class m {
    private static final String b = "MixedLBM_CORE";
    private static volatile boolean c;
    private static Method d;
    private static Method e;
    private static Method f;
    private static Method g;
    private static volatile m h;
    Context a;

    private static Object b(Context context) {
        if (!c) {
            synchronized (m.class) {
                if (!c) {
                    try {
                        Class<?> cls = Class.forName(a("YW5kcm9pZC5zdXBwb3J0LnY0LmNvbnRlbnQuTG9jYWxCcm9hZGNhc3RNYW5hZ2Vy"));
                        d = cls.getMethod("getInstance", Context.class);
                        e = cls.getMethod("registerReceiver", BroadcastReceiver.class, IntentFilter.class);
                        f = cls.getMethod("unregisterReceiver", BroadcastReceiver.class);
                        g = cls.getMethod("sendBroadcast", Intent.class);
                    } catch (Throwable unused) {
                        d = null;
                    }
                    c = true;
                }
            }
        }
        Method method = d;
        if (method == null) {
            return null;
        }
        try {
            return method.invoke(null, context);
        } catch (Throwable unused2) {
            return null;
        }
    }

    private m(Context context) {
        this.a = context;
    }

    public static m a(Context context) {
        if (h == null) {
            synchronized (m.class) {
                if (h == null) {
                    h = new m(context.getApplicationContext());
                }
            }
        }
        return h;
    }

    public final void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        try {
            LocalBroadcastManager.getInstance(this.a).registerReceiver(broadcastReceiver, intentFilter);
        } catch (Throwable unused) {
            Object objB = b(this.a);
            if (objB == null || e == null) {
                return;
            }
            try {
                Log.i(b, "[MixedLBM] use support LocalBroadcastManager, op=registerReceiver");
                e.invoke(objB, broadcastReceiver, intentFilter);
            } catch (Throwable unused2) {
            }
        }
    }

    public final void a(BroadcastReceiver broadcastReceiver) {
        try {
            LocalBroadcastManager.getInstance(this.a).unregisterReceiver(broadcastReceiver);
        } catch (Throwable unused) {
            Object objB = b(this.a);
            if (objB == null || f == null) {
                return;
            }
            try {
                Log.i(b, "[MixedLBM] use support LocalBroadcastManager, op=unregisterReceiver");
                f.invoke(objB, broadcastReceiver);
            } catch (Throwable unused2) {
            }
        }
    }

    public final void a(Intent intent) {
        try {
            LocalBroadcastManager.getInstance(this.a).sendBroadcast(intent);
        } catch (Throwable unused) {
            Object objB = b(this.a);
            if (objB == null || g == null) {
                return;
            }
            try {
                Log.i(b, "[MixedLBM] use support LocalBroadcastManager, op=sendBroadcast");
                g.invoke(objB, intent);
            } catch (Throwable unused2) {
            }
        }
    }

    private static String a(String str) {
        if (str.isEmpty()) {
            return null;
        }
        try {
            return new String(Base64.decode(str, 0), StandardCharsets.UTF_8);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return null;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }
}
