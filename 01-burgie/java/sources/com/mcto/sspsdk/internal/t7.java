package com.mcto.sspsdk.internal;

import android.graphics.Bitmap;
import android.util.LruCache;

/* JADX INFO: loaded from: classes2.dex */
public final class t7 extends LruCache {
    public t7(int i) {
        super(i);
    }

    @Override // android.util.LruCache
    public final int sizeOf(Object obj, Object obj2) {
        Bitmap bitmap = (Bitmap) obj2;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getByteCount();
    }
}
