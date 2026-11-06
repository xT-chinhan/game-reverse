package com.byazt.zg;

import android.text.TextUtils;
import com.byazt.ba.hw;
import com.byazt.qn.x;
import com.byazt.zq.hn;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1179, 37})
public class pr implements hw {
    public static volatile pr pr;

    public static pr hw() {
        if (pr == null) {
            synchronized (pr.class) {
                if (pr == null) {
                    pr = new pr();
                }
            }
        }
        return pr;
    }

    @Override // com.byazt.ba.hw
    public String pr() {
        return "ugen_render";
    }

    @Override // com.byazt.ba.hw
    public String pr(String str, String str2) {
        int iHw = x.pr(str2, pr()).hw(str, 0);
        if (iHw == 0 && (str.equals("h5_render_success") || str.equals("h5_render_fail") || str.equals("native_render_success") || str.equals("native_render_fail"))) {
            return "0";
        }
        return String.valueOf(iHw);
    }

    @Override // com.byazt.ba.hw
    public void pr(String str, String str2, String str3) {
        hn hnVarPr = x.pr(str3, pr());
        synchronized (hnVarPr) {
            if (str.equals("h5_render_success") || str.equals("h5_render_fail")) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(hnVarPr.hw("key_h5_render_result_list", new HashSet()));
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
                                hnVarPr.pr("h5_render_success", hnVarPr.hw("h5_render_success", 0) - 1);
                            } else if (str4.endsWith("1")) {
                                hnVarPr.pr("h5_render_fail", hnVarPr.hw("h5_render_fail", 0) - 1);
                            }
                        }
                    }
                }
                if (str.equals("h5_render_success")) {
                    hnVarPr.pr("h5_render_success", hnVarPr.hw("h5_render_success", 0) + 1);
                } else {
                    hnVarPr.pr("h5_render_fail", hnVarPr.hw("h5_render_fail", 0) + 1);
                }
                linkedHashSet.add(str2);
                hnVarPr.pr("key_h5_render_result_list", new HashSet(new ArrayList(linkedHashSet)));
            }
            if (str.equals("native_render_success") || str.equals("native_render_fail")) {
                LinkedHashSet linkedHashSet2 = new LinkedHashSet(hnVarPr.hw("native_key_render_result_list", new HashSet()));
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
                                hnVarPr.pr("native_render_success", hnVarPr.hw("native_render_success", 0) - 1);
                            } else if (str5.endsWith("1")) {
                                hnVarPr.pr("native_render_fail", hnVarPr.hw("native_render_fail", 0) - 1);
                            }
                        }
                    }
                }
                if (str.equals("native_render_success")) {
                    hnVarPr.pr("native_render_success", hnVarPr.hw("native_render_success", 0) + 1);
                } else {
                    hnVarPr.pr("native_render_fail", hnVarPr.hw("native_render_fail", 0) + 1);
                }
                linkedHashSet2.add(str2);
                hnVarPr.pr("native_key_render_result_list", new HashSet(new ArrayList(linkedHashSet2)));
            }
        }
    }
}
