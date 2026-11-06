package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
class cp extends j {
    final /* synthetic */ co b;

    cp(co coVar) {
        this.b = coVar;
    }

    @Override // com.baidu.mobads.sdk.internal.j
    protected Object i() {
        try {
            String strA = this.b.a("key_crash_trace");
            String strA2 = this.b.a("key_crash_ad");
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            cl clVarA = cl.a();
            clVarA.a(this.b.n);
            clVarA.a(this.b.a("key_crash_source"), strA, strA2);
            this.b.g();
            return null;
        } catch (Exception e) {
            bu.a().a(e);
            return null;
        }
    }
}
