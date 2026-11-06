package com.byazt.py;

import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.hg.of;
import com.byazt.hg.zo;
import com.byazt.sd.a;
import com.byazt.vkw.nt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 438, 62})
public class fw {
    public static final Map<String, AtomicBoolean> hn = new ConcurrentHashMap();
    public final com.byazt.py.hw hw;
    public pr pr;

    public fw(int i) {
        pr prVarHw = hw(i);
        this.pr = prVarHw;
        switch (prVarHw.uc) {
            case 1:
                this.hw = new x();
                break;
            default:
                this.hw = new hn();
                break;
        }
    }

    public void pr(String str, hw hwVar, boolean z, long j, int i) {
        com.byazt.py.pr prVar;
        try {
            if (!a.hw().ul()) {
                prVar = null;
            } else {
                prVar = new com.byazt.py.pr() { // from class: com.byazt.py.fw.1
                    @Override // com.byazt.py.pr
                    public void pr(hw hwVar2) {
                        try {
                            of ofVarPr = com.byazt.sd.pr.pr(new JSONObject(((nt) com.byazt.zs.uc.pr("encrypt_service")).x(hwVar2.hn)));
                            ofVarPr.xh().x(3);
                            com.byazt.pj.pr.hn(ofVarPr, com.byazt.pfl.hw.AD_TAG_FEED);
                        } catch (Exception e) {
                        }
                    }
                };
            }
            synchronized (c(str)) {
                uc ucVar = new uc();
                ucVar.pr = z;
                ucVar.hw = (int) j;
                ucVar.hn = i;
                this.hw.pr(str, hwVar, ucVar, this.pr, prVar);
            }
        } catch (Throwable th) {
        }
    }

    public hw pr(String str, boolean z, long j) {
        hw hwVarPr;
        try {
            synchronized (c(str)) {
                hwVarPr = this.hw.pr(str, this.pr, j, null);
                if (hwVarPr != null && hwVarPr.pr() && z) {
                    this.hw.pr(str, hwVarPr.c, true);
                }
            }
            return hwVarPr;
        } catch (Throwable th) {
            return null;
        }
    }

