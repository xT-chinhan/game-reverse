package com.byazt.gxb;

import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.si.k;
import com.byazt.si.ou;
import com.byazt.si.sz;
import com.byazt.si.um;
import com.byazt.si.v;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 790, 26})
public class qg implements ou, Function {
    public volatile w n;

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case -1:
                qg();
                return null;
            case 0:
            default:
                return null;
            case 1:
                sz szVarN = n((String) sparseArray.get(1));
                return szVarN != null ? new k(szVarN) : szVarN;
            case 2:
                n(((Double) sparseArray.get(1)).doubleValue());
                return null;
            case 3:
                qg(((Double) sparseArray.get(1)).doubleValue());
                return null;
            case 4:
                s(((Double) sparseArray.get(1)).doubleValue());
                return null;
            case 5:
                n();
                return null;
            case 6:
                return n((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 7:
                return n((String) sparseArray.get(1), (String) sparseArray.get(2), (String) sparseArray.get(3));
            case 8:
                return Boolean.valueOf(qg((String) sparseArray.get(1), (String) sparseArray.get(2), (String) sparseArray.get(3)));
        }
    }

    public qg(um umVar) {
        this.n = new w(umVar == null ? l.tj() : umVar, true);
    }

    private void qg() {
        qg(0.0d);
    }

    @Override // com.byazt.si.ou
    public sz n(String str) {
        return new s.qg(this.n).n(str);
    }

    @Override // com.byazt.si.ou
    public void n(double d) {
        qg(d);
        s(d);
    }

    @Override // com.byazt.si.ou
    public void qg(double d) {
        if (this.n != null) {
            n(this.n.n(), d);
            n(this.n.qg(), d);
        }
    }

    @Override // com.byazt.si.ou
    public void s(double d) {
        if (this.n != null) {
            n(this.n.s(), d);
        }
    }

    private void n(Collection<? extends com.byazt.si.n> collection, double d) {
        if (collection == null) {
            return;
        }
        Iterator<? extends com.byazt.si.n> it = collection.iterator();
        while (it.hasNext()) {
            it.next().n(d);
        }
    }

    @Override // com.byazt.si.ou
    public void n() {
        s(0.0d);
        qg(0.0d);
    }

    @Override // com.byazt.si.ou
    public InputStream n(String str, String str2) {
        if (this.n != null) {
            if (TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                str2 = com.byazt.wvr.s.n(str);
            }
            Collection<v> collectionQg = this.n.qg();
            if (collectionQg != null) {
                Iterator<v> it = collectionQg.iterator();
                while (it.hasNext()) {
                    byte[] bArrN = it.next().n(str2);
                    if (bArrN != null) {
                        return new ByteArrayInputStream(bArrN);
                    }
                }
            }
            Collection<com.byazt.si.q> collectionS = this.n.s();
            if (collectionS != null) {
                Iterator<com.byazt.si.q> it2 = collectionS.iterator();
                while (it2.hasNext()) {
                    InputStream inputStreamN = it2.next().n(str2);
                    if (inputStreamN != null) {
                        return inputStreamN;
                    }
                }
            }
        }
        return null;
    }

    @Override // com.byazt.si.ou
    public InputStream n(String str, String str2, String str3) {
        if (this.n == null || TextUtils.isEmpty(str3)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            str2 = com.byazt.wvr.s.n(str);
        }
        com.byazt.si.q qVarN = this.n.n(str3);
        if (qVarN != null) {
            return qVarN.n(str2);
        }
        return null;
    }

    @Override // com.byazt.si.ou
    public boolean qg(String str, String str2, String str3) {
        if (this.n == null || TextUtils.isEmpty(str3)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            str2 = com.byazt.wvr.s.n(str);
        }
        com.byazt.si.q qVarN = this.n.n(str3);
        if (qVarN != null) {
            return qVarN.qg(str2);
        }
        return false;
    }
}
