package com.smartdigimkt.t;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements com.smartdigimkt.q.a {
    public final /* synthetic */ Context a;

    public c(Context context) {
        this.a = context;
    }

    @Override // com.smartdigimkt.q.a
    public final void a(String str) {
        if (f.d.get() == 10) {
            f.a(6, str);
        }
    }

    @Override // com.smartdigimkt.q.a
    public final void a(String str, boolean z) {
        String str2 = f.a;
        if (!TextUtils.isEmpty(str) && !Pattern.matches("^[0-]+$", str)) {
            f.a(this.a, str, true);
        }
        try {
            SDKContext sDKContext = SDKContext.getInstance();
            if (!TextUtils.isEmpty(sDKContext.z) && TextUtils.equals(str, sDKContext.z)) {
                sDKContext.B = true;
            }
        } catch (Throwable unused) {
        }
    }
}
