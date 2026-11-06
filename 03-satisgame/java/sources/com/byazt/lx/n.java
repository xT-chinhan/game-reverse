package com.byazt.lx;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.qp.d;
import com.byazt.qp.q;
import com.byazt.wy.qg;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_OPENED_TIME, 19})
public class n {
    public final qg n;
    public final com.byazt.qp.n qg;

    public n(qg qgVar, com.byazt.qp.n nVar) {
        this.n = qgVar;
        this.qg = nVar;
    }

    public Object n(SparseArray sparseArray) {
        String str;
        long jUptimeMillis = SystemClock.uptimeMillis();
        Object obj = sparseArray.get(0);
        int iIntValue = obj instanceof Integer ? ((Integer) obj).intValue() : -1;
        String str2 = (sparseArray == null || !(sparseArray.get(1) instanceof String)) ? "ats_bridge" : (String) sparseArray.get(1);
        com.byazt.sym.n.C0345n c0345nN = com.byazt.sym.n.n("bridge_apply", str2);
        try {
            if (obj instanceof Integer) {
                if (iIntValue == 0) {
                    this.qg.n(true);
                } else {
                    if (iIntValue == 1) {
                        Boolean boolValueOf = Boolean.valueOf(this.qg.qg());
                        str = c0345nN != null ? c0345nN.s : "bridge_apply";
                        String str3 = c0345nN != null ? c0345nN.n : "";
                        com.byazt.sym.n.n();
                        if (this.qg.w() != null) {
                            try {
                                this.qg.w().n(com.byazt.sym.qg.n(str, str2, iIntValue, str3, SystemClock.uptimeMillis() - jUptimeMillis, null));
                            } catch (Throwable unused) {
                            }
                        }
                        return boolValueOf;
                    }
                    if (iIntValue == 2) {
                        Integer numValueOf = Integer.valueOf(s(sparseArray));
                        str = c0345nN != null ? c0345nN.s : "bridge_apply";
                        String str4 = c0345nN != null ? c0345nN.n : "";
                        com.byazt.sym.n.n();
                        if (this.qg.w() != null) {
                            try {
                                this.qg.w().n(com.byazt.sym.qg.n(str, str2, iIntValue, str4, SystemClock.uptimeMillis() - jUptimeMillis, null));
                            } catch (Throwable unused2) {
                            }
                        }
                        return numValueOf;
                    }
                    if (iIntValue == 3) {
                        Object objQg = qg(sparseArray);
                        str = c0345nN != null ? c0345nN.s : "bridge_apply";
                        String str5 = c0345nN != null ? c0345nN.n : "";
                        com.byazt.sym.n.n();
                        if (this.qg.w() != null) {
                            try {
                                this.qg.w().n(com.byazt.sym.qg.n(str, str2, iIntValue, str5, SystemClock.uptimeMillis() - jUptimeMillis, null));
                            } catch (Throwable unused3) {
                            }
                        }
                        return objQg;
                    }
                    if (iIntValue == 4) {
                        Integer numValueOf2 = Integer.valueOf(q.n().qg());
                        str = c0345nN != null ? c0345nN.s : "bridge_apply";
                        String str6 = c0345nN != null ? c0345nN.n : "";
                        com.byazt.sym.n.n();
                        if (this.qg.w() != null) {
                            try {
                                this.qg.w().n(com.byazt.sym.qg.n(str, str2, iIntValue, str6, SystemClock.uptimeMillis() - jUptimeMillis, null));
                            } catch (Throwable unused4) {
                            }
                        }
                        return numValueOf2;
                    }
                }
            }
            str = c0345nN != null ? c0345nN.s : "bridge_apply";
            String str7 = c0345nN != null ? c0345nN.n : "";
            com.byazt.sym.n.n();
            if (this.qg.w() == null) {
                return null;
            }
            try {
                this.qg.w().n(com.byazt.sym.qg.n(str, str2, iIntValue, str7, SystemClock.uptimeMillis() - jUptimeMillis, null));
                return null;
            } catch (Throwable unused5) {
                return null;
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                str = c0345nN != null ? c0345nN.s : "bridge_apply";
                String str8 = c0345nN != null ? c0345nN.n : "";
                com.byazt.sym.n.n();
                if (this.qg.w() != null) {
                    try {
                        this.qg.w().n(com.byazt.sym.qg.n(str, str2, iIntValue, str8, SystemClock.uptimeMillis() - jUptimeMillis, th));
                    } catch (Throwable unused6) {
                    }
                }
                throw th2;
            }
        }
    }

    private Object qg(SparseArray sparseArray) {
        Object obj = sparseArray.get(1);
        String str = (String) sparseArray.get(2);
        return this.qg.n((String) obj, !TextUtils.isEmpty(str) ? this.qg.n(str) : null, false);
    }

    private int s(SparseArray sparseArray) {
        Object obj = sparseArray.get(1);
        if (!(obj instanceof String)) {
            return 0;
        }
        d dVarN = this.n.n((String) obj);
        if (dVarN == null || !dVarN.l) {
            return -1;
        }
        return dVarN.s;
    }

    public static int n(Function function, String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        Object objApply = function.apply(sparseArray);
        if (objApply instanceof Integer) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    public static Object n(Function function, d dVar, com.byazt.vf.n nVar) {
        if (dVar == null) {
            return null;
        }
        int iS = s(function);
        if (dVar.tj > 0 && iS < dVar.tj) {
            return null;
        }
        if (iS < 7500) {
            return function.apply(dVar.w);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, dVar.w);
        if (nVar != null) {
            sparseArray.put(2, nVar.n());
        }
        return function.apply(sparseArray);
    }

    public static Boolean n(Function function) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        Object objApply = function.apply(sparseArray);
        if (objApply instanceof Boolean) {
            return (Boolean) objApply;
        }
        return Boolean.FALSE;
    }

    public static Function qg(Function function) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, -5);
        return (Function) function.apply(sparseArray);
    }

    public static int s(Function function) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        Object objApply = function.apply(sparseArray);
        if (objApply instanceof Integer) {
            return ((Integer) objApply).intValue();
        }
        return -1;
    }
}
