package com.byazt.imu;

import android.text.TextUtils;
import android.widget.ImageView;
import com.byazt.gct.v;
import com.byazt.si.ou;
import com.byazt.si.sz;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1664, 8})
public class s {
    public static com.byazt.wg.n n() {
        return new com.byazt.wg.n() { // from class: com.byazt.imu.s.1
            @Override // com.byazt.wg.n
            public void n(ImageView imageView, String str) {
                s.n(com.byazt.iu.n.n(str)).n(imageView);
            }
        };
    }

    public static sz n(String str) {
        return n(qg().n(str));
    }

    public static sz n(v vVar) {
        return n(qg().n(vVar.n()).n(vVar.qg()).qg(vVar.s()).qg(vVar.x()));
    }

    public static InputStream n(String str, String str2) {
        return qg().n(str, str2);
    }

    public static boolean n(String str, String str2, String str3) {
        ou ouVarQg;
        if (TextUtils.isEmpty(str) || (ouVarQg = qg()) == null) {
            return false;
        }
        try {
            return ouVarQg.qg(str, str2, str3);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static ou qg() {
        return (ou) com.byazt.qp.q.n("img_service");
    }

    private static sz n(sz szVar) {
        return com.byazt.lq.l.n() ? szVar.n(new l()) : szVar;
    }
}
