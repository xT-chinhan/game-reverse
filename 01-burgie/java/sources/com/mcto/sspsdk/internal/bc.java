package com.mcto.sspsdk.internal;

import android.graphics.Bitmap;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import com.mcto.sspsdk.component.imageview.QYNiceImageView;

/* JADX INFO: loaded from: classes2.dex */
public final class bc implements Runnable {
    public final /* synthetic */ Bitmap a;
    public final /* synthetic */ QYNiceImageView b;

    public bc(QYNiceImageView qYNiceImageView, Bitmap bitmap) {
        this.b = qYNiceImageView;
        this.a = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.setImageBitmap(this.a);
        this.b.setRenderEffect(RenderEffect.createBlurEffect(70.0f, 70.0f, Shader.TileMode.CLAMP));
    }
}
