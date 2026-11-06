package ms.bz.bd.c.Pgl;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
final class y extends pbls.pgla {
    y() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    public final Object pr(long j, String str, Object obj) throws Throwable {
        JSONObject jSONObjectHn;
        try {
            f1 f1VarPr = f1.pr();
            return (!f1VarPr.x() || (jSONObjectHn = f1VarPr.hn()) == null) ? "" : jSONObjectHn.toString();
        } catch (Exception e) {
            return "";
        }
    }
}
