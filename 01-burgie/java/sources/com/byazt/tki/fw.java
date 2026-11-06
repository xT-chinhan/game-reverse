package com.byazt.tki;

import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1549, 62})
public class fw implements com.byazt.awu.pr {
    public final Object pr;

    public fw(String str) {
        if (str.equalsIgnoreCase("true")) {
            this.pr = Boolean.TRUE;
        } else if (str.equalsIgnoreCase("false")) {
            this.pr = Boolean.FALSE;
        } else {
            if (str.equalsIgnoreCase(AbstractJsonLexerKt.NULL)) {
                this.pr = null;
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    @Override // com.byazt.awu.pr
    public Object pr(Map<String, JSONObject> map) {
        return this.pr;
    }

    @Override // com.byazt.awu.pr
    public com.byazt.yiq.c pr() {
        return com.byazt.yiq.uc.CONSTANT;
    }

    public String toString() {
        return "KeywordNode [keywordValue=" + this.pr + "]";
    }

    @Override // com.byazt.awu.pr
    public String hw() {
        Object obj = this.pr;
        if (obj != null) {
            return obj.toString();
        }
        return "NULL";
    }
}
