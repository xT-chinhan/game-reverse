package com.smartdigimkt.v1;

import android.view.View;
import com.smartdigimkt.i2.k;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ k b;

    public e(boolean z, k kVar) {
        this.a = z;
        this.b = kVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.a) {
            this.b.a(1, 40);
        } else {
            this.b.a(1, 24);
        }
    }
}
