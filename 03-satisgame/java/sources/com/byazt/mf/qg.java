package com.byazt.mf;

import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.pq.bb;
import com.byazt.pq.h;
import com.byazt.pq.k;
import com.byazt.pq.ln;
import com.byazt.pq.py;
import com.byazt.pq.t;
import com.byazt.pq.wm;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1054, 26})
public class qg implements com.byazt.qk.l, Function {
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        if (((Integer) sparseArray.get(0)).intValue() != 1) {
            return null;
        }
        com.byazt.qk.s sVarN = n((String) sparseArray.get(1), (byte[]) sparseArray.get(2), (Map) sparseArray.get(3), (String) sparseArray.get(4), (String) sparseArray.get(5), ((Integer) sparseArray.get(6)).intValue());
        return sVarN != null ? new com.byazt.qk.q(sVarN) : sVarN;
    }

    @Override // com.byazt.qk.l
    public com.byazt.qk.s n(String str, byte[] bArr, Map<String, String> map, String str2, final String str3, int i) {
        Throwable th;
        if (TextUtils.isEmpty(str) || bArr == null || TextUtils.isEmpty(str3)) {
            if (bArr != null) {
                String.valueOf(bArr.length);
            }
            return new n(false, 0, null, null, "error", new IllegalArgumentException("invalid_args"));
        }
        final String strN = n(str);
        if (TextUtils.isEmpty(strN)) {
            return new n(false, 0, null, null, "error", new IllegalArgumentException("invalid_url"));
        }
        System.currentTimeMillis();
        long j = i;
        wm wmVarN = new wm.n().n(Proxy.NO_PROXY).n(j, TimeUnit.MILLISECONDS).qg(j, TimeUnit.MILLISECONDS).s(j, TimeUnit.MILLISECONDS).n(new k() { // from class: com.byazt.mf.qg.1
            @Override // com.byazt.pq.k
            public List<InetAddress> n(String str4) throws UnknownHostException {
                if (!TextUtils.equals(strN, str4)) {
                    return n.n(str4);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(InetAddress.getByName(str3));
                return arrayList;
            }
        }).n();
        h.n nVarN = new h.n().n(str).n(t.n(py.n(str2), bArr));
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                nVarN.n(entry.getKey(), entry.getValue());
            }
        }
        bb bbVar = null;
        byte[] bArrL = null;
        try {
            bb bbVarQg = wmVarN.n(nVarN.n()).qg();
            try {
                ln lnVarRv = bbVarQg.rv();
                if (lnVarRv != null) {
                    bArrL = lnVarRv.l();
                }
                String strN2 = bbVarQg.n("x-tt-logid", "error");
                int iQ = bbVarQg.q();
                System.currentTimeMillis();
                n nVar = new n(true, iQ, bbVarQg.w(), bArrL, strN2, null);
                if (bbVarQg != null) {
                    try {
                        bbVarQg.close();
                    } catch (Throwable unused) {
                    }
                }
                return nVar;
            } catch (Throwable th2) {
                th = th2;
                bbVar = bbVarQg;
                try {
                    System.currentTimeMillis();
                    th.getClass().getSimpleName();
                    th.getMessage();
                    return new n(false, 0, null, null, "error", th);
                } finally {
                    if (bbVar != null) {
                        try {
                            bbVar.close();
                        } catch (Throwable unused2) {
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static String n(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URI.create(str).getHost();
        } catch (Throwable unused) {
            return "";
        }
    }
}
