package com.anythink.core.common.h;

import com.anythink.core.api.ATAdConst;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class be {
    int a;
    boolean b;
    String c;
    boolean d;
    String e;
    String f;

    private be() {
    }

    public static be a(boolean z, String str, boolean z2, Map<String, Object> map) {
        be beVar = new be();
        beVar.a = 1;
        beVar.b = z;
        beVar.c = str;
        beVar.d = z2;
        if (map != null) {
            try {
                Object obj = map.get(ATAdConst.REWARD_EXTRA.REWARD_INFO);
                if (obj instanceof Map) {
                    Map map2 = (Map) obj;
                    beVar.e = String.valueOf(map2.get(ATAdConst.REWARD_EXTRA.REWARD_INFO_ERROR_CODE));
                    beVar.f = String.valueOf(map2.get(ATAdConst.REWARD_EXTRA.REWARD_INFO_ERROR_MSG));
                }
            } catch (Throwable unused) {
            }
        }
        return beVar;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.a);
            int i = 1;
            jSONObject.put("is_playend", this.b ? 1 : 2);
            jSONObject.put(ImagesContract.URL, this.c);
            if (!this.d) {
                i = 2;
            }
            jSONObject.put("status", i);
            jSONObject.put("e_code", this.e);
            jSONObject.put("e_reason", this.f);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public final String b() {
        return this.e;
    }

    public final String c() {
        return this.f;
    }
}
