package com.byazt.ld;

import android.util.SparseArray;
import java.io.File;
import java.util.Collection;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 104, 1121})
public class ls implements b, Function {
    public com.byazt.sl.uc loadFactory = new com.byazt.sl.uc(com.byazt.sl.c.vk(), false);

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                Object gzVar = sparseArray.get(1);
                if (gzVar != null) {
                    gzVar = new gz((Function) gzVar);
                }
                g gVarPr = pr((ve) gzVar);
                return gVarPr != null ? new ho(gVarPr) : gVarPr;
            case 2:
                Object gzVar2 = sparseArray.get(1);
                if (gzVar2 != null) {
                    gzVar2 = new gz((Function) gzVar2);
                }
                hw((ve) gzVar2);
                return null;
            case 3:
                Object gzVar3 = sparseArray.get(1);
                if (gzVar3 != null) {
                    gzVar3 = new gz((Function) gzVar3);
                }
                hn((ve) gzVar3);
                return null;
            case 4:
                pr();
                return null;
            default:
                return null;
        }
    }

    @Override // com.byazt.ld.b
    public g pr(ve veVar) {
        String strPr = veVar.pr();
        String strHw = veVar.hw();
        g gVarPr = new com.byazt.sl.hn.hw(this.loadFactory).pr(strHw);
        gVarPr.hw(com.byazt.op.pr.pr(strPr, strHw));
        gVarPr.hn(strPr);
        gVarPr.pr(x(veVar));
        return gVarPr;
    }

    @Override // com.byazt.ld.b
    public void hw(ve veVar) {
        y yVarPr;
        com.byazt.sl.uc ucVar = this.loadFactory;
        if (ucVar != null && (yVarPr = ucVar.pr(x(veVar))) != null) {
            yVarPr.pr();
        }
    }

    @Override // com.byazt.ld.b
    public void hn(ve veVar) {
        ww wwVarHw;
        com.byazt.sl.uc ucVar = this.loadFactory;
        if (ucVar != null && (wwVarHw = ucVar.hw(x(veVar))) != null) {
            wwVarHw.pr();
        }
    }

    @Override // com.byazt.ld.b
    public void pr() {
        pr(this.loadFactory.pr(), 0.0d);
        pr(this.loadFactory.hw(), 0.0d);
    }

    private void pr(Collection<? extends pr> collection, double d) {
        if (collection == null) {
            return;
        }
        for (pr prVar : collection) {
            if (prVar != null) {
                prVar.pr(d);
            }
        }
    }

    private hw x(final ve veVar) {
        return new hw() { // from class: com.byazt.ld.ls.1
            @Override // com.byazt.ld.hw
            public long pr() {
                return 0L;
            }

            @Override // com.byazt.ld.hw
            public int hw() {
                return veVar.hn();
            }

            @Override // com.byazt.ld.hw
            public boolean hn() {
                return veVar.hn() > 0;
            }

            @Override // com.byazt.ld.hw
            public boolean x() {
                return false;
            }

            @Override // com.byazt.ld.hw
            public File c() {
                return new File(veVar.pr());
            }

            @Override // com.byazt.ld.hw
            public boolean uc() {
                return false;
            }

            @Override // com.byazt.ld.hw
            public boolean fw() {
                return veVar.x() > 0;
            }

            @Override // com.byazt.ld.hw
            public int zo() {
                return veVar.x();
            }
        };
    }
}
