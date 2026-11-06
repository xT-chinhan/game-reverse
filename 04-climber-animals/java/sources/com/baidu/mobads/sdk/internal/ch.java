package com.baidu.mobads.sdk.internal;

/* JADX INFO: loaded from: classes.dex */
class ch implements ao.a {
    final /* synthetic */ ca a;

    ch(ca caVar) {
        this.a = caVar;
    }

    @Override // com.baidu.mobads.sdk.internal.ao.a
    public void a() {
        if (this.a.A) {
            this.a.A = false;
            this.a.a(false, "remote update Network access failed");
        }
    }
}
