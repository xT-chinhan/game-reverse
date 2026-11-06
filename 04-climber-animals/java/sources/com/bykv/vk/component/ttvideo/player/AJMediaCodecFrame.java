package com.bykv.vk.component.ttvideo.player;

import com.bytedance.sdk.component.utils.sl;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class AJMediaCodecFrame implements Cloneable {
    public ByteBuffer data;
    public int flags;
    public int index;
    public long pts = -269488145;
    public int size;

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AJMediaCodecFrame m21clone() {
        try {
            return (AJMediaCodecFrame) super.clone();
        } catch (Throwable th) {
            sl.ms(th);
            return null;
        }
    }
}
