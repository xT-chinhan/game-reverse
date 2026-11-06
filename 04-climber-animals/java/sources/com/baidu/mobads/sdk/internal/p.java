package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* JADX INFO: loaded from: classes.dex */
class p implements IOAdEventListener {
    final /* synthetic */ o a;

    p(o oVar) {
        this.a = oVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        bj.a(new q(this, iOAdEvent));
    }
}
