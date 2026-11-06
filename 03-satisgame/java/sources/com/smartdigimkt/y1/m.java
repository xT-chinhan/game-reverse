package com.smartdigimkt.y1;

import android.view.MotionEvent;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.FullOrientationG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements h0 {
    public final /* synthetic */ FullOrientationG2CV2View a;

    public m(FullOrientationG2CV2View fullOrientationG2CV2View) {
        this.a = fullOrientationG2CV2View;
    }

    @Override // com.smartdigimkt.y1.h0
    public final boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.a.l = motionEvent.getX();
            this.a.m = motionEvent.getY();
            return true;
        }
        if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX() - this.a.l;
                float y = motionEvent.getY();
                FullOrientationG2CV2View fullOrientationG2CV2View = this.a;
                float f = y - fullOrientationG2CV2View.m;
                fullOrientationG2CV2View.n += Math.abs(x);
                this.a.o += Math.abs(f);
                this.a.l = motionEvent.getX();
                this.a.m = motionEvent.getY();
                return false;
            }
            if (action != 3) {
                return false;
            }
        }
        FullOrientationG2CV2View fullOrientationG2CV2View2 = this.a;
        if (fullOrientationG2CV2View2.n + fullOrientationG2CV2View2.o <= fullOrientationG2CV2View2.p) {
            return false;
        }
        com.smartdigimkt.b2.e eVar = fullOrientationG2CV2View2.e;
        if (eVar != null) {
            eVar.a(11, 21);
        }
        return true;
    }
}
