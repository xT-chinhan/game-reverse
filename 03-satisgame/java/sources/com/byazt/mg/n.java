package com.byazt.mg;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.byazt.qp.d;
import com.byazt.qp.q;
import com.byazt.qp.tj;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2557, 19})
public class n {
    public final com.byazt.qp.n n;
    public List<String> qg;
    public tj s;

    public void n(tj tjVar) {
        this.s = tjVar;
    }

    public n(com.byazt.qp.n nVar) {
        this.n = nVar;
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
    public void n(Function function, boolean z) {
        String name;
        Object objApply = function.apply(null);
        if (objApply instanceof Map) {
            int iN = com.byazt.qp.n.n(function);
            for (Map.Entry entry : new ArrayList(((Map) objApply).entrySet())) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                d dVarN = this.n.x().n(str);
                if (dVarN != null) {
                    if (!TextUtils.equals(str, dVarN.w)) {
                        if (this.s != null) {
                            JSONObject jSONObject = new JSONObject();
                            if (value != null) {
                                try {
                                    name = value.getClass().getName();
                                } catch (JSONException unused) {
                                }
                            } else {
                                name = AbstractJsonLexerKt.NULL;
                            }
                            q qVarN = q.n();
                            jSONObject.put("model_key", dVarN.w);
                            jSONObject.put("origin_key", str);
                            jSONObject.put(LiveConfigKey.ORIGIN, name);
                            jSONObject.put("newRegAts", function);
                            jSONObject.put("old_sdk_version", iN);
                            jSONObject.put("current_sdk_version", qVarN.qg());
                            jSONObject.put("currentAts", qVarN);
                            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, "key not equals model_key");
                            this.s.n(dVarN, value, null, true, jSONObject, null);
                        }
                    } else if (value != null && dVarN.n((com.byazt.vf.n) null) == null) {
                        if (iN < 7500) {
                            n(str, dVarN, value, function, iN);
                        } else if (z) {
                            n(str, dVarN, value, function, iN, false);
                        }
                    }
                }
            }
        }
    }

    private boolean n() {
        return getClass().getName().contains("byaztp");
    }

    @Deprecated
    private void n(String str, d dVar, Object obj, Function function, int i) {
        if (dVar.l) {
            List<String> list = this.qg;
            if ((list == null || !list.contains(dVar.w)) && dVar.q <= 0) {
                n(str, dVar, obj, function, i, true);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0040  */
    /* JADX WARN: Code duplicated, block: B:54:0x0159  */
    /* JADX WARN: Code duplicated, block: B:73:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void n(String str, d dVar, Object obj, Function function, int i, boolean z) {
        boolean z2;
        Object objN;
        JSONObject jSONObject;
        Throwable th;
        Object obj2;
        JSONObject jSONObject2;
        tj tjVar;
        Object obj3;
        boolean z3;
        int i2 = 0;
        try {
            String name = obj.getClass().getName();
            boolean z4 = true;
            boolean z5 = obj.getClass().getClassLoader() == getClass().getClassLoader();
            if (n()) {
                if (z5) {
                    z3 = true;
                } else {
                    try {
                        if (name.contains("byaztp")) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        obj3 = obj;
                        z2 = false;
                        jSONObject = null;
                        objN = obj3;
                        th = th;
                        obj2 = objN;
                        jSONObject2 = jSONObject;
                        z2 = z2;
                        tjVar = this.s;
                        if (tjVar != null) {
                            tjVar.n(dVar, obj, obj2, z2, jSONObject2, th);
                        }
                    }
                }
                z2 = z3;
            } else {
                z2 = false;
            }
            if (z2) {
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        Field[] declaredFields = obj.getClass().getDeclaredFields();
                        JSONObject jSONObject4 = new JSONObject();
                        int length = declaredFields.length;
                        while (i2 < length) {
                            Field field = declaredFields[i2];
                            field.setAccessible(z4);
                            obj3 = obj;
                            try {
                                Object obj4 = field.get(obj3);
                                jSONObject4.put(field.getName(), field.getType().getName());
                                jSONObject4.put(field.getName() + "_v", obj4);
                                i2++;
                                z4 = true;
                            } catch (Throwable unused) {
                            }
                        }
                        obj3 = obj;
                        jSONObject3.put("fieldInfo", jSONObject4);
                    } catch (Throwable unused2) {
                        obj3 = obj;
                    }
                    try {
                        q qVarN = q.n();
                        jSONObject3.put("model_key", dVar.w);
                        jSONObject3.put("origin_key", str);
                        jSONObject3.put("sameClassLoader", z5);
                        jSONObject3.put(LiveConfigKey.ORIGIN, name);
                        jSONObject3.put("newRegAts", function);
                        jSONObject3.put("old_sdk_version", i);
                        jSONObject3.put("current_sdk_version", qVarN.qg());
                        jSONObject3.put("currentAts", qVarN);
                        jSONObject3.put(NotificationCompat.CATEGORY_MESSAGE, name + " is not plugin Clazz");
                        jSONObject2 = jSONObject3;
                        obj2 = obj3;
                    } catch (Throwable th3) {
                        th = th3;
                        jSONObject = jSONObject3;
                        objN = obj3;
                        th = th;
                        obj2 = objN;
                        jSONObject2 = jSONObject;
                        z2 = z2;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    objN = obj;
                    jSONObject = null;
                    th = th;
                    obj2 = objN;
                    jSONObject2 = jSONObject;
                    z2 = z2;
                }
            } else {
                try {
                    if (z) {
                        objN = this.n.q().qg(dVar, null, obj, function, true);
                    } else {
                        objN = this.n.q().n(dVar, null, obj, function, true);
                    }
                    try {
                        new StringBuilder("reuse service success: ").append(dVar.w).append(", service = ").append(objN).append(" ,ats = ").append(function);
                        obj2 = objN;
                        jSONObject2 = null;
                    } catch (Throwable th5) {
                        th = th5;
                        jSONObject = null;
                        th = th;
                        obj2 = objN;
                        jSONObject2 = jSONObject;
                        z2 = z2;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    objN = obj;
                    jSONObject = null;
                    th = th;
                    obj2 = objN;
                    jSONObject2 = jSONObject;
                    z2 = z2;
                    tjVar = this.s;
                    if (tjVar != null) {
                        tjVar.n(dVar, obj, obj2, z2, jSONObject2, th);
                    }
                }
            }
            th = null;
        } catch (Throwable th7) {
            th = th7;
            z2 = false;
        }
        tjVar = this.s;
        if (tjVar != null) {
            tjVar.n(dVar, obj, obj2, z2, jSONObject2, th);
        }
    }
}
