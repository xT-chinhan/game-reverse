package ms.bz.bd.c.Pgl;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
final class y extends pbls.pgla {
    y() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    public final Object n(long j, String str, Object obj) throws Throwable {
        JSONObject jSONObjectS;
        try {
            f1 f1VarN = f1.n();
            return (!f1VarN.q() || (jSONObjectS = f1VarN.s()) == null) ? "" : jSONObjectS.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
