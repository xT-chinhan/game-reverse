package com.byazt.cf;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 93, 21})
public class x implements py.n {
    public final boolean fs;
    public final fs n;
    public final um qg;
    public final boolean rv;
    public final com.byazt.cf.n tj;
    public final oa x;
    public final Map<String, qg> s = new HashMap();
    public final Map<String, q.qg> q = new HashMap();
    public final List<k> l = new ArrayList();
    public final Set<q> w = new HashSet();

    public x(tj tjVar, com.byazt.cf.n nVar, a aVar) {
        this.tj = nVar;
        this.n = tjVar.q;
        um umVar = new um(aVar, tjVar.d, tjVar.oa);
        this.qg = umVar;
        umVar.n(this);
        umVar.n(tjVar.cy);
        this.x = tjVar.rv;
        this.fs = tjVar.fs;
        this.rv = tjVar.k;
    }

    public n n(k kVar, w wVar) throws Exception {
        qg qgVar = this.s.get(kVar.q);
        if (qgVar != null) {
            try {
                ou ouVarQg = qg(wVar.qg, qgVar);
                wVar.q = ouVarQg;
                if (ouVarQg == null) {
                    throw new hd(-1);
                }
                if (qgVar instanceof l) {
                    return n(kVar, (l) qgVar, wVar);
                }
                if (qgVar instanceof s) {
                    return n(kVar, (s) qgVar, ouVarQg);
                }
            } catch (a.n e) {
                rv.n("No remote permission config fetched, call pending: ".concat(String.valueOf(kVar)), e);
                this.l.add(kVar);
                return new n(false, wm.n());
            }
        }
        q.qg qgVar2 = this.q.get(kVar.q);
        if (qgVar2 == null) {
            return null;
        }
        q qVarN = qgVar2.n();
        qVarN.n(kVar.q);
        ou ouVarQg2 = qg(wVar.qg, qVarN);
        wVar.q = ouVarQg2;
        if (ouVarQg2 == null) {
            qVarN.l();
            throw new hd(-1);
        }
        return n(kVar, qVarN, wVar);
    }

    public void n(String str, l<?, ?> lVar) {
        lVar.n(str);
        this.s.put(str, lVar);
    }

    public void n(String str, q.qg qgVar) {
        this.q.put(str, qgVar);
    }

    public boolean n(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.s.containsKey(str)) {
            return true;
        }
        return this.q.containsKey(str);
    }

    public void n() {
        Iterator<q> it = this.w.iterator();
        while (it.hasNext()) {
            it.next().w();
        }
        this.w.clear();
        this.s.clear();
        this.q.clear();
        this.qg.qg(this);
    }

    private n n(k kVar, l lVar, w wVar) throws Exception {
        return new n(true, wm.n(this.n.n(lVar.n(n(kVar.l, (qg) lVar), wVar))));
    }

    private n n(final k kVar, final q qVar, w wVar) throws Exception {
        this.w.add(qVar);
        qVar.n(n(kVar.l, qVar), wVar, new q.n() { // from class: com.byazt.cf.x.1
            @Override // com.byazt.cf.q.n
            public void n(Object obj) {
                if (x.this.tj == null) {
                    return;
                }
                x.this.tj.qg(wm.n(x.this.n.n(obj)), kVar);
                x.this.w.remove(qVar);
            }

            @Override // com.byazt.cf.q.n
            public void n(Throwable th) {
                if (x.this.tj == null) {
                    return;
                }
                x.this.tj.qg(wm.n(th), kVar);
                x.this.w.remove(qVar);
            }
        });
        return new n(false, wm.n());
    }

    private n n(final k kVar, s sVar, ou ouVar) throws Exception {
        new cd(kVar.q, ouVar, new cd.n() { // from class: com.byazt.cf.x.2
        });
        return new n(false, wm.n());
    }

    private Object n(String str, qg qgVar) throws JSONException {
        return this.n.n(str, n(qgVar)[0]);
    }

    private ou qg(String str, qg qgVar) {
        if (this.rv) {
            return ou.PRIVATE;
        }
        return this.qg.n(this.fs, str, qgVar);
    }

    private static Type[] n(Object obj) {
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        if (genericSuperclass == null) {
            throw new IllegalStateException("Method is not parameterized?!");
        }
        return ((ParameterizedType) genericSuperclass).getActualTypeArguments();
    }

    @com.byazt.cp.n(n = {0, 1, 93, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_MTU})
    static final class n {
        public boolean n;
        public String qg;

        private n(boolean z, String str) {
            this.n = z;
            this.qg = str;
        }
    }
}
