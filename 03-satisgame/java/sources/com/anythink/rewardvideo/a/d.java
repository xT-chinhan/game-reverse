package com.anythink.rewardvideo.a;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.anythink.core.api.ATCommonImpressionListener;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.common.d.s;
import com.anythink.core.common.u.p;

/* JADX INFO: loaded from: classes.dex */
public abstract class d implements ATCommonImpressionListener {
    private final boolean a;
    private final int b;
    protected final f c;
    private volatile boolean d = false;
    private volatile boolean e = false;
    private int f = -1;

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onAdVideoPlayStart() {
    }

    public d(f fVar, boolean z, int i) {
        this.c = fVar;
        this.a = z;
        this.b = i;
    }

    private boolean a() {
        return this.b == 1;
    }

    private boolean b() {
        return this.f == 0;
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onAdImpression() {
        f fVar;
        if (!this.a || (fVar = this.c) == null) {
            return;
        }
        fVar.onRewardedVideoAdPlayStart();
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onAdShowFail(String str, String str2) {
        f fVar;
        if (!this.a || (fVar = this.c) == null) {
            return;
        }
        fVar.onRewardedVideoAdPlayFailed(str, str2);
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onAdClick() {
        if (!this.a || this.c == null) {
            return;
        }
        if (!a()) {
            onAdReward();
        }
        this.c.onRewardedVideoAdPlayClicked();
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onAdDismiss() {
        if (this.a) {
            if (!this.d) {
                this.d = true;
                f fVar = this.c;
                if (fVar != null) {
                    fVar.onRewardedVideoAdPlayEnd();
                }
            }
            if (!b() || a()) {
                onAdReward();
            } else if (!this.e) {
                a("reward_none_for_click");
            }
            f fVar2 = this.c;
            if (fVar2 != null) {
                fVar2.onRewardedVideoAdClosed();
            }
        }
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onAdVideoPlayEnd() {
        if (!this.a || this.c == null || this.d) {
            return;
        }
        this.d = true;
        this.c.onRewardedVideoAdPlayEnd();
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onAdReward() {
        if (this.e) {
            return;
        }
        this.e = true;
        f fVar = this.c;
        if (fVar != null) {
            fVar.onReward();
        }
        if (b()) {
            a("reward_in_close");
        }
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onAdRewardFailed() {
        if (this.c == null || this.e) {
            return;
        }
        this.e = true;
        this.c.onRewardFailed();
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onDeeplinkCallback(boolean z) {
        f fVar = this.c;
        if (fVar != null) {
            fVar.onDeeplinkCallback(z);
        }
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onDownloadConfirm(Context context, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        f fVar = this.c;
        if (fVar != null) {
            fVar.onDownloadConfirm(context, aTNetworkConfirmInfo);
        }
    }

    public final void a(int i) {
        this.f = i;
    }

    private static void a(String str) {
        final String string;
        final Context contextG = s.b().g();
        if (contextG == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            string = contextG.getString(p.a(contextG, str, "string"));
        } catch (Throwable unused) {
            string = null;
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        s.b();
        s.b(new Runnable() { // from class: com.anythink.rewardvideo.a.d$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                d.a(contextG, string);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Context context, String str) {
        try {
            Toast.makeText(context, str, 1).show();
        } catch (Throwable unused) {
        }
    }
}
