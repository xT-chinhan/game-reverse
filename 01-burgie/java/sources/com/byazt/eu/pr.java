package com.byazt.eu;

import com.byazt.fe.hn;
import com.byazt.fe.uc;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2032, 37})
public abstract class pr implements hw {
    public abstract ByteBuffer pr();

    @Override // com.byazt.eu.hw
    public uc hw() throws IOException {
        return new hn(pr());
    }
}
