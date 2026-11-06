package com.tapsdk.tapad.stub.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.internal.n.b;
import com.tapsdk.tapad.internal.n.c;
import com.tapsdk.tapad.internal.tracker.experiment.f;
import com.tapsdk.tapad.internal.tracker.experiment.g;
import com.tapsdk.tapad.internal.tracker.experiment.h.d;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.internal.utils.h;
import com.tapsdk.tapad.model.entities.AdInfo;
import java.io.File;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class Stub_Install_or_OpenApp_Translucent_Activity extends Activity {
    private static final String EXTRA_BINDER_AD_INFO = "extra_binder_ad_info";
    private static final int PARAM_INSTALL_REQUEST_CODE = 1001;
    public AdInfo adInfo = null;
    public c.a installCallback = null;
    public String packageName = "";
    private int pausedTimes = 0;
    private int resumedTimes = 0;
    private long lastPausedTimeInMillis = -1;

    public static Intent getNewIntent(Context context, File file, AdInfo adInfo, c.a aVar) {
        Uri uriA;
        Intent intent = new Intent(context, (Class<?>) Stub_Install_or_OpenApp_Translucent_Activity.class);
        try {
            uriA = h.a(context, file);
        } catch (Throwable unused) {
            uriA = null;
        }
        try {
            intent.setData(uriA);
            if (adInfo != null) {
                Bundle bundle = new Bundle();
                bundle.putBinder(EXTRA_BINDER_AD_INFO, new b(adInfo, aVar));
                intent.putExtras(bundle);
            }
        } catch (Throwable unused2) {
        }
        return intent;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        TapADLogger.d("Stub_Install_or_OpenApp_Translucent_Activity onActivityResult");
        super.onActivityResult(i, i2, intent);
        if (i != 1001 || intent == null) {
            return;
        }
        TapADLogger.d("install callback:" + intent);
        if (intent.getExtras() != null) {
            TapADLogger.d("install callback result:" + intent);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        List<String> list;
        Intent intentA;
        String str;
        int i;
        long jLongValue;
        String str2;
        b bVar;
        super.onCreate(bundle);
        getWindow().addFlags(1152);
        setContentView(R.layout.tapad_install_foward);
        TapADLogger.d("Stub_Install_or_OpenApp_Translucent_Activity onCreate");
        try {
            Bundle extras = getIntent().getExtras();
            if (extras != null && (bVar = (b) extras.getBinder(EXTRA_BINDER_AD_INFO)) != null) {
                AdInfo adInfo = bVar.a;
                this.adInfo = adInfo;
                if (adInfo != null && adInfo.appInfo != null) {
                    TapADLogger.d("Stub_Install_Translucent_Activity adInfo not null");
                    this.packageName = this.adInfo.appInfo.packageName;
                }
                this.installCallback = bVar.b;
            }
            String str3 = this.packageName;
            boolean z = true;
            int i2 = Integer.MAX_VALUE;
            long j = Long.MAX_VALUE;
            if (str3 == null || str3.length() <= 0 || !com.tapsdk.tapad.internal.utils.b.a(this, this.packageName)) {
                Uri data = getIntent().getData();
                if (data == null) {
                    TapADLogger.d("Stub_Install_Translucent_Activity 未传入安装");
                    AdInfo adInfo2 = this.adInfo;
                    if (adInfo2 != null) {
                        str = adInfo2.trackId;
                        jLongValue = this.adInfo.spaceId.longValue();
                        i = (this.adInfo.sampleRatioInstall < 0 || this.adInfo.sampleRatioInstall > 100) ? Integer.MAX_VALUE : this.adInfo.sampleRatioInstall;
                    } else {
                        str = null;
                        i = Integer.MAX_VALUE;
                        jLongValue = Long.MAX_VALUE;
                    }
                    f.b().a(g.b).a(new d().a(1).a(Long.valueOf(jLongValue)).c(str).b("uri is not valid").a("1").b(i));
                    finish();
                }
                intentA = h.a(data);
                z = false;
            } else {
                intentA = h.a(this, this.packageName);
            }
            if (intentA != null) {
                intentA.setFlags(268435457);
                AdInfo adInfo3 = this.adInfo;
                if (adInfo3 != null) {
                    String str4 = adInfo3.trackId;
                    long jLongValue2 = this.adInfo.spaceId.longValue();
                    if (this.adInfo.sampleRatioInstall >= 0 && this.adInfo.sampleRatioInstall <= 100) {
                        i2 = this.adInfo.sampleRatioInstall;
                    }
                    str2 = str4;
                    j = jLongValue2;
                } else {
                    str2 = null;
                }
                try {
                    startActivityForResult(intentA, 1001);
                    f.b().a(g.b).a(new d().a(3).a(Long.valueOf(j)).c(str2).a("1").b(i2));
                } catch (Throwable th) {
                    if (!z) {
                        f.b().a(g.b).a(new d().a(2).a(Long.valueOf(j)).c(str2).b(th.getMessage()).a("1").b(i2));
                    }
                }
                if (z) {
                    finish();
                }
            }
        } catch (Throwable unused) {
            finish();
        }
        AdInfo adInfo4 = this.adInfo;
        if (adInfo4 == null || (list = adInfo4.installStartMonitorUrls) == null || list.size() <= 0) {
            return;
        }
        TapADLogger.d("Stub_Install_or_OpenApp_Translucent_Activity track install start");
        com.tapsdk.tapad.internal.tracker.c cVarA = com.tapsdk.tapad.internal.tracker.c.a();
        AdInfo adInfo5 = this.adInfo;
        cVarA.a(adInfo5.installStartMonitorUrls, (Map<String, String>) null, adInfo5.getInstallStartMonitorHeaderListWrapper());
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        TapADLogger.d("Stub_Install_or_OpenApp_Translucent_Activity onPause");
        this.pausedTimes++;
        this.lastPausedTimeInMillis = SystemClock.elapsedRealtime();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        TapADLogger.d("Stub_Install_or_OpenApp_Translucent_Activity onRestart");
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00cd  */
    @Override // android.app.Activity
    protected void onResume() {
        long jLongValue;
        int i;
        c.a aVar;
        super.onResume();
        TapADLogger.d("Stub_Install_or_OpenApp_Translucent_Activity onResume:resumedTime" + this.resumedTimes + ",pausedTimes:" + this.pausedTimes);
        if (this.resumedTimes < this.pausedTimes) {
            if (SystemClock.elapsedRealtime() - this.lastPausedTimeInMillis > 500) {
                TapADLogger.d("Stub_Install_or_OpenApp_Translucent_Activity preCheck installed");
                String str = null;
                if (com.tapsdk.tapad.internal.utils.b.a(this, this.packageName)) {
                    TapADLogger.d("Stub_Install_or_OpenApp_Translucent_Activity track installed 000");
                    AdInfo adInfo = this.adInfo;
                    if (adInfo != null && adInfo.installStartMonitorUrls != null && adInfo.installedMonitorUrls.size() > 0) {
                        TapADLogger.d("Stub_Install_or_OpenApp_Translucent_Activity track installed 111");
                        com.tapsdk.tapad.internal.tracker.c cVarA = com.tapsdk.tapad.internal.tracker.c.a();
                        AdInfo adInfo2 = this.adInfo;
                        cVarA.a(adInfo2.installedMonitorUrls, (Map<String, String>) null, adInfo2.getInstalledMonitorHeaderListWrapper());
                    }
                    c.a aVar2 = this.installCallback;
                    if (aVar2 != null) {
                        aVar2.a(true);
                    }
                } else {
                    AdInfo adInfo3 = this.adInfo;
                    if (adInfo3 != null) {
                        str = adInfo3.trackId;
                        jLongValue = adInfo3.spaceId.longValue();
                        i = this.adInfo.sampleRatioInstall;
                        if (i < 0 || i > 100) {
                        }
                        f.b().a(g.b).a(new d().a(4).a(Long.valueOf(jLongValue)).c(str).b("user cancel").a("1").b(i));
                        aVar = this.installCallback;
                        if (aVar != null) {
                            aVar.a(false);
                        }
                    } else {
                        jLongValue = Long.MAX_VALUE;
                    }
                    i = Integer.MAX_VALUE;
                    f.b().a(g.b).a(new d().a(4).a(Long.valueOf(jLongValue)).c(str).b("user cancel").a("1").b(i));
                    aVar = this.installCallback;
                    if (aVar != null) {
                        aVar.a(false);
                    }
                }
                finish();
            }
            this.resumedTimes++;
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        TapADLogger.d("Stub_Install_or_OpenApp_Translucent_Activity onStarted");
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        TapADLogger.d("Stub_Install_or_OpenApp_Translucent_Activity onStopped");
    }
}
