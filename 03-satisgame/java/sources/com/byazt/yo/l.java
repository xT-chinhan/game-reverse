package com.byazt.yo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.byazt.fvm.w;
import com.byazt.gct.pk;
import com.byazt.gct.y;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.qit.x;
import com.byazt.tk.h;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 170, 18})
public class l implements com.byazt.ae.n {
    public boolean l;
    public final pk n;
    public String q;
    public final WeakReference<Context> qg;
    public final q s;

    public l(pk pkVar, Context context, q qVar, boolean z) {
        this.n = pkVar;
        this.qg = new WeakReference<>(context);
        this.s = qVar;
        this.l = z;
    }

    @Override // com.byazt.ae.n
    public boolean n(String str, Dialog dialog) {
        if (TextUtils.isEmpty(str) || this.qg.get() == null || !str.startsWith("#oncall#")) {
            return false;
        }
        return n(this.qg.get(), str, dialog);
    }

    @Override // com.byazt.ae.n
    public boolean n(w wVar, String str, Dialog dialog) {
        com.byazt.oj.s sVarN = q.n();
        if (sVarN == null || !TextUtils.equals(wVar.n(), sVarN.n()) || !TextUtils.equals(wVar.qg(), sVarN.qg())) {
            return false;
        }
        wVar.qg();
        wVar.n();
        if (this.l) {
            if (this.q != null) {
                return true;
            }
            String string = UUID.randomUUID().toString();
            this.q = string;
            n(string, str);
            n(this.q);
            return true;
        }
        return n(this.qg.get(), str, dialog);
    }

    private void n(String str) {
        try {
            Context context = this.qg.get();
            if (context == null) {
                return;
            }
            ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, str));
        } catch (Throwable unused) {
        }
    }

    public boolean n(Context context, final String str, Dialog dialog) {
        try {
            if (this.q == null) {
                this.q = UUID.randomUUID().toString();
            }
            if (dialog != null) {
                dialog.dismiss();
            }
            new AlertDialog.Builder(context).setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.byazt.yo.l.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    l lVar = l.this;
                    lVar.n(lVar.q, str);
                }
            }).setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.byazt.yo.l.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).setMessage(this.s.q() + "\n\n您此次反馈的id为：" + this.q).setCancelable(true).create().show();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(final String str) {
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.yo.l.3
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.qg.get() != null) {
                    h.n((Context) l.this.qg.get(), str, 1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final String str, final String str2) {
        qg("反馈上传中，请您稍等！");
        com.byazt.qit.l.qg(new x("upload_oncall") { // from class: com.byazt.yo.l.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    l.this.qg(str, str2);
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(String str, String str2) throws Throwable {
        HashMap map = null;
        File file = new File(com.byazt.tk.w.qg(rv.getContext(), false, null), str);
        file.mkdirs();
        com.byazt.mw.qg qgVar = (com.byazt.mw.qg) rv.n();
        com.byazt.zq.qg qgVarXd = this.n.xd();
        JSONObject jSONObjectN = qgVar.n(qgVarXd, new y(), qgVarXd.a(), false, 6, false);
        if (jSONObjectN == null) {
            return;
        }
        com.byazt.xu.s.n(com.byazt.cl.q.n().qg(jSONObjectN.toString()).q().toString(), new File(file, "request.info"));
        JSONObject jSONObjectL = com.byazt.ivn.q.n((com.byazt.ivn.qg) null).l();
        com.byazt.xu.s.n(com.byazt.cl.s.n(jSONObjectL == null ? null : jSONObjectL.toString()).toString(), new File(file, "setting.info"));
        JSONObject jSONObjectPv = this.n.pv();
        com.byazt.xu.s.n(com.byazt.cl.s.n(jSONObjectPv == null ? null : jSONObjectPv.toString()).toString(), new File(file, "meta.info"));
        File fileN = com.byazt.xu.s.n(file, str + ".zip");
        String strS = s(str2, str);
        HashMap map2 = new HashMap();
        Pair<Integer, JSONObject> pairN = com.byazt.cl.q.n().n(strS, false);
        if (pairN != null) {
            map = new HashMap();
            map2.put("deviceInfo", ((JSONObject) pairN.second).optString("message"));
            map.put("x-pglcypher", String.valueOf(pairN.first));
        }
        new com.byazt.udc.qg().n(this.s.s(), fileN, map2, new com.byazt.udc.qg.n() { // from class: com.byazt.yo.l.5
            @Override // com.byazt.udc.qg.n
            public void n(String str3) {
                l lVar = l.this;
                lVar.qg(lVar.l ? "已复制广告ID\r\n请前往应用内上报问题" : "反馈上传成功！");
            }

            @Override // com.byazt.udc.qg.n
            public void n(int i, String str3) {
                l lVar = l.this;
                lVar.qg(lVar.l ? "反馈失败\r\n 请重新复制" : "反馈失败");
            }
        }, map);
        fileN.delete();
        com.byazt.xu.s.qg(file);
    }

    private String s(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("app_name", com.byazt.vyf.s.cy().wm());
            jSONObject.putOpt("app_id", com.byazt.vyf.s.cy().ou());
            jSONObject.putOpt("os_api", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("os_version", Build.VERSION.RELEASE);
            jSONObject.putOpt("manufacturer", Build.MANUFACTURER);
            jSONObject.putOpt("did", com.byazt.yu.n.n().qg());
            jSONObject.putOpt("sdk_version", 7814);
            jSONObject.putOpt("sdk_api_version", Integer.valueOf(tj.l));
            jSONObject.putOpt("live_sdk_version", com.byazt.wq.qg.n().x());
            jSONObject.putOpt(NotificationCompat.CATEGORY_MESSAGE, str);
            jSONObject.putOpt("recordId", str2);
            jSONObject.putOpt(TapEventParamConstants.PARAM_SUB_OS, "Android");
            jSONObject.putOpt("ad_info", this.n.yk());
            com.byazt.zq.qg qgVarXd = this.n.xd();
            if (qgVarXd != null) {
                jSONObject.putOpt("ad_slot_type", Integer.valueOf(qgVarXd.a()));
                jSONObject.putOpt("rit", qgVarXd.um());
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static void n(Context context, com.byazt.wg.qg qgVar, pk pkVar) {
        if (qgVar == null || pkVar == null) {
            return;
        }
        boolean zHj = rv.qg().hj();
        q qVarLg = rv.qg().lg();
        if (qVarLg == null || TextUtils.isEmpty(qVarLg.s())) {
            return;
        }
        if (qVarLg.qg() || zHj) {
            qgVar.n(new l(pkVar, context, qVarLg, zHj));
        }
    }
}
