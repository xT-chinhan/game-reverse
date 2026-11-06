package com.anythink.core.common.h;

import com.anythink.core.api.ATAdRequest;
import java.util.Map;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bo {
    private String a;
    private String b;
    private String c;
    private String d;
    private int e;
    private Map<String, Object> f;
    private Map<String, Object> g;
    private Map<String, String> h;
    private JSONObject i;
    private String j;
    private JSONObject k;
    private ATAdRequest l;
    private boolean m;
    private boolean n;
    private String o;
    private String p;

    public bo(String str, String str2, String str3, String str4, Map<String, Object> map, Map<String, Object> map2, JSONObject jSONObject, ATAdRequest aTAdRequest) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.f = map;
        this.g = map2;
        this.i = jSONObject;
        this.l = aTAdRequest;
        this.o = UUID.randomUUID().toString();
    }

    public bo(String str, String str2, String str3, String str4) {
        this.i = null;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.j = str4;
        this.o = UUID.randomUUID().toString();
    }

    public final String b() {
        return this.a;
    }

    private void b(String str) {
        this.a = str;
    }

    public final String c() {
        return this.b;
    }

    private void c(String str) {
        this.b = str;
    }

    public final String d() {
        return this.c;
    }

    private void d(String str) {
        this.c = str;
    }

    public final String e() {
        return this.d;
    }

    private void e(String str) {
        this.d = str;
    }

    public final Map<String, Object> f() {
        return this.f;
    }

    private void b(Map<String, Object> map) {
        this.f = map;
    }

    public final Map<String, Object> g() {
        return this.g;
    }

    private void c(Map<String, Object> map) {
        this.g = map;
    }

    public final int h() {
        return this.e;
    }

    public final void a(int i) {
        this.e = i;
    }

    public final Map<String, String> i() {
        return this.h;
    }

    public final void a(Map<String, String> map) {
        this.h = map;
    }

    public final ATAdRequest j() {
        return this.l;
    }

    public final String k() {
        return this.o;
    }

    public String toString() {
        return "PlaceStrategyLoaderParams{appId='" + this.a + "', appKey='" + this.b + "', placeId='" + this.c + "', settingId='" + this.d + "', fistReqPlaceStrategyFlag=" + this.e + ", customMap=" + this.f + ", tkExtraMap=" + this.g + ", cachedMap=" + this.h + ", reqReason='" + this.p + AbstractJsonLexerKt.END_OBJ;
    }

    public final JSONObject l() {
        return this.i;
    }

    public final String m() {
        return this.j;
    }

    public final JSONObject n() {
        return this.k;
    }

    public final void a(JSONObject jSONObject) {
        this.k = jSONObject;
    }

    private boolean a() {
        return this.m;
    }

    public final void a(boolean z) {
        this.m = z;
    }

    public final boolean o() {
        return this.n;
    }

    public final void b(boolean z) {
        this.n = z;
    }

    public final String p() {
        return this.p;
    }

    public final void a(String str) {
        this.p = str;
    }
}
