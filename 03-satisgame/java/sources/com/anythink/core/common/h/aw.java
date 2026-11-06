package com.anythink.core.common.h;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class aw {
    private final List<a> a = new ArrayList();

    public final List<a> a() {
        return this.a;
    }

    public static class a {
        private final String a;
        private final long b;
        private Map<String, Long> c;

        public a(String str, long j) {
            this.a = str;
            this.b = j;
        }

        public final String a() {
            return this.a;
        }

        public final long b() {
            return this.b;
        }

        public final Map<String, Long> c() {
            return this.c;
        }

        public final void a(Map<String, Long> map) {
            this.c = map;
        }

        public final String toString() {
            return "{errorCode='" + this.a + "', errorCodeInterval=" + this.b + ", msgMap=" + this.c + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public aw(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject != null) {
            try {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    try {
                        String next = itKeys.next();
                        if (!TextUtils.isEmpty(next) && (jSONObjectOptJSONObject = jSONObject.optJSONObject(next)) != null) {
                            a aVar = new a(next, jSONObjectOptJSONObject.optLong("c_t", 0L));
                            try {
                                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(NotificationCompat.CATEGORY_MESSAGE);
                                if (jSONObjectOptJSONObject2 != null) {
                                    HashMap map = new HashMap();
                                    Iterator<String> itKeys2 = jSONObjectOptJSONObject2.keys();
                                    while (itKeys2.hasNext()) {
                                        try {
                                            String next2 = itKeys2.next();
                                            if (!TextUtils.isEmpty(next2)) {
                                                long jOptLong = jSONObjectOptJSONObject2.optLong(next2, 0L);
                                                if (jOptLong > 0) {
                                                    map.put(next2, Long.valueOf(jOptLong));
                                                }
                                            }
                                        } catch (Throwable unused) {
                                        }
                                    }
                                    if (!map.isEmpty()) {
                                        aVar.a(map);
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            this.a.add(aVar);
                        }
                    } catch (Throwable unused2) {
                    }
                }
            } catch (Throwable unused3) {
            }
        }
    }
}
