package com.byazt.ee;

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
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF, 62})
public class fw implements ny.pr {
    public final boolean aj;
    public final m fw;
    public final a hw;
    public final zo pr;
    public final com.byazt.ee.pr vk;
    public final boolean zo;
    public final Map<String, hw> hn = new HashMap();
    public final Map<String, x.hw> x = new HashMap();
    public final List<nt> c = new ArrayList();
    public final Set<x> uc = new HashSet();

    public fw(vk vkVar, com.byazt.ee.pr prVar, cz czVar) {
        this.vk = prVar;
        this.pr = vkVar.x;
        a aVar = new a(czVar, vkVar.k, vkVar.m);
        this.hw = aVar;
        aVar.pr(this);
        aVar.pr(vkVar.nt);
        this.fw = vkVar.aj;
        this.zo = vkVar.zo;
        this.aj = vkVar.ho;
    }

    public pr pr(nt ntVar, uc ucVar) throws Exception {
        hw hwVar = this.hn.get(ntVar.x);
        if (hwVar != null) {
            try {
                fo foVarHw = hw(ucVar.hw, hwVar);
                ucVar.x = foVarHw;
                if (foVarHw == null) {
                    throw new lb(-1);
                }
                if (hwVar instanceof c) {
                    return pr(ntVar, (c) hwVar, ucVar);
                }
                if (hwVar instanceof hn) {
                    return pr(ntVar, (hn) hwVar, foVarHw);
                }
            } catch (cz.pr e) {
                aj.pr("No remote permission config fetched, call pending: ".concat(String.valueOf(ntVar)), e);
                this.c.add(ntVar);
                return new pr(false, rc.pr());
            }
        }
        x.hw hwVar2 = this.x.get(ntVar.x);
        if (hwVar2 == null) {
            return null;
        }
        x xVarPr = hwVar2.pr();
        xVarPr.pr(ntVar.x);
        fo foVarHw2 = hw(ucVar.hw, xVarPr);
        ucVar.x = foVarHw2;
        if (foVarHw2 == null) {
            xVarPr.c();
            throw new lb(-1);
        }
        return pr(ntVar, xVarPr, ucVar);
    }

    public void pr(String str, c<?, ?> cVar) {
        cVar.pr(str);
        this.hn.put(str, cVar);
    }

    public void pr(String str, x.hw hwVar) {
        this.x.put(str, hwVar);
    }

    public boolean pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.hn.containsKey(str)) {
            return true;
        }
        return this.x.containsKey(str);
    }

    public void pr() {
        Iterator<x> it = this.uc.iterator();
        while (it.hasNext()) {
            it.next().uc();
        }
        this.uc.clear();
        this.hn.clear();
        this.x.clear();
        this.hw.hw(this);
    }

    private pr pr(nt ntVar, c cVar, uc ucVar) throws Exception {
        return new pr(true, rc.pr(this.pr.pr(cVar.pr(pr(ntVar.c, (hw) cVar), ucVar))));
    }

    private pr pr(final nt ntVar, final x xVar, uc ucVar) throws Exception {
        this.uc.add(xVar);
        xVar.pr(pr(ntVar.c, xVar), ucVar, new x.pr() { // from class: com.byazt.ee.fw.1
            @Override // com.byazt.ee.x.pr
            public void pr(Object obj) {
                if (fw.this.vk != null) {
                    fw.this.vk.hw(rc.pr(fw.this.pr.pr(obj)), ntVar);
                    fw.this.uc.remove(xVar);
                }
            }

            @Override // com.byazt.ee.x.pr
            public void pr(Throwable th) {
                if (fw.this.vk != null) {
                    fw.this.vk.hw(rc.pr(th), ntVar);
                    fw.this.uc.remove(xVar);
                }
            }
        });
        return new pr(false, rc.pr());
    }

    private pr pr(final nt ntVar, hn hnVar, fo foVar) throws Exception {
        new qa(ntVar.x, foVar, new qa.pr() { // from class: com.byazt.ee.fw.2
        });
        return new pr(false, rc.pr());
    }

    private Object pr(String str, hw hwVar) throws JSONException {
        return this.pr.pr(str, pr(hwVar)[0]);
    }

    private fo hw(String str, hw hwVar) {
        if (this.aj) {
            return fo.PRIVATE;
        }
        return this.hw.pr(this.zo, str, hwVar);
    }

    private static Type[] pr(Object obj) {
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        if (genericSuperclass == null) {
            throw new IllegalStateException("Method is not parameterized?!");
        }
        return ((ParameterizedType) genericSuperclass).getActualTypeArguments();
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF, 766})
    static final class pr {
        public String hw;
        public boolean pr;

        private pr(boolean z, String str) {
            this.pr = z;
            this.hw = str;
        }
    }
}
