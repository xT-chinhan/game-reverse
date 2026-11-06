package com.bytedance.adsdk.xr.xr;

import com.bytedance.adsdk.xr.xr.ah.ms.ab;
import com.bytedance.adsdk.xr.xr.ah.ms.ah;
import com.bytedance.adsdk.xr.xr.ah.ms.c;
import com.bytedance.adsdk.xr.xr.ah.ms.ch;
import com.bytedance.adsdk.xr.xr.ah.ms.d;
import com.bytedance.adsdk.xr.xr.ah.ms.ka;
import com.bytedance.adsdk.xr.xr.ah.ms.ny;
import com.bytedance.adsdk.xr.xr.ah.ms.x;
import com.bytedance.adsdk.xr.xr.ah.ms.xr;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final com.bytedance.adsdk.xr.xr.ah.ms f463ms;
    private com.bytedance.adsdk.xr.xr.xr.ms ah;
    private Deque<com.bytedance.adsdk.xr.xr.xr.ms> d = new LinkedList();
    private String ka;
    private final com.bytedance.adsdk.xr.xr.ah.ms xr;

    static {
        int i = 8;
        c[] cVarArr = {new ch(), new d(), new ny(), new xr(), new ka(), new com.bytedance.adsdk.xr.xr.ah.ms.ms(), new ab(), new ah(), new x()};
        final com.bytedance.adsdk.xr.xr.ah.ms msVar = new com.bytedance.adsdk.xr.xr.ah.ms() { // from class: com.bytedance.adsdk.xr.xr.ms.1
            @Override // com.bytedance.adsdk.xr.xr.ah.ms
            public int ms(String str, int i2, Deque<com.bytedance.adsdk.xr.xr.xr.ms> deque) {
                return i2;
            }
        };
        while (i >= 0) {
            final c cVar = cVarArr[i];
            i--;
            msVar = new com.bytedance.adsdk.xr.xr.ah.ms() { // from class: com.bytedance.adsdk.xr.xr.ms.2
                @Override // com.bytedance.adsdk.xr.xr.ah.ms
                public int ms(String str, int i2, Deque<com.bytedance.adsdk.xr.xr.xr.ms> deque) {
                    return cVar.ms(str, i2, deque, msVar);
                }
            };
        }
        f463ms = msVar;
    }

    private ms(String str, com.bytedance.adsdk.xr.xr.ah.ms msVar) {
        this.xr = msVar;
        this.ka = str;
        try {
            ms();
        } catch (Exception e) {
            throw new com.bytedance.adsdk.xr.ms.xr(str, e);
        }
    }

    public static ms ms(String str) {
        return new ms(str, f463ms);
    }

    private void ms() {
        int length = this.ka.length();
        int i = 0;
        while (i < length) {
            int iMs = this.xr.ms(this.ka, i, this.d);
            if (iMs == i) {
                throw new IllegalArgumentException("Unrecognized expression, unrecognized characters encountered during parsing:" + this.ka.substring(0, i));
            }
            i = iMs;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            com.bytedance.adsdk.xr.xr.xr.ms msVarPollFirst = this.d.pollFirst();
            if (msVarPollFirst != null) {
                arrayList.add(0, msVarPollFirst);
            } else {
                this.ah = com.bytedance.adsdk.xr.xr.ka.xr.ms(arrayList, this.ka, i);
                this.d = null;
                return;
            }
        }
    }

    public <T> T ms(JSONObject jSONObject) {
        HashMap map = new HashMap();
        map.put("default_key", jSONObject);
        return (T) ms(map);
    }

    public <T> T ms(Map<String, JSONObject> map) {
        return (T) this.ah.ms(map);
    }
}
