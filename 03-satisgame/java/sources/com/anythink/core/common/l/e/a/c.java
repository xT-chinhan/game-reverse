package com.anythink.core.common.l.e.a;

import com.anythink.core.common.l.e.i;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class c extends e {
    private static final int c = 1;
    private static final int d = 2;
    protected String a = getClass().getSimpleName();

    @Override // com.anythink.core.common.l.e.a.e
    protected synchronized void a(i iVar, i.a aVar) {
        c(aVar);
    }

    @Override // com.anythink.core.common.l.e.a.e
    protected synchronized boolean b(i iVar, i.a aVar) {
        return c(aVar);
    }

    private boolean c(i.a aVar) throws IOException {
        InputStream inputStream = this.b.getInputStream();
        int iA = a(inputStream);
        if (iA != 2) {
            if (aVar != null) {
                aVar.a((Object) null);
            }
            return iA == 1;
        }
        a(inputStream, new byte[1], 1);
        byte[] bArr = new byte[4];
        a(inputStream, bArr, 4);
        int i = ByteBuffer.wrap(bArr).getInt();
        if (i <= 0) {
            if (aVar != null) {
                aVar.a((Object) null);
            }
            return false;
        }
        byte[] bArr2 = new byte[i];
        a(inputStream, bArr2, i);
        String str = new String(bArr2);
        if (aVar != null) {
            aVar.a(str);
        }
        return true;
    }
}
