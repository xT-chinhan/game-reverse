package com.byazt.soz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.byazt.gct.pk;
import com.byazt.gct.wv;
import com.byazt.llp.d;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.tk.h;
import com.byazt.tk.k;
import com.byazt.wr.w;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_STREAM_INFO, 18})
public class l {
    public static volatile boolean x = false;
    public final d fs;
    public boolean l;
    public Toast n;
    public String q;
    public final Context qg;
    public final boolean rv;
    public int s;
    public Map<String, Object> tj;
    public wv w;

    public interface n {
        void n();

        void n(com.byazt.wr.n nVar);
    }

    public static boolean n() {
        return x;
    }

    public static void n(boolean z) {
        x = z;
    }

    public l(d dVar, Context context, boolean z) {
        this.fs = dVar;
        this.qg = context;
        this.rv = z;
    }

    public l n(String str) {
        this.q = str;
        return this;
    }

    public l n(int i) {
        this.s = i;
        return this;
    }

    public l qg(boolean z) {
        this.l = z;
        return this;
    }

    public l n(Map<String, Object> map) {
        this.tj = map;
        return this;
    }

    public boolean n(n nVar) {
        if (this.w == null) {
            d dVar = this.fs;
            this.w = dVar != null ? dVar.J_() : null;
        }
        if (this.w == null) {
            return false;
        }
        if (this.rv) {
            d dVar2 = this.fs;
            if (dVar2 instanceof com.byazt.llp.q) {
                return n(((com.byazt.llp.q) dVar2).tj(), nVar);
            }
        }
        return qg(nVar);
    }

    private boolean qg(n nVar) {
        int iS;
        int iQg = this.w.qg();
        if (iQg != 1) {
            if (iQg != 2 || (iS = s()) == 0) {
                return false;
            }
            if (iS == 1) {
                n(nVar, this.w);
                return true;
            }
            if (TextUtils.isEmpty(this.w.n())) {
                return false;
            }
            n(nVar, this.w, 2000L);
            return true;
        }
        if (this.l) {
            if (TextUtils.isEmpty(this.w.fs())) {
                return true;
            }
            if (s() == 1) {
                n(nVar, this.w);
                return true;
            }
        }
        return false;
    }

    private boolean n(int i, n nVar) {
        if (i == 1) {
            n(nVar, this.w);
            return true;
        }
        if (i == 2) {
            if (TextUtils.isEmpty(this.w.n())) {
                return false;
            }
            n(nVar, this.w, 2000L);
            return true;
        }
        if (i != 3 || !this.l) {
            return false;
        }
        n(nVar, this.w);
        return true;
    }

    private int s() {
        wv wvVar = this.w;
        if (wvVar == null) {
            return 0;
        }
        if (wvVar.w() == 1 && q.s().n()) {
            return TextUtils.isEmpty(this.w.x()) ? 0 : 1;
        }
        return 2;
    }

    private void n(final n nVar, wv wvVar) {
        q();
        d dVar = this.fs;
        if ((dVar instanceof com.byazt.llp.q) && !TextUtils.isEmpty(((com.byazt.llp.q) dVar).x()) && !TextUtils.isEmpty(((com.byazt.llp.q) this.fs).rv())) {
            q qVarS = q.s();
            d dVar2 = this.fs;
            qVarS.n(dVar2, ((com.byazt.llp.q) dVar2).rv(), ((com.byazt.llp.q) this.fs).x(), nVar, this.q, this.l, this.tj);
        } else {
            rv.n().n(wvVar, this.fs.fs(), this.fs.F_(), new qg(nVar, wvVar, this.n) { // from class: com.byazt.soz.l.1
                @Override // com.byazt.soz.l.qg, com.byazt.mw.n.s
                public void n(JSONObject jSONObject) {
                    String strOptString = jSONObject.optString("userName");
                    String strOptString2 = jSONObject.optString("path");
                    if (!TextUtils.isEmpty(strOptString)) {
                        if (l.this.n != null) {
                            l.this.n.cancel();
                        }
                        q.s().n(l.this.fs, strOptString, strOptString2, nVar, l.this.q, l.this.l, l.this.tj);
                        return;
                    }
                    n(MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, " userName or path is null!");
                }

                @Override // com.byazt.soz.l.qg, com.byazt.mw.n.s
                public void n(int i, String str) {
                    w wVar;
                    l.this.w.qg(0);
                    if (l.this.n != null) {
                        l.this.n.cancel();
                    }
                    if (i == 606) {
                        wVar = w.tj;
                    } else {
                        wVar = w.rv;
                    }
                    n nVar2 = nVar;
                    if (nVar2 != null) {
                        nVar2.n(wVar);
                    }
                }
            }, 1, 2000L);
        }
    }

