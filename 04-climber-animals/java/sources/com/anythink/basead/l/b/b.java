package com.anythink.basead.l.b;

import android.text.TextUtils;
import android.util.Xml;
import com.anythink.basead.exoplayer.k.o;
import com.anythink.basead.l.c.ah;
import com.anythink.basead.l.c.ai;
import com.anythink.basead.l.c.ak;
import com.anythink.basead.l.c.at;
import com.anythink.basead.l.c.av;
import com.anythink.basead.l.c.k;
import com.anythink.basead.l.c.l;
import com.anythink.basead.l.c.p;
import com.anythink.basead.l.c.x;
import com.anythink.basead.l.e;
import com.anythink.basead.l.f;
import com.bytedance.android.live.base.api.push.ILivePush;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class b extends com.anythink.basead.l.b.a {
    public static final int a = 1;
    public static final int b = 3;
    public static final int c = 2;
    private static final String[] d = {o.e, o.g, o.f, "video/mkv"};
    private static final String e = "b";
    private boolean f;
    private volatile b g;
    private av k;
    private ArrayList<at> h = new ArrayList<>();
    private ArrayList<ah> j = new ArrayList<>();
    private ArrayList<k> i = new ArrayList<>();

    private ArrayList<at> g() {
        return this.h;
    }

    public final ArrayList<ah> a() {
        return this.j;
    }

    public final ArrayList<k> b() {
        return this.i;
    }

    public static class a {
        public static final int a = 0;
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;
        public static final int e = 4;
        public static final int f = 5;
        public static final int g = 6;
        public static final int h = 7;
        public static final int i = 8;
        public static final int j = 9;
        public static final int k = 10;
        public static final int l = 11;
        public static final int m = 12;
        public static final int n = 13;
        public static final int o = 14;
        public static final int p = 15;
        public static final int q = 16;
        public static final int r = 17;
        public static final int s = 18;
        public static final int t = 19;
        public static final int u = 20;
        public static final int v = 21;
        public static final String[] w = {"creativeView", "start", "firstQuartile", "midpoint", "thirdQuartile", "complete", "mute", "unmute", "pause", "rewind", "resume", "fullscreen", "exitFullscreen", "expand", "collapse", "acceptInvitation", "acceptInvitationLinear", "closeLinear", ILivePush.ClickType.CLOSE, "skip", "error", "impression", "click"};
        private int x;
        private String y;

        private a(String str, String str2) {
            this.x = a(str);
            this.y = str2;
        }

        private static int a(String str) {
            int i2 = 0;
            while (true) {
                String[] strArr = w;
                if (i2 >= strArr.length) {
                    return -1;
                }
                if (strArr[i2].equals(str)) {
                    return i2;
                }
                i2++;
            }
        }

        private int a() {
            return this.x;
        }

        private String b() {
            return this.y;
        }
    }

    public b(String str) throws com.anythink.basead.l.b {
        int iIndexOf;
        this.f = false;
        String strSubstring = null;
        if (str != null) {
            try {
                if (!str.isEmpty() && (iIndexOf = str.indexOf("<")) > 0) {
                    strSubstring = str.substring(iIndexOf);
                }
            } catch (Throwable th) {
                throw new com.anythink.basead.l.b("-3", th.getLocalizedMessage());
            }
        }
        str = strSubstring != null ? strSubstring : str;
        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
        xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
        xmlPullParserNewPullParser.setInput(new StringReader(str));
        xmlPullParserNewPullParser.nextTag();
        this.k = new av(xmlPullParserNewPullParser);
        this.f = true;
    }

    public final av c() {
        return this.k;
    }

    private static String b(String str) {
        int iIndexOf;
        if (str == null || str.isEmpty() || (iIndexOf = str.indexOf("<")) <= 0) {
            return null;
        }
        return str.substring(iIndexOf);
    }

    private List<String> h() {
        ArrayList arrayList = new ArrayList();
        if (this.g != null) {
            this.g.h();
            arrayList.addAll(this.g.h());
        }
        return arrayList;
    }

    public final String d() {
        if (this.k.a() == null) {
            return null;
        }
        for (com.anythink.basead.l.c.a aVar : this.k.a()) {
            if (aVar.b() != null && aVar.b().a() != null) {
                return aVar.b().a().a();
            }
        }
        return null;
    }

    public final String a(b bVar, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        if (this.g != null) {
            this.g.a(this.g, i, i2);
        } else {
            for (p pVar : bVar.k.a().get(i).a().e()) {
                if (pVar.a() != null && pVar.a().c() != null) {
                    for (ak akVar : pVar.a().c()) {
                        if (c(akVar.b())) {
                            arrayList.add(akVar);
                        }
                    }
                    if (arrayList.size() == 0) {
                        return null;
                    }
                    int i3 = 0;
                    int i4 = 0;
                    int i5 = 0;
                    while (i3 < arrayList.size()) {
                        ak akVar2 = (ak) arrayList.get(i3);
                        int i6 = e.b((CharSequence) akVar2.c()) ? 0 : Integer.parseInt(akVar2.c());
                        if (i6 != i2) {
                            int iAbs = Math.abs(i2 - i6);
                            if (i4 == 0 || iAbs < i4) {
                                i5 = i3;
                                i4 = iAbs;
                            }
                            i3++;
                        } else {
                            return ((ak) arrayList.get(i3)).a();
                        }
                    }
                    i3 = i5;
                    return ((ak) arrayList.get(i3)).a();
                }
            }
        }
        return null;
    }

    private static boolean c(String str) {
        if (!TextUtils.isEmpty(str)) {
            int i = 0;
            while (true) {
                String[] strArr = d;
                if (i >= strArr.length) {
                    break;
                }
                if (str.equalsIgnoreCase(strArr[i])) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    public final ArrayList<ah> a(b bVar, int i) {
        if (b(bVar.k, i) != null) {
            this.j.addAll(b(bVar.k, i));
        }
        if (bVar.g != null) {
            a(bVar.g, i);
        }
        return this.j;
    }

    private static ArrayList<at> a(av avVar, int i) {
        com.anythink.basead.l.c.a aVar = avVar.a().get(i);
        if (aVar.a() != null) {
            if (aVar.a().e() == null) {
                return null;
            }
            for (p pVar : aVar.a().e()) {
                if (pVar.a() != null) {
                    return pVar.a().d();
                }
            }
            return null;
        }
        if (aVar.b() == null || aVar.b().c() == null || aVar.b().c() == null) {
            return null;
        }
        for (p pVar2 : aVar.b().c()) {
            if (pVar2.a() != null) {
                return pVar2.a().d();
            }
            if (pVar2.c() != null) {
                return pVar2.c().a();
            }
        }
        return null;
    }

    private static ArrayList<ah> b(av avVar, int i) {
        com.anythink.basead.l.c.a aVar = avVar.a().get(i);
        if (aVar.a() != null) {
            return aVar.a().d();
        }
        if (aVar.b() != null) {
            return aVar.b().b();
        }
        return null;
    }

    public final ArrayList<at> b(b bVar, int i) {
        if (a(bVar.k, i) != null) {
            this.h.addAll(a(bVar.k, i));
        }
        if (bVar.g != null) {
            b(bVar.g, i);
        }
        return this.h;
    }

    public final ArrayList<String> a(f.a aVar) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (at atVar : this.h) {
            if (atVar.a().equals(a.w[aVar.ordinal()])) {
                arrayList.add(atVar.b());
            }
        }
        return arrayList;
    }

    public final String a(b bVar) {
        for (b bVar2 = this; bVar2.g != null; bVar2 = bVar2.g) {
        }
        com.anythink.basead.l.c.a aVar = bVar.k.a().get(0);
        if (aVar == null || aVar.a() == null || aVar.a().e() == null) {
            return null;
        }
        for (p pVar : aVar.a().e()) {
            if (pVar.a() != null) {
                return pVar.a().a();
            }
        }
        return null;
    }

    public final String b(b bVar) {
        for (b bVar2 = this; bVar2.g != null; bVar2 = bVar2.g) {
        }
        com.anythink.basead.l.c.a aVar = bVar.k.a().get(0);
        if (aVar == null || aVar.a() == null || aVar.a().e() == null) {
            return null;
        }
        for (p pVar : aVar.a().e()) {
            if (pVar.a() != null) {
                return pVar.a().b().a();
            }
        }
        return null;
    }

    private static com.anythink.basead.l.c.e d(b bVar, int i) {
        ArrayList<x> arrayListA;
        com.anythink.basead.l.c.a aVar = bVar.k.a().get(i);
        if (aVar != null && aVar.a() != null) {
            if (aVar.a().g() != null) {
                return aVar.a().g();
            }
            if (aVar.a().f() != null && (arrayListA = aVar.a().f().a()) != null) {
                for (x xVar : arrayListA) {
                    if (xVar.a() != null) {
                        return xVar.a();
                    }
                }
            }
        }
        return null;
    }

    public static String c(b bVar) {
        com.anythink.basead.l.c.a aVar = bVar.k.a().get(0);
        if (aVar == null || aVar.a() == null || aVar.a().c() == null) {
            return null;
        }
        return aVar.a().c().a();
    }

    public static String d(b bVar) {
        com.anythink.basead.l.c.a aVar = bVar.k.a().get(0);
        if (aVar == null || aVar.a() == null || aVar.a().a() == null) {
            return null;
        }
        return aVar.a().a().a();
    }

    public static String e(b bVar) {
        com.anythink.basead.l.c.a aVar = bVar.k.a().get(0);
        if (aVar == null || aVar.a() == null || aVar.a().b() == null) {
            return null;
        }
        return aVar.a().b().a();
    }

    public final String f(b bVar) {
        b bVar2 = this;
        while (bVar2.g != null) {
            b bVar3 = bVar2.g;
            b bVar4 = bVar2.g;
            bVar2 = bVar3;
            bVar = bVar4;
        }
        com.anythink.basead.l.c.a aVar = bVar.k.a().get(0);
        if (aVar.a().e() == null) {
            return null;
        }
        for (p pVar : aVar.a().e()) {
            if (pVar.a() != null && pVar.a().e() != null && pVar.a().e().a() != null) {
                return pVar.a().e().a().a();
            }
        }
        return null;
    }

    private static ArrayList<k> c(av avVar, int i) {
        com.anythink.basead.l.c.a aVar = avVar.a().get(i);
        if (aVar.a() != null) {
            if (aVar.a().e() == null) {
                return null;
            }
            for (p pVar : aVar.a().e()) {
                if (pVar.a() != null && pVar.a().e() != null && pVar.a().e().b() != null) {
                    return pVar.a().e().b();
                }
            }
            return null;
        }
        if (aVar.b() == null || aVar.b().c() == null || aVar.b().c() == null) {
            return null;
        }
        for (p pVar2 : aVar.b().c()) {
            if (pVar2.a() != null && pVar2.a().e() != null && pVar2.a().e().b() != null) {
                return pVar2.a().e().b();
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00bc A[EDGE_INSN: B:32:0x00bc->B:33:0x00bd BREAK  A[LOOP:0: B:7:0x0028->B:44:0x0028]] */
    public final ArrayList<k> c(b bVar, int i) {
        ArrayList<k> arrayListB;
        com.anythink.basead.l.c.a aVar = bVar.k.a().get(i);
        if (aVar.a() != null) {
            if (aVar.a().e() == null) {
                arrayListB = null;
                break;
            }
            Iterator<p> it = aVar.a().e().iterator();
            while (true) {
                if (!it.hasNext()) {
                    arrayListB = null;
                    break;
                }
                p next = it.next();
                if (next.a() != null && next.a().e() != null && next.a().e().b() != null) {
                    arrayListB = next.a().e().b();
                    break;
                }
            }
        } else if (aVar.b() != null && aVar.b().c() != null && aVar.b().c() != null) {
            Iterator<p> it2 = aVar.b().c().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    arrayListB = null;
                    break;
                }
                p next2 = it2.next();
                if (next2.a() != null && next2.a().e() != null && next2.a().e().b() != null) {
                    arrayListB = next2.a().e().b();
                    break;
                }
            }
        } else {
            arrayListB = null;
            break;
        }
        if (arrayListB != null) {
            this.i.addAll(arrayListB);
        }
        if (bVar.g != null) {
            c(bVar.g, i);
        }
        return this.i;
    }

    private List<String> i() {
        ArrayList arrayList = new ArrayList();
        if (this.g != null) {
            this.g.i();
            arrayList.addAll(this.g.i());
        }
        return arrayList;
    }

    public static l a(ai aiVar) {
        int iA;
        int iA2;
        l lVar = null;
        if (aiVar.e() == null) {
            return null;
        }
        Iterator<p> it = aiVar.e().iterator();
        while (it.hasNext()) {
            ArrayList<l> arrayListB = it.next().b();
            if (arrayListB != null && arrayListB.size() != 0) {
                for (int i = 0; i < arrayListB.size(); i++) {
                    try {
                        l lVar2 = arrayListB.get(i);
                        if (lVar2 == null && lVar == null) {
                            throw new IllegalArgumentException("No companions to compare");
                        }
                        char c2 = 2;
                        if (lVar2 != null) {
                            if (lVar == null) {
                                c2 = 1;
                            } else {
                                Integer numA = a(lVar2);
                                Integer numA2 = a(lVar);
                                if (numA == null && numA2 == null) {
                                    throw new IllegalArgumentException("No companion resources to compare");
                                }
                                if (numA != null) {
                                    if (numA2 != null && numA.intValue() >= numA2.intValue()) {
                                        if (numA.intValue() <= numA2.intValue() && (iA = a(lVar2.a(), lVar2.b())) >= (iA2 = a(lVar.a(), lVar.b()))) {
                                            if (iA <= iA2) {
                                                c2 = 0;
                                            }
                                        }
                                    }
                                    c2 = 1;
                                }
                            }
                        }
                        if (c2 == 1) {
                            lVar = lVar2;
                        }
                    } catch (IllegalArgumentException e2) {
                        e2.getMessage();
                    }
                }
            }
        }
        return lVar;
    }

    private static int a(l lVar, l lVar2) {
        int iA;
        int iA2;
        if (lVar == null && lVar2 == null) {
            throw new IllegalArgumentException("No companions to compare");
        }
        if (lVar == null) {
            return 2;
        }
        if (lVar2 == null) {
            return 1;
        }
        Integer numA = a(lVar);
        Integer numA2 = a(lVar2);
        if (numA == null && numA2 == null) {
            throw new IllegalArgumentException("No companion resources to compare");
        }
        if (numA == null) {
            return 2;
        }
        if (numA2 == null || numA.intValue() < numA2.intValue()) {
            return 1;
        }
        if (numA.intValue() <= numA2.intValue() && (iA = a(lVar.a(), lVar.b())) >= (iA2 = a(lVar2.a(), lVar2.b()))) {
            return iA > iA2 ? 1 : 0;
        }
        return 2;
    }

    private static int a(String str, String str2) {
        return (e.b((CharSequence) str) ? 0 : Integer.parseInt(str)) * (e.b((CharSequence) str2) ? 0 : Integer.parseInt(str2));
    }

    public static Integer a(l lVar) {
        if (lVar == null) {
            return null;
        }
        if (lVar.e() != null) {
            return 1;
        }
        if (lVar.c() != null) {
            return 2;
        }
        return lVar.d() != null ? 3 : null;
    }

    public static at a(ArrayList<at> arrayList) {
        if (arrayList == null) {
            return null;
        }
        for (at atVar : arrayList) {
            if (atVar.a().equals("creativeView")) {
                return atVar;
            }
        }
        return null;
    }

    private synchronized boolean j() {
        return this.f && (this.g == null || this.g.j());
    }

    public final void g(b bVar) {
        this.g = bVar;
    }

    private b k() {
        return this.g;
    }

    public final int e() {
        try {
            return Integer.parseInt(this.k.a().get(0).a().e().get(0).a().c().get(0).c());
        } catch (Exception unused) {
            return 0;
        }
    }

    public final int f() {
        try {
            return Integer.parseInt(this.k.a().get(0).a().e().get(0).a().c().get(0).d());
        } catch (Exception unused) {
            return 0;
        }
    }

    private void a(String str) throws XmlPullParserException, IOException {
        int iIndexOf;
        String strSubstring = null;
        if (str != null && !str.isEmpty() && (iIndexOf = str.indexOf("<")) > 0) {
            strSubstring = str.substring(iIndexOf);
        }
        if (strSubstring != null) {
            str = strSubstring;
        }
        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
        xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
        xmlPullParserNewPullParser.setInput(new StringReader(str));
        xmlPullParserNewPullParser.nextTag();
        this.k = new av(xmlPullParserNewPullParser);
    }
}
