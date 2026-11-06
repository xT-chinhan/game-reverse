package com.anythink.core.common.q;

import android.text.TextUtils;
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
public class g {
    public static final String a = "g";
    private boolean b;
    private long c;
    private int d;
    private long e;
    private int f;
    private long g;
    private int h;
    private long i;
    private Integer[] j;
    private final List<h> k = Collections.synchronizedList(new ArrayList());
    private final Map<String, h> l = new ConcurrentHashMap();

    private static int a(int i) {
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
            gVar.c = jSONObject.optLong("pre_load_time", 30000L);
            gVar.d = jSONObject.optInt("pre_load_num", 1);
            gVar.e = jSONObject.optLong("pre_load_timeout", 30000L);
            gVar.f = jSONObject.optInt("pre_load_mode", 1);
            gVar.g = jSONObject.optLong("shared_delay_time_in_wf", 2000L);
            gVar.i = jSONObject.optLong("shared_retry_time_in_loadfailed", 15000L);
            gVar.h = jSONObject.optInt("shared_retry_count_in_loadfailed", 6);
            gVar.j = b(jSONObject);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("formats");
            if (jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    try {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject != null) {
                            h hVar = new h();
                            hVar.a = jSONObjectOptJSONObject.optInt(com.anythink.core.common.f.a.C0017a.d);
                            hVar.b = jSONObjectOptJSONObject.optString(com.anythink.core.common.l.f.bn, "");
                            hVar.c = jSONObjectOptJSONObject.optInt("req_pacing");
                            hVar.d = jSONObjectOptJSONObject.optInt("ad_cache", 1);
                            hVar.e = jSONObjectOptJSONObject.optDouble("ad_ecpm", -1.0d);
                            hVar.j = gVar;
                            if (!jSONObjectOptJSONObject.isNull("pre_load_mode_n")) {
                                hVar.k = c(jSONObjectOptJSONObject);
                            }
                            gVar.k.add(hVar);
                            gVar.l.put(hVar.b, hVar);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            return gVar;
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static Integer[] b(JSONObject jSONObject) {
        Integer[] numArr;
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("pre_load_mode_n");
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                numArr = new Integer[]{Integer.valueOf(a(jSONObject.optInt("pre_load_mode", 1))), 6, 11};
            } else {
                numArr = new Integer[jSONArrayOptJSONArray.length()];
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    try {
                        numArr[i] = Integer.valueOf(a(jSONArrayOptJSONArray.optInt(i)));
                    } catch (Throwable unused) {
                        return numArr;
                    }
                }
            }
            return numArr;
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static Integer[] c(JSONObject jSONObject) {
        Integer[] numArr = null;
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("pre_load_mode_n");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                numArr = new Integer[jSONArrayOptJSONArray.length()];
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    numArr[i] = Integer.valueOf(a(jSONArrayOptJSONArray.optInt(i)));
                }
            }
        } catch (Throwable unused) {
        }
        return numArr;
    }

    public final long a() {
        return this.c;
    }

    public final int b() {
        return this.d;
    }

    public final long c() {
        return this.e;
    }

    private int m() {
        return this.f;
    }

    public final Map<String, h> d() {
        return this.l;
    }

    public final List<h> e() {
        return this.k;
    }

    public final long f() {
        return this.g;
    }

    public final int g() {
        if (this.h <= 0) {
            this.h = 6;
        }
        return this.h;
    }

    public final long h() {
        return this.i;
    }

    public final boolean i() {
        if (this.k != null) {
            for (int i = 0; i < this.k.size(); i++) {
                h hVar = this.k.get(i);
                if (hVar != null && hVar.k != null) {
                    for (Integer num : hVar.k) {
                        if (num.intValue() == 10) {
                            return true;
                        }
                    }
                }
            }
        }
        Integer[] numArr = this.j;
        if (numArr != null) {
            return Arrays.asList(numArr).contains(10);
        }
        return false;
    }

    public final boolean j() {
        Integer[] numArr = this.j;
        if (numArr != null) {
            return Arrays.asList(numArr).contains(10);
        }
        return false;
    }

    public final boolean a(int i, String str) {
        boolean z;
        Integer[] numArr;
        h hVar;
        if (this.l != null && !TextUtils.isEmpty(str) && (hVar = this.l.get(str)) != null && hVar.k != null) {
            Integer[] numArr2 = hVar.k;
            int length = numArr2.length;
            int i2 = 0;
            while (true) {
                z = true;
                if (i2 >= length) {
                    break;
                }
                if (numArr2[i2].intValue() == i) {
                    return true;
                }
                i2++;
            }
        } else {
            z = false;
        }
        if (z || (numArr = this.j) == null) {
            return false;
        }
        return Arrays.asList(numArr).contains(Integer.valueOf(i));
    }

    public final boolean k() {
        return this.b;
    }

    public final void l() {
        this.b = true;
    }

    public String toString() {
        return "SharedPlaceConfig{isPreLocalConfig=" + this.b + ", delayPreloadTime=" + this.c + ", parallelReqNum=" + this.d + ", preLoadTimeout=" + this.e + ", preloadMode=" + this.f + ", loadDelayTimeInWF=" + this.g + ", retryLoadCountInFailed=" + this.h + ", retryLoadDelayTimeInfFailed=" + this.i + ", loadModes=" + Arrays.toString(this.j) + ", sharedPlaceInfoList=" + this.k + ", placementIdToSharedPlaceInfoMap=" + this.l + AbstractJsonLexerKt.END_OBJ;
    }
}
