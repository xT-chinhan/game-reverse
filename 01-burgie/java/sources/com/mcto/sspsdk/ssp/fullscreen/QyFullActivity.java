package com.mcto.sspsdk.ssp.fullscreen;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import com.mcto.sspsdk.QyAdSlot;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.internal.e;
import com.mcto.sspsdk.internal.ea;
import com.mcto.sspsdk.internal.eh;
import com.mcto.sspsdk.internal.hk;
import com.mcto.sspsdk.internal.m;
import com.mcto.sspsdk.internal.o6;
import com.mcto.sspsdk.internal.o9;
import com.mcto.sspsdk.internal.og;
import com.mcto.sspsdk.internal.p;
import com.mcto.sspsdk.internal.p9;
import com.mcto.sspsdk.internal.q6;
import com.mcto.sspsdk.internal.q9;
import com.mcto.sspsdk.internal.qd;
import com.mcto.sspsdk.internal.r9;
import com.mcto.sspsdk.internal.v6;

/* JADX INFO: loaded from: classes2.dex */
public class QyFullActivity extends AppCompatActivity {
    private p a;
    private m b;
    private q6 c;
    private ViewGroup d;

    private boolean a() {
        ea eaVar = (ea) og.a.getAndSet(null);
        if (eaVar == null) {
            m mVar = this.b;
            if (mVar != null) {
                mVar.a("ad is empty when activity onCreate");
            }
            q9 q9Var = p9.a;
            p pVar = this.a;
            q9Var.getClass();
            q9.a(6, pVar, "msg:ad is empty when activity onCreate");
            return false;
        }
        p pVar2 = eaVar.b;
        this.a = pVar2;
        this.b = eaVar.d;
        if (pVar2.o()) {
            this.c = new v6(this);
        } else {
            this.c = new q6(this);
        }
        q6 q6Var = this.c;
        p pVar3 = this.a;
        QyAdSlot qyAdSlot = eaVar.c;
        m mVar2 = this.b;
        qd qdVar = new qd(this);
        q6Var.getClass();
        q6Var.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        q6Var.d = pVar3;
        q6Var.f = mVar2;
        q6Var.e = qyAdSlot;
        e eVar = pVar3.L0;
        q6Var.g = eVar;
        q6Var.q = eVar.b;
        q6Var.r = eVar.d;
        q6Var.h = qdVar;
        this.c.a(eaVar.f, eaVar.e);
        this.c.d();
        this.d.addView(this.c, new ViewGroup.LayoutParams(-1, -1));
        return true;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public final void onBackPressed() {
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        hk.a((AppCompatActivity) this, true);
        setContentView(R.layout.qy_activity_trueview);
        this.d = (ViewGroup) findViewById(R.id.qy_reward_root);
        try {
            if (a()) {
                return;
            }
            finish();
        } catch (Exception e) {
            r9.a("ssp_fullscreen", "Activity render error", e);
            q9 q9Var = p9.a;
            q9Var.getClass();
            eh.a.a(new o9("ssp_fullscreen", "Activity render error", e));
            String str = "Activity render error" + r9.a(e);
            m mVar = this.b;
            if (mVar != null) {
                mVar.a(str);
            }
            q9Var.getClass();
            q9.a(6, this.a, "msg:" + str);
            finish();
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected final void onDestroy() {
        try {
            q6 q6Var = this.c;
            if (q6Var != null) {
                o6 o6Var = q6Var.s;
                if (o6Var != null) {
                    o6Var.a();
                    q6Var.s = null;
                }
                q6Var.f.a();
            }
            super.onDestroy();
        } catch (Exception e) {
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            hk.a((AppCompatActivity) this, true);
        }
    }
}
