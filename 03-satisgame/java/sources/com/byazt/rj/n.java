package com.byazt.rj;

import android.text.TextUtils;
import com.byazt.gh.qg;
import com.byazt.gwu.s;
import com.byazt.lk.l;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1806, 19})
public class n implements qg {
    public static volatile n n;

    @Override // com.byazt.gh.qg
    public String n() {
        return "ugen_render";
    }

    public static n qg() {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n = new n();
                }
            }
        }
        return n;
    }

    @Override // com.byazt.gh.qg
    public String n(String str, String str2) {
        int iQg = l.n(str2, n()).qg(str, 0);
        return (iQg == 0 && (str.equals("h5_render_success") || str.equals("h5_render_fail") || str.equals("native_render_success") || str.equals("native_render_fail"))) ? "0" : String.valueOf(iQg);
    }

    @Override // com.byazt.gh.qg
    public void n(String str, String str2, String str3) {
        s sVarN = l.n(str3, n());
        synchronized (sVarN) {
            if (str.equals("h5_render_success") || str.equals("h5_render_fail")) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(sVarN.qg("key_h5_render_result_list", new HashSet()));
                if (linkedHashSet.size() >= 100) {
                    Iterator it = linkedHashSet.iterator();
                    while (it.hasNext()) {
                        String str4 = (String) it.next();
                        if (TextUtils.isEmpty(str4)) {
                            it.remove();
                        } else {
                            if ((System.currentTimeMillis() - Long.parseLong(str4.substring(0, str4.length() - 1))) / 3600000.0d <= 168.0d && linkedHashSet.size() < 100) {
                                break;
                            }
                            it.remove();
                            if (str4.endsWith("0")) {
                                sVarN.n("h5_render_success", sVarN.qg("h5_render_success", 0) - 1);
                            } else if (str4.endsWith("1")) {
                                sVarN.n("h5_render_fail", sVarN.qg("h5_render_fail", 0) - 1);
                            }
                        }
                    }
                }
                if (str.equals("h5_render_success")) {
                    sVarN.n("h5_render_success", sVarN.qg("h5_render_success", 0) + 1);
                } else {
                    sVarN.n("h5_render_fail", sVarN.qg("h5_render_fail", 0) + 1);
                }
                linkedHashSet.add(str2);
                sVarN.n("key_h5_render_result_list", new HashSet(new ArrayList(linkedHashSet)));
            }
            if (str.equals("native_render_success") || str.equals("native_render_fail")) {
                LinkedHashSet linkedHashSet2 = new LinkedHashSet(sVarN.qg("native_key_render_result_list", new HashSet()));
                if (linkedHashSet2.size() >= 100) {
                    Iterator it2 = linkedHashSet2.iterator();
                    while (it2.hasNext()) {
                        String str5 = (String) it2.next();
                        if (TextUtils.isEmpty(str5)) {
                            it2.remove();
                        } else {
                            if ((System.currentTimeMillis() - Long.parseLong(str5.substring(0, str5.length() - 1))) / 3600000.0d <= 168.0d && linkedHashSet2.size() < 100) {
                                break;
                            }
                            it2.remove();
                            if (str5.endsWith("0")) {
                                sVarN.n("native_render_success", sVarN.qg("native_render_success", 0) - 1);
                            } else if (str5.endsWith("1")) {
                                sVarN.n("native_render_fail", sVarN.qg("native_render_fail", 0) - 1);
                            }
                        }
                    }
                }
                if (str.equals("native_render_success")) {
                    sVarN.n("native_render_success", sVarN.qg("native_render_success", 0) + 1);
                } else {
                    sVarN.n("native_render_fail", sVarN.qg("native_render_fail", 0) + 1);
                }
                linkedHashSet2.add(str2);
                sVarN.n("native_key_render_result_list", new HashSet(new ArrayList(linkedHashSet2)));
            }
        }
    }
}
