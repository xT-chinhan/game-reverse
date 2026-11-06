package com.mcto.sspsdk.internal;

import android.view.View;
import com.mcto.sspsdk.IQyFullScreenAd;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.button.DownloadButtonView;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class m implements View.OnClickListener {
    public final p a;
    public IQyFullScreenAd.AdInteractionListener b;
    public q6 c;
    public DownloadButtonView d;
    public long e;
    public float f = -999.0f;
    public float g = -999.0f;
    public float h = -999.0f;
    public float i = -999.0f;
    public float j = -999.0f;
    public float k = -999.0f;
    public boolean l = false;

    public m(p pVar) {
        this.a = pVar;
    }

    public void a(q6 q6Var) {
        this.c = q6Var;
        DownloadButtonView downloadButtonView = (DownloadButtonView) q6Var.findViewById(R.id.qy_full_screen_ad_button);
        this.d = downloadButtonView;
        downloadButtonView.setOnClickListener(this);
        if (this.a.L0.t != 2) {
            q6Var.findViewById(R.id.qy_full_screen_main_creative).setOnClickListener(this);
            q6Var.findViewById(R.id.qy_full_screen_background).setOnClickListener(this);
        }
    }

    public final void b() {
        HashMap map = new HashMap(4);
        map.put(v5.KEY_VIEW_COORDINATE, gj.a(this.c));
        map.put(v5.KEY_AD_VIEW_RECT, this.c.getWidth() + "_" + this.c.getHeight());
        l lVarA = l.a();
        p pVar = this.a;
        lVarA.getClass();
        l.a(12, pVar, map);
        IQyFullScreenAd.AdInteractionListener adInteractionListener = this.b;
        if (adInteractionListener != null) {
            adInteractionListener.onAdShow();
        }
    }

    public void c() {
        l lVarA = l.a();
        p pVar = this.a;
        lVarA.getClass();
        l.a(13, pVar, null);
    }

    public void d() {
        l lVarA = l.a();
        p pVar = this.a;
        lVarA.getClass();
        l.a(18, pVar, null);
        IQyFullScreenAd.AdInteractionListener adInteractionListener = this.b;
        if (adInteractionListener != null) {
            adInteractionListener.onVideoComplete();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        b4 b4Var;
        this.l = true;
        z3 z3Var = z3.GRAPHIC;
        if (view == null) {
            z3Var = z3.AUTO_ACT;
        } else if (view.getId() == R.id.qy_full_screen_ad_close_icon) {
            z3Var = z3.CLOSE_ACT;
        } else if (view.getId() == R.id.qy_full_screen_ad_button) {
            z3Var = this.a.p() ? z3.DIRECT_ACTION_BTN : z3.BUTTON;
        } else if (view.getId() == R.id.qy_full_screen_action) {
            z3Var = this.a.L0.q == 2 ? z3.TWIST : z3.SHAKE;
        }
        if (view != null) {
            a4 a4Var = new a4();
            float f = this.f;
            float f2 = this.g;
            float f3 = this.h;
            float f4 = this.i;
            a4Var.h = f;
            a4Var.i = f2;
            a4Var.j = f3;
            a4Var.k = f4;
            a4 a4VarA = a4Var.a(this.j, this.k);
            a4VarA.a = view;
            a4VarA.e = gj.a(view);
            a4VarA.b = z3Var;
            b4Var = new b4(a4VarA);
        } else {
            a4 a4Var2 = new a4();
            a4Var2.a = this.c;
            a4Var2.b = z3Var;
            b4Var = new b4(a4Var2);
        }
        DownloadButtonView downloadButtonView = this.d;
        if (downloadButtonView != null) {
            b4Var.a(downloadButtonView.c());
            b4Var.k = this.d.a();
        }
        a(b4Var);
        if (y3.a(jd.a, this.a, b4Var) == 4) {
            l lVarA = l.a();
            p pVar = this.a;
            lVarA.getClass();
            l.a(25, pVar, null);
        }
    }

    public final void a(b4 b4Var) {
        int i;
        IQyFullScreenAd.AdInteractionListener adInteractionListener;
        z3 z3Var = z3.AUTO_ACT;
        z3 z3Var2 = b4Var.a;
        if (z3Var2 == null) {
            z3Var2 = z3.GRAPHIC;
        }
        if (z3Var.equals(z3Var2)) {
            i = 2;
        } else {
            z3 z3Var3 = z3.CLOSE_ACT;
            z3 z3Var4 = b4Var.a;
            if (z3Var4 == null) {
                z3Var4 = z3.GRAPHIC;
            }
            i = z3Var3.equals(z3Var4) ? 1 : 0;
        }
        int iIntValue = this.a.c(i).intValue();
        l lVarA = l.a();
        p pVar = this.a;
        HashMap mapA = gj.a(b4Var, this.c);
        lVarA.getClass();
        l.a(21, pVar, mapA);
        if (iIntValue == 0 || (adInteractionListener = this.b) == null) {
            return;
        }
        adInteractionListener.onAdClick();
    }

    public void a() {
        if (this.a.o()) {
            l lVarA = l.a();
            p pVar = this.a;
            lVarA.getClass();
            l.a(17, pVar, null);
        }
        IQyFullScreenAd.AdInteractionListener adInteractionListener = this.b;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClose();
        }
    }

    public void a(String str) {
        IQyFullScreenAd.AdInteractionListener adInteractionListener = this.b;
        if (adInteractionListener != null) {
            adInteractionListener.onError(14, str);
        }
    }
}
