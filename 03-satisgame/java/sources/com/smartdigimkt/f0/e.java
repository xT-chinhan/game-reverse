package com.smartdigimkt.f0;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.sdk.core.SDKContext;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final String g = com.smartdigimkt.r4.e.a("eyJkc3BfY2xpY2tfbWFjcm9fY29uZmlnIjp7IjQ5Ijp7Im1hcHBpbmdzIjpbeyJtYWNybyI6Il9fUkVfQ19ET1dOX1hfXyIsImFjdGlvbiI6IjMiLCJ2YWx1ZSI6IiRkeCQifSx7Im1hY3JvIjoiX19SRV9DX0RPV05fWV9fIiwiYWN0aW9uIjoiMyIsInZhbHVlIjoiJGR5JCJ9LHsibWFjcm8iOiJfX1JFX0NfVVBfWF9fIiwiYWN0aW9uIjoiMyIsInZhbHVlIjoiJHV4JCJ9LHsibWFjcm8iOiJfX1JFX0NfVVBfWV9fIiwiYWN0aW9uIjoiMyIsInZhbHVlIjoiJHV5JCJ9LHsibWFjcm8iOiJfX01fWF9BQ0NfXyIsImFjdGlvbiI6IjMiLCJ2YWx1ZSI6IiR6bWEkIn0seyJtYWNybyI6Il9fTV9ZX0FDQ19fIiwiYWN0aW9uIjoiMyIsInZhbHVlIjoiJHltYSQifSx7Im1hY3JvIjoiX19NX1pfQUNDX18iLCJhY3Rpb24iOiIzIiwidmFsdWUiOiIkem1hJCJ9XX19fQ==");
    public volatile String b;
    public final File c;
    public final HashMap e;
    public final String a = com.anythink.core.common.b.e.a;
    public final Object d = new Object();
    public boolean f = false;

    public e() {
        File file;
        File filesDir;
        try {
            Context contextD = SDKContext.getInstance().d();
            file = (contextD == null || (filesDir = contextD.getFilesDir()) == null) ? null : new File(filesDir.getAbsoluteFile().getAbsolutePath() + "/sdm_tracker_mapping/");
        } catch (Throwable unused) {
        }
        this.c = file;
        this.e = new HashMap();
        if (file != null) {
            com.smartdigimkt.q3.f.a().c(new a(this));
        }
    }

    public final void a(String str) {
        JSONArray jSONArrayOptJSONArray;
        try {
            HashMap map = this.e;
            if (map == null) {
                return;
            }
            map.clear();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("dsp_click_macro_config");
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(next);
                    if (jSONObjectOptJSONObject2 != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("mappings")) != null) {
                        g gVar = new g();
                        gVar.a(jSONArrayOptJSONArray);
                        this.e.put(next, gVar);
                    }
                }
            }
            Objects.toString(jSONObjectOptJSONObject);
        } catch (Throwable unused) {
        }
    }
}
