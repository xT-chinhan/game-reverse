package com.byazt.uy;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.byazt.zs.g;
import com.byazt.zs.k;
import com.byazt.zs.uc;
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
@com.byazt.vzx.pr(pr = {0, 1, 1127, 37})
public class pr {
    public k hn;
    public List<String> hw;
    public final com.byazt.zs.pr pr;

    public void pr(k kVar) {
        this.hn = kVar;
    }

    public pr(com.byazt.zs.pr prVar) {
        this.pr = prVar;
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
    public void pr(Function function, boolean z) {
        String name;
        Object objApply = function.apply(null);
        if (objApply instanceof Map) {
            int iPr = com.byazt.zs.pr.pr(function);
            for (Map.Entry entry : new ArrayList(((Map) objApply).entrySet())) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                g gVarPr = this.pr.aj().pr(str);
                if (gVarPr != null) {
                    if (!TextUtils.equals(str, gVarPr.uc)) {
                        if (this.hn != null) {
                            JSONObject jSONObject = new JSONObject();
                            if (value != null) {
                                try {
                                    name = value.getClass().getName();
                                } catch (JSONException e) {
                                }
                            } else {
                                name = AbstractJsonLexerKt.NULL;
                            }
                            uc ucVarPr = uc.pr();
                            jSONObject.put("model_key", gVarPr.uc);
                            jSONObject.put("origin_key", str);
                            jSONObject.put(LiveConfigKey.ORIGIN, name);
                            jSONObject.put("newRegAts", function);
                            jSONObject.put("old_sdk_version", iPr);
                            jSONObject.put("current_sdk_version", ucVarPr.hw());
                            jSONObject.put("currentAts", ucVarPr);
                            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, "key not equals model_key");
                            this.hn.pr(gVarPr, value, null, true, jSONObject, null);
                        }
                    } else if (value != null && gVarPr.pr((com.byazt.vkw.pr) null) == null) {
                        if (iPr < 7500) {
                            pr(str, gVarPr, value, function, iPr);
                        } else if (z) {
                            pr(str, gVarPr, value, function, iPr, false);
                        }
                    }
                }
            }
        }
    }

    private boolean pr() {
        return getClass().getName().contains("byaztp");
    }

    @Deprecated
    private void pr(String str, g gVar, Object obj, Function function, int i) {
        if (!gVar.c) {
            return;
        }
        List<String> list = this.hw;
        if ((list != null && list.contains(gVar.uc)) || gVar.x > 0) {
            return;
        }
        pr(str, gVar, obj, function, i, true);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0044  */
    /* JADX WARN: Code duplicated, block: B:57:0x0165  */
    /* JADX WARN: Code duplicated, block: B:75:? A[RETURN, SYNTHETIC] */
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
    public void pr(String str, g gVar, Object obj, Function function, int i, boolean z) {
        boolean z2;
        Object objPr;
        JSONObject jSONObject;
        Throwable th;
        Object obj2;
        JSONObject jSONObject2;
        boolean z3;
        k kVar;
        Object obj3;
        boolean z4;
        int i2 = 0;
        try {
            String name = obj.getClass().getName();
            boolean z5 = true;
            boolean z6 = obj.getClass().getClassLoader() == getClass().getClassLoader();
            if (!pr()) {
                z2 = false;
            } else {
                if (z6) {
                    z4 = true;
                } else {
                    try {
                        if (!name.contains("byaztp")) {
                            z4 = false;
                        } else {
                            z4 = true;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        obj3 = obj;
                        z2 = false;
                        jSONObject = null;
                        objPr = obj3;
                        th = th;
                        obj2 = objPr;
                        jSONObject2 = jSONObject;
                        z3 = z2;
                        kVar = this.hn;
                        if (kVar != null) {
                            kVar.pr(gVar, obj, obj2, z3, jSONObject2, th);
                        }
                    }
                }
                z2 = z4;
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
                            field.setAccessible(z5);
                            obj3 = obj;
                            Object obj4 = field.get(obj3);
                            jSONObject4.put(field.getName(), field.getType().getName());
                            jSONObject4.put(field.getName() + "_v", obj4);
                            i2++;
                            z5 = true;
                        }
                        obj3 = obj;
                        jSONObject3.put("fieldInfo", jSONObject4);
                    } catch (Throwable th3) {
                        obj3 = obj;
                    }
                    try {
                        uc ucVarPr = uc.pr();
                        jSONObject3.put("model_key", gVar.uc);
                        jSONObject3.put("origin_key", str);
                        jSONObject3.put("sameClassLoader", z6);
                        jSONObject3.put(LiveConfigKey.ORIGIN, name);
                        jSONObject3.put("newRegAts", function);
                        jSONObject3.put("old_sdk_version", i);
                        jSONObject3.put("current_sdk_version", ucVarPr.hw());
                        jSONObject3.put("currentAts", ucVarPr);
                        jSONObject3.put(NotificationCompat.CATEGORY_MESSAGE, name + " is not plugin Clazz");
                        jSONObject2 = jSONObject3;
                        z3 = z2;
                        obj2 = obj3;
                        th = null;
                    } catch (Throwable th4) {
                        th = th4;
                        jSONObject = jSONObject3;
                        objPr = obj3;
                        th = th;
                        obj2 = objPr;
                        jSONObject2 = jSONObject;
                        z3 = z2;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    objPr = obj;
                    jSONObject = null;
                    th = th;
                    obj2 = objPr;
                    jSONObject2 = jSONObject;
                    z3 = z2;
                }
            } else {
                try {
                    if (z) {
                        objPr = this.pr.uc().hw(gVar, null, obj, function, true);
                    } else {
                        objPr = this.pr.uc().pr(gVar, null, obj, function, true);
                    }
                    try {
                        new StringBuilder("reuse service success: ").append(gVar.uc).append(", service = ").append(objPr).append(" ,ats = ").append(function);
                        obj2 = objPr;
                        z3 = z2;
                        jSONObject2 = null;
                        th = null;
                    } catch (Throwable th6) {
                        th = th6;
                        jSONObject = null;
                        th = th;
                        obj2 = objPr;
                        jSONObject2 = jSONObject;
                        z3 = z2;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    objPr = obj;
                    jSONObject = null;
                    th = th;
                    obj2 = objPr;
                    jSONObject2 = jSONObject;
                    z3 = z2;
                    kVar = this.hn;
                    if (kVar != null) {
                        kVar.pr(gVar, obj, obj2, z3, jSONObject2, th);
                    }
                }
            }
        } catch (Throwable th8) {
            th = th8;
            z2 = false;
        }
        kVar = this.hn;
        if (kVar != null) {
            kVar.pr(gVar, obj, obj2, z3, jSONObject2, th);
        }
    }
}
