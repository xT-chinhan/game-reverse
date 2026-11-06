package com.byazt.dd;

import android.text.TextUtils;
import com.byazt.rb.l;
import com.byazt.sg.s;
import com.byazt.ws.fs;
import com.byazt.ws.tj;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1106, 26})
public class qg implements n {
    public int l;
    public tj n;
    public String q;
    public com.byazt.ow.n qg;
    public int rv;
    public String s;
    public int w;
    public boolean x;
    public long fs = -1;
    public boolean tj = false;

    private qg() {
    }

    public static qg n(tj tjVar, com.byazt.ow.n nVar) {
        qg qgVar = new qg();
        qgVar.n = tjVar;
        qgVar.qg = nVar;
        return qgVar;
    }

    public int s() {
        return this.rv;
    }

    public void n(int i) {
        this.rv = i;
    }

    public long q() {
        return this.fs;
    }

    public void n(long j) {
        this.fs = j;
    }

    public boolean l() {
        return this.x;
    }

    public void n(boolean z) {
        this.x = z;
    }

    public int w() {
        return this.w;
    }

    public void qg(int i) {
        this.w = i;
    }

    public int x() {
        return this.l;
    }

    public void s(int i) {
        this.l = i;
    }

    public tj fs() {
        return this.n;
    }

    public void n(final List<s> list, final tj tjVar) {
        l.n(new Runnable() { // from class: com.byazt.dd.qg.1
            @Override // java.lang.Runnable
            public void run() {
                if (qg.this.qg != null) {
                    qg.this.qg.n(list, tjVar);
                }
            }
        });
    }

    public void n(final com.byazt.mj.n nVar, final tj tjVar) {
        l.n(new Runnable() { // from class: com.byazt.dd.qg.2
            @Override // java.lang.Runnable
            public void run() {
                if (qg.this.qg != null) {
                    qg.this.qg.n(nVar, tjVar);
                }
            }
        });
    }

    public void rv() {
        l.n(new Runnable() { // from class: com.byazt.dd.qg.3
            @Override // java.lang.Runnable
            public void run() {
                if (qg.this.qg != null) {
                    qg.this.qg.n();
                }
            }
        });
    }

    public boolean tj() {
        tj tjVar = this.n;
        if (tjVar != null) {
            return tjVar.oj();
        }
        return false;
    }

    public boolean cp() {
        tj tjVar = this.n;
        if (tjVar != null) {
            return TextUtils.equals(tjVar.k(), MediationConstant.ADN_PANGLE);
        }
        return false;
    }

    public String d() {
        tj tjVar = this.n;
        return tjVar != null ? tjVar.cd() : "";
    }

    public String oa() {
        tj tjVar = this.n;
        return tjVar != null ? tjVar.k() : "";
    }

    public int sz() {
        tj tjVar = this.n;
        if (tjVar != null) {
            return tjVar.tj();
        }
        return 0;
    }

    public int k() {
        tj tjVar = this.n;
        if (tjVar != null) {
            return tjVar.w();
        }
        return 0;
    }

    public String cy() {
        tj tjVar = this.n;
        return tjVar != null ? tjVar.ur() : "";
    }

    public void n(String str) {
        this.s = str;
    }

    public String hd() {
        return this.s;
    }

    /* JADX WARN: Code duplicated, block: B:62:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e5  */
    public String cd() {
        String str;
        tj tjVar = this.n;
        String str2 = "";
        if (tjVar == null) {
            return "";
        }
        String strK = tjVar.k();
        strK.hashCode();
        switch (strK) {
            case "klevin":
                str = "com.bytedance.msdk.adapter.klevin.Klevin";
                break;
            case "pangle":
                str = "com.bytedance.msdk.adapter.pangle_csjm.Pangle";
                break;
            case "sigmob":
                str = "com.bytedance.msdk.adapter.sigmob.Sigmob";
                break;
            case "xiaomi":
                str = "com.bytedance.msdk.adapter.xiaomi.Xiaomi";
                break;
            case "ks":
                str = "com.bytedance.msdk.adapter.ks.Ks";
                break;
            case "gdt":
                str = "com.bytedance.msdk.adapter.gdt.Gdt";
                break;
            case "baidu":
                str = "com.bytedance.msdk.adapter.baidu.Baidu";
                break;
            case "unity":
                str = "com.bytedance.msdk.adapter.unity.Unity";
                break;
            case "mintegral":
                str = "com.bytedance.msdk.adapter.mintegral.Mintegral";
                break;
            default:
                str = "";
                break;
        }
        int iW = this.n.w();
        switch (this.n.oa()) {
            case 1:
                str2 = "BannerLoader";
                break;
            case 2:
                str2 = "InterstitialLoader";
                break;
            case 3:
                str2 = "SplashLoader";
                break;
            case 5:
                str2 = "NativeLoader";
                if (iW != 4) {
                    if (iW == 5) {
                        str2 = "DrawLoader";
                    } else if (iW == 3) {
                        str2 = "BannerLoader";
                    }
                }
                break;
            case 7:
                str2 = "RewardLoader";
                if (iW != 6) {
                    if (iW == 7) {
                        str2 = "FullVideoLoader";
                    } else if (iW == 8) {
                        str2 = "InterstitialLoader";
                    }
                }
                break;
            case 8:
                str2 = "FullVideoLoader";
                break;
            case 9:
                str2 = "DrawLoader";
                break;
            case 10:
                if (iW == 1) {
                    str2 = "InterstitialLoader";
                } else if (iW == 2) {
                    str2 = "FullVideoLoader";
                }
                break;
        }
        return str.concat(str2);
    }

