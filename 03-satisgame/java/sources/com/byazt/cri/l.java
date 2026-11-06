package com.byazt.cri;

import com.byazt.pq.bb;
import com.byazt.pq.cd;
import com.byazt.pq.oa;
import com.byazt.pq.um;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1393, 18})
public final class l {
    public static final Pattern n = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    public static long n(bb bbVar) {
        return n(bbVar.fs());
    }

    public static long n(cd cdVar) {
        return n(cdVar.n("Content-Length"));
    }

    private static long n(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static Set<String> qg(cd cdVar) {
        Set<String> setEmptySet = Collections.emptySet();
        int iN = cdVar.n();
        for (int i = 0; i < iN; i++) {
            if ("Vary".equalsIgnoreCase(cdVar.n(i))) {
                String strQg = cdVar.qg(i);
                if (setEmptySet.isEmpty()) {
                    setEmptySet = new TreeSet<>((Comparator<? super String>) String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : strQg.split(",")) {
                    setEmptySet.add(str.trim());
                }
            }
        }
        return setEmptySet;
    }

    public static cd qg(bb bbVar) {
        return n(bbVar.cp().qg().s(), bbVar.fs());
    }

    public static cd n(cd cdVar, cd cdVar2) {
        Set<String> setQg = qg(cdVar2);
        if (setQg.isEmpty()) {
            return new cd.n().n();
        }
        cd.n nVar = new cd.n();
        int iN = cdVar.n();
        for (int i = 0; i < iN; i++) {
            String strN = cdVar.n(i);
            if (setQg.contains(strN)) {
                nVar.n(strN, cdVar.qg(i));
            }
        }
        return nVar.n();
    }

    public static void n(oa oaVar, um umVar, cd cdVar) {
        if (oaVar == oa.n) {
            return;
        }
        com.byazt.pq.d.n(umVar, cdVar).isEmpty();
    }

    public static boolean s(bb bbVar) {
        if (bbVar.qg().qg().equals("HEAD")) {
            return false;
        }
        int iQ = bbVar.q();
        return (((iQ >= 100 && iQ < 200) || iQ == 204 || iQ == 304) && n(bbVar) == -1 && !"chunked".equalsIgnoreCase(bbVar.qg("Transfer-Encoding"))) ? false : true;
    }

    public static int n(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int n(String str, int i) {
        char cCharAt;
        while (i < str.length() && ((cCharAt = str.charAt(i)) == ' ' || cCharAt == '\t')) {
            i++;
        }
        return i;
    }

    public static int qg(String str, int i) {
        try {
            long j = Long.parseLong(str);
            if (j > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j < 0) {
                return 0;
            }
            return (int) j;
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
