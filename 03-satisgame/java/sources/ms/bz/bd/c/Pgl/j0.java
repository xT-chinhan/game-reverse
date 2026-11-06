package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver;
import com.volcengine.mobsecBiz.metasec.ml.PglMSManager;
import com.volcengine.mobsecBiz.metasec.ml.PglMSManagerUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 {
    public static final /* synthetic */ int n = 0;
    private static volatile boolean qg = false;
    private static final ConcurrentHashMap s = new ConcurrentHashMap();
    private static CopyOnWriteArraySet q = new CopyOnWriteArraySet();

    public interface pgla {
        Map<String, String> getFeatureHash(String str, byte[] bArr);

        String getToken();

        void report(String str);

        void setBDDeviceID(String str);

        void setCollectMode(int i);

        void setDeviceID(String str);

        void setInstallID(String str);
    }

    protected j0() {
    }

    public static synchronized void n(String str) {
        if (pblp.n().qg() != null) {
            pblo pbloVar = (pblo) s.get(str);
            if (qg(str) != null && pbloVar != null) {
                q.addAll(pbloVar.o);
                PglMSManager pglMSManager = PglMSManagerUtils.get(str);
                if (pglMSManager != null) {
                    pglMSManager.report((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e8efa7", new byte[]{75, 51, 24, 27, 74, 31, 116, 28, 36, 57, 102, 46}));
                }
            }
        }
    }

    public static synchronized i0 qg(String str) {
        try {
            if (str == null) {
                throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a02842", new byte[]{113, 34, 81, 101, 47, 101, 111, 4, 112, 124, 48, 48, 68, 12, 24, 32, 118}));
            }
            if (!qg) {
                return null;
            }
            int i = pbls.n;
            Object objA = com.volcengine.mobsecBiz.matrix.pgla.a(67108866, 0, 0L, str, null);
            if (objA == null) {
                return null;
            }
            pblo pbloVar = (pblo) s.get(str);
            if (pbloVar == null) {
                return null;
            }
            return new i0(pbloVar, pblp.n().qg(), ((Long) objA).longValue());
        } catch (Throwable th) {
            throw th;
        }
    }

    public static void s(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "aea014", new byte[]{127, 105, 32, 65, 30, 44, 112, 80, 22, 105, 126, 110, 1, 76, 78, 55, 109, 79, 53, 110, 48, 42, 95, 9, 78});
        Iterator it = q.iterator();
        while (it.hasNext()) {
            ((PglITokenObserver) it.next()).onTokenLoaded(str);
        }
    }

    public static synchronized boolean n(Context context, pblo pbloVar) {
        if (context == null) {
            throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d51e29", new byte[]{118, 56, 76, 5, 8, 54, 115, 84, 99, 58, 96, 59, 70, 81, 3, 33, 115, 84, 98, 48, 53, 57, 87, 29, 1}));
        }
        if (pbloVar == null) {
            throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2b5d1f", new byte[]{32, 111, 72, 22, 7, 118, 113, com.anythink.core.common.r.a.c.b, 107, 33, 47, 100, 6, 30, 1, 101, 113, 65, 97, 116, 45, 117, 74, 28}));
        }
        String str = pbloVar.a;
        String str2 = (str == null || str.length() <= 0) ? pbloVar.g : pbloVar.a;
        if (str2 == null || str2.length() <= 0) {
            throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6cc266", new byte[]{38, 113, 0, 111, 45, 97, 56, 87, 33, 118, 103, 99, 21, 6, 26, 36, 33}));
        }
        if (!qg) {
            synchronized (j0.class) {
                if (!qg) {
                    n(context);
                    qg = true;
                }
            }
        }
        if (s.containsKey(str2)) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(pblo.a(pbloVar.a));
        jSONArray.put(pblo.a(pbloVar.h));
        jSONArray.put(pblo.a(pbloVar.g));
        jSONArray.put(pblo.a(pbloVar.i));
        jSONArray.put(pblo.a(h1.n()));
        jSONArray.put(pblo.a(pbloVar.b));
        jSONArray.put(pblo.a(pbloVar.c));
        jSONArray.put(pblo.a(pbloVar.d));
        jSONArray.put(pblo.a(pbloVar.e));
        jSONArray.put(pblo.a(pbloVar.f));
        jSONArray.put(String.valueOf(pbloVar.j));
        jSONArray.put(String.valueOf(pbloVar.k));
        jSONArray.put(String.valueOf(pbloVar.l));
        JSONArray jSONArray2 = new JSONArray();
        for (Map.Entry<String, String> entry : pbloVar.m.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                jSONArray2.put(pblo.a(entry.getKey()));
                jSONArray2.put(pblo.a(entry.getValue()));
            }
        }
        jSONArray.put(jSONArray2);
        JSONArray jSONArray3 = new JSONArray();
        for (Map.Entry entry2 : pbloVar.n.entrySet()) {
            if (!TextUtils.isEmpty((CharSequence) entry2.getKey())) {
                jSONArray3.put(pblo.a(entry2.getKey()));
                jSONArray3.put(pblo.a(entry2.getValue()));
            }
        }
        jSONArray.put(jSONArray3);
        String string = jSONArray.toString();
        int i = pbls.n;
        if (!((Boolean) com.volcengine.mobsecBiz.matrix.pgla.a(67108865, 0, 0L, string, null)).booleanValue()) {
            return false;
        }
        s.put(str2, pbloVar);
        g1.n(context).n();
        return true;
    }

    static synchronized void n(Context context) {
        if (!qg) {
            Context applicationContext = context.getApplicationContext();
            pblp.n().n(applicationContext);
            w0.n(applicationContext);
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b9443d", new byte[]{61, 54, 84});
            pbls.n(16777218, new d());
            pbls.n(16777217, new o());
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f8b1e1", new byte[]{57, 55, 21});
            pbls.n(16777219, new z());
            pbls.n(16777221, new c0());
            pbls.n(16777222, new d0());
            pbls.n(16777223, new e0());
            pbls.n(16777224, new f0());
            pbls.n(16777225, new g0());
            pbls.n(16777226, new h0());
            pbls.n(16777228, new pblt());
            pbls.n(InputDeviceCompat.SOURCE_JOYSTICK, new pblu());
            pbls.n(16777233, new pblv());
            pbls.n(16777235, new pblw());
            pbls.n(16777238, new pblx());
            pbls.n(16777239, new pbly());
            pbls.n(16777241, new pblz());
            pbls.n(16777242, new a());
            pbls.n(16777243, new b());
            pbls.n(16777244, new c());
            pbls.n(16777245, new e());
            pbls.n(16777246, new f());
            pbls.n(16777247, new g());
            pbls.n(16777248, new h());
            pbls.n(16777249, new i());
            pbls.n(16777250, new j());
            pbls.n(16777251, new k());
            pbls.n(16777240, new l());
            pbls.n(16777252, new m());
            pbls.n(16777253, new n());
            pbls.n(16777254, new p());
            pbls.n(16777255, new q());
            pbls.n(16777256, new r());
            pbls.n(16777257, new s());
            pbls.n(16777317, new t());
            pbls.n(16777318, new u());
            pbls.n(16777261, new v());
            pbls.n(16777266, new w());
            pbls.n(16777319, new x());
            pbls.n(16777259, new y());
            pbls.n(16777262, new a0());
            pbls.n(33554435, new b0());
            r0.n();
            s0.n();
            com.volcengine.mobsecBiz.matrix.pgla.a(16777219, 0, 0L, null, applicationContext);
            qg = true;
        }
    }
}