    public int um() {
        tj tjVar = this.n;
        if (tjVar != null) {
            return tjVar.um();
        }
        return 0;
    }

    public int a() {
        tj tjVar = this.n;
        if (tjVar != null) {
            return tjVar.h();
        }
        return 0;
    }

    public int py() {
        tj tjVar = this.n;
        if (tjVar != null) {
            return tjVar.t();
        }
        return 0;
    }

    public String ou() {
        tj tjVar = this.n;
        return tjVar != null ? tjVar.k() : "";
    }

    @Override // com.byazt.dd.n
    public boolean n() {
        tj tjVar = this.n;
        return tjVar != null && tjVar.um() == 1;
    }

    public boolean wm() {
        tj tjVar = this.n;
        return tjVar != null && tjVar.um() == 2;
    }

    public boolean m() {
        tj tjVar = this.n;
        return tjVar != null && tjVar.um() == 3;
    }

    public String hu() {
        return (wm() && lh() != null) ? lh().tj() : "";
    }

    public void qg(String str) {
        this.q = str;
    }

    @Override // com.byazt.dd.n
    public String qg() {
        return this.q;
    }

    public int h() {
        tj tjVar = this.n;
        if (tjVar != null) {
            return tjVar.oa();
        }
        return 0;
    }

    public int t() {
        tj tjVar = this.n;
        if (tjVar != null) {
            return tjVar.n();
        }
        return 0;
    }

    public double ur() {
        tj tjVar;
        if (wm() || n() || m() || (tjVar = this.n) == null) {
            return 0.0d;
        }
        return tjVar.m();
    }

    public double bb() {
        tj tjVar = this.n;
        if (tjVar != null) {
            return tjVar.py();
        }
        return 0.0d;
    }

    public double ln() {
        tj tjVar = this.n;
        if (tjVar != null) {
            return tjVar.ou();
        }
        return 0.0d;
    }

    public fs lh() {
        tj tjVar = this.n;
        if (tjVar != null) {
            return tjVar.ln();
        }
        return null;
    }

    public String v() {
        tj tjVar = this.n;
        return tjVar != null ? tjVar.sz() : "";
    }

    public int j() {
        tj tjVar = this.n;
        if (tjVar != null) {
            return tjVar.rv();
        }
        return 0;
    }

    public String an() {
        tj tjVar = this.n;
        return tjVar != null ? tjVar.df() : "";
    }

    public Object ae() {
        if (wm() && lh() != null) {
            return lh().qg();
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:40:0x004a A[RETURN] */
    public int f() {
        tj tjVar = this.n;
        if (tjVar == null) {
            return 0;
        }
        int iW = tjVar.w();
        switch (this.n.oa()) {
            case 1:
                return 20001;
            case 2:
                return 20004;
            case 3:
                return 20007;
            case 4:
            case 6:
            default:
                return 0;
            case 5:
                if (iW == 4) {
                    return 20005;
                }
                if (iW == 5) {
                    return 20002;
                }
                return iW == 3 ? 20001 : 20005;
            case 7:
                if (iW == 6) {
                    return 20006;
                }
                if (iW == 7) {
                    return 20003;
                }
                return iW == 8 ? 20004 : 20006;
            case 8:
                return 20003;
            case 9:
                return 20002;
            case 10:
                if (iW == 1) {
                    return 20004;
                }
                if (iW == 2) {
                    return 20003;
                }
                return 0;
        }
    }

    public boolean fi() {
        return this.tj;
    }

    public void qg(boolean z) {
        this.tj = z;
    }
}
