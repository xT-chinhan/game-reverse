package com.mcto.sspsdk.internal;

import java.io.File;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public final class m4 {
    public final String a;
    public final String b;
    public final long c;
    public final long d;

    public m4(File file) {
        this.a = "";
        this.b = "";
        long j = LongCompanionObject.MAX_VALUE;
        this.c = LongCompanionObject.MAX_VALUE;
        String name = file.getName();
        try {
            int iLastIndexOf = name.lastIndexOf("_s");
            String strSubstring = name.substring(iLastIndexOf + 2);
            long j2 = 0;
            if (!lj.b(strSubstring)) {
                j2 = Long.parseLong(strSubstring);
            }
            this.d = j2;
            int iLastIndexOf2 = name.lastIndexOf("_e");
            String strSubstring2 = name.substring(iLastIndexOf2 + 2, iLastIndexOf);
            if (!lj.b(strSubstring2)) {
                j = Long.parseLong(strSubstring2);
            }
            this.c = j;
            this.a = name.substring(0, iLastIndexOf2);
        } catch (IndexOutOfBoundsException e) {
        }
        this.b = file.getAbsolutePath();
    }

    public final String toString() {
        return "CupidAdsFileInfo{mUrlMD5='" + this.a + "', mStartTime=" + this.d + ", mMaxValue=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
