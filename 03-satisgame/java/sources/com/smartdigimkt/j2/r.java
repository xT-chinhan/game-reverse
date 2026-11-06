package com.smartdigimkt.j2;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.web.WebLoadFailRefrshView;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements View.OnClickListener {
    public final /* synthetic */ WebLoadFailRefrshView a;

    public r(WebLoadFailRefrshView webLoadFailRefrshView) {
        this.a = webLoadFailRefrshView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View.OnClickListener onClickListener = this.a.a;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }
}
