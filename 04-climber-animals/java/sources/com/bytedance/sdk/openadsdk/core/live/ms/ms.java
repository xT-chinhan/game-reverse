package com.bytedance.sdk.openadsdk.core.live.ms;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.jw.az;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.h;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.re;
import com.bytedance.sdk.openadsdk.core.t.u;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms implements d {
    protected JSONObject ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected volatile Bridge f2845ms = null;
    protected volatile String xr;

    public void a_(String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public long ah() {
        return -1L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public void d(lm lmVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public void ms() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public void ms(String str, lm lmVar, long j) {
    }

    protected abstract boolean w_();

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public void ms(Bridge bridge) {
        if (bridge == null) {
            return;
        }
        this.f2845ms = new com.bytedance.sdk.openadsdk.ao.ms(bridge);
    }

    protected boolean a_(lm lmVar) {
        if (lmVar == null) {
            return false;
        }
        return ms(lmVar.eo(), lmVar.ku());
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public boolean ms(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (Long.parseLong(str) <= 0) {
                return false;
            }
            switch (i) {
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    return true;
                default:
                    return false;
            }
        } catch (Exception unused) {
            return false;
        }
    }

    protected long xr(lm lmVar) {
        if (lmVar == null) {
            return 0L;
        }
        String strEo = lmVar.eo();
        if (TextUtils.isEmpty(strEo)) {
            strEo = ms(lmVar.tc());
        }
        try {
            return Long.parseLong(strEo);
        } catch (Exception unused) {
            return 0L;
        }
    }

    protected String ms(h hVar) {
        Map<String, String> mapMs;
        if (hVar == null) {
            return null;
        }
        String strXr = hVar.xr();
        if (TextUtils.isEmpty(strXr)) {
            return null;
        }
        if ((strXr.startsWith("snssdk2329") || strXr.startsWith("snssdk1128")) && (mapMs = az.ms(strXr)) != null) {
            return mapMs.get("room_id");
        }
        return null;
    }

    protected String ms(lm lmVar, String str, Map map) {
        if (map == null) {
            return str;
        }
        try {
            String str2 = (String) map.get("dpa_tag");
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            String strKa = re.ka(lmVar, str2);
            if (TextUtils.isEmpty(strKa)) {
                return str;
            }
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(strKa);
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.putOpt(next, jSONObject2.opt(next));
            }
            return jSONObject.toString();
        } catch (Exception e) {
            sl.xr("TTLiveSDkBridge", e);
            u.ms().ms("getEcomLiveParams", e);
            return str;
        }
    }

    protected void ms(lm lmVar, String str, int i, int i2, int i3) {
        com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVar, str, i, i2, i3, w_());
    }

    protected boolean ms(lm lmVar, int i) {
        return lmVar.ku() == 7 || i == 103;
    }

    protected int ah(lm lmVar) {
        h hVarTc;
        if (1 != com.bytedance.sdk.openadsdk.core.live.xr.ms().ka()) {
            return 2;
        }
        if (!com.bytedance.sdk.openadsdk.core.live.ka.ms.ms(lmVar)) {
            return 3;
        }
        if (lmVar != null && f.xr(com.bytedance.sdk.openadsdk.core.re.getContext()) && (hVarTc = lmVar.tc()) != null) {
            String strXr = hVarTc.xr();
            if (!TextUtils.isEmpty(strXr)) {
                Uri uri = Uri.parse(strXr);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                return f.xr(com.bytedance.sdk.openadsdk.core.re.getContext(), intent, true) ? 0 : 4;
            }
        }
        return 0;
    }
}
