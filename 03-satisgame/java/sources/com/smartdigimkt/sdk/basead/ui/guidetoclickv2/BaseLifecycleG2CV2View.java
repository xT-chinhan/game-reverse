package com.smartdigimkt.sdk.basead.ui.guidetoclickv2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.smartdigimkt.b2.e;
import com.smartdigimkt.n1.y2;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.u1.d;
import com.smartdigimkt.y1.b;
import com.smartdigimkt.y1.c;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseLifecycleG2CV2View extends BaseG2CV2View {
    public GTCV2InnerCountDownView h;

    public BaseLifecycleG2CV2View(Context context) {
        super(context);
    }

    public final void b() {
        if (this.h == null) {
            this.h = new GTCV2InnerCountDownView(getContext());
            addView(this.h, new ViewGroup.MarginLayoutParams(-1, -1));
            this.h.initSetting(new c(this));
        }
        f fVarA = f.a();
        fVarA.b.removeCallbacks(this.d);
    }

    public abstract int getClickArea();

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public void init(long j, int i, int i2, e eVar, b bVar) {
        d dVar;
        super.init(j, i, i2, eVar, bVar);
        e eVar2 = this.e;
        if (!(eVar2 instanceof y2) || (dVar = ((y2) eVar2).a.n) == null) {
            return;
        }
        dVar.s = false;
        dVar.b();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public void pauseAnim() {
        GTCV2InnerCountDownView gTCV2InnerCountDownView = this.h;
        if (gTCV2InnerCountDownView != null) {
            gTCV2InnerCountDownView.onPause();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public void pauseAnimPlay() {
        GTCV2InnerCountDownView gTCV2InnerCountDownView = this.h;
        if (gTCV2InnerCountDownView != null) {
            gTCV2InnerCountDownView.onPause();
        } else {
            super.pauseAnimPlay();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public void release() {
        d dVar;
        super.release();
        GTCV2InnerCountDownView gTCV2InnerCountDownView = this.h;
        if (gTCV2InnerCountDownView != null) {
            gTCV2InnerCountDownView.release();
        }
        e eVar = this.e;
        if (!(eVar instanceof y2) || (dVar = ((y2) eVar).a.n) == null) {
            return;
        }
        dVar.s = true;
        dVar.d();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public void resumeAnim() {
        GTCV2InnerCountDownView gTCV2InnerCountDownView = this.h;
        if (gTCV2InnerCountDownView != null) {
            gTCV2InnerCountDownView.onResume();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public void resumeAnimPlay() {
        GTCV2InnerCountDownView gTCV2InnerCountDownView = this.h;
        if (gTCV2InnerCountDownView != null) {
            gTCV2InnerCountDownView.onResume();
        } else {
            super.resumeAnimPlay();
        }
    }

    public BaseLifecycleG2CV2View(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseLifecycleG2CV2View(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
