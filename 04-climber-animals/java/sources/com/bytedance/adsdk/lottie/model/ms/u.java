package com.bytedance.adsdk.lottie.model.ms;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
abstract class u<V, O> implements zb<V, O> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final List<com.bytedance.adsdk.lottie.c.ms<V>> f213ms;

    u(List<com.bytedance.adsdk.lottie.c.ms<V>> list) {
        this.f213ms = list;
    }

    @Override // com.bytedance.adsdk.lottie.model.ms.zb
    public List<com.bytedance.adsdk.lottie.c.ms<V>> ah() {
        return this.f213ms;
    }

    @Override // com.bytedance.adsdk.lottie.model.ms.zb
    public boolean xr() {
        return this.f213ms.isEmpty() || (this.f213ms.size() == 1 && this.f213ms.get(0).ka());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f213ms.isEmpty()) {
            sb.append("values=").append(Arrays.toString(this.f213ms.toArray()));
        }
        return sb.toString();
    }
}
