package com.baidu.mobads.sdk.internal;

/* JADX INFO: loaded from: classes.dex */
class ab implements Runnable {
    final /* synthetic */ aa a;

    ab(aa aaVar) {
        this.a = aaVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a("加载dex超过5秒");
    }
}
