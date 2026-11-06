package com.baidu.mobads.sdk.internal;

/* JADX INFO: loaded from: classes.dex */
class ac implements ca.c {
    final /* synthetic */ aa a;

    ac(aa aaVar) {
        this.a = aaVar;
    }

    @Override // com.baidu.mobads.sdk.internal.ca.c
    public void a(boolean z) {
        if (z) {
            try {
                if (h.a != null) {
                    this.a.b = h.a.i();
                    if (this.a.b != null) {
                        this.a.k();
                        return;
                    }
                }
            } catch (Exception unused) {
                this.a.a("加载dex异常");
                return;
            }
        }
        h.a = null;
        this.a.a("加载dex失败");
    }
}
