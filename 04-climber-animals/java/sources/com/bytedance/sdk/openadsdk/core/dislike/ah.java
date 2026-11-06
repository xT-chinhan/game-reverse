package com.bytedance.sdk.openadsdk.core.dislike;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.op;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.ao.xr.xr.c;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.g.ka;
import com.bytedance.sdk.openadsdk.core.g.x;
import com.bytedance.sdk.openadsdk.core.nw.e;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.op.ab;
import com.bytedance.sdk.openadsdk.op.d;
import com.tapsdk.tapad.constants.Constants;
import com.umeng.analytics.pro.bv;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements com.bytedance.sdk.openadsdk.core.dislike.xr.ms {
    private final xr ah;
    private String d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final lm f2461ms;
    private final WeakReference<Context> xr;

    public ah(lm lmVar, Context context, xr xrVar) {
        this.f2461ms = lmVar;
        this.xr = new WeakReference<>(context);
        this.ah = xrVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dislike.xr.ms
    public boolean ms(String str, Dialog dialog) {
        if (TextUtils.isEmpty(str) || this.xr.get() == null || !str.startsWith("#oncall#")) {
            return false;
        }
        return ms(this.xr.get(), str, dialog);
    }

    @Override // com.bytedance.sdk.openadsdk.core.dislike.xr.ms
    public boolean ms(c cVar, String str, Dialog dialog) {
        com.bytedance.sdk.openadsdk.core.dislike.ah.ah ahVarMs = xr.ms();
        if (ahVarMs != null && TextUtils.equals(cVar.ms(), ahVarMs.ms()) && TextUtils.equals(cVar.xr(), ahVarMs.xr())) {
            return ms(this.xr.get(), str, dialog);
        }
        return false;
    }

    public boolean ms(Context context, final String str, Dialog dialog) {
        try {
            if (this.d == null) {
                this.d = UUID.randomUUID().toString();
            }
            if (dialog != null) {
                dialog.dismiss();
            }
            new AlertDialog.Builder(context).setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ah.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    ah ahVar = ah.this;
                    ahVar.ms(ahVar.d, str);
                }
            }).setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ah.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).setMessage(this.ah.d() + "\n\n您此次反馈的id为：" + this.d).setCancelable(true).create().show();
            return true;
        } catch (Exception e) {
            sl.ms(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final String str) {
        ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ah.3
            @Override // java.lang.Runnable
            public void run() {
                if (ah.this.xr.get() != null) {
                    op.ms((Context) ah.this.xr.get(), str, 1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final String str, final String str2) {
        ms("反馈上传中，请您稍等！");
        com.bytedance.sdk.component.ch.ab.xr(new ny("upload_oncall") { // from class: com.bytedance.sdk.openadsdk.core.dislike.ah.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ah.this.xr(str, str2);
                } catch (Throwable th) {
                    sl.xr("#oncall#", th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(String str, String str2) throws Throwable {
        File file = new File(com.bytedance.sdk.openadsdk.api.plugin.xr.xr(re.getContext()), str);
        file.mkdirs();
        com.bytedance.sdk.openadsdk.core.op opVar = (com.bytedance.sdk.openadsdk.core.op) re.ms();
        com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVarRt = this.f2461ms.rt();
        JSONObject jSONObjectMs = opVar.ms(xrVarRt, new e(), xrVarRt.t(), false, 6);
        if (jSONObjectMs == null) {
            return;
        }
        d.ms(com.bytedance.sdk.openadsdk.core.ah.c.ms().xr(jSONObjectMs.toString()).d().toString(), new File(file, "request.info"));
        HashMap map = null;
        d.ms(com.bytedance.sdk.component.utils.ms.ms(x.ms((ka) null).ab()).toString(), new File(file, "setting.info"));
        d.ms(com.bytedance.sdk.component.utils.ms.ms(this.f2461ms.rm()).toString(), new File(file, "meta.info"));
        File fileMs = d.ms(file, str + ".zip");
        String strAh = ah(str2, str);
        HashMap map2 = new HashMap();
        Pair<Integer, JSONObject> pairMs = com.bytedance.sdk.openadsdk.core.ah.c.ms().ms(strAh, false);
        if (pairMs != null) {
            map = new HashMap();
            map2.put("deviceInfo", ((JSONObject) pairMs.second).optString("message"));
            map.put("x-pglcypher", String.valueOf(pairMs.first));
        }
        new com.bytedance.sdk.openadsdk.zb.ms().ms(this.ah.ah(), fileMs, map2, new com.bytedance.sdk.openadsdk.zb.ms.InterfaceC0343ms() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ah.5
            @Override // com.bytedance.sdk.openadsdk.zb.ms.InterfaceC0343ms
            public void ms(String str3) {
                ah.this.ms("反馈上传成功！");
            }

            @Override // com.bytedance.sdk.openadsdk.zb.ms.InterfaceC0343ms
            public void ms(int i, String str3) {
                ah.this.ms("反馈失败！");
            }
        }, map);
        fileMs.delete();
        d.ms(file);
    }

    private String ah(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("app_name", ch.ub().nw());
            jSONObject.putOpt("app_id", ch.ub().t());
            jSONObject.putOpt("os_api", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt(bv.y, Build.VERSION.RELEASE);
            jSONObject.putOpt("manufacturer", Build.MANUFACTURER);
            jSONObject.putOpt("did", com.bytedance.sdk.openadsdk.core.c.ms().ah());
            jSONObject.putOpt("sdk_version", 6923);
            jSONObject.putOpt("sdk_api_version", Integer.valueOf(g.xr));
            jSONObject.putOpt("live_sdk_version", com.bytedance.sdk.openadsdk.core.live.xr.ms().ab());
            jSONObject.putOpt("msg", str);
            jSONObject.putOpt("recordId", str2);
            jSONObject.putOpt("os", "Android");
            jSONObject.putOpt(Constants.p.a, this.f2461ms.zg());
            com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVarRt = this.f2461ms.rt();
            if (xrVarRt != null) {
                jSONObject.putOpt("ad_slot_type", Integer.valueOf(xrVarRt.t()));
                jSONObject.putOpt("rit", xrVarRt.y());
            }
            return jSONObject.toString();
        } catch (Exception e) {
            sl.xr("#oncall#", e);
            return str;
        }
    }

    public static void ms(Context context, com.bytedance.sdk.openadsdk.core.dislike.ui.ms msVar, lm lmVar) {
        xr xrVarJy;
        if (msVar == null || lmVar == null || (xrVarJy = re.xr().jy()) == null || !xrVarJy.xr() || TextUtils.isEmpty(xrVarJy.ah())) {
            return;
        }
        msVar.ms(new ah(lmVar, context, xrVarJy));
    }
}
