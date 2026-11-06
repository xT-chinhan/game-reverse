package com.anythink.core.common.m.b;

import android.text.TextUtils;
import com.anythink.core.api.ATSDK;
import com.anythink.core.common.n.a.i;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    private int a;
    private a b;

    private c() {
    }

    public static c a(JSONObject jSONObject) {
        int[] iArr = null;
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.a = jSONObject.optInt("net_type", 1);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("net_d");
        if (jSONObjectOptJSONObject != null) {
            long jOptLong = jSONObjectOptJSONObject.optLong("s_timeout", 500L);
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("s_i");
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("srv");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                iArr = new int[jSONArrayOptJSONArray.length()];
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    iArr[i] = jSONArrayOptJSONArray.optInt(i);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i2);
                    if (jSONObjectOptJSONObject2 != null) {
                        String strOptString = jSONObjectOptJSONObject2.optString("ip");
                        if (!TextUtils.isEmpty(strOptString)) {
                            arrayList.add(new b(strOptString, jSONObjectOptJSONObject2.optInt("port", 57), jSONObjectOptJSONObject2.optLong("timeout", 500L)));
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                cVar.b = new a(iArr, jOptLong, (b[]) arrayList.toArray(new b[0]));
            }
        }
        return cVar;
    }

    public final boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        a aVar = this.b;
        boolean z = (aVar == null || aVar.b() == null || this.b.b().length <= 0 || this.b.a() == null || this.b.a().length <= 0 || ATSDK.isCnSDK()) ? false : true;
        if (!z) {
            return z;
        }
        int[] iArrA = this.b.a();
        try {
            int iA = g.a(str);
            for (int i : iArrA) {
                if (iA == i) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            getClass().getSimpleName();
            return false;
        }
    }

    public final i[] a() {
        a aVar = this.b;
        i[] iVarArr = null;
        b[] bVarArrB = aVar != null ? aVar.b() : null;
        if (bVarArrB != null && bVarArrB.length != 0) {
            iVarArr = new i[bVarArrB.length];
            for (int i = 0; i < bVarArrB.length; i++) {
                b bVar = bVarArrB[i];
                if (bVar != null) {
                    iVarArr[i] = new com.anythink.core.common.n.a.g(bVar.a(), bVar.b(), bVar.c());
                }
            }
        }
        return iVarArr;
    }

    public final int b() {
        return this.a;
    }

    private void a(int i) {
        this.a = i;
    }

    private void a(a aVar) {
        this.b = aVar;
    }

    public static class a {
        private final int[] a;
        private final long b;
        private final b[] c;

        public a(int[] iArr, long j, b[] bVarArr) {
            this.a = iArr;
            this.b = j;
            this.c = bVarArr;
        }

        public final int[] a() {
            return this.a;
        }

        public final b[] b() {
            return this.c;
        }

        private long c() {
            return this.b;
        }
    }

    public static class b {
        private final String a;
        private final int b;
        private final long c;

        public b(String str, int i, long j) {
            this.a = str;
            this.b = i;
            this.c = j;
        }

        public final String a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }

        public final long c() {
            return this.c;
        }
    }
}
