package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.umeng.analytics.pro.ek;
import com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver;
import com.volcengine.mobsecBiz.metasec.ml.PglMSManager;
import com.volcengine.mobsecBiz.metasec.ml.PglMSManagerUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
public final class n0 {
    private static final ConcurrentHashMap ah = new ConcurrentHashMap();
    private static CopyOnWriteArraySet d = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final /* synthetic */ int f4839ms = 0;
    private static volatile boolean xr = false;

    public interface pgla {
        Map<String, String> getFeatureHash(String str, byte[] bArr);

        String getToken();

        void report(String str);

        void setBDDeviceID(String str);

        void setCollectMode(int i);

        void setDeviceID(String str);

        void setInstallID(String str);
    }

    protected n0() {
    }

    public static void ah(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "76029e", new byte[]{41, 58, 113, 67, 22, 125, 38, 3, 71, 107, 40, 61, 80, 78, 70, 102, 59, 28, 100, 108, 102, 121, ek.l, 11, 70});
        Iterator it = d.iterator();
        while (it.hasNext()) {
            ((PglITokenObserver) it.next()).onTokenLoaded(str);
        }
    }

    public static synchronized void ms(String str) {
        if (pblv.ms().xr() != null) {
            pblu pbluVar = (pblu) ah.get(str);
            if (xr(str) != null && pbluVar != null) {
                d.addAll(pbluVar.p);
                PglMSManager pglMSManager = PglMSManagerUtils.get(str);
                if (pglMSManager != null) {
                    pglMSManager.report((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a1d7a5", new byte[]{79, 58, 25, 74, 74, 29, 112, 21, 37, 104, 98, 39}));
                }
            }
        }
    }

    public static synchronized m0 xr(String str) {
        try {
            if (str == null) {
                throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "92ff3a", new byte[]{41, 32, 5, 59, 40, 54, 55, 6, 36, 34, 104, 50, ek.n, 82, 31, 115, 46}));
            }
            if (!xr) {
                return null;
            }
            int i = pbly.f4864ms;
            Object objA = com.volcengine.mobsecBiz.matrix.pgla.a(67108866, 0, 0L, str, null);
            if (objA == null) {
                return null;
            }
            pblu pbluVar = (pblu) ah.get(str);
            if (pbluVar == null) {
                return null;
            }
            return new m0(pbluVar, pblv.ms().xr(), ((Long) objA).longValue());
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized boolean ms(Context context, pblu pbluVar) {
        try {
            if (context == null) {
                throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6f8a97", new byte[]{36, 107, 69, 1, 3, 56, 33, 7, 106, 62, 50, 104, 79, 85, 8, 47, 33, 7, 107, 52, 103, 106, 94, 25, 10}));
            }
            if (pbluVar == null) {
                throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "903493", new byte[]{43, 61, 78, 70, ek.m, 35, 122, 18, 109, 113, 36, 54, 0, 78, 9, 48, 122, 19, 103, 36, 38, 39, 76, 76}));
            }
            String str = pbluVar.a;
            String str2 = (str == null || str.length() <= 0) ? pbluVar.g : pbluVar.a;
            if (str2 == null || str2.length() <= 0) {
                throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a8f4ba", new byte[]{113, 42, 5, 105, 121, 54, 111, 12, 36, 112, 48, 56, ek.n, 0, 78, 115, 118}));
            }
            if (!xr) {
                synchronized (n0.class) {
                    if (!xr) {
                        ms(context);
                        xr = true;
                    }
                }
            }
            if (ah.containsKey(str2)) {
                return false;
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(pblu.a(pbluVar.a));
            jSONArray.put(pblu.a(pbluVar.h));
            jSONArray.put(pblu.a(pbluVar.g));
            jSONArray.put(pblu.a(pbluVar.i));
            jSONArray.put(pblu.a(n1.ms()));
            jSONArray.put(pblu.a(pbluVar.b));
            jSONArray.put(pblu.a(pbluVar.c));
            jSONArray.put(pblu.a(pbluVar.d));
            jSONArray.put(pblu.a(pbluVar.e));
            jSONArray.put(pblu.a(pbluVar.f));
            jSONArray.put(String.valueOf(pbluVar.k));
            jSONArray.put(String.valueOf(pbluVar.l));
            jSONArray.put(String.valueOf(pbluVar.m));
            JSONArray jSONArray2 = new JSONArray();
            for (Map.Entry<String, String> entry : pbluVar.n.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey())) {
                    jSONArray2.put(pblu.a(entry.getKey()));
                    jSONArray2.put(pblu.a(entry.getValue()));
                }
            }
            jSONArray.put(jSONArray2);
            JSONArray jSONArray3 = new JSONArray();
            for (Map.Entry entry2 : pbluVar.o.entrySet()) {
                if (!TextUtils.isEmpty((CharSequence) entry2.getKey())) {
                    if (((String) entry2.getKey()).equals("kOA1") && TextUtils.equals((CharSequence) entry2.getValue(), "1")) {
                        a1.f4827ms = false;
                        a1.xr = pbluVar.j;
                    }
                    jSONArray3.put(pblu.a(entry2.getKey()));
                    jSONArray3.put(pblu.a(entry2.getValue()));
                }
            }
            jSONArray.put(jSONArray3);
            String string = jSONArray.toString();
            int i = pbly.f4864ms;
            if (!((Boolean) com.volcengine.mobsecBiz.matrix.pgla.a(67108865, 0, 0L, string, null)).booleanValue()) {
                return false;
            }
            ah.put(str2, pbluVar);
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    static synchronized void ms(Context context) {
        if (!xr) {
            Context applicationContext = context.getApplicationContext();
            pblv.ms().ms(applicationContext);
            e1.ms(applicationContext);
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e8b05f", new byte[]{58, 55, 2});
            pbly.ms(16777218, new j());
            pbly.ms(16777217, new u());
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "eb841a", new byte[]{58, 109, 79});
            pbly.ms(16777219, new f0());
            pbly.ms(16777221, new g0());
            pbly.ms(16777222, new h0());
            pbly.ms(16777223, new i0());
            pbly.ms(16777224, new j0());
            pbly.ms(16777225, new k0());
            pbly.ms(16777226, new l0());
            pbly.ms(16777228, new pblz());
            pbly.ms(InputDeviceCompat.SOURCE_JOYSTICK, new a());
            pbly.ms(16777233, new b());
            pbly.ms(16777235, new c());
            pbly.ms(16777238, new d());
            pbly.ms(16777239, new e());
            pbly.ms(16777241, new f());
            pbly.ms(16777242, new g());
            pbly.ms(16777243, new h());
            pbly.ms(16777244, new i());
            pbly.ms(16777245, new k());
            pbly.ms(16777246, new l());
            pbly.ms(16777247, new m());
            pbly.ms(16777248, new n());
            pbly.ms(16777249, new o());
            pbly.ms(16777250, new p());
            pbly.ms(16777251, new q());
            pbly.ms(16777240, new r());
            pbly.ms(16777252, new s());
            pbly.ms(16777253, new t());
            pbly.ms(16777254, new v());
            pbly.ms(16777255, new w());
            pbly.ms(16777256, new x());
            pbly.ms(16777257, new y());
            pbly.ms(16777258, new z());
            pbly.ms(16777259, new a0());
            pbly.ms(16777261, new b0());
            pbly.ms(16777266, new c0());
            pbly.ms(16777272, new d0());
            pbly.ms(33554435, new e0());
            v0.ms();
            w0.ms();
            com.volcengine.mobsecBiz.matrix.pgla.a(16777219, 0, 0L, null, applicationContext);
            xr = true;
        }
    }
}
