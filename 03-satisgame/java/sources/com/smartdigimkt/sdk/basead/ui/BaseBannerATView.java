package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.i2.t;
import com.smartdigimkt.j1.a;
import com.smartdigimkt.j1.w;
import com.smartdigimkt.n1.j3;
import com.smartdigimkt.n1.m0;
import com.smartdigimkt.r4.k;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseBannerATView extends BaseATView {
    public static final /* synthetic */ int H = 0;
    public final a D;
    public CloseImageView E;
    public final t F;
    public View G;
    public final String TAG;

    public BaseBannerATView(Context context) {
        super(context);
        this.TAG = getClass().getSimpleName();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void a(w wVar) {
        a aVar = this.D;
        if (aVar != null) {
            aVar.onAdClick(wVar);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public int getATViewType() {
        return 4;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public RelativeLayout.LayoutParams getSpecialNoteViewLayoutParams() {
        int measuredHeight = getMeasuredHeight() - k.a(getContext(), 12.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.setMargins(0, measuredHeight, 0, 0);
        return layoutParams;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void i() {
        a aVar = this.D;
        if (aVar != null) {
            aVar.onAdShow(new w());
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        t tVar;
        if (this.G == null) {
            this.G = findViewById(k.a(getContext(), "myoffer_guide2click_container", "id"));
        }
        View view = this.G;
        return ((view == null || view.getVisibility() != 0) && (tVar = this.F) != null) ? tVar.a(motionEvent) : super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        t tVar;
        if (this.G == null) {
            this.G = findViewById(k.a(getContext(), "myoffer_guide2click_container", "id"));
        }
        View view = this.G;
        if ((view != null && view.getVisibility() == 0) || (tVar = this.F) == null) {
            return super.onTouchEvent(motionEvent);
        }
        tVar.a(this, motionEvent);
        return true;
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        if (z) {
            a(110);
        } else {
            a(111);
        }
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (Build.VERSION.SDK_INT < 28) {
            if (z) {
                a(110);
            } else {
                a(111);
            }
        }
    }

    public BaseBannerATView(Context context, com.smartdigimkt.a3.a aVar, c cVar, a aVar2) {
        e eVar;
        super(context, aVar, cVar);
        this.TAG = getClass().getSimpleName();
        this.D = aVar2;
        if (aVar == null || (eVar = aVar.s) == null || eVar.l0 < 2) {
            return;
        }
        t tVar = new t();
        this.F = tVar;
        tVar.e = new m0(this);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void a(int i, int i2) {
        super.a(i, i2);
        a((j3) this.E, true);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void a(boolean z) {
        a aVar = this.D;
        if (aVar != null) {
            aVar.onDeeplinkCallback(z);
        }
    }
}
