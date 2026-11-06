package com.byazt.sl;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.byazt.ld.lb;
import com.byazt.ld.nl;
import com.byazt.ld.qa;
import com.byazt.ld.s;
import com.byazt.ld.ww;
import com.byazt.ld.y;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 4, 5})
public class uc {
    public nl aj;
    public lb fw;
    public final qa hw;
    public com.byazt.ld.c uc;
    public ExecutorService zo;
    public Map<String, List<hn>> pr = new ConcurrentHashMap();
    public Map<String, y> hn = new HashMap();
    public Map<String, ww> x = new HashMap();
    public Map<String, com.byazt.ld.x> c = new HashMap();

    public uc(qa qaVar, boolean z) {
        this.hw = (qa) zo.pr(qaVar);
        if (z) {
            com.byazt.bbo.pr.pr(qaVar.aj());
        }
    }

    public Collection<y> pr() {
        return this.hn.values();
    }

    public Collection<ww> hw() {
        return this.x.values();
    }

    public Collection<com.byazt.ld.x> hn() {
        return this.c.values();
    }

    public y pr(com.byazt.ld.hw hwVar) {
        if (hwVar == null) {
            hwVar = com.byazt.bbo.pr.aj();
        }
        String string = hwVar.c().toString();
        y yVar = this.hn.get(string);
        if (yVar == null) {
            y yVarX = x(hwVar);
            this.hn.put(string, yVarX);
            return yVarX;
        }
        return yVar;
    }

    private y x(com.byazt.ld.hw hwVar) {
        y yVarC = this.hw.c();
        if (yVarC != null) {
            return com.byazt.aqe.pr.pr(yVarC);
        }
        return com.byazt.aqe.pr.pr(hwVar.hw());
    }

    public ww hw(com.byazt.ld.hw hwVar) {
        if (hwVar == null) {
            hwVar = com.byazt.bbo.pr.aj();
        }
        String string = hwVar.c().toString();
        ww wwVar = this.x.get(string);
        if (wwVar == null) {
            ww wwVarC = c(hwVar);
            this.x.put(string, wwVarC);
            return wwVarC;
        }
        return wwVar;
    }

    private ww c(com.byazt.ld.hw hwVar) {
        ww wwVarUc = this.hw.uc();
        if (wwVarUc != null) {
            return wwVarUc;
        }
        return com.byazt.aqe.c.pr(hwVar.zo());
    }

    public com.byazt.ld.x hn(com.byazt.ld.hw hwVar) {
        if (hwVar == null) {
            hwVar = com.byazt.bbo.pr.aj();
        }
        String string = hwVar.c().toString();
        com.byazt.ld.x xVar = this.c.get(string);
        if (xVar == null) {
            com.byazt.ld.x xVarUc = uc(hwVar);
            this.c.put(string, xVarUc);
            return xVarUc;
        }
        return xVar;
    }

    public com.byazt.ld.x pr(String str) {
        return hn(com.byazt.bbo.pr.pr(new File(str)));
    }

    private com.byazt.ld.x uc(com.byazt.ld.hw hwVar) {
        com.byazt.ld.x xVarFw = this.hw.fw();
        if (xVarFw != null) {
            return xVarFw;
        }
        return new com.byazt.bo.hw(hwVar.c(), hwVar.pr(), uc());
    }

    public com.byazt.ld.c x() {
        if (this.uc == null) {
            this.uc = aj();
        }
        return this.uc;
    }

    private com.byazt.ld.c aj() {
        com.byazt.ld.c cVarX = this.hw.x();
        if (cVarX == null) {
            return com.byazt.xw.hw.pr();
        }
        return cVarX;
    }

    public lb c() {
        if (this.fw == null) {
            this.fw = vk();
        }
        return this.fw;
    }

    private lb vk() {
        lb lbVarPr = this.hw.pr();
        if (lbVarPr != null) {
            return lbVarPr;
        }
        return com.byazt.ih.hw.pr();
    }

    public ExecutorService uc() {
        ExecutorService executorServicePr;
        s sVarHn = this.hw.hn();
        if (sVarHn != null && (executorServicePr = sVarHn.pr()) != null) {
            return executorServicePr;
        }
        if (this.zo == null) {
            this.zo = w();
        }
        return this.zo;
    }

    private ExecutorService w() {
        ExecutorService executorServiceHw = this.hw.hw();
        if (executorServiceHw != null) {
            return executorServiceHw;
        }
        return com.byazt.ih.hn.pr();
    }

    public Map<String, List<hn>> fw() {
        return this.pr;
    }

    public com.byazt.qnt.pr pr(hn hnVar) {
        ImageView.ScaleType scaleType;
        Bitmap.Config config;
        ImageView.ScaleType scaleTypeC = hnVar.c();
        if (scaleTypeC != null) {
            scaleType = scaleTypeC;
        } else {
            scaleType = com.byazt.qnt.pr.pr;
        }
        Bitmap.Config configK = hnVar.k();
        if (configK != null) {
            config = configK;
        } else {
            config = com.byazt.qnt.pr.hw;
        }
        return new com.byazt.qnt.pr(hnVar.hn(), hnVar.x(), scaleType, config, hnVar.aj(), hnVar.vk());
    }

    public nl zo() {
        if (this.aj == null) {
            this.aj = k();
        }
        return this.aj;
    }

    private nl k() {
        nl nlVarZo = this.hw.zo();
        if (nlVarZo == null) {
            return new fw();
        }
        return nlVarZo;
    }
}
