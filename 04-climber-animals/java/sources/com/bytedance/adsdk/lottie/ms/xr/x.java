package com.bytedance.adsdk.lottie.ms.xr;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class x {
    private final List<com.bytedance.adsdk.lottie.model.xr.x> ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final List<ms<com.bytedance.adsdk.lottie.model.xr.u, Path>> f264ms;
    private final List<ms<Integer, Integer>> xr;

    public x(List<com.bytedance.adsdk.lottie.model.xr.x> list) {
        this.ah = list;
        this.f264ms = new ArrayList(list.size());
        this.xr = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.f264ms.add(list.get(i).xr().ms());
            this.xr.add(list.get(i).ah().ms());
        }
    }

    public List<com.bytedance.adsdk.lottie.model.xr.x> ms() {
        return this.ah;
    }

    public List<ms<com.bytedance.adsdk.lottie.model.xr.u, Path>> xr() {
        return this.f264ms;
    }

    public List<ms<Integer, Integer>> ah() {
        return this.xr;
    }
}
