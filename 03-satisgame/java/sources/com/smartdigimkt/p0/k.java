package com.smartdigimkt.p0;

import android.media.MediaFormat;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k {
    public static void a(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }
}
