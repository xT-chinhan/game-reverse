package com.mcto.sspsdk.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import com.mcto.sspsdk.QyCustomMade;
import com.mcto.sspsdk.R;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class c1 {
    public static volatile c1 k;
    public final v0 a;
    public h8 b;
    public final r4 c;
    public final String d;
    public z0 h;
    public final HashMap e = new HashMap();
    public final int[] f = new int[0];
    public final AtomicBoolean g = new AtomicBoolean(true);
    public final ConcurrentHashMap i = new ConcurrentHashMap();
    public final x0 j = new x0(this);

    public c1() {
        Context context = jd.a;
        this.a = v0.a();
        a(0);
        QyCustomMade qyCustomMade = rd.d;
        if (qyCustomMade == null || !qyCustomMade.canUseNotification()) {
            return;
        }
        String str = jd.a() + ".download_notice_action";
        this.d = str;
        this.c = new r4(jd.a, str);
        w0 w0Var = new w0(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(str);
        if (Build.VERSION.SDK_INT >= 33) {
            jd.a.registerReceiver(w0Var, intentFilter, 2);
        } else {
            jd.a.registerReceiver(w0Var, intentFilter);
        }
    }

    public static void a(c1 c1Var, String str) {
        synchronized (c1Var) {
            d1 d1Var = (d1) c1Var.i.get(str);
            if (d1Var != null) {
                d1Var.a.f = 3;
            }
            c1Var.i.remove(str);
        }
    }

    public final void b(u0 u0Var) {
        d1 d1Var = (d1) this.i.get(u0Var.a());
        String str = "resume";
        if (d1Var == null) {
            d1 d1Var2 = new d1(jd.a, u0Var, new y0(this));
            this.i.put(u0Var.a(), d1Var2);
            int i = d1Var2.a.e;
            if (i == 0 || i == 2 || i == 3 || i == 6) {
                a(u0Var.a(), u0Var.g, new s0(1, 0.0f));
            }
            d1Var2.a();
            a(u0Var, d1Var2.a.k ? "resume" : TrackAction.START);
            return;
        }
        r1 r1Var = d1Var.a;
        int i2 = r1Var.e;
        if (i2 == 5) {
            d1Var.a();
        } else if (r1Var.f == 1) {
            if (i2 != 5) {
                r1Var.f = 2;
                float f = ((r1Var.g / r1Var.i) * 1000.0f) / 10.0f;
                if (r1Var.l != null && r1Var.n != null) {
                    kh.a.a(new m1(r1Var, f));
                }
            }
            str = "pause";
        } else {
            String strA = u0Var.a();
            String str2 = u0Var.g;
            r1 r1Var2 = d1Var.a;
            long j = r1Var2.i;
            a(strA, str2, new s0(1, j > 0 ? ((int) (r1Var2.g / j)) * 100 : 0));
            d1Var.a();
        }
        a(u0Var, str);
        int i3 = d1Var.a.e;
    }

    public static c1 a() {
        if (k == null) {
            synchronized (c1.class) {
                if (k == null) {
                    k = new c1();
                }
            }
        }
        return k;
    }

    public final synchronized void a(u0 u0Var) {
        z2 g5Var;
        z2 g5Var2;
        String str = u0Var.d;
        a(10);
        if (lj.b(u0Var.a())) {
            return;
        }
        if (e1.c(u0Var.i)) {
            a(u0Var.a(), u0Var.g, new s0(7, 100.0f));
            return;
        }
        u0Var.m = 9;
        int i = u0Var.n;
        int i2 = u0Var.k;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (jd.a != null) {
            if (i >= 3) {
                switch (i) {
                    case 3:
                    case 5:
                        g5Var2 = new g5(i);
                        break;
                    case 4:
                        g5Var2 = new i5(i);
                        break;
                    case 6:
                        g5Var2 = new h5(i);
                        break;
                    case 7:
                    default:
                        g5Var2 = new k5(i);
                        break;
                    case 8:
                        g5Var2 = new j5(i);
                        break;
                }
                linkedHashSet.add(g5Var2);
            }
            if (i2 >= 3) {
                switch (i2) {
                    case 3:
                    case 5:
                        g5Var = new g5(i2);
                        break;
                    case 4:
                        g5Var = new i5(i2);
                        break;
                    case 6:
                        g5Var = new h5(i2);
                        break;
                    case 7:
                    default:
                        g5Var = new k5(i2);
                        break;
                    case 8:
                        g5Var = new j5(i2);
                        break;
                }
                linkedHashSet.add(g5Var);
            }
            linkedHashSet.add(new k5(0));
        }
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            if (((z2) it.next()).a(u0Var)) {
                return;
            }
        }
    }

    public final s0 a(u0 u0Var, b1 b1Var) {
        int i;
        if (u0Var == null) {
            return null;
        }
        String strA = u0Var.a();
        if (lj.b(strA)) {
            return new s0(6, 0.0f);
        }
        if (e1.c(strA)) {
            return new s0(7, 0.0f);
        }
        synchronized (this.f) {
            List list = (List) this.e.get(strA);
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new WeakReference(b1Var));
                this.e.put(strA, arrayList);
            } else {
                list.add(new WeakReference(b1Var));
            }
        }
        d1 d1Var = (d1) this.i.get(strA);
        if (d1Var != null) {
            r1 r1Var = d1Var.a;
            int i2 = r1Var.e;
            long j = r1Var.i;
            return new s0(i2, j > 0 ? ((int) (r1Var.g / j)) * 100 : 0);
        }
        this.a.getClass();
        u0 u0VarB = v0.b(strA);
        if (u0VarB != null && (i = u0VarB.m) != 0 && i != 5) {
            if (u0VarB.l >= 3) {
                return new s0(0, 0.0f);
            }
            if (u0VarB.a == 5) {
                return new s0(5, 100.0f);
            }
            long j2 = u0VarB.b;
            return new s0(2, j2 != 0 ? (int) ((0 / j2) * 100) : 0);
        }
        return new s0(0, 0.0f);
    }

    public final void b(u0 u0Var, b1 b1Var) {
        if (u0Var == null) {
            return;
        }
        String strA = u0Var.a();
        if (lj.b(strA)) {
            return;
        }
        synchronized (this.f) {
            List list = (List) this.e.get(strA);
            if (list != null && !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((WeakReference) it.next()).get() == b1Var) {
                        it.remove();
                        break;
                    }
                }
            }
        }
    }

    public final synchronized void a(int i) {
        if (i == 0) {
            if (this.h == null) {
                z0 z0Var = new z0(this);
                this.h = z0Var;
                jd.d.add(z0Var);
                z0Var.a(Boolean.valueOf(jd.e));
            }
        }
        if (i >= gj.a((Object) nh.a(jd.a).a("ql_misc"), 0) && this.b == null) {
            h8 h8Var = new h8();
            this.b = h8Var;
            h8Var.a = this.j;
            boolean zCanListeningBackground = true;
            if (rd.a()) {
                zCanListeningBackground = "1".equals(nh.a(jd.a).a.getSharedPreferences("iad_dev", 0).getString("ql_cbmi", "0"));
            } else {
                QyCustomMade qyCustomMade = rd.d;
                if (qyCustomMade != null) {
                    zCanListeningBackground = qyCustomMade.canListeningBackground();
                }
            }
            if (zCanListeningBackground) {
                this.b.a();
                z0 z0Var2 = this.h;
                if (z0Var2 != null) {
                    jd.d.remove(z0Var2);
                    this.h = null;
                }
            } else {
                if (this.h == null) {
                    z0 z0Var3 = new z0(this);
                    this.h = z0Var3;
                    jd.d.add(z0Var3);
                    z0Var3.a(Boolean.valueOf(jd.e));
                }
                h8 h8Var2 = this.b;
                if (h8Var2.c == null) {
                    g8 g8Var = new g8(h8Var2);
                    h8Var2.c = g8Var;
                    jd.d.add(g8Var);
                    g8Var.a(Boolean.valueOf(jd.e));
                }
            }
        }
    }

    public final void a(String str, String str2, s0 s0Var) {
        String str3;
        String str4;
        r4 r4Var = this.c;
        if (r4Var != null) {
            int i = s0Var.a;
            if (i == 3 || i == 7) {
                Integer num = (Integer) r4Var.d.get(str);
                if (num != null) {
                    r4Var.c.cancel(num.intValue());
                    r4Var.d.remove(str);
                }
            } else if (i != 0) {
                if (!r4Var.d.containsKey(str)) {
                    HashMap map = r4Var.d;
                    int i2 = r4Var.e;
                    r4Var.e = i2 + 1;
                    map.put(str, Integer.valueOf(i2));
                }
                int iIntValue = ((Integer) r4Var.d.get(str)).intValue();
                Intent intent = new Intent(r4Var.a);
                intent.putExtra("taskId", str);
                intent.putExtra("apkName", s0Var.c);
                PendingIntent broadcast = PendingIntent.getBroadcast(r4Var.b, str.hashCode(), intent, 201326592);
                int i3 = s0Var.a;
                if (i3 == 5) {
                    str3 = "《" + str2 + "》下载完成";
                    str4 = "点击安装";
                } else if (i3 == 2) {
                    str3 = "《" + str2 + "》下载暂停";
                    str4 = "点击继续";
                } else if (i3 == 6) {
                    str3 = "《" + str2 + "》下载错误";
                    str4 = "点击重试";
                } else {
                    str3 = "正在下载《" + str2 + "》";
                    str4 = String.format("下载进度: %.2f%%", Float.valueOf(s0Var.b));
                }
                r4Var.c.notify(iIntValue, new NotificationCompat.Builder(r4Var.b, "download_channel").setSmallIcon(R.drawable.qy_lg_gift_box_big).setContentTitle(str3).setContentText(str4).setProgress(100, (int) s0Var.b, false).setOnlyAlertOnce(true).setAutoCancel(false).setPriority(1).setContentIntent(broadcast).build());
            }
        }
        synchronized (this.f) {
            List list = (List) this.e.get(str);
            if (list != null && !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    b1 b1Var = (b1) ((WeakReference) it.next()).get();
                    if (b1Var != null) {
                        b1Var.a(s0Var);
                    } else {
                        it.remove();
                    }
                }
            }
        }
    }

    public static void a(u0 u0Var, String str) {
        HashMap map = new HashMap();
        map.put(v5.KEY_DOWNLOAD_CUSTOM_INFO, "action:" + str + ";dw:" + u0Var.k + ";scene:" + u0Var.q + ";apk:" + u0Var.i + ";");
        l lVarA = l.a();
        String strA = u0Var.a();
        String str2 = u0Var.f;
        lVarA.getClass();
        l.a(strA, str2, 31, map);
    }
}
