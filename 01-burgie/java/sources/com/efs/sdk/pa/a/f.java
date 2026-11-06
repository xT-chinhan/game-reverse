package com.efs.sdk.pa.a;

import android.util.Log;
import com.efs.sdk.pa.PAMsgListener;
import java.io.BufferedOutputStream;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
final class f implements d {
    PAMsgListener a;
    boolean b;
    String c;
    BufferedOutputStream d;

    f() {
    }

    @Override // com.efs.sdk.pa.a.d
    public final void a(String str, long j, long j2) {
        com.efs.sdk.pa.b bVarB = b(str, j, j2);
        if (bVarB != null) {
            if (this.b) {
                Log.e("PerformanceAnalyze", bVarB.toString());
            }
            if (this.c != null) {
                try {
                    this.d.write((bVarB.toString() + "\n").getBytes());
                } catch (Exception e) {
                }
            }
            this.a.msg(bVarB);
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0088  */
    private static com.efs.sdk.pa.b b(String str, long j, long j2) {
        String strSubstring;
        int i;
        String strSubstring2;
        String strSubstring3;
        int iLastIndexOf;
        int i2;
        int i3;
        int i4;
        if (str == null) {
            return null;
        }
        com.efs.sdk.pa.b bVar = new com.efs.sdk.pa.b();
        try {
            int iIndexOf = str.indexOf(":");
            if (iIndexOf != -1 && (i4 = iIndexOf + 2) < str.length()) {
                strSubstring = str.substring(i4, str.length());
            } else {
                strSubstring = "";
            }
            bVar.a = strSubstring;
            if (str.contains("(") && str.contains(")")) {
                int iIndexOf2 = str.indexOf("(");
                int iIndexOf3 = str.indexOf(")");
                if (iIndexOf2 != -1 && iIndexOf3 != -1 && (i3 = iIndexOf2 + 1) < str.length() && iIndexOf3 > i3) {
                    strSubstring2 = str.substring(i3, iIndexOf3);
                } else {
                    strSubstring2 = "";
                }
            } else if (str.contains("{") && str.contains("}")) {
                int iIndexOf4 = str.indexOf("{");
                int iIndexOf5 = str.indexOf("}");
                if (iIndexOf4 != -1 && iIndexOf5 != -1 && (i = iIndexOf4 + 1) < str.length() && iIndexOf5 > i) {
                    strSubstring2 = str.substring(i, iIndexOf5);
                } else {
                    strSubstring2 = "";
                }
            } else {
                strSubstring2 = "";
            }
            bVar.b = strSubstring2;
            if (!str.contains(AbstractJsonLexerKt.NULL) && str.contains("}") && (iLastIndexOf = str.lastIndexOf("}")) != -1 && (i2 = iLastIndexOf + 1) < str.length()) {
                strSubstring3 = str.substring(i2, str.length());
            } else {
                strSubstring3 = "";
            }
            bVar.c = strSubstring3;
            bVar.d = j;
            bVar.e = j2;
            return bVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
