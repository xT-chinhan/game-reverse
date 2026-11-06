package com.smartdigimkt.y1;

import android.widget.TextView;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.GTCV2InnerCountDownView;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends com.smartdigimkt.o3.b {
    public final /* synthetic */ v f;
    public final /* synthetic */ GTCV2InnerCountDownView g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(GTCV2InnerCountDownView gTCV2InnerCountDownView, v vVar) {
        super(com.anythink.core.common.d.i.l.c);
        this.g = gTCV2InnerCountDownView;
        this.f = vVar;
    }

    @Override // com.smartdigimkt.o3.b
    public final void a(long j) {
        long j2 = j / 1000;
        int i = (int) (j2 / 60);
        int i2 = (int) (j2 % 60);
        TextView textView = this.g.b;
        if (textView != null) {
            textView.setText(String.format("%02d", Integer.valueOf(i)));
        }
        TextView textView2 = this.g.c;
        if (textView2 != null) {
            textView2.setText(String.format("%02d", Integer.valueOf(i2)));
        }
    }

    @Override // com.smartdigimkt.o3.b
    public final void a() {
        v vVar = this.f;
        if (vVar != null) {
            ((c) vVar).a.a();
        }
    }
}
