package com.tencent.bugly.crashreport.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class BuglyBroadcastRecevier extends BroadcastReceiver {
    private static BuglyBroadcastRecevier d;
    private Context b;
    private String c;
    private boolean e = true;
    private IntentFilter a = new IntentFilter();

    public static synchronized BuglyBroadcastRecevier getInstance() {
        if (d == null) {
            d = new BuglyBroadcastRecevier();
        }
        return d;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        Context context = this.b;
        if (context != null) {
            context.unregisterReceiver(this);
        }
    }

    public synchronized void addFilter(String str) {
        if (!this.a.hasAction(str)) {
            this.a.addAction(str);
        }
        x.c("add action %s", str);
    }

    public synchronized void register(Context context) {
        this.b = context;
        z.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.BuglyBroadcastRecevier.1
            /* JADX WARN: Bottom block not found for handler: all -> 0x002b */
            /* JADX WARN: Code restructure failed: missing block: B:12:0x002f, code lost:
            
                return;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void run() {
                /*
                    r4 = this;
                    com.tencent.bugly.crashreport.crash.BuglyBroadcastRecevier r0 = com.tencent.bugly.crashreport.crash.BuglyBroadcastRecevier.a()     // Catch: java.lang.Throwable -> L2b
                    java.lang.Class r0 = r0.getClass()     // Catch: java.lang.Throwable -> L2b
                    java.lang.String r1 = "Register broadcast receiver of Bugly."
                    r2 = 0
                    java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L2b
                    com.tencent.bugly.proguard.x.a(r0, r1, r2)     // Catch: java.lang.Throwable -> L2b
                    com.tencent.bugly.crashreport.crash.BuglyBroadcastRecevier r0 = r2     // Catch: java.lang.Throwable -> L2b
                    monitor-enter(r0)     // Catch: java.lang.Throwable -> L2b
                    com.tencent.bugly.crashreport.crash.BuglyBroadcastRecevier r1 = com.tencent.bugly.crashreport.crash.BuglyBroadcastRecevier.this     // Catch: java.lang.Throwable -> L28
                    android.content.Context r1 = com.tencent.bugly.crashreport.crash.BuglyBroadcastRecevier.b(r1)     // Catch: java.lang.Throwable -> L28
                    com.tencent.bugly.crashreport.crash.BuglyBroadcastRecevier r2 = com.tencent.bugly.crashreport.crash.BuglyBroadcastRecevier.a()     // Catch: java.lang.Throwable -> L28
                    com.tencent.bugly.crashreport.crash.BuglyBroadcastRecevier r3 = com.tencent.bugly.crashreport.crash.BuglyBroadcastRecevier.this     // Catch: java.lang.Throwable -> L28
                    android.content.IntentFilter r3 = com.tencent.bugly.crashreport.crash.BuglyBroadcastRecevier.a(r3)     // Catch: java.lang.Throwable -> L28
                    r1.registerReceiver(r2, r3)     // Catch: java.lang.Throwable -> L28
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L28
                    goto L2f
                L28:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L2b
                    throw r1     // Catch: java.lang.Throwable -> L2b
                L2b:
                    r0 = move-exception
                    r0.printStackTrace()
                L2f:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.BuglyBroadcastRecevier.AnonymousClass1.run():void");
            }
        });
    }

    public synchronized void unregister(Context context) {
        try {
            x.a(getClass(), "Unregister broadcast receiver of Bugly.", new Object[0]);
            context.unregisterReceiver(this);
            this.b = context;
        } catch (Throwable th) {
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            a(context, intent);
        } catch (Throwable th) {
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private synchronized boolean a(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (this.e) {
                    this.e = false;
                    return true;
                }
                String strE = com.tencent.bugly.crashreport.common.info.b.e(this.b);
                x.c("is Connect BC " + strE, new Object[0]);
                x.a("network %s changed to %s", this.c, strE);
                if (strE == null) {
                    this.c = null;
                    return true;
                }
                String str = this.c;
                this.c = strE;
                long jCurrentTimeMillis = System.currentTimeMillis();
                com.tencent.bugly.crashreport.common.strategy.a aVarA = com.tencent.bugly.crashreport.common.strategy.a.a();
                u uVarA = u.a();
                com.tencent.bugly.crashreport.common.info.a aVarA2 = com.tencent.bugly.crashreport.common.info.a.a(context);
                if (aVarA != null && uVarA != null && aVarA2 != null) {
                    if (!strE.equals(str)) {
                        if (jCurrentTimeMillis - uVarA.a(c.a) > 30000) {
                            x.a("try to upload crash on network changed.", new Object[0]);
                            c cVarA = c.a();
                            if (cVarA != null) {
                                cVarA.a(0L);
                            }
                        }
                        if (jCurrentTimeMillis - uVarA.a(1001) > 30000) {
                            x.a("try to upload userinfo on network changed.", new Object[0]);
                            com.tencent.bugly.crashreport.biz.b.a.b();
                        }
                    }
                    return true;
                }
                x.d("not inited BC not work", new Object[0]);
                return true;
            }
        }
        return false;
    }
}
