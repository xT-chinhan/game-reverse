package com.byazt.pw;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Pair;
import com.byazt.ca.b;
import com.byazt.hg.i;
import com.byazt.hg.of;
import com.byazt.mg.PluginConstants;
import com.byazt.mr.uc;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import com.byazt.sd.rc;
import com.byazt.xlm.fw;
import com.byazt.zp.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.an;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 420, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements com.byazt.vg.pr {
    public boolean c;
    public final x hn;
    public final WeakReference<Context> hw;
    public final of pr;
    public String x;

    public c(of ofVar, Context context, x xVar, boolean z) {
        this.pr = ofVar;
        this.hw = new WeakReference<>(context);
        this.hn = xVar;
        this.c = z;
    }

    @Override // com.byazt.vg.pr
    public boolean pr(String str, Dialog dialog) {
        if (TextUtils.isEmpty(str) || this.hw.get() == null || !str.startsWith("#oncall#")) {
            return false;
        }
        return pr(this.hw.get(), str, dialog);
    }

    @Override // com.byazt.vg.pr
    public boolean pr(uc ucVar, String str, Dialog dialog) {
        com.byazt.dw.hn hnVarPr = x.pr();
        if (hnVarPr != null && TextUtils.equals(ucVar.pr(), hnVarPr.pr()) && TextUtils.equals(ucVar.hw(), hnVarPr.hw())) {
            ucVar.hw();
            ucVar.pr();
            if (this.c) {
                if (this.x == null) {
                    String string = UUID.randomUUID().toString();
                    this.x = string;
                    pr(string, str);
                    pr(this.x);
                    return true;
                }
                return true;
            }
            return pr(this.hw.get(), str, dialog);
        }
        return false;
    }

    private void pr(String str) {
        try {
            Context context = this.hw.get();
            if (context == null) {
                return;
            }
            ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, str));
        } catch (Throwable th) {
        }
    }

    public boolean pr(Context context, final String str, Dialog dialog) {
        try {
            if (this.x == null) {
                this.x = UUID.randomUUID().toString();
            }
            if (dialog != null) {
                dialog.dismiss();
            }
            new AlertDialog.Builder(context).setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.byazt.pw.c.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    c cVar = c.this;
                    cVar.pr(cVar.x, str);
                }
            }).setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.byazt.pw.c.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).setMessage(this.hn.x() + "\n\n您此次反馈的id为：" + this.x).setCancelable(true).create().show();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(final String str) {
        zo.pr(new Runnable() { // from class: com.byazt.pw.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.hw.get() != null) {
                    b.pr((Context) c.this.hw.get(), str, 1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final String str, final String str2) {
        hw("反馈上传中，请您稍等！");
        com.byazt.xlm.c.hw(new fw("upload_oncall") { // from class: com.byazt.pw.c.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    c.this.hw(str, str2);
                } catch (Throwable th) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(String str, String str2) throws Throwable {
        HashMap map;
        File file = new File(com.byazt.ca.uc.hw(a.getContext(), false, null), str);
        file.mkdirs();
        rc rcVar = (rc) a.pr();
        com.byazt.qe.hw hwVarP = this.pr.p();
        JSONObject jSONObjectPr = rcVar.pr(hwVarP, new i(), hwVarP.a(), false, 6, false);
        if (jSONObjectPr == null) {
            return;
        }
        com.byazt.zp.c.pr(com.byazt.mp.uc.pr().hw(jSONObjectPr.toString()).x().toString(), new File(file, "request.info"));
        JSONObject jSONObjectUc = com.byazt.is.zo.pr((com.byazt.is.c) null).uc();
        com.byazt.zp.c.pr(com.byazt.wt.rc.pr(jSONObjectUc == null ? null : jSONObjectUc.toString()).toString(), new File(file, "setting.info"));
        JSONObject jSONObject = this.pr.to();
        com.byazt.zp.c.pr(com.byazt.wt.rc.pr(jSONObject == null ? null : jSONObject.toString()).toString(), new File(file, "meta.info"));
        File filePr = com.byazt.zp.c.pr(file, str + ".zip");
        String strHn = hn(str2, str);
        HashMap map2 = new HashMap();
        Pair<Integer, JSONObject> pairPr = com.byazt.mp.uc.pr().pr(strHn, false);
        if (pairPr == null) {
            map = null;
        } else {
            HashMap map3 = new HashMap();
            map2.put("deviceInfo", ((JSONObject) pairPr.second).optString("message"));
            map3.put("x-pglcypher", String.valueOf(pairPr.first));
            map = map3;
        }
        new com.byazt.vl.pr().pr(this.hn.hn(), filePr, map2, new com.byazt.vl.pr.InterfaceC0216pr() { // from class: com.byazt.pw.c.5
            @Override // com.byazt.vl.pr.InterfaceC0216pr
            public void pr(String str3) {
                c cVar = c.this;
                cVar.hw(cVar.c ? "已复制广告ID\r\n请前往应用内上报问题" : "反馈上传成功！");
            }

            @Override // com.byazt.vl.pr.InterfaceC0216pr
            public void pr(int i, String str3) {
                c cVar = c.this;
                cVar.hw(cVar.c ? "反馈失败\r\n 请重新复制" : "反馈失败");
            }
        }, map);
        filePr.delete();
        com.byazt.zp.c.hw(file);
    }

    private String hn(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, com.byazt.sd.zo.nt().fo());
            jSONObject.putOpt(PluginConstants.KEY_APP_ID, com.byazt.sd.zo.nt().ny());
            jSONObject.putOpt("os_api", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt(an.y, Build.VERSION.RELEASE);
            jSONObject.putOpt("manufacturer", Build.MANUFACTURER);
            jSONObject.putOpt("did", com.byazt.sd.uc.pr().hw());
            jSONObject.putOpt("sdk_version", 7714);
            jSONObject.putOpt("sdk_api_version", Integer.valueOf(iu.x));
            jSONObject.putOpt("live_sdk_version", com.byazt.eg.hw.pr().fw());
            jSONObject.putOpt(NotificationCompat.CATEGORY_MESSAGE, str);
            jSONObject.putOpt("recordId", str2);
            jSONObject.putOpt("os", "Android");
            jSONObject.putOpt("ad_info", this.pr.td());
            com.byazt.qe.hw hwVarP = this.pr.p();
            if (hwVarP != null) {
                jSONObject.putOpt("ad_slot_type", Integer.valueOf(hwVarP.a()));
                jSONObject.putOpt("rit", hwVarP.qa());
            }
            return jSONObject.toString();
        } catch (Exception e) {
            return str;
        }
    }

    public static void pr(Context context, com.byazt.pfl.hw hwVar, of ofVar) {
        if (hwVar == null || ofVar == null) {
            return;
        }
        boolean zGp = a.hw().gp();
        x xVarSx = a.hw().sx();
        if (xVarSx == null || TextUtils.isEmpty(xVarSx.hn())) {
            return;
        }
        if (xVarSx.hw() || zGp) {
            hwVar.pr(new c(ofVar, context, xVarSx, zGp));
        }
    }
}
