package com.smartdigimkt.x2;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.bytedance.pangle.LocalBroadcastManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final Object f = new Object();
    public static d g;
    public final Context a;
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public final ArrayList d = new ArrayList();
    public final a e;

    public d(Context context) {
        this.a = context;
        this.e = new a(this, context.getMainLooper());
    }

    public static d a(Context context) {
        d dVar;
        synchronized (f) {
            if (g == null) {
                g = new d(context.getApplicationContext());
            }
            dVar = g;
        }
        return dVar;
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
    public final void a(Intent intent) {
        int i;
        String str;
        ArrayList arrayList;
        ArrayList arrayList2;
        String str2;
        boolean z;
        synchronized (this.b) {
            String action = intent.getAction();
            String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z2 = true;
            boolean z3 = (intent.getFlags() & 8) != 0;
            if (z3) {
                intent.toString();
            }
            ArrayList arrayList3 = (ArrayList) this.c.get(intent.getAction());
            if (arrayList3 != null) {
                if (z3) {
                    arrayList3.toString();
                }
                ArrayList arrayList4 = null;
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    c cVar = (c) arrayList3.get(i2);
                    if (z3) {
                        Objects.toString(cVar.a);
                    }
                    if (cVar.c) {
                        i = i2;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = strResolveTypeIfNeeded;
                        arrayList = arrayList4;
                        z = z2;
                    } else {
                        IntentFilter intentFilter = cVar.a;
                        String str3 = action;
                        String str4 = strResolveTypeIfNeeded;
                        i = i2;
                        str = action;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        str2 = strResolveTypeIfNeeded;
                        z = z2;
                        int iMatch = intentFilter.match(str3, str4, scheme, data, categories, LocalBroadcastManager.TAG);
                        if (iMatch >= 0) {
                            if (z3) {
                                Integer.toHexString(iMatch);
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(cVar);
                            cVar.c = z;
                        }
                        i2 = i + 1;
                        z2 = z;
                        action = str;
                        arrayList3 = arrayList2;
                        strResolveTypeIfNeeded = str2;
                    }
                    arrayList4 = arrayList;
                    i2 = i + 1;
                    z2 = z;
                    action = str;
                    arrayList3 = arrayList2;
                    strResolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                boolean z4 = z2;
                if (arrayList5 != null) {
                    for (int i3 = 0; i3 < arrayList5.size(); i3++) {
                        ((c) arrayList5.get(i3)).c = false;
                    }
                    this.d.add(new b(intent, arrayList5));
                    if (!this.e.hasMessages(z4 ? 1 : 0)) {
                        this.e.sendEmptyMessage(z4 ? 1 : 0);
                    }
                }
            }
        }
    }
}
