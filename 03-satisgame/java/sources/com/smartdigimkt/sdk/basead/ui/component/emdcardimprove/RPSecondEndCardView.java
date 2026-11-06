package com.smartdigimkt.sdk.basead.ui.component.emdcardimprove;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.smartdigimkt.p1.h;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.basead.ui.ScanningAnimButton;
import com.smartdigimkt.w1.a;
import com.smartdigimkt.w1.b;
import com.smartdigimkt.w1.c;

/* JADX INFO: loaded from: classes3.dex */
public class RPSecondEndCardView extends SecondEndCardView {
    public h i;

    public RPSecondEndCardView(Context context) {
        super(context);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.component.emdcardimprove.SecondEndCardView
    public final void a() {
        super.a();
        if (getAdIconView() != null) {
            getAdIconView().setRadiusInDip(12);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.component.emdcardimprove.SecondEndCardView
    public final void b() {
        if (getContainerView() != null) {
            getContainerView().setOnClickListener(new a(this));
        }
        if (getCTAButton() != null) {
            getCTAButton().setOnClickListener(new b(this));
        }
        setOnClickListener(new c(this));
    }

    @Override // com.smartdigimkt.sdk.basead.ui.component.emdcardimprove.SecondEndCardView
    public int getLayoutInflateID() {
        return k.a(getContext(), "myoffer_endcard_improve_rp_second_endcard", "layout");
    }

    @Override // com.smartdigimkt.sdk.basead.ui.component.emdcardimprove.SecondEndCardView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ScanningAnimButton cTAButton = getCTAButton();
        if (cTAButton == null) {
            return;
        }
        h hVar = this.i;
        if (hVar != null) {
            hVar.stop();
        }
        h hVar2 = new h(cTAButton);
        this.i = hVar2;
        hVar2.start();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.component.emdcardimprove.SecondEndCardView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimation();
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            h hVar = this.i;
            if (hVar != null) {
                hVar.a();
                return;
            }
            return;
        }
        h hVar2 = this.i;
        if (hVar2 != null) {
            hVar2.pause();
        }
    }

    public void stopAnimation() {
        h hVar = this.i;
        if (hVar != null) {
            hVar.stop();
            this.i = null;
        }
    }

    public RPSecondEndCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RPSecondEndCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
