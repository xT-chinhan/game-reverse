package com.anythink.core.common.m.d.a;

import com.anythink.core.common.m.d.d;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class b extends c {
    private static final String b = "b";
    private static final int c = 2;

    @Override // com.anythink.core.common.m.d.a.c
    protected final synchronized void a(d dVar, d.a aVar) {
        InputStream inputStream = this.a.getInputStream();
        int iA = a(inputStream);
        Object[] objArr = new Object[1];
        Integer.valueOf(iA);
        if (iA != 2) {
            if (aVar != null) {
                aVar.a((Object) null);
            }
            return;
        }
        byte[] bArr = new byte[1];
        inputStream.read(bArr, 0, 1);
        byte[] bArr2 = new byte[4];
        inputStream.read(bArr2, 0, 4);
        int i = ByteBuffer.wrap(bArr2).getInt();
        Object[] objArr2 = new Object[2];
        Integer.valueOf(i);
        Byte.valueOf(bArr[0]);
        if (i <= 0) {
            if (aVar != null) {
                aVar.a((Object) null);
            }
            return;
        }
        byte[] bArr3 = new byte[i];
        inputStream.read(bArr3, 0, i);
        String str = new String(bArr3);
        Object[] objArr3 = new Object[1];
        if (aVar != null) {
            aVar.a(str);
        }
    }
}
