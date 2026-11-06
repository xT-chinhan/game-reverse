package com.anythink.basead.webtemplet;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebView;
import com.anythink.core.common.d.t;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class g implements com.anythink.basead.webtemplet.adformat.c {
    protected Pattern a;
    protected Context c;
    protected WTWebView d;
    protected Handler e;
    private final String f = com.anythink.basead.f.g.i;
    protected final int b = 1;

    public g(WTWebView wTWebView) {
        this.c = wTWebView != null ? wTWebView.getContext().getApplicationContext() : t.b().g();
        this.d = wTWebView;
    }

    @Override // com.anythink.basead.webtemplet.adformat.c
    public final WebView a() {
        return this.d;
    }

    @Override // com.anythink.basead.webtemplet.adformat.c
    public final void a(WTWebView wTWebView) {
        this.d = wTWebView;
    }

    @Override // com.anythink.basead.webtemplet.adformat.c
    public final boolean a(String str) {
        if (!h.a(str)) {
            return false;
        }
        this.a = h.b(str);
        return true;
    }

    @Override // com.anythink.basead.webtemplet.adformat.c
    public final e b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = this.a.matcher(str);
        if (matcher.matches()) {
            e eVar = new e();
            int iGroupCount = matcher.groupCount();
            if (iGroupCount >= 5) {
                eVar.f = matcher.group(5);
            }
            if (iGroupCount >= 3) {
                eVar.d = matcher.group(1);
                eVar.g = matcher.group(2);
                eVar.e = matcher.group(3);
                eVar.a = this.d;
                return eVar;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0048  */
    @Override // com.anythink.basead.webtemplet.adformat.c
    public final void c(String str) {
        e eVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            eVar = null;
        } else {
            Matcher matcher = this.a.matcher(str);
            if (matcher.matches()) {
                eVar = new e();
                int iGroupCount = matcher.groupCount();
                if (iGroupCount >= 5) {
                    eVar.f = matcher.group(5);
                }
                if (iGroupCount >= 3) {
                    eVar.d = matcher.group(1);
                    eVar.g = matcher.group(2);
                    eVar.e = matcher.group(3);
                    eVar.a = this.d;
                } else {
                    eVar = null;
                }
            } else {
                eVar = null;
            }
        }
        if (eVar == null) {
            return;
        }
        WTWebView wTWebView = eVar.a;
        String str2 = eVar.d;
        String str3 = eVar.e;
        String str4 = eVar.g;
        com.anythink.core.common.v.k.b(eVar.f);
        Object jsObject = eVar.a != null ? eVar.a.getJsObject(eVar.d) : null;
        if (jsObject == null) {
            return;
        }
        try {
            com.anythink.basead.webtemplet.b.a.f fVarA = com.anythink.basead.webtemplet.b.a.a(this.c.getClassLoader(), jsObject.getClass().getName()).a(eVar.e, Object.class, String.class);
            fVarA.a();
            if (jsObject == null || !(jsObject instanceof d)) {
                return;
            }
            eVar.c = fVarA;
            eVar.b = jsObject;
            t.b().b(new AnonymousClass1(eVar));
        } catch (Throwable unused) {
        }
    }

    @Override // com.anythink.basead.webtemplet.adformat.c
    public final void a(Pattern pattern) {
        this.a = pattern;
    }

    private void a(e eVar) {
        Object jsObject = eVar.a == null ? null : eVar.a.getJsObject(eVar.d);
        if (jsObject == null) {
            return;
        }
        try {
            com.anythink.basead.webtemplet.b.a.f fVarA = com.anythink.basead.webtemplet.b.a.a(this.c.getClassLoader(), jsObject.getClass().getName()).a(eVar.e, Object.class, String.class);
            fVarA.a();
            if (jsObject == null || !(jsObject instanceof d)) {
                return;
            }
            eVar.c = fVarA;
            eVar.b = jsObject;
            t.b().b(new AnonymousClass1(eVar));
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.webtemplet.g$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ e a;

        AnonymousClass1(e eVar) {
            this.a = eVar;
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
        @Override // java.lang.Runnable
        public final void run() {
            try {
                Object obj = this.a.b;
                com.anythink.basead.webtemplet.b.a.f fVar = this.a.c;
                if (fVar == null || obj == null) {
                    return;
                }
                Object[] objArr = new Object[2];
                e eVar = this.a;
                objArr[0] = eVar;
                objArr[1] = TextUtils.isEmpty(eVar.f) ? "{}" : this.a.f;
                fVar.a(obj, objArr);
            } catch (Throwable unused) {
            }
        }
    }

    private void b(e eVar) {
        t.b().b(new AnonymousClass1(eVar));
    }
}
