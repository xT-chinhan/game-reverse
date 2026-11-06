package com.smartdigimkt.sdk.basead.ui.improveclick.ambience;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.smartdigimkt.c2.g;
import com.smartdigimkt.r1.c;
import com.smartdigimkt.sdk.basead.ui.animplayerview.redpacket.RedPacketView;

/* JADX INFO: loaded from: classes3.dex */
public class BubbleDropChildView extends RedPacketView {
    public g p;
    public boolean q;

    public BubbleDropChildView(Context context) {
        super(context);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.redpacket.RedPacketView
    public int getRedPacketScaleBaseWidth() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        return (measuredWidth <= 0 || measuredHeight <= 0) ? measuredWidth : Math.min(measuredWidth, measuredHeight);
    }

    public void initSetting(g gVar) {
        this.a = 0.25d;
        this.b = 0.33000001311302185d;
        this.q = false;
        this.p = gVar;
    }

    public boolean isTouchOnAnyBubble(float f, float f2) {
        for (c cVar : this.d) {
            float f3 = cVar.e;
            if (f3 <= f && f <= f3 + cVar.b) {
                float f4 = cVar.f;
                if (f4 <= f2 && f2 <= f4 + cVar.c) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        g gVar;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                if (this.q && (gVar = this.p) != null) {
                    gVar.a();
                }
                this.q = false;
            }
        } else if (isTouchOnAnyBubble(motionEvent.getX(), motionEvent.getY())) {
            this.q = true;
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public BubbleDropChildView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BubbleDropChildView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
