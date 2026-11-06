package com.bytedance.adsdk.lottie.ms.ms;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final List<nw> f258ms = new ArrayList();

    void ms(nw nwVar) {
        this.f258ms.add(nwVar);
    }

    public void ms(Path path) {
        for (int size = this.f258ms.size() - 1; size >= 0; size--) {
            com.bytedance.adsdk.lottie.ka.ny.ms(path, this.f258ms.get(size));
        }
    }
}
