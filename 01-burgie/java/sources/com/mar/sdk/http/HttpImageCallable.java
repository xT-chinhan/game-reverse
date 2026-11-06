package com.mar.sdk.http;

import android.graphics.Bitmap;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public class HttpImageCallable implements Callable<Bitmap> {
    private final HttpImage httpImage;

    public HttpImageCallable(String url, HttpImage httpImage) {
        this.httpImage = httpImage;
        this.httpImage.url(url);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Bitmap call() throws Exception {
        return this.httpImage.load();
    }
}
