package com.smartdigimkt.n0;

import com.smartdigimkt.o0.p;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements g {
    public static final Constructor a;

    static {
        Constructor constructor = null;
        try {
            constructor = Class.forName("com.smartdigimkt.sdk.basead.exoplayer.ext.flac.FlacExtractor").asSubclass(e.class).getConstructor(null);
        } catch (ClassNotFoundException unused) {
        } catch (Exception e) {
            throw new RuntimeException("Error instantiating FLAC extension", e);
        }
        a = constructor;
    }

    @Override // com.smartdigimkt.n0.g
    public final synchronized e[] a() {
        e[] eVarArr;
        Constructor constructor = a;
        eVarArr = new e[constructor == null ? 2 : 3];
        eVarArr[0] = new com.smartdigimkt.o0.m();
        eVarArr[1] = new p();
        if (constructor != null) {
            try {
                eVarArr[2] = (e) constructor.newInstance(null);
            } catch (Exception e) {
                throw new IllegalStateException("Unexpected error creating FLAC extractor", e);
            }
        }
        return eVarArr;
    }
}