    private void n(n nVar, wv wvVar, long j) {
        q();
        rv.n().n(wvVar, this.fs.fs(), this.fs.F_(), new qg(nVar, wvVar, this.n), 2, j);
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_STREAM_INFO, 120})
    class qg implements com.byazt.mw.n.s<JSONObject> {
        public final n n;
        public final Toast q;
        public final wv qg;

        public qg(n nVar, wv wvVar, Toast toast) {
            this.n = nVar;
            this.qg = wvVar;
            this.q = toast;
        }

        @Override // com.byazt.mw.n.s
        public void n(int i, String str) {
            w wVar;
            this.qg.qg(0);
            Toast toast = this.q;
            if (toast != null) {
                toast.cancel();
            }
            if (i == 606) {
                wVar = w.w;
            } else {
                wVar = w.l;
            }
            n nVar = this.n;
            if (nVar != null) {
                nVar.n(wVar);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.byazt.mw.n.s
        public void n(JSONObject jSONObject) {
            String strOptString = jSONObject.optString("scheme");
            if (!TextUtils.isEmpty(strOptString)) {
                l.this.n(strOptString, this.qg, this.n);
            } else {
                n(MediaPlayer.MEDIA_PLAYER_OPTION_MAX_AV_POS_GAP, " scheme is null!");
            }
        }
    }

    private void q() {
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.soz.l.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (l.this.n != null) {
                        l.this.n.cancel();
                    }
                    l lVar = l.this;
                    lVar.n = h.n(lVar.qg, "即将跳转微信...", 1, 17, 0, 0);
                    l.this.n.show();
                } catch (Throwable th) {
                    k.n("toast error:" + th.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, final wv wvVar, final n nVar) {
        Toast toast = this.n;
        if (toast != null) {
            toast.cancel();
        }
        Uri uri = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        final String strN = com.byazt.qq.qg.qg(qg()) ? this.q : com.byazt.vgx.w.n(this.s);
        HashMap map = new HashMap();
        map.put("source", "WechatClickProcesser");
        map.put("scheme", com.byazt.vgx.w.n(str));
        com.byazt.hm.n.n(qg(), strN, (Map<String, Object>) map, false);
        com.byazt.tk.n.n(this.qg, intent, new com.byazt.tk.n.InterfaceC0352n() { // from class: com.byazt.soz.l.3
            @Override // com.byazt.tk.n.InterfaceC0352n
            public void n() {
                wvVar.qg(1);
                com.byazt.hm.n.n(l.this.qg(), strN, (Throwable) null, false, true);
                com.byazt.hm.l.n().n(l.this.qg(), strN, false, false, new com.byazt.okk.qg.n() { // from class: com.byazt.soz.l.3.1
                    @Override // com.byazt.okk.qg.n
                    public void n(String str2) {
                    }

                    @Override // com.byazt.okk.qg.n
                    public void n(long j) {
                        if (nVar != null) {
                            nVar.n(w.fs);
                        }
                    }

                    @Override // com.byazt.okk.qg.n
                    public void n(boolean z) {
                        if (nVar != null) {
                            nVar.n();
                        }
                    }
                });
            }

            @Override // com.byazt.tk.n.InterfaceC0352n
            public void n(Throwable th) {
                com.byazt.hm.n.n(l.this.qg(), strN, th, false, false);
                wvVar.qg(0);
                n nVar2 = nVar;
                if (nVar2 != null) {
                    nVar2.n(w.x);
                }
            }
        }, TextUtils.equals(tj.rv, "internal"));
    }

    public pk qg() {
        return com.byazt.ukb.qg.n(this.fs, this.tj);
    }
}
