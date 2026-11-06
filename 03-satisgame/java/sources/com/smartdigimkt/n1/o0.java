package com.smartdigimkt.n1;

import android.view.MotionEvent;
import android.view.View;
import com.smartdigimkt.sdk.basead.ui.BaseBannerATView;

/* JADX INFO: loaded from: classes3.dex */
public final class o0 implements View.OnTouchListener {
    public final /* synthetic */ BaseBannerATView a;

    public o0(BaseBannerATView baseBannerATView) {
        this.a = baseBannerATView;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        com.smartdigimkt.j1.a aVar;
        if (motionEvent.getAction() != 0 || (aVar = this.a.D) == null) {
            return true;
        }
        aVar.onAdClosed();
        return true;
    }
}
