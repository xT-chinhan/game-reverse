package com.bytedance.pangle.res.ms;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class sl {
    public static void ms(ab abVar) throws IOException {
        abVar.xr(1835009, 0);
        int i = abVar.readInt();
        int i2 = abVar.readInt();
        int i3 = abVar.readInt();
        abVar.ms();
        int i4 = abVar.readInt();
        int i5 = abVar.readInt();
        abVar.skipBytes(i2 * 4);
        if (i3 != 0) {
            abVar.skipBytes(i3 * 4);
        }
        abVar.skipBytes((i5 == 0 ? i : i5) - i4);
        if (i5 == 0) {
            return;
        }
        int i6 = i - i5;
        abVar.skipBytes(i6);
        int i7 = i6 % 4;
        if (i7 <= 0) {
            return;
        }
        while (true) {
            int i8 = i7 - 1;
            if (i7 <= 0) {
                return;
            }
            abVar.readByte();
            i7 = i8;
        }
    }
}
