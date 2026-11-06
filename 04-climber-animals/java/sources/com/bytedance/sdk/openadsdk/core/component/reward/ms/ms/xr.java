package com.bytedance.sdk.openadsdk.core.component.reward.ms.ms;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.c;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.jw.nw;
import com.bytedance.sdk.openadsdk.core.ka.d.d;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.re;
import java.io.File;
import java.io.FileFilter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile xr f2227ms;
    private final ah ah;
    private long d;
    private final Context xr;

    public static xr ms() {
        if (f2227ms == null) {
            synchronized (xr.class) {
                if (f2227ms == null) {
                    f2227ms = new xr(re.getContext());
                }
            }
        }
        return f2227ms;
    }

    private xr(Context context) {
        this.xr = context == null ? re.getContext() : context.getApplicationContext();
        this.ah = new ah();
    }

    public void xr() {
        File fileAh;
        File[] fileArrListFiles;
        d.ms(7).ms();
        d.ms(8).ms();
        if (("mounted".equals(com.bytedance.sdk.openadsdk.op.ah.ms()) || !Environment.isExternalStorageRemovable()) && com.bytedance.sdk.openadsdk.api.plugin.xr.ah(this.xr) != null) {
            fileAh = com.bytedance.sdk.openadsdk.api.plugin.xr.ah(this.xr);
        } else {
            fileAh = com.bytedance.sdk.openadsdk.api.plugin.xr.xr(this.xr);
        }
        if (fileAh == null || !fileAh.exists() || !fileAh.isDirectory() || (fileArrListFiles = fileAh.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.ms.ms.xr.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (file != null) {
                    return file.getName().contains("reward_video_cache");
                }
                return false;
            }
        })) == null || fileArrListFiles.length <= 0) {
            return;
        }
        for (File file : fileArrListFiles) {
            try {
                c.ah(file);
            } catch (Throwable unused) {
            }
        }
    }

    public String ms(boolean z, String str) {
        long jAh = re.xr().ah(str);
        if (jAh > 0 && System.currentTimeMillis() - this.d < jAh) {
            return "1";
        }
        int i = z ? 7 : 8;
        lm lmVarXr = xr(z, str);
        if (lmVarXr == null) {
            return "0";
        }
        if (lmVarXr.f() + lmVarXr.re() < System.currentTimeMillis()) {
            d.ms(i).ms(str);
            return "1";
        }
        JSONObject jSONObjectMs = ms(lmVarXr);
        if (jSONObjectMs == null) {
            return "0";
        }
        this.d = System.currentTimeMillis();
        return jSONObjectMs.toString();
    }

    private JSONObject ms(lm lmVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("req_id", lmVar.cv());
            jSONObject.put("aid", Long.valueOf(lmVar.cz()));
            jSONObject.put("cid", Long.valueOf(lmVar.df()));
            jSONObject.put("price", lmVar.jw());
            jSONObject.put("material_key", lmVar.p());
            jSONObject.put("s_send_ts", lmVar.f());
            jSONObject.put("cache_time", lmVar.re());
            jSONObject.put("ext", lmVar.i());
            return jSONObject;
        } catch (JSONException e) {
            sl.ms(e);
            return null;
        }
    }

    public void ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, String str) {
        this.ah.ms(str, xrVar);
    }

    public com.bytedance.sdk.openadsdk.ao.xr.ah.xr ms(String str) {
        return this.ah.ms(str);
    }

    public void xr(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ms(xrVar, str);
    }

    public synchronized lm xr(boolean z, String str) {
        lm lmVarMs = com.bytedance.sdk.openadsdk.core.component.reward.ms.d.ms(z, false).ms(str, 0L);
        if (lmVarMs == null) {
            return null;
        }
        if (nw.ah(lmVarMs)) {
            if (TextUtils.isEmpty(str) || !str.endsWith("again")) {
                return lmVarMs;
            }
            return null;
        }
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(lmVarMs)) {
            return lmVarMs;
        }
        if (qr.u(lmVarMs) == null) {
            return null;
        }
        return lmVarMs;
    }
}
