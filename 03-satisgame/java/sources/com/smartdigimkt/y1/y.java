package com.smartdigimkt.y1;

import android.view.MotionEvent;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.GestureNewG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class y implements h0 {
    public final /* synthetic */ GestureNewG2CV2View a;

    public y(GestureNewG2CV2View gestureNewG2CV2View) {
        this.a = gestureNewG2CV2View;
    }

    @Override // com.smartdigimkt.y1.h0
    public final boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.a.n = motionEvent.getX();
            return true;
        }
        if (action == 1) {
            GestureNewG2CV2View gestureNewG2CV2View = this.a;
            if (gestureNewG2CV2View.o <= gestureNewG2CV2View.p) {
                return false;
            }
            com.smartdigimkt.b2.e eVar = gestureNewG2CV2View.e;
            if (eVar != null) {
                eVar.a(11, 46);
            }
            return true;
        }
        if (action != 2) {
            return false;
        }
        float x = motionEvent.getX();
        GestureNewG2CV2View gestureNewG2CV2View2 = this.a;
        gestureNewG2CV2View2.o += Math.abs(x - gestureNewG2CV2View2.n);
        this.a.n = motionEvent.getX();
        return false;
    }
}
