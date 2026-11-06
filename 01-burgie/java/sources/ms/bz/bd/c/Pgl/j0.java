package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
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
    private static volatile boolean hw;
    public static final /* synthetic */ int pr = 0;
    private static final ConcurrentHashMap hn = new ConcurrentHashMap();
    private static CopyOnWriteArraySet x = new CopyOnWriteArraySet();

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

    public static void hn(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "aea014", new byte[]{127, 105, 32, 65, 30, 44, 112, 80, 22, 105, 126, 110, 1, 76, 78, 55, 109, 79, 53, 110, 48, 42, 95, 9, 78});
        Iterator it = x.iterator();
        while (it.hasNext()) {
            ((PglITokenObserver) it.next()).onTokenLoaded(str);
        }
    }

    public static synchronized i0 hw(String str) {
        try {
            if (str == null) {
                throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a02842", new byte[]{113, 34, 81, 101, 47, 101, 111, 4, 112, 124, 48, 48, 68, 12, 24, 32, 118}));
            }
            if (!hw) {
                return null;
            }
            int i = pbls.pr;
            Object objA = com.volcengine.mobsecBiz.matrix.pgla.a(67108866, 0, 0L, str, null);
            if (objA == null) {
                return null;
            }
            pblo pbloVar = (pblo) hn.get(str);
            return pbloVar != null ? new i0(pbloVar, pblp.pr().hw(), ((Long) objA).longValue()) : null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized void pr(String str) {
        if (pblp.pr().hw() != null) {
            pblo pbloVar = (pblo) hn.get(str);
            if (hw(str) != null && pbloVar != null) {
                x.addAll(pbloVar.o);
                PglMSManager pglMSManager = PglMSManagerUtils.get(str);
                if (pglMSManager != null) {
                    pglMSManager.report((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e8efa7", new byte[]{75, 51, 24, 27, 74, 31, 116, 28, 36, 57, 102, 46}));
                }
            }
        }
    }

    public static synchronized boolean pr(Context context, pblo pbloVar) {
        if (context == null) {
            throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d51e29", new byte[]{118, 56, 76, 5, 8, 54, 115, 84, 99, 58, 96, 59, 70, 81, 3, 33, 115, 84, 98, 48, 53, 57, 87, 29, 1}));
        }
        if (pbloVar == null) {
            throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2b5d1f", new byte[]{32, 111, 72, 22, 7, 118, 113, 64, 107, 33, 47, 100, 6, 30, 1, 101, 113, 65, 97, 116, 45, 117, 74, 28}));
        }
        String str = pbloVar.a;
        String str2 = (str == null || str.length() <= 0) ? pbloVar.g : pbloVar.a;
        if (str2 == null || str2.length() <= 0) {
            throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6cc266", new byte[]{38, 113, 0, 111, 45, 97, 56, 87, 33, 118, 103, 99, 21, 6, 26, 36, 33}));
        }
        if (!hw) {
            synchronized (j0.class) {
                if (!hw) {
                    pr(context);
                    hw = true;
                }
            }
        }
        if (hn.containsKey(str2)) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(pblo.a(pbloVar.a));
        jSONArray.put(pblo.a(pbloVar.h));
        jSONArray.put(pblo.a(pbloVar.g));
        jSONArray.put(pblo.a(pbloVar.i));
        jSONArray.put(pblo.a(h1.pr()));
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
        int i = pbls.pr;
        if (!((Boolean) com.volcengine.mobsecBiz.matrix.pgla.a(67108865, 0, 0L, string, null)).booleanValue()) {
            return false;
        }
        hn.put(str2, pbloVar);
        g1.pr(context).pr();
        return true;
    }

    static synchronized void pr(Context context) {
        if (!hw) {
            Context applicationContext = context.getApplicationContext();
            pblp.pr().pr(applicationContext);
            w0.pr(applicationContext);
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b9443d", new byte[]{61, 54, 84});
            pbls.pr(16777218, new d());
            pbls.pr(16777217, new o());
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f8b1e1", new byte[]{57, 55, 21});
            pbls.pr(16777219, new z());
            pbls.pr(16777221, new c0());
            pbls.pr(16777222, new d0());
            pbls.pr(16777223, new e0());
            pbls.pr(16777224, new f0());
            pbls.pr(16777225, new g0());
            pbls.pr(16777226, new h0());
            pbls.pr(16777228, new pblt());
            pbls.pr(InputDeviceCompat.SOURCE_JOYSTICK, new pblu());
            pbls.pr(16777233, new pblv());
            pbls.pr(16777235, new pblw());
            pbls.pr(16777238, new pblx());
            pbls.pr(16777239, new pbly());
            pbls.pr(16777241, new pblz());
            pbls.pr(16777242, new a());
            pbls.pr(16777243, new b());
            pbls.pr(16777244, new c());
            pbls.pr(16777245, new e());
            pbls.pr(16777246, new f());
            pbls.pr(16777247, new g());
            pbls.pr(16777248, new h());
            pbls.pr(16777249, new i());
            pbls.pr(16777250, new j());
            pbls.pr(16777251, new k());
            pbls.pr(16777240, new l());
            pbls.pr(16777252, new m());
            pbls.pr(16777253, new n());
            pbls.pr(16777254, new p());
            pbls.pr(16777255, new q());
            pbls.pr(16777256, new r());
            pbls.pr(16777257, new s());
            pbls.pr(16777317, new t());
            pbls.pr(16777318, new u());
            pbls.pr(16777261, new v());
            pbls.pr(16777266, new w());
            pbls.pr(16777319, new x());
            pbls.pr(16777259, new y());
            pbls.pr(16777262, new a0());
            pbls.pr(33554435, new b0());
            r0.pr();
            s0.pr();
            com.volcengine.mobsecBiz.matrix.pgla.a(16777219, 0, 0L, null, applicationContext);
            hw = true;
        }
    }
}
