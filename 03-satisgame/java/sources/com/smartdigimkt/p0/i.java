package com.smartdigimkt.p0;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements g {
    public final int a;
    public MediaCodecInfo[] b;

    public i(boolean z) {
        this.a = z ? 1 : 0;
    }

    @Override // com.smartdigimkt.p0.g
    public final boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    @Override // com.smartdigimkt.p0.g
    public final boolean b() {
        return true;
    }

    @Override // com.smartdigimkt.p0.g
    public final int a() {
        if (this.b == null) {
            this.b = new MediaCodecList(this.a).getCodecInfos();
        }
        return this.b.length;
    }

    @Override // com.smartdigimkt.p0.g
    public final MediaCodecInfo a(int i) {
        if (this.b == null) {
            this.b = new MediaCodecList(this.a).getCodecInfos();
        }
        return this.b[i];
    }
}
