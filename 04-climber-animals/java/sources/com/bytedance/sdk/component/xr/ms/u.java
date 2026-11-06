package com.bytedance.sdk.component.xr.ms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public sl f1621ms;

    public abstract String ah();

    public ub c() {
        return null;
    }

    public abstract Map<String, List<String>> d();

    public abstract com.bytedance.sdk.component.xr.ms.ms ka();

    public abstract Object ms();

    public abstract ab xr();

    public void ms(sl slVar) {
        this.f1621ms = slVar;
    }

    public ms ab() {
        return new ms(this);
    }

    public static class ms {
        c.ms ab;
        ab ah;
        ub c;
        String d;
        Object ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        com.bytedance.sdk.component.xr.ms.ms f1622ms;
        public Map<String, List<String>> xr;

        public ms() {
            this.xr = new HashMap();
            this.ab = new c.ms();
        }

        public ms ms(com.bytedance.sdk.component.xr.ms.ms msVar) {
            this.f1622ms = msVar;
            return this;
        }

        ms(u uVar) {
            this.ah = uVar.xr();
            this.d = uVar.ah();
            this.xr = uVar.d();
            this.ka = uVar.ms();
            this.c = uVar.c();
            this.f1622ms = uVar.ka();
        }

        public ms ms(Object obj) {
            this.ka = obj;
            return this;
        }

        public ms ms(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            ab abVarAh = ab.ah(str);
            if (abVarAh == null) {
                throw new IllegalArgumentException("unexpected url: ".concat(String.valueOf(str)));
            }
            return ms(abVarAh);
        }

        public ms ms(ab abVar) {
            this.ah = abVar;
            return this;
        }

        public ms ms(String str, String str2) {
            return xr(str, str2);
        }

        public ms ms(c cVar) {
            if (cVar != null) {
                this.xr = cVar.xr();
            }
            return this;
        }

        public ms xr(String str, String str2) {
            if (!this.xr.containsKey(str)) {
                this.xr.put(str, new ArrayList());
            }
            this.xr.get(str).add(str2);
            return this;
        }

        public ms ms() {
            return ms("GET", (ub) null);
        }

        public ms ms(String str, ub ubVar) {
            this.d = str;
            this.c = ubVar;
            return this;
        }

        public ms ms(ub ubVar) {
            return ms("POST", ubVar);
        }

        public u xr() {
            return new u() { // from class: com.bytedance.sdk.component.xr.ms.u.ms.1
                public String toString() {
                    return "";
                }

                @Override // com.bytedance.sdk.component.xr.ms.u
                public Object ms() {
                    return ms.this.ka;
                }

                @Override // com.bytedance.sdk.component.xr.ms.u
                public ab xr() {
                    return ms.this.ah;
                }

                @Override // com.bytedance.sdk.component.xr.ms.u
                public String ah() {
                    return ms.this.d;
                }

                @Override // com.bytedance.sdk.component.xr.ms.u
                public Map d() {
                    return ms.this.xr;
                }

                @Override // com.bytedance.sdk.component.xr.ms.u
                public com.bytedance.sdk.component.xr.ms.ms ka() {
                    return ms.this.f1622ms;
                }

                @Override // com.bytedance.sdk.component.xr.ms.u
                public ub c() {
                    return ms.this.c;
                }
            };
        }
    }
}
