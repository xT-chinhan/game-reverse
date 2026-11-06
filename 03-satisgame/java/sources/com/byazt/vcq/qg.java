package com.byazt.vcq;

import android.net.Uri;
import android.text.TextUtils;
import com.byazt.tbt.cy;
import com.byazt.tbt.d;
import com.byazt.tbt.hd;
import com.byazt.tbt.sz;
import com.byazt.tbt.w;
import com.byazt.tbt.x;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1112, 26})
public class qg extends s {
    public static final com.byazt.tbt.n n = new com.byazt.tbt.n.C0349n().n().qg();
    public static final com.byazt.tbt.n qg = new com.byazt.tbt.n.C0349n().qg();
    public com.byazt.tbt.n fs;
    public boolean rv;
    public Map<String, String> tj;

    public qg(d dVar) {
        super(dVar);
        this.fs = n;
        this.rv = false;
        this.tj = new HashMap();
    }

    public void n(String str, String str2) {
        if (str == null) {
            return;
        }
        this.tj.put(str, str2);
    }

    @Override // com.byazt.vcq.s
    public void n(final com.byazt.dgx.n nVar) {
        try {
            sz.n nVar2 = new sz.n();
            if (this.rv) {
                nVar2.qg(this.w);
            } else {
                x.n nVar3 = new x.n();
                Uri uri = Uri.parse(this.w);
                nVar3.n(uri.getScheme());
                nVar3.qg(uri.getHost());
                String encodedPath = uri.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith("/")) {
                        encodedPath = encodedPath.substring(1);
                    }
                    nVar3.s(encodedPath);
                }
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.tj.put(str, uri.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.tj.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String strEncode = URLEncoder.encode(key, "UTF-8");
                        if (value == null) {
                            value = "";
                        }
                        nVar3.n(strEncode, URLEncoder.encode(value, "UTF-8"));
                    }
                }
                nVar2.n(nVar3.qg());
            }
            n(nVar2);
            nVar2.n(this.fs);
            nVar2.n((Object) qg());
            this.s.n(nVar2.n().qg()).n(new com.byazt.tbt.s() { // from class: com.byazt.vcq.qg.1
                @Override // com.byazt.tbt.s
                public void onFailure(com.byazt.tbt.qg qgVar, IOException iOException) {
                    com.byazt.dgx.n nVar4 = nVar;
                    if (nVar4 != null) {
                        nVar4.n(qg.this, iOException);
                    }
                }

                @Override // com.byazt.tbt.s
                public void onResponse(com.byazt.tbt.qg qgVar, cy cyVar) throws IOException {
                    if (nVar != null) {
                        HashMap map = new HashMap();
                        if (cyVar != null) {
                            nVar.n(qg.this, qg.this.n(cyVar, map));
                        }
                    }
                }
            });
        } catch (Throwable th) {
            if (nVar != null) {
                nVar.n(this, new IOException(th.getMessage()));
            }
        }
    }

    @Override // com.byazt.vcq.s
    public com.byazt.phf.q n() {
        try {
            sz.n nVar = new sz.n();
            if (this.rv) {
                nVar.qg(this.w);
            } else {
                x.n nVar2 = new x.n();
                Uri uri = Uri.parse(this.w);
                nVar2.n(uri.getScheme());
                nVar2.qg(uri.getHost());
                String encodedPath = uri.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith("/")) {
                        encodedPath = encodedPath.substring(1);
                    }
                    nVar2.s(encodedPath);
                }
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.tj.put(str, uri.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.tj.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String strEncode = URLEncoder.encode(key, "UTF-8");
                        if (value == null) {
                            value = "";
                        }
                        nVar2.n(strEncode, URLEncoder.encode(value, "UTF-8"));
                    }
                }
                nVar.n(nVar2.qg());
            }
            n(nVar);
            nVar.n(this.fs);
            nVar.n((Object) qg());
            cy cyVarQg = this.s.n(nVar.n().qg()).qg();
            if (cyVarQg != null) {
                return n(cyVarQg, new HashMap());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.phf.q n(cy cyVar, Map<String, String> map) throws IOException {
        w wVarFs = cyVar.fs();
        if (wVarFs != null) {
            int iN = wVarFs.n();
            for (int i = 0; i < iN; i++) {
                String strN = wVarFs.n(i);
                String strQg = wVarFs.qg(i);
                map.put(strN, strQg);
                if (strN != null && strN.equalsIgnoreCase("content-type")) {
                    map.put("content-type", strQg == null ? "" : strQg.toLowerCase());
                }
            }
        }
        hd hdVarX = cyVar.x();
        if (this.x || com.byazt.nx.n.n(map)) {
            byte[] bArrQ = hdVarX == null ? new byte[0] : hdVarX.q();
            com.byazt.phf.q qVar = new com.byazt.phf.q(cyVar.l(), cyVar.q(), cyVar.w(), map, null, cyVar.qg(), cyVar.n());
            qVar.n(bArrQ);
            return qVar;
        }
        return new com.byazt.phf.q(cyVar.l(), cyVar.q(), cyVar.w(), map, hdVarX != null ? hdVarX.qg() : "", cyVar.qg(), cyVar.n());
    }
}
