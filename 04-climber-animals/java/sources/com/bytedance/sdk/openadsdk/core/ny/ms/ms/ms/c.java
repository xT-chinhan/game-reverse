package com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c implements com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms {
    private View ab;
    private Context ah;
    private int c;
    private String d;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms f3135ms;
    private Map<String, Object> x;
    private lm xr;

    private boolean xr(int i) {
        switch (i) {
            case 101:
            case 102:
            case 103:
                return true;
            default:
                return false;
        }
    }

    public c(lm lmVar, Context context, String str, String str2) {
        this.xr = lmVar;
        this.ah = context;
        this.d = str;
        this.ka = str2;
        xr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms
    public boolean ms(Map<String, Object> map) {
        boolean zMs = ms();
        xr();
        if (zMs) {
            return true;
        }
        HashMap map2 = new HashMap(2);
        map2.put("event_tag", this.d);
        if (!TextUtils.isEmpty(this.ka)) {
            map2.put("dpa_tag", this.ka);
        }
        if ((com.bytedance.sdk.openadsdk.core.live.xr.ms().ms(this.ah, this.xr, map2) & 255) == 0) {
            return true;
        }
        com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms msVar = this.f3135ms;
        return msVar != null && msVar.ms(map);
    }

    private boolean ms() {
        if (this.c < 2) {
            return false;
        }
        HashMap map = new HashMap(2);
        if (xr(this.c)) {
            map.put("live_saas_param_interaction_type", Integer.valueOf(this.c));
        }
        map.put("event_tag", this.d);
        String str = this.ka;
        if (str != null) {
            map.put("dpa_tag", str);
        }
        if (this.x == null) {
            this.x = new HashMap();
        }
        com.bytedance.sdk.openadsdk.core.live.xr.ms().ms(this.ab, this.xr.ml(), map, this.x);
        int iMs = com.bytedance.sdk.openadsdk.core.live.xr.ms().ms(this.ah, this.xr, map);
        int i = iMs & 255;
        int i2 = (iMs & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (i2 > 0) {
            this.x.put("click_saas_action", Integer.valueOf(i2));
        }
        return i == 0;
    }

    public void xr(Map<String, Object> map) {
        this.x = map;
    }

    private void xr() {
        lm lmVar = this.xr;
        if (lmVar != null) {
            this.c = lmVar.ku();
        } else {
            this.c = -1;
        }
    }

    public void ms(int i) {
        this.c = i;
    }

    public void ms(View view) {
        this.ab = view;
    }
}
