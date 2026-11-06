package com.smartdigimkt.j2;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.web.BaseWebView;
import com.smartdigimkt.sdk.basead.ui.web.WebLandPageActivity;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ WebLandPageActivity a;

    public m(WebLandPageActivity webLandPageActivity) {
        this.a = webLandPageActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        BaseWebView baseWebView = this.a.c;
        if (baseWebView == null || !baseWebView.canGoBack()) {
            this.a.finish();
        } else {
            this.a.c.goBack();
        }
    }
}
