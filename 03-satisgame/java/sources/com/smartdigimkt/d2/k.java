package com.smartdigimkt.d2;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.QAIncentiveTaskView;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements com.smartdigimkt.i3.l {
    public final /* synthetic */ QAIncentiveTaskView a;

    public k(QAIncentiveTaskView qAIncentiveTaskView) {
        this.a = qAIncentiveTaskView;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        ImageView imageView = this.a.i;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
