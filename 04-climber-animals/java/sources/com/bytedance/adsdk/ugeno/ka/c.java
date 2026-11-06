package com.bytedance.adsdk.ugeno.ka;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.DebugKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ms f361ms;
    private List<ms> xr;

    public ms ms() {
        return this.f361ms;
    }

    public List<ms> xr() {
        return this.xr;
    }

    public static class ms {
        private String ah = "global";
        private Map<String, Object> c;
        private String d;
        private Map<String, String> ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private String f362ms;
        private String xr;

        public String ms() {
            return this.ah;
        }

        public void ms(String str) {
            this.ah = str;
        }

        public String xr() {
            return this.d;
        }

        public void xr(String str) {
            this.d = str;
        }

        public Map<String, String> ah() {
            return this.ka;
        }

        public void ms(Map<String, String> map) {
            this.ka = map;
        }

        public void ah(String str) {
            this.f362ms = str;
        }

        public String d() {
            return this.f362ms;
        }

        public void d(String str) {
            this.xr = str;
        }

        public String ka() {
            return this.xr;
        }

        public String toString() {
            return "Action{scheme='" + this.ah + "', name='" + this.d + "', params=" + this.ka + ", host='" + this.xr + "', origin='" + this.f362ms + "', extra=" + this.c + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public static c ms(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        String strOptString = jSONObject.optString(DebugKt.DEBUG_PROPERTY_VALUE_ON);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("handlers");
        cVar.f361ms = sl.ms(strOptString, jSONObject2);
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            ms msVarMs = sl.ms(jSONArrayOptJSONArray.optString(i), jSONObject2);
            if (msVarMs != null) {
                arrayList.add(msVarMs);
            }
        }
        cVar.xr = arrayList;
        return cVar;
    }
}
