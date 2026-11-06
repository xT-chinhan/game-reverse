package com.smartdigimkt.sdk.basead.ui.simpleview;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.RelativeLayout;
import com.smartdigimkt.g2.d;
import com.smartdigimkt.g2.e;
import com.smartdigimkt.g2.f;
import com.smartdigimkt.i0.c;
import com.smartdigimkt.i0.i0;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.basead.ui.CountDownView;
import com.smartdigimkt.v0.j;
import com.smartdigimkt.x0.g;
import com.smartdigimkt.x1.q;
import com.smartdigimkt.x1.v;
import com.smartdigimkt.y0.n;
import com.smartdigimkt.y0.p;
import com.smartdigimkt.z.e0;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class SimplePlayer extends RelativeLayout {
    public static final String TAG = "SimplePlayer";
    public i0 a;
    public j b;
    public final TextureView c;
    public d d;
    public e e;
    public boolean f;
    public String g;
    public String h;
    public boolean i;
    public f j;

    public SimplePlayer(Context context) {
        this(context, null);
    }

    private String getValidVideoPath() {
        return new File(this.g).exists() ? this.g : this.h;
    }

    public final void a(String str, boolean z) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (this.a == null) {
                a();
                return;
            }
            this.f = TextUtils.equals(str, this.g);
            Uri uri = Uri.parse(str);
            if (str.toLowerCase().startsWith("http")) {
                this.b = new j(uri, new p(), new com.smartdigimkt.n0.d());
            } else {
                this.b = new j(uri, new n(getContext()), new com.smartdigimkt.n0.d());
            }
            this.a.a(this.c);
            this.a.a(this.b);
        } catch (Throwable th) {
            th.printStackTrace();
            if (!TextUtils.equals(str, this.h) && !z) {
                a(this.h, true);
            } else {
                th.getMessage();
                a();
            }
        }
    }

    public void autoFitVideoSize(int i, int i2, View view) {
        float f = i;
        float f2 = i2;
        float fMax = Math.max(f / view.getMeasuredWidth(), f2 / view.getMeasuredHeight());
        int iCeil = (int) Math.ceil(f / fMax);
        int iCeil2 = (int) Math.ceil(f2 / fMax);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.width = iCeil;
        layoutParams.height = iCeil2;
        view.setLayoutParams(layoutParams);
    }

    public void load(String str, boolean z) {
        this.h = str;
        e0.a().getClass();
        this.g = e0.a(3, str);
        this.i = false;
        if (!new File(this.g).exists() && TextUtils.isEmpty(this.h)) {
            a();
            return;
        }
        if (this.a == null) {
            i0 i0Var = new i0(new com.smartdigimkt.i0.f(getContext()), new g(), new c());
            this.a = i0Var;
            d dVar = new d(this);
            this.d = dVar;
            i0Var.b.g.add(dVar);
            e eVar = new e(this);
            this.e = eVar;
            this.a.e.add(eVar);
            this.a.a(1.0f);
            this.a.a(z);
            a(getValidVideoPath(), false);
        }
        postDelayed(new com.smartdigimkt.g2.c(this), 5000L);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i0 i0Var = this.a;
        if (i0Var != null) {
            if (i0Var.i()) {
                this.a.k();
            }
            d dVar = this.d;
            if (dVar != null) {
                this.a.b.g.remove(dVar);
            }
            e eVar = this.e;
            if (eVar != null) {
                this.a.e.remove(eVar);
            }
            this.a.j();
            this.a = null;
        }
        this.j = null;
    }

    public void setSimplePlayerViewListener(f fVar) {
        this.j = fVar;
    }

    public void stopVideo() {
        i0 i0Var = this.a;
        if (i0Var == null || !i0Var.i()) {
            return;
        }
        this.a.k();
    }

    public SimplePlayer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SimplePlayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = "";
        this.h = "";
        this.f = false;
        setBackgroundColor(Color.parseColor("#000000"));
        if (this.c == null) {
            TextureView textureView = new TextureView(getContext());
            this.c = textureView;
            textureView.setKeepScreenOn(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            removeAllViews();
            addView(textureView, layoutParams);
        }
    }

    public final void a() {
        SimplePlayer simplePlayer;
        f fVar = this.j;
        if (fVar != null) {
            q qVar = (q) fVar;
            v vVar = qVar.a;
            if (!vVar.s && (simplePlayer = vVar.q) != null) {
                com.smartdigimkt.o3.d.a(simplePlayer);
            }
            v vVar2 = qVar.a;
            vVar2.j = false;
            vVar2.k = null;
            vVar2.n.refresh(vVar2.m);
            CountDownView countDownView = qVar.a.n;
            if (countDownView != null) {
                countDownView.setVisibility(0);
                v vVar3 = qVar.a;
                CountDownView countDownView2 = vVar3.n;
                Context context = vVar3.a;
                countDownView2.setCountDownEndDrawable(com.smartdigimkt.o3.d.a(context, k.a(context, "myoffer_base_close_icon", "drawable")));
                qVar.a.n.setOnClickListener(new com.smartdigimkt.x1.p(qVar));
            }
        }
    }
}
