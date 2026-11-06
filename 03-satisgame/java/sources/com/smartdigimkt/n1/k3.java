package com.smartdigimkt.n1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.LetterFullScreenATView;

/* JADX INFO: loaded from: classes3.dex */
public final class k3 implements View.OnClickListener {
    public final /* synthetic */ LetterFullScreenATView a;

    public k3(LetterFullScreenATView letterFullScreenATView) {
        this.a = letterFullScreenATView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.a(1, 7);
    }
}
