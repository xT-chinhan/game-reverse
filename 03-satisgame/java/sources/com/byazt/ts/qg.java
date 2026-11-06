package com.byazt.ts;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.byazt.gwu.s;
import com.byazt.qk.oa;
import com.byazt.qk.x;
import com.byazt.qp.q;
import com.byazt.si.cy;
import com.byazt.si.m;
import com.byazt.si.ou;
import com.byazt.vf.ae;
import com.byazt.vf.cp;
import com.byazt.vf.wo;
import com.byazt.yl.l;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1844, 26})
public class qg {
    public static final String n = "tt_derive" + File.separator + "lottie" + File.separator + MediaFormat.KEY_AUDIO;
    public static final String qg = "tt_derive" + File.separator + "lottie" + File.separator + "anim_img";
    public static final String s = "tt_derive" + File.separator + "lottie" + File.separator + "json";
    public static final Set<String> w = new HashSet();
    public static volatile qg x;
    public volatile com.byazt.yl.qg l;
    public final s q = ((ae) q.n("storage_service")).qg(q.qg(com.byazt.gkj.n.n().s().q()), "lottie_tpl_info", 1, com.byazt.p001if.n.n());

    public interface n<T> {
        void n(int i, String str);

        void n(T t);
    }

    private qg() {
    }

