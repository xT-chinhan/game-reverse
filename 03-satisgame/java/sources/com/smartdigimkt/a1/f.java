package com.smartdigimkt.a1;

import android.media.MediaCodec;
import android.os.Handler;
import android.view.Surface;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements MediaCodec.OnFrameRenderedListener {
    public final /* synthetic */ g a;

    public f(g gVar, MediaCodec mediaCodec) {
        this.a = gVar;
        mediaCodec.setOnFrameRenderedListener(this, new Handler());
    }

    @Override // android.media.MediaCodec.OnFrameRenderedListener
    public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
        g gVar = this.a;
        if (this == gVar.y0 && !gVar.e0) {
            gVar.e0 = true;
            s sVar = gVar.T;
            Surface surface = gVar.b0;
            if (sVar.b != null) {
                sVar.a.post(new q(sVar, surface));
            }
        }
    }
}
