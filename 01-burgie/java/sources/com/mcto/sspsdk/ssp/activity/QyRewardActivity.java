package com.mcto.sspsdk.ssp.activity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.mcto.sspsdk.IQyRewardVideoAd;
import com.mcto.sspsdk.QyAdSlot;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.internal.ce;
import com.mcto.sspsdk.internal.hk;
import com.mcto.sspsdk.internal.l;
import com.mcto.sspsdk.internal.o7;
import com.mcto.sspsdk.internal.oc;
import com.mcto.sspsdk.internal.og;
import com.mcto.sspsdk.internal.p;
import com.mcto.sspsdk.internal.p9;
import com.mcto.sspsdk.internal.pc;
import com.mcto.sspsdk.internal.pg;
import com.mcto.sspsdk.internal.q9;
import com.mcto.sspsdk.internal.r9;
import com.mcto.sspsdk.internal.rg;
import com.mcto.sspsdk.internal.ue;
import com.mcto.sspsdk.internal.ve;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class QyRewardActivity extends AppCompatActivity implements o7 {
    private ArrayList a;
    private ArrayList b;
    private QyAdSlot c;
    private p f;
    private ve g;
    private int h;
    private boolean i;
    private IQyRewardVideoAd.IAdInteractionListener l;
    private ViewGroup m;
    private int d = 0;
    private int e = 0;
    private final AtomicBoolean j = new AtomicBoolean(false);
    private final AtomicBoolean k = new AtomicBoolean(false);

    private void b() {
        int i = this.d;
        if (i < this.e) {
            if (i == 0) {
                this.f = ((rg) this.a.get(i)).a;
                this.g = (ve) this.b.get(this.d);
            } else {
                ve veVar = this.g;
                this.i = veVar.v;
                int width = veVar.getWidth();
                Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(veVar, width, 0, (float) Math.hypot(width, veVar.getHeight()), 0.0f);
                animatorCreateCircularReveal.setDuration(400L);
                animatorCreateCircularReveal.addListener(new b(this, veVar));
                animatorCreateCircularReveal.start();
                this.f = ((rg) this.a.get(this.d)).a;
                ve veVar2 = (ve) this.b.get(this.d);
                this.g = veVar2;
                if (this.i) {
                    veVar2.n.a(true);
                    veVar2.h.setImageResource(R.drawable.qy_ic_volume_off_with_bg);
                    veVar2.v = true;
                } else {
                    veVar2.n.a(false);
                    veVar2.h.setImageResource(R.drawable.qy_ic_volume_on_with_bg);
                    veVar2.v = false;
                }
            }
            this.m.addView(this.g, 0, new ViewGroup.LayoutParams(-1, -1));
            this.d++;
        }
    }

    @Override // com.mcto.sspsdk.internal.o7
    public final void onAdClick() {
        IQyRewardVideoAd.IAdInteractionListener iAdInteractionListener = this.l;
        if (iAdInteractionListener != null) {
            iAdInteractionListener.onAdClick();
        }
    }

    @Override // com.mcto.sspsdk.internal.o7
    public final void onAdClose() {
        if (this.l != null) {
            r9.a("ssp_sdk", "reward Ad close。", null);
            this.l.onAdClose();
        }
        finish();
        q9 q9Var = p9.a;
        p pVar = this.f;
        q9Var.getClass();
        q9.a(22, pVar, null);
    }

    @Override // com.mcto.sspsdk.internal.o7
    public final void onAdComplete() {
        if (this.d != this.e && this.f.L0.M == 0) {
            b();
            return;
        }
        IQyRewardVideoAd.IAdInteractionListener iAdInteractionListener = this.l;
        if (iAdInteractionListener != null) {
            iAdInteractionListener.onVideoComplete();
        }
    }

    @Override // com.mcto.sspsdk.internal.o7
    public final void onAdShow() {
        IQyRewardVideoAd.IAdInteractionListener iAdInteractionListener;
        if (!this.j.compareAndSet(false, true) || (iAdInteractionListener = this.l) == null) {
            return;
        }
        iAdInteractionListener.onAdShow();
    }

    @Override // com.mcto.sspsdk.internal.o7
    public final void onAdSkip() {
        if (this.d != this.e) {
            b();
        }
        q9 q9Var = p9.a;
        p pVar = this.f;
        q9Var.getClass();
        q9.a(24, pVar, null);
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.qy_activity_trueview);
        int i = 1;
        hk.a((AppCompatActivity) this, true);
        try {
            pg pgVar = (pg) og.a.getAndSet(null);
            ArrayList arrayList = pgVar.a;
            this.d = 0;
            this.e = arrayList.size();
            this.a = arrayList;
            this.c = pgVar.b;
            this.l = pgVar.c;
            int rotation = getWindowManager().getDefaultDisplay().getRotation();
            int intExtra = getResources().getConfiguration().orientation;
            Intent intent = getIntent();
            if (intent != null) {
                intExtra = intent.getIntExtra("orientation", intExtra);
            }
            if (intExtra == 1) {
                this.h = 1;
            } else {
                this.h = 2;
            }
            if (!hk.d(this)) {
                if (intExtra != 1) {
                    i = rotation == 1 ? 0 : 8;
                }
                setRequestedOrientation(i);
            }
            this.i = this.c.isMute();
            this.m = (ViewGroup) findViewById(R.id.qy_reward_root);
            View viewFindViewById = findViewById(android.R.id.content);
            viewFindViewById.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            viewFindViewById.setOnApplyWindowInsetsListener(new ce(this));
            a();
            b();
        } catch (Exception e) {
            r9.a("ssp_reward", "create", e);
            a(4, "Activity render error" + r9.a(e));
            finish();
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected final void onDestroy() {
        super.onDestroy();
        ArrayList arrayList = this.b;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((ve) it.next()).e();
            }
        }
        if (!this.k.get() || this.f == null) {
            return;
        }
        l lVarA = l.a();
        p pVar = this.f;
        lVarA.getClass();
        l.a(1, pVar);
    }

    @Override // com.mcto.sspsdk.internal.o7
    public final void onRewardVerify(HashMap map) {
        if (this.d == this.e && this.k.compareAndSet(false, true)) {
            IQyRewardVideoAd.IAdInteractionListener iAdInteractionListener = this.l;
            if (iAdInteractionListener != null) {
                iAdInteractionListener.onRewardVerify(map);
            }
            q9 q9Var = p9.a;
            p pVar = this.f;
            q9Var.getClass();
            q9.a(26, pVar, null);
        }
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
        if (this.d != this.e && this.f.L0.M == 0) {
            b();
            return;
        }
        IQyRewardVideoAd.IAdInteractionListener iAdInteractionListener = this.l;
        if (iAdInteractionListener != null) {
            iAdInteractionListener.onVideoError(i, str);
        }
        q9 q9Var = p9.a;
        q9Var.getClass();
        q9.a(6, this.f, "error:" + i + "msg:" + str);
    }

    @Override // com.mcto.sspsdk.internal.o7
    public final void a(HashMap map) {
        IQyRewardVideoAd.IAdInteractionListener iAdInteractionListener;
        if (this.d == this.e && (iAdInteractionListener = this.l) != null) {
            iAdInteractionListener.onRewardVerify(map);
        }
    }

    private void a() {
        ViewParent veVar;
        this.b = new ArrayList(this.e);
        for (int i = 0; i < this.e; i++) {
            rg rgVar = (rg) this.a.get(i);
            rgVar.a.d0 = this.c.isAutoDownloadInLandingPage();
            if (rgVar.a.n()) {
                int i2 = pc.m0;
                oc ocVar = new oc();
                ocVar.j = rgVar;
                ocVar.b = this;
                ocVar.c = rgVar.a;
                ocVar.f = this;
                ocVar.e = this.h;
                ocVar.a = this.i;
                ocVar.d = this.c;
                int i3 = this.e;
                ocVar.g = i + 1;
                ocVar.h = i3;
                ocVar.i = true;
                veVar = new pc(ocVar);
            } else {
                int i4 = ve.i0;
                ue ueVar = new ue();
                ueVar.b = this;
                ueVar.c = rgVar.a;
                ueVar.f = this;
                ueVar.e = this.h;
                ueVar.a = this.i;
                ueVar.d = this.c;
                int i5 = this.e;
                ueVar.g = i + 1;
                ueVar.h = i5;
                ueVar.i = true;
                veVar = new ve(ueVar);
            }
            this.b.add(veVar);
        }
    }
}
