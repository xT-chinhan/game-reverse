package com.byazt.dqk;

import android.text.TextUtils;
import com.byazt.jv.a;
import com.byazt.jv.b;
import com.byazt.jv.cz;
import com.byazt.jv.fo;
import com.byazt.jv.gz;
import com.byazt.jv.iu;
import com.byazt.jv.ny;
import com.byazt.nzn.g;
import com.byazt.nzn.ho;
import com.byazt.nzn.k;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1320, 5})
public class uc extends k {
    public fo k;
    public com.byazt.nzn.x m;

    public uc(k.pr prVar) {
        super(prVar);
        pr(prVar);
        this.m = new fw(this.k);
    }

    private void pr(k.pr prVar) {
        fo.pr prVar2 = new fo.pr();
        prVar2.rc = (int) prVar.hn;
        prVar2.nl = prVar.x;
        prVar2.z = (int) prVar.c;
        prVar2.y = prVar.uc;
        prVar2.b = (int) prVar.fw;
        prVar2.ww = prVar.zo;
        prVar2.gz = prVar.vk;
        prVar2.ve = prVar.w;
        prVar2.pr(new hn(prVar.hw));
        List<com.byazt.nzn.aj> list = prVar.pr;
        if (list != null && !list.isEmpty()) {
            for (final com.byazt.nzn.aj ajVar : list) {
                prVar2.pr(new a() { // from class: com.byazt.dqk.uc.1
                    @Override // com.byazt.jv.a
                    public gz pr(a.pr prVar3) throws IOException {
                        return ((aj) ajVar.pr(new c(prVar3))).pr;
                    }
                });
            }
        }
        this.k = prVar2.pr();
    }

    @Override // com.byazt.nzn.k
    public com.byazt.nzn.x pr() {
        return this.m;
    }

    @Override // com.byazt.nzn.k
    public com.byazt.nzn.hw pr(g gVar) {
        if (gVar == null) {
            return null;
        }
        b.pr prVar = new b.pr();
        prVar.pr(gVar.pr());
        if (gVar.hw() != null) {
            prVar.pr(gVar.hw().toString());
        }
        if (gVar.uc() != null) {
            if (hn(gVar.uc())) {
                prVar.pr(gVar.hn(), iu.pr(cz.pr(gVar.uc().hn.toString()), gVar.uc().x));
            } else if (pr(gVar.uc())) {
                prVar.pr(gVar.hn(), new ny.pr().pr(ny.c).pr(gVar.uc().hw(), gVar.uc().pr(), iu.pr(cz.pr("multipart/form-data"), gVar.uc().c)).pr());
            } else if (hw(gVar.uc())) {
                prVar.pr(gVar.hn(), iu.pr(cz.pr(gVar.uc().hn.toString()), gVar.uc().c));
            }
        }
        if (gVar.c() != null && gVar.c().pr) {
            prVar.pr(new com.byazt.jv.x.pr().pr().hn());
        }
        if (gVar.x() != null && gVar.x().size() > 0) {
            for (Map.Entry<String, List<String>> entry : gVar.x().entrySet()) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    prVar.pr(entry.getKey(), it.next());
                }
            }
        }
        return new x(this.k.pr(prVar.pr()));
    }

    private boolean pr(ho hoVar) {
        if (hoVar == null || hoVar.uc != ho.pr.FILE_TYPE || hoVar.c == null || hoVar.c.length <= 0) {
            return false;
        }
        return true;
    }

    private boolean hw(ho hoVar) {
        if (hoVar == null || hoVar.uc != ho.pr.BYTE_ARRAY_TYPE || hoVar.c == null || hoVar.c.length <= 0) {
            return false;
        }
        return true;
    }

    private boolean hn(ho hoVar) {
        if (hoVar == null || hoVar.uc != ho.pr.STRING_TYPE || TextUtils.isEmpty(hoVar.x)) {
            return false;
        }
        return true;
    }
}
