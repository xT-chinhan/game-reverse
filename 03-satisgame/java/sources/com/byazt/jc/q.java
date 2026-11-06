package com.byazt.jc;

import android.text.TextUtils;
import com.byazt.ep.fs;
import com.byazt.gct.nf;
import com.byazt.gct.pk;
import com.byazt.gct.y;
import com.byazt.nf.rv;
import com.byazt.qk.oa;
import com.byazt.qk.x;
import com.byazt.tk.k;
import com.byazt.vgx.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1447, 5})
public class q {

    public interface n {
        void n(int i, String str);

        void n(JSONObject jSONObject);
    }

    public interface qg {
        void n();

        void n(JSONObject jSONObject);
    }

    public static void n(com.byazt.ai.n nVar, qg qgVar) {
        if (nVar != null) {
            n(nVar.s(), nVar.n(), nVar.qg(), qgVar);
        } else if (qgVar != null) {
            qgVar.n();
        }
    }

    public static void n(String str, final String str2, final String str3, final qg qgVar) {
        if (!TextUtils.isEmpty(str)) {
            com.byazt.phf.s.qg(str).n(new x() { // from class: com.byazt.jc.q.1
                @Override // com.byazt.qk.x
                public void n(oa oaVar) {
                    if (oaVar == null) {
                        return;
                    }
                    if (oaVar.x()) {
                        String strFs = oaVar.fs();
                        fs.n().n(str2, str3, strFs);
                        if (qgVar != null) {
                            try {
                                qgVar.n(new JSONObject(strFs));
                                return;
                            } catch (JSONException unused) {
                                qgVar.n();
                                return;
                            }
                        }
                        return;
                    }
                    qg qgVar2 = qgVar;
                    if (qgVar2 != null) {
                        qgVar2.n();
                    }
                }

                @Override // com.byazt.qk.x
                public void n(int i, String str4, Throwable th) {
                    qg qgVar2 = qgVar;
                    if (qgVar2 != null) {
                        qgVar2.n();
                    }
                }
            });
        } else if (qgVar != null) {
            qgVar.n();
        }
    }

    public static void n(pk pkVar, JSONObject jSONObject, final com.byazt.uv.q qVar, com.byazt.zq.qg qgVar) {
        if (qVar == null) {
            return;
        }
        if (pkVar != null) {
            try {
                if (!TextUtils.isEmpty(pkVar.F_())) {
                    int iD = w.d(pkVar);
                    com.byazt.zq.qg qgVarXd = pkVar.xd();
                    if (qgVarXd != null) {
                        qgVar = qgVarXd;
                    }
                    y yVar = new y();
                    yVar.l = 2;
                    if (nf.x(pkVar) != null) {
                        yVar.x = 2;
                    }
                    JSONObject jSONObjectVh = pkVar.vh();
                    JSONObject jSONObject2 = new JSONObject();
                    if (jSONObjectVh != null) {
                        try {
                            Iterator<String> itKeys = jSONObjectVh.keys();
                            while (itKeys.hasNext()) {
                                String next = itKeys.next();
                                jSONObject2.put(next, jSONObjectVh.opt(next));
                            }
                        } catch (JSONException unused) {
                        }
                    }
                    if (jSONObject != null) {
                        Iterator<String> itKeys2 = jSONObject.keys();
                        while (itKeys2.hasNext()) {
                            String next2 = itKeys2.next();
                            jSONObject2.put(next2, jSONObject.opt(next2));
                        }
                    }
                    yVar.oa = jSONObject2;
                    rv.n().n(qgVar, yVar, iD, new com.byazt.mw.n.qg() { // from class: com.byazt.jc.q.2
                        @Override // com.byazt.mw.n.qg
                        public void n(int i, String str, com.byazt.gct.qg qgVar2) {
                            qVar.n(false, null, false);
                            qgVar2.n(i);
                            com.byazt.gct.qg.n(qgVar2);
                        }

                        @Override // com.byazt.mw.n.qg
                        public void n(com.byazt.gct.n nVar, com.byazt.gct.qg qgVar2) {
                            if (nVar.qg() != null && !nVar.qg().isEmpty()) {
                                qVar.n(true, nVar.qg(), false);
                                return;
                            }
                            qVar.n(false, null, false);
                            qgVar2.n(-3);
                            com.byazt.gct.qg.n(qgVar2);
                        }
                    });
                    return;
                }
            } catch (Exception e) {
                k.n("PageNetUtils", "get ads error", e);
                return;
            }
        }
        qVar.n(false, null, false);
    }

    public static void n(String str, final n nVar) {
        com.byazt.phf.s.qg(str).n(new x() { // from class: com.byazt.jc.q.3
            @Override // com.byazt.qk.x
            public void n(oa oaVar) {
                if (oaVar != null && oaVar.x()) {
                    try {
                        JSONObject jSONObject = new JSONObject(oaVar.fs());
                        n nVar2 = nVar;
                        if (nVar2 != null) {
                            nVar2.n(jSONObject);
                            return;
                        }
                        return;
                    } catch (JSONException unused) {
                        return;
                    }
                }
                n nVar3 = nVar;
                if (nVar3 == null || oaVar == null) {
                    return;
                }
                nVar3.n(oaVar.n(), oaVar.qg());
            }

            @Override // com.byazt.qk.x
            public void n(int i, String str2, Throwable th) {
                n nVar2 = nVar;
                if (nVar2 != null) {
                    nVar2.n(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, th.getMessage());
                }
            }
        });
    }
}
