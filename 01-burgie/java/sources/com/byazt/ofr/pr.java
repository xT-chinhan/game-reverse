package com.byazt.ofr;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.LongSupplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1195, 37})
public abstract class pr extends x implements LongSupplier {
    public abstract void hw();

    public abstract void pr();

    @Override // com.byazt.ofr.x
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        switch (i) {
            case 0:
                pr();
                break;
            case 1:
                hw();
                break;
        }
        return null;
    }

    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }
}
