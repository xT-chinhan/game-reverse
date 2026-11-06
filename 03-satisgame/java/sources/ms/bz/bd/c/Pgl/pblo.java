package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class pblo {
    public static final int CLIENT_TYPE_BUSINESS = 1;
    public static final int CLIENT_TYPE_INHOUSE = 0;
    public static final int CLIENT_TYPE_UNKNOWN = -1;
    public static final int COLLECT_MODE_DEFAULT = 99999;
    public static final int COLLECT_MODE_ML_MINIMIZE = 290;
    public static final int COLLECT_MODE_ML_PGL_AL = 810;
    protected String a = "";
    protected String b = "";
    protected String c = "";
    protected String d = "";
    protected String e = "";
    protected String f = "";
    protected String g = "";
    protected String h = "";
    protected String i = "";
    protected int j = -1;
    protected int k = -1;
    protected int l = COLLECT_MODE_DEFAULT;
    protected Map<String, String> m = new HashMap();
    protected HashMap n = new HashMap();
    protected HashSet o = new HashSet();

    public interface pblb {
    }

    public static abstract class pgla<T extends pblb> extends pblo implements pblb {
        public pgla(String str, String str2, int i) {
            this.a = str;
            this.i = str2;
            this.l = i;
            if (TextUtils.isEmpty(str) || "0".equals(str) || TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("appID or license must be set.");
            }
            if (i != 99999 && i != 290 && i != 810) {
                throw new IllegalArgumentException("COLLECT_MODE is error ");
            }
        }

        public pgla(String str, String str2, String str3, int i) {
            this.g = str;
            this.h = str2;
            this.i = str3;
            this.l = i;
            if (TextUtils.isEmpty(str) || "0".equals(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                throw new IllegalArgumentException("sdkID or license must be set.");
            }
        }

        protected final pgla a() {
            this.j = 1;
            return this;
        }

        public T addAdvanceInfo0(String str, String str2) {
            this.n.put(str, str2);
            return this;
        }

        public T addDataObserver(PglITokenObserver pglITokenObserver) {
            if (pglITokenObserver != null) {
                this.o.add(pglITokenObserver);
            }
            return this;
        }

        public T setBDDeviceID0(String str) {
            this.d = str;
            return this;
        }

        public T setChannel0(String str) {
            this.b = str;
            return this;
        }

        public T setClientType0(int i) {
            this.j = i;
            return this;
        }

        public T setCustomInfo0(Map<String, String> map) {
            if (map == null) {
                map = new HashMap<>();
            }
            this.m = map;
            return this;
        }

        public T setDeviceID0(String str) {
            this.c = str;
            return this;
        }

        public T setInstallID0(String str) {
            this.e = str;
            return this;
        }

        public T setOVRegionType0(int i) {
            this.k = i;
            return this;
        }

        public T setOaid0(String str) {
            if (str.equals("timeout") || str.equals("error") || !str.isEmpty()) {
                this.n.put("kOA1", "1");
            }
            return this;
        }

        public T setSecssionID0(String str) {
            this.f = str;
            return this;
        }
    }

    protected pblo() {
    }

    static String a(Object obj) {
        return (obj == null || !(obj instanceof String)) ? "" : ((String) obj).trim();
    }
}
