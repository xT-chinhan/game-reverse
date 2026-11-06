package com.anythink.core.basead.adx.api;

import android.text.TextUtils;
import com.anythink.core.e.i;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ATAdxAdapterConfig {
    public static final int RULE_TYPE_GROUP = 1;
    public static final int RULE_TYPE_NORMAL = 2;
    boolean isDefault;
    i mAdapterStrategy;
    JSONObject mOriginJSONObject;

    private ATAdxAdapterConfig(i iVar, JSONObject jSONObject) {
        this.mAdapterStrategy = iVar;
        this.mOriginJSONObject = jSONObject;
    }

    private ATAdxAdapterConfig(boolean z) {
        this.isDefault = z;
    }

    public int getRuleType() {
        i iVar = this.mAdapterStrategy;
        if (iVar != null) {
            return iVar.a();
        }
        return 1;
    }

    public int getGroupCount() {
        i.a aVarB;
        i iVar = this.mAdapterStrategy;
        if (iVar == null || (aVarB = iVar.b()) == null) {
            return 3;
        }
        return aVarB.a;
    }

    public int getValuedTimes() {
        i.a aVarB;
        i iVar = this.mAdapterStrategy;
        if (iVar == null || (aVarB = iVar.b()) == null) {
            return 3;
        }
        return aVarB.b;
    }

    public int getCoolingTimes() {
        i.a aVarB;
        i iVar = this.mAdapterStrategy;
        if (iVar == null || (aVarB = iVar.b()) == null) {
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
        i iVar = this.mAdapterStrategy;
        if (iVar != null) {
            return iVar.c();
        }
        return true;
    }

    public static ATAdxAdapterConfig parse(JSONObject jSONObject) {
        i iVarA = i.a(jSONObject);
        if (iVarA != null) {
            return new ATAdxAdapterConfig(iVarA, jSONObject);
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
