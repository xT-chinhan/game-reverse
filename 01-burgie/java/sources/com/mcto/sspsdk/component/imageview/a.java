package com.mcto.sspsdk.component.imageview;

import android.graphics.Bitmap;
import com.mcto.sspsdk.internal.r9;
import com.mcto.sspsdk.internal.w7;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements w7 {
    public final /* synthetic */ QYNiceImageView a;

    public a(QYNiceImageView qYNiceImageView) {
        this.a = qYNiceImageView;
    }

    @Override // com.mcto.sspsdk.internal.w7
    public final void a(Bitmap bitmap) {
        int i = 0;
        if (bitmap == null) {
            QYNiceImageView.a(this.a, 0);
            return;
        }
        try {
            QYNiceImageView.a(this.a, bitmap);
            i = 1;
        } catch (Throwable th) {
            r9.a("ssp_ImageLoad", "load error", th);
        }
        QYNiceImageView.a(this.a, i);
    }
}
