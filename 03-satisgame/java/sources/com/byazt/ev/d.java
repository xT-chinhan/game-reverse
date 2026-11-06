package com.byazt.ev;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, 113})
public class d {
    public static void n(x xVar) throws IOException {
        xVar.qg(1835009, 0);
        int i = xVar.readInt();
        int i2 = xVar.readInt();
        int i3 = xVar.readInt();
        xVar.n();
        int i4 = xVar.readInt();
        int i5 = xVar.readInt();
        xVar.skipBytes(i2 * 4);
        if (i3 != 0) {
            xVar.skipBytes(i3 * 4);
        }
        xVar.skipBytes((i5 == 0 ? i : i5) - i4);
        if (i5 == 0) {
            return;
        }
        int i6 = i - i5;
        xVar.skipBytes(i6);
        int i7 = i6 % 4;
        if (i7 <= 0) {
            return;
        }
        while (true) {
            int i8 = i7 - 1;
            if (i7 <= 0) {
                return;
            }
            xVar.readByte();
            i7 = i8;
        }
    }
}
