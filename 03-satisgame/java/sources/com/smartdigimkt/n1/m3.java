package com.smartdigimkt.n1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.LetterHalfScreenATView;

/* JADX INFO: loaded from: classes3.dex */
public final class m3 implements View.OnClickListener {
    public final /* synthetic */ LetterHalfScreenATView a;

    public m3(LetterHalfScreenATView letterHalfScreenATView) {
        this.a = letterHalfScreenATView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.a(1, 7);
    }
}
