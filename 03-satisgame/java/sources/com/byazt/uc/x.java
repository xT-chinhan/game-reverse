package com.byazt.uc;

import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1276, 21})
public class x implements com.byazt.uk.n {
    public final Object n;

    public x(String str) {
        if (str.equalsIgnoreCase("true")) {
            this.n = Boolean.TRUE;
        } else if (str.equalsIgnoreCase("false")) {
            this.n = Boolean.FALSE;
        } else {
            if (str.equalsIgnoreCase(AbstractJsonLexerKt.NULL)) {
                this.n = null;
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    @Override // com.byazt.uk.n
    public Object n(Map<String, JSONObject> map) {
        return this.n;
    }

    @Override // com.byazt.uk.n
    public com.byazt.mn.l n() {
        return com.byazt.mn.w.CONSTANT;
    }

    public String toString() {
        return "KeywordNode [keywordValue=" + this.n + "]";
    }

    @Override // com.byazt.uk.n
    public String qg() {
        Object obj = this.n;
        return obj != null ? obj.toString() : "NULL";
    }
}
