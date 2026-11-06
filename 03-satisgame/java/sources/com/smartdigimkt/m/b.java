package com.smartdigimkt.m;

import android.app.NotificationManager;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.smartdigimkt.k.r;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {
    public final /* synthetic */ r a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ j e;

    public b(long j, long j2, r rVar, j jVar, boolean z) {
        this.e = jVar;
        this.a = rVar;
        this.b = j;
        this.c = j2;
        this.d = z;
    }

    /* JADX WARN: Code duplicated, block: B:70:0x01a9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x01ab A[Catch: all -> 0x01ea, TryCatch #0 {all -> 0x01ea, blocks: (B:3:0x0002, B:5:0x0008, B:9:0x0016, B:8:0x000e, B:10:0x0018, B:14:0x0035, B:17:0x0041, B:68:0x01a1, B:71:0x01ab, B:72:0x01b2, B:73:0x01b7, B:75:0x01c9, B:77:0x01dc, B:76:0x01d3, B:19:0x0059, B:21:0x0061, B:22:0x007c, B:24:0x0084, B:26:0x00a1, B:35:0x00be, B:43:0x00dd, B:47:0x00e4, B:49:0x00ed, B:51:0x00f5, B:53:0x00fc, B:54:0x0113, B:55:0x012a, B:57:0x0132, B:58:0x0149, B:63:0x0157, B:65:0x015e, B:66:0x017f, B:38:0x00cc, B:48:0x00e8), top: B:82:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x01b2 A[Catch: all -> 0x01ea, TryCatch #0 {all -> 0x01ea, blocks: (B:3:0x0002, B:5:0x0008, B:9:0x0016, B:8:0x000e, B:10:0x0018, B:14:0x0035, B:17:0x0041, B:68:0x01a1, B:71:0x01ab, B:72:0x01b2, B:73:0x01b7, B:75:0x01c9, B:77:0x01dc, B:76:0x01d3, B:19:0x0059, B:21:0x0061, B:22:0x007c, B:24:0x0084, B:26:0x00a1, B:35:0x00be, B:43:0x00dd, B:47:0x00e4, B:49:0x00ed, B:51:0x00f5, B:53:0x00fc, B:54:0x0113, B:55:0x012a, B:57:0x0132, B:58:0x0149, B:63:0x0157, B:65:0x015e, B:66:0x017f, B:38:0x00cc, B:48:0x00e8), top: B:82:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x01c9 A[Catch: all -> 0x01ea, TryCatch #0 {all -> 0x01ea, blocks: (B:3:0x0002, B:5:0x0008, B:9:0x0016, B:8:0x000e, B:10:0x0018, B:14:0x0035, B:17:0x0041, B:68:0x01a1, B:71:0x01ab, B:72:0x01b2, B:73:0x01b7, B:75:0x01c9, B:77:0x01dc, B:76:0x01d3, B:19:0x0059, B:21:0x0061, B:22:0x007c, B:24:0x0084, B:26:0x00a1, B:35:0x00be, B:43:0x00dd, B:47:0x00e4, B:49:0x00ed, B:51:0x00f5, B:53:0x00fc, B:54:0x0113, B:55:0x012a, B:57:0x0132, B:58:0x0149, B:63:0x0157, B:65:0x015e, B:66:0x017f, B:38:0x00cc, B:48:0x00e8), top: B:82:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x01d3 A[Catch: all -> 0x01ea, TryCatch #0 {all -> 0x01ea, blocks: (B:3:0x0002, B:5:0x0008, B:9:0x0016, B:8:0x000e, B:10:0x0018, B:14:0x0035, B:17:0x0041, B:68:0x01a1, B:71:0x01ab, B:72:0x01b2, B:73:0x01b7, B:75:0x01c9, B:77:0x01dc, B:76:0x01d3, B:19:0x0059, B:21:0x0061, B:22:0x007c, B:24:0x0084, B:26:0x00a1, B:35:0x00be, B:43:0x00dd, B:47:0x00e4, B:49:0x00ed, B:51:0x00f5, B:53:0x00fc, B:54:0x0113, B:55:0x012a, B:57:0x0132, B:58:0x0149, B:63:0x0157, B:65:0x015e, B:66:0x017f, B:38:0x00cc, B:48:0x00e8), top: B:82:0x0002 }] */
    @Override // java.lang.Runnable
    public final void run() {
        String str;
        boolean z;
        int i;
        String string;
        String string2;
        try {
            j jVar = this.e;
            if (jVar.a == null) {
                Context context = jVar.c;
                jVar.a = context == null ? null : (NotificationManager) context.getSystemService("notification");
            }
            k kVarA = j.a(this.e, this.a);
            NotificationCompat.Builder progress = kVarA.b;
            j.a(this.e, this.a, progress, kVarA);
            int i2 = kVarA.c;
            r rVar = this.a;
            boolean z2 = rVar.q == 2;
            if (rVar.s != com.smartdigimkt.k.c.INSTALLED) {
                if (this.a.s != com.smartdigimkt.k.c.FINISH) {
                    if (this.a.s == com.smartdigimkt.k.c.FAIL) {
                        string2 = this.e.c.getResources().getString(com.smartdigimkt.r4.k.a(this.e.c, "notification_click_to_retry", "string"));
                    } else {
                        j jVar2 = this.e;
                        long j = this.b;
                        str = "default";
                        long j2 = this.c;
                        jVar2.getClass();
                        boolean z3 = j2 > 0 && j >= 0 && j <= j2;
                        if (z3) {
                            j jVar3 = this.e;
                            long j3 = this.b;
                            long j4 = this.c;
                            jVar3.getClass();
                            if (j4 <= 0 || (i = (int) (((j3 * 1.0f) / j4) * 100.0f)) < 0) {
                                i = 0;
                            } else if (i > 100) {
                                i = 100;
                            }
                            if (!this.d && i2 == i) {
                                return;
                            }
                            kVarA.c = i;
                            z = false;
                        } else {
                            kVarA.c = -1;
                            z = true;
                            i = 0;
                        }
                        if (this.a.s == com.smartdigimkt.k.c.IDLE) {
                            string = this.a.r == 2 ? this.e.c.getResources().getString(com.smartdigimkt.r4.k.a(this.e.c, "notification_waiting_for_download", "string")) : this.e.c.getResources().getString(com.smartdigimkt.r4.k.a(this.e.c, "notification_waiting_for_download_or_pause", "string"));
                        } else if (this.a.s == com.smartdigimkt.k.c.PAUSE) {
                            string = this.e.c.getResources().getString(com.smartdigimkt.r4.k.a(this.e.c, "notification_continue_to_download", "string"));
                        } else if (this.a.s == com.smartdigimkt.k.c.LOADING) {
                            if (z3) {
                                string = this.a.r == 2 ? this.e.c.getResources().getString(com.smartdigimkt.r4.k.a(this.e.c, "notification_in_download", "string"), String.valueOf(i)) : this.e.c.getResources().getString(com.smartdigimkt.r4.k.a(this.e.c, "notification_in_download_or_pause", "string"), String.valueOf(i));
                            } else {
                                string = "下载中…";
                            }
                        }
                        z2 = false;
                    }
                    if (this.a.s == com.smartdigimkt.k.c.LOADING) {
                        if (z) {
                            progress = progress.setProgress(0, 0, true);
                        } else {
                            progress = progress.setProgress(100, i, false);
                        }
                    }
                    progress.setContentText(str).setStyle(new NotificationCompat.BigTextStyle().bigText(str));
                    if (z2) {
                        progress.setOngoing(false).setAutoCancel(true);
                    } else {
                        progress.setOngoing(true).setAutoCancel(false);
                    }
                    this.e.a.notify(kVarA.a, progress.build());
                }
                string = this.e.c.getResources().getString(com.smartdigimkt.r4.k.a(this.e.c, "notification_click_to_install", "string"));
                i = 100;
                z = false;
                str = string;
                if (this.a.s == com.smartdigimkt.k.c.LOADING) {
                    if (z) {
                        progress = progress.setProgress(0, 0, true);
                    } else {
                        progress = progress.setProgress(100, i, false);
                    }
                }
                progress.setContentText(str).setStyle(new NotificationCompat.BigTextStyle().bigText(str));
                if (z2) {
                    progress.setOngoing(false).setAutoCancel(true);
                } else {
                    progress.setOngoing(true).setAutoCancel(false);
                }
                this.e.a.notify(kVarA.a, progress.build());
            }
            string2 = this.e.c.getResources().getString(com.smartdigimkt.r4.k.a(this.e.c, "notification_click_to_open", "string"));
            str = string2;
            z = false;
            z2 = true;
            i = 0;
            if (this.a.s == com.smartdigimkt.k.c.LOADING) {
                if (z) {
                    progress = progress.setProgress(0, 0, true);
                } else {
                    progress = progress.setProgress(100, i, false);
                }
            }
            progress.setContentText(str).setStyle(new NotificationCompat.BigTextStyle().bigText(str));
            if (z2) {
                progress.setOngoing(false).setAutoCancel(true);
            } else {
                progress.setOngoing(true).setAutoCancel(false);
            }
            this.e.a.notify(kVarA.a, progress.build());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
