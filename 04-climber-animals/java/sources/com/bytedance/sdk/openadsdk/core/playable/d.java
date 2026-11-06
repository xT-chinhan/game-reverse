package com.bytedance.sdk.openadsdk.core.playable;

import com.bytedance.sdk.component.utils.c;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d extends com.bytedance.sdk.openadsdk.core.ch.xr {
    public d(int i, int i2) {
        super(i, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ch.xr, com.bytedance.sdk.openadsdk.core.ch.ms
    protected void ms(List<File> list) {
        int size = list.size();
        if (ms(0L, size)) {
            return;
        }
        for (File file : list) {
            c.ah(file);
            size--;
            if (ms(file, 0L, size)) {
                return;
            }
        }
    }
}
