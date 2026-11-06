package com.bytedance.adsdk.xr.xr.xr.ms;

import com.tencent.bugly.Bugly;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ab implements com.bytedance.adsdk.xr.xr.xr.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Object f466ms;

    public ab(String str) {
        if (str.equalsIgnoreCase("true")) {
            this.f466ms = Boolean.TRUE;
        } else if (str.equalsIgnoreCase(Bugly.SDK_IS_DEV)) {
            this.f466ms = Boolean.FALSE;
        } else {
            if (str.equalsIgnoreCase(AbstractJsonLexerKt.NULL)) {
                this.f466ms = null;
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    @Override // com.bytedance.adsdk.xr.xr.xr.ms
    public Object ms(Map<String, JSONObject> map) {
        return this.f466ms;
    }

    @Override // com.bytedance.adsdk.xr.xr.xr.ms
    public com.bytedance.adsdk.xr.xr.d.ka ms() {
        return com.bytedance.adsdk.xr.xr.d.c.CONSTANT;
    }

    public String toString() {
        return "KeywordNode [keywordValue=" + this.f466ms + "]";
    }

    @Override // com.bytedance.adsdk.xr.xr.xr.ms
    public String xr() {
        Object obj = this.f466ms;
        return obj != null ? obj.toString() : "NULL";
    }
}
