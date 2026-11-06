package com.smartdigimkt.y1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.QuestionDialogG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class z0 implements View.OnClickListener {
    public final /* synthetic */ QuestionDialogG2CV2View a;

    public z0(QuestionDialogG2CV2View questionDialogG2CV2View) {
        this.a = questionDialogG2CV2View;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.smartdigimkt.b2.e eVar = this.a.e;
        if (eVar != null) {
            eVar.a(11, 17);
        }
    }
}
