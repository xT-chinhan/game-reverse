package com.mcto.sspsdk.internal;

import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class qk {
    public static void a(ImageView imageView, int i) {
        if (Build.VERSION.SDK_INT < 28) {
            imageView.setImageResource(i);
            return;
        }
        try {
            Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(imageView.getResources(), i));
            imageView.setImageDrawable(drawableDecodeDrawable);
            if (drawableDecodeDrawable instanceof AnimatedImageDrawable) {
                ((AnimatedImageDrawable) drawableDecodeDrawable).start();
            }
        } catch (Exception e) {
            r9.a("QyCardView", "Failed to load animated WebP", e);
            imageView.setImageResource(i);
        }
    }
}
