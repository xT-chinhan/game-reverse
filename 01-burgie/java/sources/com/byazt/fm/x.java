package com.byazt.fm;

import android.text.TextUtils;
import com.byazt.nzn.c;
import com.byazt.nzn.g;
import com.byazt.nzn.ho;
import com.byazt.nzn.k;
import com.byazt.nzn.nt;
import com.byazt.nzn.uc;
import com.byazt.nzn.vk;
import com.byazt.nzn.yb;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_TIMESTAMP_MONOTONIC, 121})
public class x extends hn {
    public ho pr;

    public x(k kVar) {
        super(kVar);
        this.pr = null;
    }

    public void hn(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "{}";
        }
        this.pr = ho.pr(vk.pr("application/json; charset=utf-8"), str);
    }

    public void pr(Map<String, String> map) {
        c.pr prVar = new c.pr();
        if (map != null && !map.isEmpty()) {
            for (String str : map.keySet()) {
                prVar.pr(str, map.get(str));
            }
        }
        this.pr = prVar.pr();
    }

    public void pr(String str, byte[] bArr) {
        this.pr = ho.pr(vk.pr(str), bArr);
    }

    @Override // com.byazt.fm.hn
    public void pr(final com.byazt.elv.pr prVar) {
        try {
            g.pr prVar2 = new g.pr();
            if (TextUtils.isEmpty(this.uc)) {
                prVar.pr(this, new IOException("Url is Empty"));
                return;
            }
            prVar2.pr(this.uc);
            if (this.pr == null) {
                if (prVar != null) {
                    prVar.pr(this, new IOException("RequestBody is null, content type is not support!!"));
                    return;
                }
                return;
            }
            pr(prVar2);
            prVar2.pr((Object) hw());
            com.byazt.nzn.hw hwVarPr = this.hn.pr(prVar2.pr(this.pr).hw());
            boolean zPr = com.byazt.tf.pr.pr(x());
            long jCurrentTimeMillis = 0;
            if (zPr) {
                jCurrentTimeMillis = System.currentTimeMillis();
                com.byazt.tf.pr.pr(this.hn.pr());
                com.byazt.tf.pr.pr(x(), hwVarPr.pr().pr(), jCurrentTimeMillis);
            }
            hwVarPr.pr(new com.byazt.nzn.hn() { // from class: com.byazt.fm.x.1
                @Override // com.byazt.nzn.hn
                public void onFailure(com.byazt.nzn.hw hwVar, IOException iOException) {
                    x.this.pr(hwVar);
                    com.byazt.elv.pr prVar3 = prVar;
                    if (prVar3 != null) {
                        prVar3.pr(x.this, iOException);
                    }
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // com.byazt.nzn.hn
                public void onResponse(com.byazt.nzn.hw hwVar, nt ntVar) throws IOException {
                    com.byazt.tf.x xVar;
                    x.this.pr(hwVar);
                    com.byazt.elv.pr prVar3 = prVar;
                    if (prVar3 != null) {
                        if (ntVar == null) {
                            prVar3.pr(x.this, new IOException("No response"));
                            return;
                        }
                        com.byazt.tf.x xVar2 = null;
                        IOException iOException = null;
                        try {
                            HashMap map = new HashMap();
                            uc ucVarFw = ntVar.fw();
                            if (ucVarFw != null) {
                                for (int i = 0; i < ucVarFw.pr(); i++) {
                                    String strPr = ucVarFw.pr(i);
                                    String strHw = ucVarFw.hw(i);
                                    map.put(strPr, strHw);
                                    if (strPr != null && strPr.equalsIgnoreCase("content-type")) {
                                        map.put("content-type", strHw == null ? "" : strHw.toLowerCase());
                                    }
                                }
                            }
                            try {
                                if (com.byazt.am.pr.pr(map)) {
                                    byte[] bArrX = ntVar.uc().x();
                                    xVar = new com.byazt.tf.x(ntVar.x(), ntVar.hn(), ntVar.c(), map, null, ntVar.hw(), ntVar.pr());
                                    xVar.pr(bArrX);
                                } else if (x.this.fw) {
                                    byte[] bArrX2 = ntVar.uc().x();
                                    x xVar3 = x.this;
                                    xVar = new com.byazt.tf.x(ntVar.x(), ntVar.hn(), ntVar.c(), map, new String(bArrX2, xVar3.pr(xVar3.pr(ntVar.uc()))), ntVar.hw(), ntVar.pr());
                                    xVar.pr(bArrX2);
                                } else {
                                    xVar = new com.byazt.tf.x(ntVar.x(), ntVar.hn(), ntVar.c(), map, ntVar.uc().hw(), ntVar.hw(), ntVar.pr());
                                }
                                x.this.pr(xVar, ntVar);
                                xVar.pr(ntVar.aj());
                            } catch (Throwable th) {
                                th = th;
                                xVar2 = xVar;
                                xVar = xVar2;
                                iOException = new IOException(th);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        if (xVar != null) {
                            prVar.pr(x.this, xVar);
                            return;
                        }
                        com.byazt.elv.pr prVar4 = prVar;
                        x xVar4 = x.this;
                        if (iOException == null) {
                            iOException = new IOException("Unexpected exception");
                        }
                        prVar4.pr(xVar4, iOException);
                    }
                }
            });
            if (zPr) {
                int size = this.hn.pr().hn().size();
                if (com.byazt.tf.pr.pr(size, jCurrentTimeMillis)) {
                    com.byazt.tf.pr.pr(size, this.hn.pr().hn(), this.hn.pr().x(), jCurrentTimeMillis);
                }
            }
        } catch (Throwable th) {
            com.byazt.tf.pr.pr((Object) hw());
            prVar.pr(this, new IOException(th.getMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.nzn.hw hwVar) {
        if (hwVar != null && hwVar.pr() != null && hwVar.pr().pr() != null) {
            com.byazt.tf.pr.pr(hwVar.pr().pr());
        }
    }

    @Override // com.byazt.fm.hn
    public com.byazt.tf.x pr() {
        Throwable th;
        com.byazt.tf.x xVar;
        g gVar = null;
        try {
            g.pr prVar = new g.pr();
            if (TextUtils.isEmpty(this.uc)) {
                com.byazt.tf.x xVar2 = new com.byazt.tf.x(false, 5000, "URL_NULL_MSG", null, "URL_NULL_BODY", 1L, 1L);
                com.byazt.tf.pr.pr((Object) hw());
                return xVar2;
            }
            prVar.pr(this.uc);
            if (this.pr == null) {
                com.byazt.tf.x xVar3 = new com.byazt.tf.x(false, 5000, "BODY_NULL_MSG", null, "BODY_NULL_BODY", 1L, 1L);
                com.byazt.tf.pr.pr((Object) hw());
                return xVar3;
            }
            pr(prVar);
            prVar.pr((Object) hw());
            g gVarHw = prVar.pr(this.pr).hw();
            try {
                nt ntVarHw = this.hn.pr(gVarHw).hw();
                if (ntVarHw == null) {
                    com.byazt.tf.pr.pr(gVarHw == null ? hw() : gVarHw.pr());
                    return null;
                }
                HashMap map = new HashMap();
                uc ucVarFw = ntVarHw.fw();
                if (ucVarFw != null) {
                    for (int i = 0; i < ucVarFw.pr(); i++) {
                        String strPr = ucVarFw.pr(i);
                        String strHw = ucVarFw.hw(i);
                        map.put(strPr, strHw);
                        if (strPr != null && strPr.equalsIgnoreCase("content-type")) {
                            map.put("content-type", strHw == null ? "" : strHw.toLowerCase());
                        }
                    }
                }
                if (com.byazt.am.pr.pr(map)) {
                    byte[] bArrX = ntVarHw.uc().x();
                    xVar = new com.byazt.tf.x(ntVarHw.x(), ntVarHw.hn(), ntVarHw.c(), map, null, ntVarHw.hw(), ntVarHw.pr());
                    xVar.pr(bArrX);
                } else if (this.fw) {
                    byte[] bArrX2 = ntVarHw.uc().x();
                    xVar = new com.byazt.tf.x(ntVarHw.x(), ntVarHw.hn(), ntVarHw.c(), map, new String(bArrX2, pr(pr(ntVarHw.uc()))), ntVarHw.hw(), ntVarHw.pr());
                    xVar.pr(bArrX2);
                } else {
                    xVar = new com.byazt.tf.x(ntVarHw.x(), ntVarHw.hn(), ntVarHw.c(), map, ntVarHw.uc().hw(), ntVarHw.hw(), ntVarHw.pr());
                }
                pr(xVar, ntVarHw);
                xVar.pr(ntVarHw.aj());
                com.byazt.tf.pr.pr(gVarHw == null ? hw() : gVarHw.pr());
                return xVar;
            } catch (Throwable th2) {
                th = th2;
                gVar = gVarHw;
                try {
                    return new com.byazt.tf.x(false, 5001, th.getMessage(), null, "BODY_NULL_BODY", 1L, 1L, th);
                } finally {
                    com.byazt.tf.pr.pr(gVar == null ? hw() : gVar.pr());
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Charset pr(vk vkVar) {
        try {
            return vkVar != null ? vkVar.pr(com.byazt.qm.vk.pr) : com.byazt.qm.vk.pr;
        } catch (Exception e) {
            return com.byazt.qm.vk.pr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public vk pr(yb ybVar) {
        try {
            return ybVar.c();
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.tf.x xVar, nt ntVar) {
        if (xVar != null && ntVar != null) {
            xVar.pr(ntVar.zo());
        }
    }
}
