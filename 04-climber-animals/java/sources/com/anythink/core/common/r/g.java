package com.anythink.core.common.r;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class g {
    private boolean a;
    private long b;
    private int c;
    private long d;
    private int e;
    private long f;
    private int g;
    private long h;
    private int[] i;
    private final List<h> j = Collections.synchronizedList(new ArrayList());
    private final Map<String, h> k = new ConcurrentHashMap();

    private static int b(int i) {
        switch (i) {
            case 1:
                return 10;
            case 2:
                return 12;
            case 3:
                return 6;
            case 4:
                return 11;
            case 5:
                return 15;
            case 6:
                return 16;
            default:
                return 17;
        }
    }

    public static g a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            g gVar = new g();
            gVar.b = jSONObject.optLong("pre_load_time", 30000L);
            gVar.c = jSONObject.optInt("pre_load_num", 1);
            gVar.d = jSONObject.optLong("pre_load_timeout", 30000L);
            gVar.e = jSONObject.optInt("pre_load_mode", 1);
            gVar.f = jSONObject.optLong("shared_delay_time_in_wf", com.anythink.basead.exoplayer.i.a.f);
            gVar.h = jSONObject.optLong("shared_retry_time_in_loadfailed", 15000L);
            gVar.g = jSONObject.optInt("shared_retry_count_in_loadfailed", 6);
            gVar.i = b(jSONObject);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("formats");
            if (jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    try {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject != null) {
                            h hVar = new h();
                            hVar.a = jSONObjectOptJSONObject.optInt("format");
                            hVar.b = jSONObjectOptJSONObject.optString(com.anythink.core.common.m.e.bk, "");
                            hVar.c = jSONObjectOptJSONObject.optInt("req_pacing");
                            hVar.d = jSONObjectOptJSONObject.optInt("ad_cache", 1);
                            hVar.e = jSONObjectOptJSONObject.optDouble("ad_ecpm", -1.0d);
                            hVar.j = gVar;
                            gVar.j.add(hVar);
                            gVar.k.put(hVar.b, hVar);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            return gVar;
        } catch (Throwable th) {
            Object[] objArr = new Object[1];
            th.getMessage();
            return null;
        }
    }

    private static int[] b(JSONObject jSONObject) {
        int[] iArr;
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("pre_load_mode_n");
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                iArr = new int[]{b(jSONObject.optInt("pre_load_mode", 1)), 6, 11};
            } else {
                iArr = new int[jSONArrayOptJSONArray.length()];
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    try {
                        iArr[i] = b(jSONArrayOptJSONArray.optInt(i));
                    } catch (Throwable unused) {
                        return iArr;
                    }
                }
            }
            return iArr;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public final long a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    public final long c() {
        return this.d;
    }

    private int k() {
        return this.e;
    }

    public final Map<String, h> d() {
        return this.k;
    }

    public final List<h> e() {
        return this.j;
    }

    public final long f() {
        return this.f;
    }

    public final int g() {
        if (this.g <= 0) {
            this.g = 6;
        }
        return this.g;
    }

    public final long h() {
        return this.h;
    }

    public final boolean a(int i) {
        int[] iArr = this.i;
        if (iArr != null) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean i() {
        return this.a;
    }

    public final void j() {
        this.a = true;
    }

    public final String toString() {
        return "SharedPlaceConfig{isPreLocalConfig=" + this.a + ", delayPreloadTime=" + this.b + ", parallelReqNum=" + this.c + ", preLoadTimeout=" + this.d + ", preloadMode=" + this.e + ", loadDelayTimeInWF=" + this.f + ", retryLoadCountInFailed=" + this.g + ", retryLoadDelayTimeInfFailed=" + this.h + ", loadModes=" + Arrays.toString(this.i) + ", sharedPlaceInfoList=" + this.j + ", placementIdToSharedPlaceInfoMap=" + this.k + AbstractJsonLexerKt.END_OBJ;
    }
}
