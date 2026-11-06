package com.smartdigimkt.n1;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.smartdigimkt.sdk.basead.ui.PanelView;

/* JADX INFO: loaded from: classes3.dex */
public final class a4 implements com.smartdigimkt.i3.l {
    public final /* synthetic */ String a;
    public final /* synthetic */ PanelView b;

    public a4(PanelView panelView, String str) {
        this.b = panelView;
        this.a = str;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        if (TextUtils.equals(str, this.a)) {
            this.b.b.setImageBitmap(bitmap);
        }
    }
}
