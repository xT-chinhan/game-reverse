package com.mcto.sspsdk.internal;

import android.graphics.Bitmap;
import com.mcto.sspsdk.component.imageview.QYNiceImageView;

/* JADX INFO: loaded from: classes2.dex */
public final class dc implements Runnable {
    public final /* synthetic */ Bitmap a;
    public final /* synthetic */ QYNiceImageView b;

    public dc(QYNiceImageView qYNiceImageView, Bitmap bitmap) {
        this.b = qYNiceImageView;
        this.a = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.setImageBitmap(this.a);
    }
}
