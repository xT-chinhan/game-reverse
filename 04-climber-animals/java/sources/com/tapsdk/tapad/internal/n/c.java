package com.tapsdk.tapad.internal.n;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tapsdk.tapad.internal.tracker.experiment.f;
import com.tapsdk.tapad.internal.tracker.experiment.g;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.model.entities.AdInfo;
import com.tapsdk.tapad.stub.activity.Stub_Install_or_OpenApp_Translucent_Activity;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    private static volatile long d = -1;
    private final WeakReference<Activity> a;
    private final File b;
    private final AdInfo c;

    public interface a {
        void a(boolean z);
    }

    public c(Activity activity, File file, AdInfo adInfo) {
        this.a = new WeakReference<>(activity);
        this.b = file;
        this.c = adInfo;
    }

    private void a(Activity activity, a aVar) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        d dVar = (d) fragmentManager.findFragmentByTag(d.c);
        if (dVar == null) {
            dVar = new d();
            fragmentManager.beginTransaction().add(dVar, d.c).commitNowAllowingStateLoss();
        }
        dVar.a(aVar, this.b, this.c);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0023 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private void a(Throwable th, String str) {
        long jLongValue;
        String str2;
        int i;
        AdInfo adInfo = this.c;
        String string = null;
        if (adInfo != null) {
            str2 = adInfo.trackId;
            jLongValue = adInfo.spaceId.longValue();
            i = this.c.sampleRatioInstall;
            if (i < 0 || i > 100) {
            }
            if (th != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("exception", th.getMessage());
                    jSONObject.put("ref", str);
                    string = jSONObject.toString();
                } catch (Throwable unused) {
                }
            }
            f.b().a(g.b).a(new com.tapsdk.tapad.internal.tracker.experiment.h.d().a(0).a(Long.valueOf(jLongValue)).c(str2).b(string).a("1").b(i));
        }
        jLongValue = Long.MAX_VALUE;
        str2 = null;
        i = Integer.MAX_VALUE;
        if (th != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("exception", th.getMessage());
            jSONObject2.put("ref", str);
            string = jSONObject2.toString();
        }
        f.b().a(g.b).a(new com.tapsdk.tapad.internal.tracker.experiment.h.d().a(0).a(Long.valueOf(jLongValue)).c(str2).b(string).a("1").b(i));
    }

    public void a() {
        a(null);
    }

    public void a(a aVar) {
        String str;
        if (d == -1 || SystemClock.elapsedRealtime() - d > 500) {
            d = SystemClock.elapsedRealtime();
            if (this.a.get() == null || this.a.get().isDestroyed() || this.c != null) {
                try {
                    Context applicationContext = com.tapsdk.tapad.c.a.getApplicationContext();
                    Intent newIntent = Stub_Install_or_OpenApp_Translucent_Activity.getNewIntent(applicationContext, this.b, this.c, aVar);
                    newIntent.addFlags(C.ENCODING_PCM_MU_LAW);
                    applicationContext.startActivity(newIntent);
                    return;
                } catch (Throwable th) {
                    th = th;
                    TapADLogger.e("Get Experiment Tap Activity :" + th.getMessage());
                    str = TTDownloadField.TT_ACTIVITY;
                }
            } else {
                try {
                    a(this.a.get(), aVar);
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    TapADLogger.e("Get Experiment Tap Activity :" + th.getMessage());
                    str = "fragment";
                }
            }
            a(th, str);
        }
    }
}
