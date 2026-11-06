package com.byazt.qp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.SparseArray;
import com.byazt.vf.um;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 525, 21})
public class x implements um, Function {
    public static final int TYPE_NEW_SHARED_PREFERENCES = 3;
    public static File qg;
    public static final Set<String> s = new HashSet();
    public Map<String, com.byazt.eau.l> n = new ConcurrentHashMap();

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            com.byazt.eau.l lVarN = n((String) sparseArray.get(1));
            return lVarN != null ? new com.byazt.eau.w(lVarN) : lVarN;
        }
        if (iIntValue == 2) {
            com.byazt.eau.l lVarN2 = n((String) sparseArray.get(1), ((Integer) sparseArray.get(2)).intValue());
            return lVarN2 != null ? new com.byazt.eau.w(lVarN2) : lVarN2;
        }
        if (iIntValue == 3) {
            com.byazt.eau.s sVarN = n(((Integer) sparseArray.get(1)).intValue());
            return sVarN != null ? new com.byazt.eau.q(sVarN) : sVarN;
        }
        if (iIntValue == 4) {
            n();
            return null;
        }
        if (iIntValue != 5) {
            return null;
        }
        qg();
        return null;
    }

    public x() {
        s.add("sp_bidding_opt_libra");
    }

    @Override // com.byazt.vf.um
    public com.byazt.eau.l n(String str) {
        if (str == null) {
            str = "tt_sp";
        }
        com.byazt.eau.l lVar = this.n.get(str);
        if (lVar != null) {
            return lVar;
        }
        synchronized (this.n) {
            com.byazt.eau.l lVar2 = this.n.get(str);
            if (lVar2 != null) {
                return lVar2;
            }
            com.byazt.eau.l lVarQ = q(str);
            this.n.put(str, lVarQ);
            return lVarQ;
        }
    }

    private com.byazt.eau.l q(String str) {
        try {
            return l(str);
        } catch (InternalError unused) {
            return new n();
        }
    }

    private com.byazt.eau.l l(String str) {
        int iQ = com.byazt.tz.n.qg().q();
        com.byazt.pnm.s sVarKh = com.byazt.nf.rv.qg().kh();
        if (iQ == 3 && Build.VERSION.SDK_INT != 27) {
            File fileS = s(str);
            return new com.byazt.mty.s(fileS, n(fileS, str), n(str, sVarKh.n), sVarKh.qg);
        }
        String strW = w(str);
        try {
            return new com.byazt.mty.q(com.byazt.nf.rv.getContext().getSharedPreferences(strW, 0));
        } catch (Error unused) {
            File file = new File(l(), strW + ".xml");
            return new com.byazt.mty.s(file, n(file, str), n(str, sVarKh.n), sVarKh.qg);
        }
    }

    @Override // com.byazt.vf.um
    public com.byazt.eau.l n(String str, int i) {
        return n(str);
    }

    private com.byazt.uyg.n n(File file, String str) {
        if (s.contains(str)) {
            return s();
        }
        n(file);
        return new com.byazt.mty.n(null);
    }

    private com.byazt.uyg.qg n(String str, boolean z) {
        if (s.contains(str)) {
            return q();
        }
        com.byazt.ga.n nVar = z ? new com.byazt.ga.n() : null;
        if (Build.VERSION.SDK_INT != 27) {
            return new com.byazt.mty.n(nVar);
        }
        return q();
    }

    private com.byazt.uyg.n s() {
        if (com.byazt.mty.l.n()) {
            return new com.byazt.mty.l(null);
        }
        return new com.byazt.mty.w(null);
    }

    private com.byazt.uyg.qg q() {
        if (com.byazt.mty.l.n()) {
            return new com.byazt.mty.l(null);
        }
        return new com.byazt.mty.w(null);
    }

    private void n(File file) {
        File file2 = new File(file.getParent(), file.getName() + ".prop");
        if (!file2.exists() || file2.length() <= 0) {
            return;
        }
        file.delete();
    }

    @Override // com.byazt.vf.um
    public com.byazt.eau.s n(int i) {
        if (i != 32) {
            return null;
        }
        return new com.byazt.ga.n();
    }

    @Override // com.byazt.vf.um
    public void n() {
        Iterator<String> it = this.n.keySet().iterator();
        while (it.hasNext()) {
            com.byazt.eau.l lVar = this.n.get(it.next());
            if (lVar != null) {
                lVar.qg();
            }
        }
    }

    @Override // com.byazt.vf.um
    public void qg() {
        synchronized (this.n) {
            this.n.clear();
        }
    }

    public static com.byazt.eau.l qg(String str) {
        return ((um) q.n("kv_store_factory")).n(str);
    }

    public static SharedPreferences n(Context context, String str, int i) {
        return qg(str);
    }

    private static File l() {
        String name;
        File fileN = com.byazt.tk.w.n(com.byazt.nf.rv.getContext(), false, null);
        do {
            name = fileN.getName();
            if (name == null) {
                break;
            }
            fileN = fileN.getParentFile();
        } while (!name.equals("files"));
        return new File(fileN, "shared_prefs");
    }

    @com.byazt.cp.n(n = {0, 1, 525, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_MTU})
    private static class n implements com.byazt.eau.l {
        @Override // com.byazt.eau.l, android.content.SharedPreferences
        public boolean contains(String str) {
            return false;
        }

        @Override // com.byazt.eau.l, android.content.SharedPreferences
        public boolean getBoolean(String str, boolean z) {
            return z;
        }

        @Override // com.byazt.eau.l, android.content.SharedPreferences
        public float getFloat(String str, float f) {
            return f;
        }

        @Override // com.byazt.eau.l, android.content.SharedPreferences
        public int getInt(String str, int i) {
            return i;
        }

        @Override // com.byazt.eau.l, android.content.SharedPreferences
        public long getLong(String str, long j) {
            return j;
        }

        @Override // com.byazt.eau.l, android.content.SharedPreferences
        public String getString(String str, String str2) {
            return str2;
        }

        @Override // com.byazt.eau.l, android.content.SharedPreferences
        public Set<String> getStringSet(String str, Set<String> set) {
            return set;
        }

        @Override // com.byazt.eau.l
        public void n() {
        }

        @Override // com.byazt.eau.l
        public void n(String str) {
        }

        @Override // com.byazt.eau.l
        public void n(String str, float f) {
        }

        @Override // com.byazt.eau.l
        public void n(String str, int i) {
        }

        @Override // com.byazt.eau.l
        public void n(String str, long j) {
        }

        @Override // com.byazt.eau.l
        public void n(String str, String str2) {
        }

        @Override // com.byazt.eau.l
        public void n(String str, Set<String> set) {
        }

        @Override // com.byazt.eau.l
        public void n(String str, boolean z) {
        }

        @Override // com.byazt.eau.l
        public float qg(String str, float f) {
            return f;
        }

        @Override // com.byazt.eau.l
        public int qg(String str, int i) {
            return i;
        }

        @Override // com.byazt.eau.l
        public long qg(String str, long j) {
            return j;
        }

        @Override // com.byazt.eau.l
        public String qg(String str, String str2) {
            return str2;
        }

        @Override // com.byazt.eau.l
        public Set<String> qg(String str, Set<String> set) {
            return set;
        }

        @Override // com.byazt.eau.l
        public void qg() {
        }

        @Override // com.byazt.eau.l
        public boolean qg(String str, boolean z) {
            return z;
        }

        @Override // com.byazt.eau.l, android.content.SharedPreferences
        public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        }

        @Override // com.byazt.eau.l
        public void s() {
        }

        @Override // com.byazt.eau.l, android.content.SharedPreferences
        public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        }

        private n() {
        }

        @Override // com.byazt.eau.l, android.content.SharedPreferences
        public Map<String, ?> getAll() {
            return Collections.emptyMap();
        }

        @Override // com.byazt.eau.l, android.content.SharedPreferences
        public SharedPreferences.Editor edit() {
            return new SharedPreferencesEditorC0314n();
        }

        /* JADX INFO: renamed from: com.byazt.qp.x$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, 525, 1471})
        private static class SharedPreferencesEditorC0314n implements SharedPreferences.Editor {
            @Override // android.content.SharedPreferences.Editor
            public void apply() {
            }

            @Override // android.content.SharedPreferences.Editor
            public SharedPreferences.Editor clear() {
                return this;
            }

            @Override // android.content.SharedPreferences.Editor
            public boolean commit() {
                return true;
            }

            @Override // android.content.SharedPreferences.Editor
            public SharedPreferences.Editor putBoolean(String str, boolean z) {
                return this;
            }

            @Override // android.content.SharedPreferences.Editor
            public SharedPreferences.Editor putFloat(String str, float f) {
                return this;
            }

            @Override // android.content.SharedPreferences.Editor
            public SharedPreferences.Editor putInt(String str, int i) {
                return this;
            }

            @Override // android.content.SharedPreferences.Editor
            public SharedPreferences.Editor putLong(String str, long j) {
                return this;
            }

            @Override // android.content.SharedPreferences.Editor
            public SharedPreferences.Editor putString(String str, String str2) {
                return this;
            }

            @Override // android.content.SharedPreferences.Editor
            public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
                return this;
            }

            @Override // android.content.SharedPreferences.Editor
            public SharedPreferences.Editor remove(String str) {
                return this;
            }

            private SharedPreferencesEditorC0314n() {
            }
        }
    }

    public static File s(String str) {
        if (qg == null) {
            qg = l();
        }
        return new File(qg, w(str) + ".xml");
    }

    private static String w(String str) {
        return !str.startsWith("pangle_") ? "pangle_com.byted.pangle_".concat(String.valueOf(str)) : str;
    }
}
