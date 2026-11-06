package com.smartdigimkt.y1;

import android.view.MotionEvent;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.GestureG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements h0 {
    public final /* synthetic */ GestureG2CV2View a;

    public x(GestureG2CV2View gestureG2CV2View) {
        this.a = gestureG2CV2View;
    }

    @Override // com.smartdigimkt.y1.h0
    public final boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.a.o = motionEvent.getX();
            return true;
        }
        if (action == 1) {
            GestureG2CV2View gestureG2CV2View = this.a;
            if (gestureG2CV2View.p <= gestureG2CV2View.q) {
                return false;
            }
            com.smartdigimkt.b2.e eVar = gestureG2CV2View.e;
            if (eVar != null) {
                eVar.a(11, 15);
            }
            return true;
        }
        if (action != 2) {
            return false;
        }
        float x = motionEvent.getX();
        GestureG2CV2View gestureG2CV2View2 = this.a;
        gestureG2CV2View2.p += Math.abs(x - gestureG2CV2View2.o);
        this.a.o = motionEvent.getX();
        return false;
    }
}