    public List<hw> pr(String str, boolean z, long j, int i, double d) {
        ArrayList<hw> arrayList = new ArrayList();
        try {
            synchronized (c(str)) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < i; i2++) {
                    hw hwVarPr = this.hw.pr(str, this.pr, j, arrayList2);
                    if (hwVarPr == null || !hwVarPr.pr()) {
                        break;
                    }
                    arrayList2.add(hwVarPr.c);
                    arrayList.add(hwVarPr);
                }
                if (d > 0.0d) {
                    int iFloor = (int) Math.floor(((double) i) * d);
                    arrayList.size();
                    if (arrayList.size() < iFloor) {
                        return Collections.emptyList();
                    }
                }
                for (hw hwVar : arrayList) {
                    if (z) {
                        this.hw.pr(str, hwVar.c, true);
                    }
                }
                return arrayList;
            }
        } catch (Throwable th) {
            return arrayList;
        }
    }

    public hw pr(String str, long j, List<String> list) {
        hw hwVarPr;
        try {
            synchronized (c(str)) {
                System.currentTimeMillis();
                hwVarPr = this.hw.pr(str, this.pr, j, list);
                if (hwVarPr != null && hwVarPr.pr()) {
                    System.currentTimeMillis();
                }
            }
            return hwVarPr;
        } catch (Throwable th) {
            return null;
        }
    }

    public void pr() {
        try {
            this.hw.pr(this.pr);
        } catch (Throwable th) {
        }
    }

    public void pr(String str) {
        try {
            this.hw.pr(str);
        } catch (Throwable th) {
        }
    }

    public void hw(String str) {
        com.byazt.py.pr prVar;
        if (!a.hw().bo()) {
            prVar = null;
        } else {
            prVar = new com.byazt.py.pr() { // from class: com.byazt.py.fw.2
                @Override // com.byazt.py.pr
                public void pr(hw hwVar) {
                    try {
                        of ofVarPr = com.byazt.sd.pr.pr(new JSONObject(((nt) com.byazt.zs.uc.pr("encrypt_service")).x(hwVar.hn)));
                        ofVarPr.xh().x(2);
                        com.byazt.pj.pr.hn(ofVarPr, com.byazt.pfl.hw.AD_TAG_FEED);
                    } catch (Exception e) {
                    }
                }
            };
        }
        try {
            ho.hw("cache_tag", "广告类型 " + this.pr.hw + " ---缓存清理中--- rit: " + str);
            this.hw.pr(str, this.pr, prVar);
        } catch (Throwable th) {
        }
    }

    public void hn(String str) {
        try {
            if (c(str).compareAndSet(false, true)) {
                System.currentTimeMillis();
                this.hw.hw(str);
                System.currentTimeMillis();
            }
        } catch (Throwable th) {
        }
    }

    public void pr(String str, String str2, boolean z) {
        try {
            synchronized (c(str)) {
                this.hw.pr(str, str2, z);
            }
        } catch (Throwable th) {
        }
    }

    public void pr(String str, String str2) {
        try {
            synchronized (c(str)) {
                this.hw.pr(str, str2);
            }
        } catch (Throwable th) {
        }
    }

    public boolean x(String str) {
        boolean zPr;
        try {
            synchronized (c(str)) {
                zPr = this.hw.pr(str, this.pr);
            }
            return zPr;
        } catch (Throwable th) {
            return false;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 438, 984})
    public static class hw {
        public String c;
        public String hn;
        public long hw;
        public long pr;
        public int x = 7714;

        public hw(String str, long j, long j2, String str2) {
            this.pr = j;
            this.hw = j2;
            this.hn = str;
            this.c = str2;
        }

        public boolean pr() {
            return (TextUtils.isEmpty(this.hn) || this.pr == 0) ? false : true;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 438, 766})
    public static class pr {
        public final int c;
        public final int fw;
        public final int hn;
        public final int hw;
        public final String pr;
        public final int uc;
        public final boolean x;

        private pr(C0168pr c0168pr) {
            this.pr = c0168pr.pr;
            this.hw = c0168pr.hw;
            this.hn = c0168pr.hn;
            this.x = c0168pr.x;
            this.uc = c0168pr.uc;
            this.fw = c0168pr.fw;
            this.c = c0168pr.c;
        }

        public String pr() {
            return this.pr;
        }

        public int hw() {
            return this.hw;
        }

        public boolean hn() {
            return this.x;
        }

        public int x() {
            return this.c;
        }

        public int c() {
            return this.fw;
        }

        /* JADX INFO: renamed from: com.byazt.py.fw$pr$pr, reason: collision with other inner class name */
        @com.byazt.vzx.pr(pr = {0, 1, 438, 1703})
        public static class C0168pr {
            public int hn;
            public int hw;
            public String pr = "Default";
            public boolean x = true;
            public int c = 1;
            public int uc = 0;
            public int fw = 1;

            public C0168pr pr(String str) {
                this.pr = str;
                return this;
            }

            public C0168pr pr(int i) {
                this.hw = i;
                return this;
            }

            public C0168pr pr(boolean z) {
                this.x = z;
                return this;
            }

            public C0168pr hw(int i) {
                this.uc = i;
                return this;
            }

            public C0168pr hn(int i) {
                this.fw = i;
                return this;
            }

            public C0168pr x(int i) {
                this.c = i;
                return this;
            }

            public pr pr() {
                return new pr(this);
            }
        }
    }

    private pr hw(int i) {
        String str;
        zo.hn hnVarPr = zo.pr(i);
        switch (i) {
            case 1:
                str = "Banner";
                break;
            case 2:
            default:
                str = "Default";
                break;
            case 3:
            case 4:
                str = "Splash";
                break;
            case 5:
                str = "Feed";
                break;
            case 6:
                str = "Stream";
                break;
            case 7:
                str = "Reward";
                break;
            case 8:
                str = "Full";
                break;
            case 9:
                str = "Draw";
                break;
        }
        if (hnVarPr == null) {
            return new pr.C0168pr().pr();
        }
        return new pr.C0168pr().pr(str).pr(i).pr(hnVarPr.zo()).hw(hnVarPr.c()).hn(hnVarPr.hw()).x(hnVarPr.hn()).pr();
    }

    private AtomicBoolean c(String str) {
        Map<String, AtomicBoolean> map = hn;
        if (!map.containsKey(str)) {
            map.put(str, new AtomicBoolean(false));
        }
        return map.get(str);
    }

    public void pr(int i) {
        this.pr = hw(i);
    }
}
