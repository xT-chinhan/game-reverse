package com.smartdigimkt.p0;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements g {
    @Override // com.smartdigimkt.p0.g
    public final int a() {
        return MediaCodecList.getCodecCount();
    }

    @Override // com.smartdigimkt.p0.g
    public final boolean b() {
        return false;
    }

    @Override // com.smartdigimkt.p0.g
    public final MediaCodecInfo a(int i) {
        return MediaCodecList.getCodecInfoAt(i);
    }

    @Override // com.smartdigimkt.p0.g
    public final boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return "video/avc".equals(str);
    }
}