    private com.byazt.yl.qg s() {
        final Context context = com.byazt.gkj.n.n().s().getContext();
        l lVar = (l) q.n("file_store");
        if (lVar == null) {
            return null;
        }
        return lVar.n(new com.byazt.yl.s() { // from class: com.byazt.ts.qg.1
            @Override // com.byazt.yl.s
            public long qg() {
                return 52428800L;
            }

            @Override // com.byazt.yl.s
            public File n() {
                return qg.this.qg(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.yl.qg q() {
        if (this.l == null) {
            synchronized (this) {
                if (this.l == null) {
                    this.l = s();
                }
            }
        }
        return this.l;
    }

    private boolean l() {
        JSONObject jSONObjectK;
        cp cpVar = (cp) q.n("csj_settings", q.qg(null));
        return (cpVar == null || (jSONObjectK = cpVar.k()) == null || jSONObjectK.optInt("uttie_json_cache_back_to_sp", 0) != 1) ? false : true;
    }

    public static qg n() {
        if (x == null) {
            synchronized (qg.class) {
                if (x == null) {
                    x = new qg();
                }
            }
        }
        return x;
    }

    public boolean n(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(str, "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/easy_show/easy_client_20260723140601/easy_client_20260723140601.json") || TextUtils.equals(str, "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/easy_show/easy_client_20260723140715/easy_client_20260723140715.json") || TextUtils.equals(str, "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/easy_show/easy_client_20260723140150/easy_client_20260723140150.json") || TextUtils.equals(str, "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/easy_show/easy_client_20260723140428/easy_client_20260723140428.json");
    }

    public void n(Context context, com.byazt.ts.n nVar) {
        if (nVar != null) {
            String strS = nVar.s();
            if (!TextUtils.isEmpty(strS)) {
                qg(strS, null);
            }
            String strN = nVar.n();
            if (TextUtils.isEmpty(strN) || !TextUtils.isEmpty(qg(strN))) {
                return;
            }
            n(strN, (n<String>) null);
        }
    }

    public void n(final String str, final n<String> nVar) {
        com.byazt.phf.s.qg(str).n(new x() { // from class: com.byazt.ts.qg.2
            @Override // com.byazt.qk.x
            public void n(oa oaVar) {
                if (oaVar != null) {
                    try {
                        if (oaVar.x()) {
                            String strFs = oaVar.fs();
                            JSONObject jSONObjectL = oaVar.l();
                            if (jSONObjectL != null) {
                                jSONObjectL.optString("v");
                                qg.this.n(str, strFs);
                                n nVar2 = nVar;
                                if (nVar2 != null) {
                                    nVar2.n(strFs);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        n nVar3 = nVar;
                        if (nVar3 != null) {
                            nVar3.n(10001, "lottieJsonUrl加载失败2, " + th.getMessage());
                            return;
                        }
                        return;
                    }
                }
                n nVar4 = nVar;
                if (nVar4 != null) {
                    boolean z = true;
                    StringBuilder sbAppend = new StringBuilder("lottieJsonUrl加载失败1, response is not null:").append(oaVar != null).append(", isSuccess:");
                    if (oaVar == null || !oaVar.x()) {
                        z = false;
                    }
                    nVar4.n(10001, sbAppend.append(z).toString());
                }
            }

            @Override // com.byazt.qk.x
            public void n(int i, String str2, Throwable th) {
                n nVar2 = nVar;
                if (nVar2 != null) {
                    nVar2.n(10001, "lottieJsonUrl加载失败3, " + th.getMessage());
                }
            }
        });
    }

    public void n(Context context, String str, final n<Bitmap> nVar) {
        ou ouVarL = com.byazt.gkj.n.n().l();
        if (ouVarL != null) {
            ouVarL.n(str).s(n(context)).n(Bitmap.Config.ARGB_4444).s(2).n(new m<Bitmap>() { // from class: com.byazt.ts.qg.3
                @Override // com.byazt.si.m
                public void n(cy<Bitmap> cyVar) {
                    n nVar2;
                    try {
                        Bitmap bitmapS = cyVar.s();
                        if (bitmapS == null || (nVar2 = nVar) == null) {
                            return;
                        }
                        nVar2.n(bitmapS);
                    } catch (Throwable unused) {
                    }
                }

                @Override // com.byazt.si.m
                public void n(int i, String str2, Throwable th) {
                    n nVar2 = nVar;
                    if (nVar2 != null) {
                        nVar2.n(i, "load lottie pic fail: ".concat(String.valueOf(str2)));
                    }
                }
            }, 4);
        } else if (nVar != null) {
            nVar.n(-1, "imageCenter is null");
        }
    }

    public void qg(String str, final n<Bitmap> nVar) {
        ou ouVarL = com.byazt.gkj.n.n().l();
        if (ouVarL != null) {
            ouVarL.n(str).n(Bitmap.Config.ARGB_4444).s(2).n(new m<Bitmap>() { // from class: com.byazt.ts.qg.4
                @Override // com.byazt.si.m
                public void n(cy<Bitmap> cyVar) {
                    n nVar2;
                    try {
                        Bitmap bitmapS = cyVar.s();
                        if (bitmapS == null || (nVar2 = nVar) == null) {
                            return;
                        }
                        nVar2.n(bitmapS);
                    } catch (Throwable unused) {
                    }
                }

                @Override // com.byazt.si.m
                public void n(int i, String str2, Throwable th) {
                    n nVar2 = nVar;
                    if (nVar2 != null) {
                        nVar2.n(i, "load ad pic fail: ".concat(String.valueOf(str2)));
                    }
                }
            }, 4);
        } else if (nVar != null) {
            nVar.n(-1, "imageCenter is null");
        }
    }

    public String qg(String str) {
        String strQg = com.byazt.tk.l.qg(str);
        if (TextUtils.isEmpty(strQg)) {
            return null;
        }
        if (l()) {
            String strQg2 = this.q.qg(strQg, "");
            if (TextUtils.isEmpty(strQg2)) {
                return null;
            }
            return strQg2;
        }
        com.byazt.yl.qg qgVarQ = q();
        if (qgVarQ != null) {
            String strQg3 = qgVarQ.qg(strQg);
            if (!TextUtils.isEmpty(strQg3)) {
                if (!w.contains(strQg)) {
                    n(str, strQg, strQg3);
                }
                return strQg3;
            }
            return n(strQg, qgVarQ);
        }
        String strQg4 = this.q.qg(strQg, "");
        if (TextUtils.isEmpty(strQg4)) {
            return null;
        }
        return strQg4;
    }

    private void n(final String str, final String str2, final String str3) {
        wo woVar = (wo) q.n("thread_service");
        if (woVar == null || woVar.qg() == null) {
            return;
        }
        woVar.qg().execute(new Runnable() { // from class: com.byazt.ts.qg.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    new JSONObject(str3);
                    qg.w.add(str2);
                } catch (OutOfMemoryError unused) {
                } catch (JSONException e) {
                    com.byazt.yl.qg qgVarQ = qg.this.q();
                    if (qgVarQ != null) {
                        qgVarQ.l(str2);
                    }
                    qg.this.n(str, e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, final JSONException jSONException) {
        com.byazt.sf.s sVar = (com.byazt.sf.s) q.n("ad_log", q.qg(null));
        if (sVar == null) {
            return;
        }
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(ImagesContract.URL, str);
        } catch (JSONException unused) {
        }
        sVar.n("exception", (byte) 1, new com.byazt.rs.n() { // from class: com.byazt.ts.qg.6
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.putOpt("scene", "uttie_json_file_cache_invalid");
                jSONObject3.putOpt("object", jSONObject);
                jSONObject3.putOpt("exception", Log.getStackTraceString(jSONException));
                return jSONObject3;
            }
        });
    }

    private String n(String str, com.byazt.yl.qg qgVar) {
        String strQg = this.q.qg(str, "");
        if (TextUtils.isEmpty(strQg)) {
            return null;
        }
        if (qgVar != null && qgVar.n(str, strQg)) {
            this.q.n(str);
        }
        return strQg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, String str2) {
        String strQg = com.byazt.tk.l.qg(str);
        if (TextUtils.isEmpty(strQg)) {
            return;
        }
        if (l()) {
            this.q.n(strQg, str2);
            return;
        }
        com.byazt.yl.qg qgVarQ = q();
        if (qgVarQ == null) {
            this.q.n(strQg, str2);
        } else {
            if (qgVarQ.n(strQg, str2)) {
                return;
            }
            this.q.n(strQg, str2);
        }
    }

    public String n(Context context) {
        return com.byazt.tk.x.n(context, com.byazt.gkj.n.n().s().tj(), qg).getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File qg(Context context) {
        return com.byazt.tk.x.qg(context, com.byazt.gkj.n.n().s().tj(), s);
    }
}
