package com.anythink.dlopt.common.b;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.anythink.core.common.d.t;
import com.anythink.core.common.v.q;
import com.anythink.dlopt.common.NotificationBroadcastReceiver;
import com.anythink.dlopt.common.a.j;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a implements b {
    public static final String a = "a";
    public static final String b = "anythink_action_notification_click";
    public static final String c = "anythink_action_notification_cannel";
    public static final String d = "anythink_broadcast_receiver_extra_url";
    public static final String e = "anythink_broadcast_receiver_extra_unique_id";
    public static final String f = "anythink_broadcast_receiver_extra_request_status";
    public static final String g = "anythink_broadcast_receiver_extra_notification_id";
    private static volatile a j;
    Map<String, c> h = new HashMap();
    private NotificationManager i;
    private Context k;
    private int l;

    static /* synthetic */ int a(long j2, long j3) {
        return (int) (((j2 * 1.0f) / j3) * 100.0f);
    }

    private static int b(long j2, long j3) {
        return (int) (((j2 * 1.0f) / j3) * 100.0f);
    }

    public static a a(Context context) {
        if (j == null) {
            synchronized (a.class) {
                if (j == null) {
                    j = new a(context);
                }
            }
        }
        return j;
    }

    private a(Context context) {
        this.k = context;
        this.i = b(context);
    }

    @Override // com.anythink.dlopt.common.b.b
    public final NotificationManager b(Context context) {
        if (context == null) {
            return null;
        }
        return (NotificationManager) context.getSystemService("notification");
    }

    @Override // com.anythink.dlopt.common.b.b
    public final synchronized void a(final j jVar, final long j2, final long j3, final boolean z) {
        if (jVar != null) {
            if (!TextUtils.isEmpty(jVar.b)) {
                t.b().b(new Runnable() { // from class: com.anythink.dlopt.common.b.a.1
                    /* JADX WARN: Code duplicated, block: B:42:0x017e A[Catch: all -> 0x01b3, TryCatch #0 {all -> 0x01b3, blocks: (B:2:0x0000, B:4:0x0008, B:5:0x0015, B:9:0x0034, B:12:0x0042, B:40:0x0176, B:42:0x017e, B:43:0x0182, B:45:0x0194, B:47:0x01a3, B:46:0x019c, B:14:0x0060, B:16:0x0068, B:17:0x0085, B:19:0x008d, B:20:0x00a8, B:24:0x00b7, B:26:0x00c1, B:28:0x00c7, B:29:0x00e2, B:31:0x00ff, B:33:0x0107, B:34:0x0122, B:36:0x012a, B:38:0x0130, B:39:0x0153), top: B:52:0x0000 }] */
                    /* JADX WARN: Code duplicated, block: B:45:0x0194 A[Catch: all -> 0x01b3, TryCatch #0 {all -> 0x01b3, blocks: (B:2:0x0000, B:4:0x0008, B:5:0x0015, B:9:0x0034, B:12:0x0042, B:40:0x0176, B:42:0x017e, B:43:0x0182, B:45:0x0194, B:47:0x01a3, B:46:0x019c, B:14:0x0060, B:16:0x0068, B:17:0x0085, B:19:0x008d, B:20:0x00a8, B:24:0x00b7, B:26:0x00c1, B:28:0x00c7, B:29:0x00e2, B:31:0x00ff, B:33:0x0107, B:34:0x0122, B:36:0x012a, B:38:0x0130, B:39:0x0153), top: B:52:0x0000 }] */
                    /* JADX WARN: Code duplicated, block: B:46:0x019c A[Catch: all -> 0x01b3, TryCatch #0 {all -> 0x01b3, blocks: (B:2:0x0000, B:4:0x0008, B:5:0x0015, B:9:0x0034, B:12:0x0042, B:40:0x0176, B:42:0x017e, B:43:0x0182, B:45:0x0194, B:47:0x01a3, B:46:0x019c, B:14:0x0060, B:16:0x0068, B:17:0x0085, B:19:0x008d, B:20:0x00a8, B:24:0x00b7, B:26:0x00c1, B:28:0x00c7, B:29:0x00e2, B:31:0x00ff, B:33:0x0107, B:34:0x0122, B:36:0x012a, B:38:0x0130, B:39:0x0153), top: B:52:0x0000 }] */
                    @Override // java.lang.Runnable
                    public final void run() {
                        int iA;
                        try {
                            if (a.this.i == null) {
                                a aVar = a.this;
                                aVar.i = aVar.b(aVar.k);
                            }
                            c cVarF = a.this.f(jVar);
                            NotificationCompat.Builder progress = cVarF.b;
                            a.a(a.this, jVar, progress, cVarF);
                            int i = cVarF.c;
                            boolean z2 = jVar.q == 2;
                            String string = com.anythink.core.express.b.a.f;
                            if (jVar.g()) {
                                string = a.this.k.getResources().getString(q.a(a.this.k, "notification_click_to_open", "string"));
                            } else {
                                if (jVar.h()) {
                                    string = a.this.k.getResources().getString(q.a(a.this.k, "notification_click_to_install", "string"));
                                    iA = 100;
                                } else if (jVar.i()) {
                                    string = a.this.k.getResources().getString(q.a(a.this.k, "notification_click_to_retry", "string"));
                                } else {
                                    iA = a.a(j2, j3);
                                    if (!z && i == iA) {
                                        return;
                                    }
                                    cVarF.c = iA;
                                    if (jVar.b()) {
                                        string = jVar.r == 2 ? a.this.k.getResources().getString(q.a(a.this.k, "notification_waiting_for_download", "string")) : a.this.k.getResources().getString(q.a(a.this.k, "notification_waiting_for_download_or_pause", "string"));
                                    } else if (jVar.c()) {
                                        string = a.this.k.getResources().getString(q.a(a.this.k, "notification_continue_to_download", "string"));
                                    } else if (jVar.e()) {
                                        string = jVar.r == 2 ? a.this.k.getResources().getString(q.a(a.this.k, "notification_in_download", "string"), String.valueOf(iA)) : a.this.k.getResources().getString(q.a(a.this.k, "notification_in_download_or_pause", "string"), String.valueOf(iA));
                                    }
                                    z2 = false;
                                }
                                if (jVar.e()) {
                                    progress = progress.setProgress(100, iA, false);
                                }
                                progress.setContentText(string).setStyle(new NotificationCompat.BigTextStyle().bigText(string));
                                if (z2) {
                                    progress.setOngoing(false).setAutoCancel(true);
                                } else {
                                    progress.setOngoing(true).setAutoCancel(false);
                                }
                                a.this.i.notify(cVarF.a, progress.build());
                            }
                            z2 = true;
                            iA = 0;
                            if (jVar.e()) {
                                progress = progress.setProgress(100, iA, false);
                            }
                            progress.setContentText(string).setStyle(new NotificationCompat.BigTextStyle().bigText(string));
                            if (z2) {
                                progress.setOngoing(false).setAutoCancel(true);
                            } else {
                                progress.setOngoing(true).setAutoCancel(false);
                            }
                            a.this.i.notify(cVarF.a, progress.build());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    public final void a(final boolean z, final j jVar, final long j2, final long j3) {
        t.b().b(new Runnable() { // from class: com.anythink.dlopt.common.b.a.2
            @Override // java.lang.Runnable
            public final void run() {
                if (z) {
                    a.this.e(jVar);
                }
                a.this.a(jVar, j2, j3, false);
            }
        });
    }

    public final void a(final j jVar) {
        t.b().b(new Runnable() { // from class: com.anythink.dlopt.common.b.a.3
            @Override // java.lang.Runnable
            public final void run() {
                a.this.e(jVar);
                a.this.a(jVar, 100L, 100L, true);
            }
        });
    }

    public final void b(final j jVar) {
        t.b().b(new Runnable() { // from class: com.anythink.dlopt.common.b.a.4
            @Override // java.lang.Runnable
            public final void run() {
                a.this.e(jVar);
                a.this.a(jVar, 0L, 100L, true);
            }
        });
    }

    public final void c(final j jVar) {
        t.b().b(new Runnable() { // from class: com.anythink.dlopt.common.b.a.5
            @Override // java.lang.Runnable
            public final void run() {
                a.this.e(jVar);
                a.this.a(jVar, 0L, 100L, true);
            }
        });
    }

    private void a(j jVar, NotificationCompat.Builder builder, c cVar) {
        if (cVar.d == null || cVar.d != jVar.a()) {
            cVar.d = jVar.a();
            Intent intent = new Intent(b);
            intent.putExtra(e, jVar.o);
            intent.putExtra(d, jVar.b);
            intent.putExtra(f, jVar.a().toString());
            intent.putExtra(g, cVar.a);
            intent.setClass(this.k, NotificationBroadcastReceiver.class);
            PendingIntent broadcast = PendingIntent.getBroadcast(this.k, cVar.a, intent, Build.VERSION.SDK_INT >= 31 ? 201326592 : 134217728);
            Intent intent2 = new Intent(c);
            intent2.putExtra(e, jVar.o);
            intent2.putExtra(d, jVar.b);
            intent2.putExtra(f, jVar.a().toString());
            intent2.putExtra(g, cVar.a);
            intent2.setClass(this.k, NotificationBroadcastReceiver.class);
            builder.setContentIntent(broadcast).setDeleteIntent(PendingIntent.getBroadcast(this.k, cVar.a, intent2, Build.VERSION.SDK_INT < 31 ? 134217728 : 201326592));
        }
    }

    @Override // com.anythink.dlopt.common.b.b
    public final String d(j jVar) {
        return jVar.o;
    }

    public final void e(final j jVar) {
        if (jVar == null || TextUtils.isEmpty(jVar.b) || this.i == null) {
            return;
        }
        t.b().b(new Runnable() { // from class: com.anythink.dlopt.common.b.a.6
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.i.cancel(a.this.f(jVar).a);
                    a.this.h.remove(jVar.o);
                } catch (Throwable th) {
                    String str = a.a;
                    Object[] objArr = new Object[1];
                    th.getMessage();
                }
            }
        });
    }

    public final void a(final int i) {
        if (i < 0) {
            return;
        }
        t.b().b(new Runnable() { // from class: com.anythink.dlopt.common.b.a.7
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.i.cancel(i);
                } catch (Throwable th) {
                    String str = a.a;
                    Object[] objArr = new Object[1];
                    th.getMessage();
                }
            }
        });
    }

    public final void a() {
        t.b().b(new Runnable() { // from class: com.anythink.dlopt.common.b.a.8
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (a.this.i != null) {
                        a.this.i.cancelAll();
                    }
                } catch (Throwable th) {
                    String str = a.a;
                    Object[] objArr = new Object[1];
                    th.getMessage();
                }
            }
        });
    }

    private static void a(Runnable runnable) {
        t.b().b(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c f(j jVar) {
        String str = jVar.o;
        c cVar = this.h.get(str);
        if (cVar != null) {
            return cVar;
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this.k, str);
        NotificationChannel notificationChannel = new NotificationChannel(str, str, 3);
        notificationChannel.setSound(null, null);
        this.i.createNotificationChannel(notificationChannel);
        this.l++;
        builder.setOngoing(true).setSound(null).setPriority(0).setOnlyAlertOnce(true).setAutoCancel(false);
        try {
            builder.setSmallIcon(this.k.getPackageManager().getApplicationInfo(this.k.getPackageName(), 128).icon);
        } catch (Throwable th) {
            th.printStackTrace();
            builder.setSmallIcon(q.a(this.k, "core_icon_close", "drawable"));
        }
        builder.setContentTitle(jVar.c).setLargeIcon(jVar.d);
        c cVar2 = new c();
        cVar2.a = this.l;
        cVar2.b = builder;
        cVar2.c = -1;
        this.h.put(str, cVar2);
        return cVar2;
    }

    static /* synthetic */ void a(a aVar, j jVar, NotificationCompat.Builder builder, c cVar) {
        if (cVar.d == null || cVar.d != jVar.a()) {
            cVar.d = jVar.a();
            Intent intent = new Intent(b);
            intent.putExtra(e, jVar.o);
            intent.putExtra(d, jVar.b);
            intent.putExtra(f, jVar.a().toString());
            intent.putExtra(g, cVar.a);
            intent.setClass(aVar.k, NotificationBroadcastReceiver.class);
            PendingIntent broadcast = PendingIntent.getBroadcast(aVar.k, cVar.a, intent, Build.VERSION.SDK_INT >= 31 ? 201326592 : 134217728);
            Intent intent2 = new Intent(c);
            intent2.putExtra(e, jVar.o);
            intent2.putExtra(d, jVar.b);
            intent2.putExtra(f, jVar.a().toString());
            intent2.putExtra(g, cVar.a);
            intent2.setClass(aVar.k, NotificationBroadcastReceiver.class);
            builder.setContentIntent(broadcast).setDeleteIntent(PendingIntent.getBroadcast(aVar.k, cVar.a, intent2, Build.VERSION.SDK_INT < 31 ? 134217728 : 201326592));
        }
    }
}
