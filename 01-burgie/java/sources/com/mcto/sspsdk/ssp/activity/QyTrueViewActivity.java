package com.mcto.sspsdk.ssp.activity;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import com.mcto.sspsdk.IQyRewardVideoAd;
import com.mcto.sspsdk.QyAdSlot;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.internal.hk;
import com.mcto.sspsdk.internal.lj;
import com.mcto.sspsdk.internal.o7;
import com.mcto.sspsdk.internal.og;
import com.mcto.sspsdk.internal.p;
import com.mcto.sspsdk.internal.p9;
import com.mcto.sspsdk.internal.pg;
import com.mcto.sspsdk.internal.q9;
import com.mcto.sspsdk.internal.r9;
import com.mcto.sspsdk.internal.ue;
import com.mcto.sspsdk.internal.ve;
import com.mcto.sspsdk.internal.we;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class QyTrueViewActivity extends AppCompatActivity implements o7 {
    private p a;
    private QyAdSlot b;
    private ve c;
    private int d;
    private boolean e;
    private IQyRewardVideoAd.IAdInteractionListener f;
    private final AtomicBoolean g = new AtomicBoolean(false);

    private boolean a() {
        pg pgVar = (pg) og.a.getAndSet(null);
        p pVar = (p) pgVar.a.get(0);
        this.a = pVar;
        this.b = pgVar.b;
        this.f = pgVar.c;
        if (pVar == null) {
            a(14, "ad is empty when activity initData");
            return false;
        }
        if (pVar.T0 != 4) {
            a(8, "init data type error");
            return false;
        }
        if (!lj.b(pVar.G)) {
            return true;
        }
        a(4, "creative url is null");
        return false;
    }

    @Override // com.mcto.sspsdk.internal.o7
    public final void onAdClick() {
        IQyRewardVideoAd.IAdInteractionListener iAdInteractionListener = this.f;
        if (iAdInteractionListener != null) {
            iAdInteractionListener.onAdClick();
        }
    }

    @Override // com.mcto.sspsdk.internal.o7
    public final void onAdClose() {
        if (this.f != null) {
            r9.a("ssp_sdk", "reward Ad close。", null);
            this.f.onAdClose();
        }
        finish();
        q9 q9Var = p9.a;
        p pVar = this.a;
        q9Var.getClass();
        q9.a(22, pVar, null);
    }

    @Override // com.mcto.sspsdk.internal.o7
    public final void onAdComplete() {
        p9.a.a("onVideoComplete:");
        IQyRewardVideoAd.IAdInteractionListener iAdInteractionListener = this.f;
        if (iAdInteractionListener != null) {
            iAdInteractionListener.onVideoComplete();
        }
    }

    @Override // com.mcto.sspsdk.internal.o7
    public final void onAdShow() {
        if (this.g.compareAndSet(false, true)) {
            p9.a.a(Integer.valueOf(this.a.a), "onAdShow()");
            IQyRewardVideoAd.IAdInteractionListener iAdInteractionListener = this.f;
            if (iAdInteractionListener != null) {
                iAdInteractionListener.onAdShow();
            }
        }
    }

    @Override // com.mcto.sspsdk.internal.o7
    public final void onAdSkip() {
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.qy_activity_trueview);
        try {
            if (!a()) {
                finish();
                return;
            }
            int i = 1;
            hk.a((AppCompatActivity) this, true);
            int videoAdOrientation = this.b.getVideoAdOrientation();
            this.d = videoAdOrientation;
            if (videoAdOrientation != 1) {
                i = 0;
            }
            setRequestedOrientation(i);
            this.e = this.b.isMute();
            this.a.d0 = this.b.isAutoDownloadInLandingPage();
            p pVar = this.a;
            int i2 = ve.i0;
            ue ueVar = new ue();
            ueVar.b = this;
            ueVar.c = pVar;
            ueVar.f = this;
            ueVar.e = this.d;
            ueVar.a = this.e;
            ueVar.d = this.b;
            this.c = new ve(ueVar);
            ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
            viewGroup.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            viewGroup.setOnApplyWindowInsetsListener(new we(this));
            viewGroup.addView(this.c, new ViewGroup.LayoutParams(-1, -1));
        } catch (Exception e) {
            a(4, "Activity render error" + e.getMessage());
            finish();
            r9.a("ssp_reward", "create", e);
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected final void onDestroy() {
        ve veVar = this.c;
        if (veVar != null) {
            veVar.e();
        }
        super.onDestroy();
    }

    @Override // com.mcto.sspsdk.internal.o7
    public final void onRewardVerify(HashMap map) {
        p9.a.a("rvf", "hasSendImpression:", Boolean.valueOf(this.g.get()));
        IQyRewardVideoAd.IAdInteractionListener iAdInteractionListener = this.f;
        if (iAdInteractionListener != null) {
            iAdInteractionListener.onRewardVerify(map);
        }
        q9.a(26, this.a, null);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            hk.a((AppCompatActivity) this, true);
        }
    }

    @Override // com.mcto.sspsdk.internal.o7
    public final void a(int i, String str) {
        p9.a.a("onAdError:", Integer.valueOf(i), str);
        IQyRewardVideoAd.IAdInteractionListener iAdInteractionListener = this.f;
        if (iAdInteractionListener != null) {
            iAdInteractionListener.onVideoError(i, str);
        }
        q9.a(6, this.a, "error:" + i + "msg:" + str);
    }

    @Override // com.mcto.sspsdk.internal.o7
    public final void a(HashMap map) {
        p9.a.a("hasSendImpression:", Boolean.valueOf(this.g.get()), "prv", map);
        IQyRewardVideoAd.IAdInteractionListener iAdInteractionListener = this.f;
        if (iAdInteractionListener != null) {
            iAdInteractionListener.onRewardVerify(map);
        }
    }
}
