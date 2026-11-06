package com.tapsdk.tapad.internal.n;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.tapsdk.tapad.internal.tracker.experiment.f;
import com.tapsdk.tapad.internal.tracker.experiment.g;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.internal.utils.h;
import com.tapsdk.tapad.model.entities.AdInfo;
import java.io.File;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class d extends Fragment {
    public static final String c = "InstallFragment";
    public static final int d = 1;
    private volatile long a = -1;
    private c.a b;

    class a implements Runnable {
        final /* synthetic */ AdInfo a;
        final /* synthetic */ c.a b;
        final /* synthetic */ File c;

        a(AdInfo adInfo, c.a aVar, File file) {
            this.a = adInfo;
            this.b = aVar;
            this.c = file;
        }

        /* JADX WARN: Code duplicated, block: B:33:0x00b5  */
        /* JADX WARN: Code duplicated, block: B:45:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        public void run() {
            long jLongValue;
            String str;
            int i;
            List<String> list;
            AdInfo adInfo = this.a;
            if (adInfo != null && adInfo.materialInfo != null) {
                TapADLogger.d("startInstall " + this.a.appInfo.packageName);
            }
            AdInfo adInfo2 = this.a;
            Uri uriA = null;
            if (adInfo2 != null && (list = adInfo2.installStartMonitorUrls) != null && list.size() > 0) {
                com.tapsdk.tapad.internal.tracker.c cVarA = com.tapsdk.tapad.internal.tracker.c.a();
                AdInfo adInfo3 = this.a;
                cVarA.a(adInfo3.installStartMonitorUrls, (Map<String, String>) null, adInfo3.getInstallStartMonitorHeaderListWrapper());
            }
            d.this.b = this.b;
            File file = this.c;
            if (file == null || !file.exists()) {
                return;
            }
            Context context = d.this.getContext();
            AdInfo adInfo4 = this.a;
            try {
                if (adInfo4 != null) {
                    str = adInfo4.trackId;
                    jLongValue = adInfo4.spaceId.longValue();
                    i = this.a.sampleRatioInstall;
                    if (i < 0 || i > 100) {
                    }
                    uriA = h.a(context, this.c);
                    if (uriA != null) {
                        try {
                            d.this.startActivityForResult(h.a(uriA), 1);
                        } catch (Throwable th) {
                            f.b().a(g.b).a(new com.tapsdk.tapad.internal.tracker.experiment.h.d().a(2).a(Long.valueOf(jLongValue)).c(str).b(th.getMessage()).a("1").b(i));
                            return;
                        }
                    }
                }
                jLongValue = Long.MAX_VALUE;
                str = null;
                uriA = h.a(context, this.c);
            } catch (Throwable th2) {
                f.b().a(g.b).a(new com.tapsdk.tapad.internal.tracker.experiment.h.d().a(1).a(Long.valueOf(jLongValue)).c(str).b(th2.getMessage()).a("1").b(i));
            }
            i = Integer.MAX_VALUE;
            if (uriA != null) {
                d.this.startActivityForResult(h.a(uriA), 1);
            }
        }
    }

    public void a(c.a aVar, File file, AdInfo adInfo) {
        if (this.a == -1 || SystemClock.elapsedRealtime() - this.a > 1000) {
            this.a = SystemClock.elapsedRealtime();
            new Handler().post(new a(adInfo, aVar, file));
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        TapADLogger.d("InstallFragment onActivityResult callback000:" + i);
        if (i == 1) {
            TapADLogger.d("InstallFragment onActivityResult callback111");
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.a(true);
                return;
            }
        }
        c.a aVar2 = this.b;
        if (aVar2 != null) {
            aVar2.a(false);
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.b != null) {
            TapADLogger.d("InstallFragment onStop callback onResult");
            this.b.a(true);
        }
    }
}
