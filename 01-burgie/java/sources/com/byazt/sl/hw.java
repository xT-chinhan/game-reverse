package com.byazt.sl;

import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.ld.g;
import com.byazt.ld.ho;
import com.byazt.ld.ny;
import com.byazt.ld.qa;
import com.byazt.ld.ww;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 4, 13})
public class hw implements ny, Function {
    public volatile uc pr;

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case -1:
                hw();
                return null;
            case 0:
            default:
                return null;
            case 1:
                g gVarPr = pr((String) sparseArray.get(1));
                return gVarPr != null ? new ho(gVarPr) : gVarPr;
            case 2:
                pr(((Double) sparseArray.get(1)).doubleValue());
                return null;
            case 3:
                hw(((Double) sparseArray.get(1)).doubleValue());
                return null;
            case 4:
                hn(((Double) sparseArray.get(1)).doubleValue());
                return null;
            case 5:
                pr();
                return null;
            case 6:
                return pr((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 7:
                return pr((String) sparseArray.get(1), (String) sparseArray.get(2), (String) sparseArray.get(3));
            case 8:
                return Boolean.valueOf(hw((String) sparseArray.get(1), (String) sparseArray.get(2), (String) sparseArray.get(3)));
        }
    }

    public hw(qa qaVar) {
        this.pr = new uc(qaVar == null ? c.vk() : qaVar, true);
    }

    private void hw() {
        hw(0.0d);
    }

    @Override // com.byazt.ld.ny
    public g pr(String str) {
        return new hn.hw(this.pr).pr(str);
    }

    @Override // com.byazt.ld.ny
    public void pr(double d) {
        hw(d);
        hn(d);
    }

    @Override // com.byazt.ld.ny
    public void hw(double d) {
        if (this.pr != null) {
            pr(this.pr.pr(), d);
            pr(this.pr.hw(), d);
        }
    }

    @Override // com.byazt.ld.ny
    public void hn(double d) {
        if (this.pr != null) {
            pr(this.pr.hn(), d);
        }
    }

    private void pr(Collection<? extends com.byazt.ld.pr> collection, double d) {
        if (collection == null) {
            return;
        }
        Iterator<? extends com.byazt.ld.pr> it = collection.iterator();
        while (it.hasNext()) {
            it.next().pr(d);
        }
    }

    @Override // com.byazt.ld.ny
    public void pr() {
        hn(0.0d);
        hw(0.0d);
    }

    @Override // com.byazt.ld.ny
    public InputStream pr(String str, String str2) {
        if (this.pr != null) {
            if (TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                str2 = com.byazt.cb.hn.pr(str);
            }
            Collection<ww> collectionHw = this.pr.hw();
            if (collectionHw != null) {
                Iterator<ww> it = collectionHw.iterator();
                while (it.hasNext()) {
                    byte[] bArrPr = it.next().pr(str2);
                    if (bArrPr != null) {
                        return new ByteArrayInputStream(bArrPr);
                    }
                }
            }
            Collection<com.byazt.ld.x> collectionHn = this.pr.hn();
            if (collectionHn != null) {
                Iterator<com.byazt.ld.x> it2 = collectionHn.iterator();
                while (it2.hasNext()) {
                    InputStream inputStreamPr = it2.next().pr(str2);
                    if (inputStreamPr != null) {
                        return inputStreamPr;
                    }
                }
            }
        }
        return null;
    }

    @Override // com.byazt.ld.ny
    public InputStream pr(String str, String str2, String str3) {
        if (this.pr == null || TextUtils.isEmpty(str3)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            str2 = com.byazt.cb.hn.pr(str);
        }
        com.byazt.ld.x xVarPr = this.pr.pr(str3);
        if (xVarPr != null) {
            return xVarPr.pr(str2);
        }
        return null;
    }

    @Override // com.byazt.ld.ny
    public boolean hw(String str, String str2, String str3) {
        if (this.pr == null || TextUtils.isEmpty(str3)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            str2 = com.byazt.cb.hn.pr(str);
        }
        com.byazt.ld.x xVarPr = this.pr.pr(str3);
        if (xVarPr != null) {
            return xVarPr.hw(str2);
        }
        return false;
    }
}
