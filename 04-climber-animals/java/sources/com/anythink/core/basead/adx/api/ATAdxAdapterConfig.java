package com.anythink.core.basead.adx.api;

import android.text.TextUtils;
import com.anythink.core.d.h;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ATAdxAdapterConfig {
    public static final int RULE_TYPE_GROUP = 1;
    public static final int RULE_TYPE_NORMAL = 2;
    boolean isDefault;
    h mAdapterStrategy;
    JSONObject mOriginJSONObject;

    private ATAdxAdapterConfig(h hVar, JSONObject jSONObject) {
        this.mAdapterStrategy = hVar;
        this.mOriginJSONObject = jSONObject;
    }

    private ATAdxAdapterConfig(boolean z) {
        this.isDefault = z;
    }

    public int getRuleType() {
        h hVar = this.mAdapterStrategy;
        if (hVar != null) {
            return hVar.a();
        }
        return 1;
    }

    public int getGroupCount() {
        h.a aVarB;
        h hVar = this.mAdapterStrategy;
        if (hVar == null || (aVarB = hVar.b()) == null) {
            return 3;
        }
        return aVarB.a;
    }

    public int getValuedTimes() {
        h.a aVarB;
        h hVar = this.mAdapterStrategy;
        if (hVar == null || (aVarB = hVar.b()) == null) {
            return 3;
        }
        return aVarB.b;
    }

    public int getCoolingTimes() {
        h.a aVarB;
        h hVar = this.mAdapterStrategy;
        if (hVar == null || (aVarB = hVar.b()) == null) {
            return 5;
        }
        return aVarB.c;
    }

    public JSONObject getOriginJSONObject() {
        return this.mOriginJSONObject;
    }

    public boolean isDefault() {
        return this.isDefault;
    }

    public boolean isExpired() {
        h hVar = this.mAdapterStrategy;
        if (hVar != null) {
            return hVar.c();
        }
        return true;
    }

    public static ATAdxAdapterConfig parse(JSONObject jSONObject) {
        h hVarA = h.a(jSONObject);
        if (hVarA != null) {
            return new ATAdxAdapterConfig(hVarA, jSONObject);
        }
        return new ATAdxAdapterConfig(true);
    }

    public static ATAdxAdapterConfig parse(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return parse(new JSONObject(str));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public String toString() {
        return "ATAdxAdapterConfig{isDefault=" + isDefault() + ", isExpired=" + isExpired() + ", getRuleType=" + getRuleType() + ", getGroupCount=" + getGroupCount() + ", getValuedTimes=" + getValuedTimes() + ", getCoolingTimes=" + getCoolingTimes() + ", getOriginJSONObject=" + this.mOriginJSONObject + AbstractJsonLexerKt.END_OBJ;
    }
}
