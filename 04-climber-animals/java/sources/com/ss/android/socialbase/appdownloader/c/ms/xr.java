package com.ss.android.socialbase.appdownloader.c.ms;

import com.anythink.core.common.d.j;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class xr {
    public static final void ms(d dVar, int i) throws IOException {
        int iXr = dVar.xr();
        if (iXr != i) {
            throw new IOException("Expected chunk of type 0x" + Integer.toHexString(i) + ", read 0x" + Integer.toHexString(iXr) + j.z);
        }
    }
}
