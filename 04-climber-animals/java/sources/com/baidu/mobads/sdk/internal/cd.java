package com.baidu.mobads.sdk.internal;

/* JADX INFO: loaded from: classes.dex */
class cd implements co.a {
    final /* synthetic */ ca a;

    cd(ca caVar) {
        this.a = caVar;
    }

    @Override // com.baidu.mobads.sdk.internal.co.a
    public void a(String str) {
        try {
            this.a.b();
            this.a.a(str);
        } catch (Throwable th) {
            bu.a().a(th);
        }
    }
}
