package com.smartdigimkt.n1;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.smartdigimkt.sdk.basead.ui.SimpleMediaATView;

/* JADX INFO: loaded from: classes3.dex */
public final class d5 implements com.smartdigimkt.i3.l {
    public final /* synthetic */ String a;
    public final /* synthetic */ SimpleMediaATView b;

    public d5(SimpleMediaATView simpleMediaATView, String str) {
        this.b = simpleMediaATView;
        this.a = str;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        if (TextUtils.equals(str, this.a)) {
            this.b.post(new c5(this, bitmap));
        }
    }
}
