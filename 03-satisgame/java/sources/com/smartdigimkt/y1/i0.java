package com.smartdigimkt.y1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.JumpConfirmG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 implements View.OnClickListener {
    public final /* synthetic */ JumpConfirmG2CV2View a;

    public i0(JumpConfirmG2CV2View jumpConfirmG2CV2View) {
        this.a = jumpConfirmG2CV2View;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.smartdigimkt.b2.e eVar = this.a.e;
        if (eVar != null) {
            eVar.a(11, 19);
        }
    }
}
