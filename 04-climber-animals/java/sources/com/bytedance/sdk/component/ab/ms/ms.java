package com.bytedance.sdk.component.ab.ms;

import android.util.Base64;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements com.bytedance.sdk.component.d.ms.ms {
    @Override // com.bytedance.sdk.component.d.ms.ms
    public int ms() {
        return 32;
    }

    @Override // com.bytedance.sdk.component.d.ms.ms
    public <T> String ms(T t) {
        return Base64.encodeToString(t.toString().getBytes(Charset.forName("UTF-8")), 0);
    }

    @Override // com.bytedance.sdk.component.d.ms.ms
    public <T> T xr(T t) {
        return (T) new String(Base64.decode(t.toString().getBytes(Charset.forName("UTF-8")), 0), Charset.forName("UTF-8"));
    }
}
