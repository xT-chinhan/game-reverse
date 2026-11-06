package com.umeng.commonsdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.z;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.utils.onMessageSendListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class UMConfigureImpl {
    private static final int e = 1000;
    private static ScheduledExecutorService f;
    private static Context g;
    private static String a = z.b().b(z.o);
    private static CopyOnWriteArrayList<onMessageSendListener> b = new CopyOnWriteArrayList<>();
    private static int c = 0;
    private static boolean d = false;
    private static int h = 0;
    private static Runnable i = new Runnable() { // from class: com.umeng.commonsdk.UMConfigureImpl.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (UMConfigureImpl.c == 0 || UMConfigureImpl.h >= 10) {
                    if (!UMConfigureImpl.d) {
                        boolean unused = UMConfigureImpl.d = true;
                        UMConfigureImpl.b(UMConfigureImpl.g);
                    }
                    if (UMConfigureImpl.f != null) {
                        UMConfigureImpl.f.shutdown();
                        ScheduledExecutorService unused2 = UMConfigureImpl.f = null;
                    }
                }
                UMConfigureImpl.f();
            } catch (Exception e2) {
            }
        }
    };

    static /* synthetic */ int f() {
        int i2 = h;
        h = i2 + 1;
        return i2;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        g = context;
        try {
            if (c >= 1) {
                if (!d(context)) {
                    UMEnvelopeBuild.setTransmissionSendFlag(false);
                    c(context);
                    if (f == null) {
                        f = Executors.newScheduledThreadPool(1);
                        f.scheduleAtFixedRate(i, 0L, 100L, TimeUnit.MILLISECONDS);
                    }
                } else {
                    UMEnvelopeBuild.setTransmissionSendFlag(true);
                }
                return;
            }
            UMEnvelopeBuild.setTransmissionSendFlag(true);
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void b(Context context) {
        try {
            UMEnvelopeBuild.setTransmissionSendFlag(true);
            if (b != null && b.size() > 0) {
                Iterator<onMessageSendListener> it = b.iterator();
                while (it.hasNext()) {
                    it.next().onMessageSend();
                }
            }
        } catch (Exception e2) {
        }
    }

    public static synchronized void registerMessageSendListener(onMessageSendListener onmessagesendlistener) {
        try {
            if (b != null) {
                b.add(onmessagesendlistener);
            }
            if (UMEnvelopeBuild.getTransmissionSendFlag() && b != null && b.size() > 0) {
                Iterator<onMessageSendListener> it = b.iterator();
                while (it.hasNext()) {
                    it.next().onMessageSend();
                }
            }
        } catch (Exception e2) {
        }
    }

    public static synchronized void removeMessageSendListener(onMessageSendListener onmessagesendlistener) {
        try {
            if (b != null) {
                b.remove(onmessagesendlistener);
            }
        } catch (Exception e2) {
        }
    }

    public static synchronized void registerInterruptFlag() {
        try {
            c++;
        } catch (Exception e2) {
        }
    }

    public static synchronized void removeInterruptFlag() {
        try {
            c--;
        } catch (Exception e2) {
        }
    }

    private static void c(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(a, 0);
            if (sharedPreferences != null && sharedPreferences != null) {
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putBoolean(a, true);
                editorEdit.commit();
            }
        } catch (Throwable th) {
        }
    }

    private static boolean d(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(a, 0);
            if (sharedPreferences != null && sharedPreferences != null) {
                return sharedPreferences.getBoolean(a, false);
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }
}
