package org.joor;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.StringWriter;
import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.tools.DiagnosticListener;
import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/* JADX INFO: loaded from: classes3.dex */
class Compile {

    @FunctionalInterface
    interface ThrowingBiFunction<T, U, R> {
        R apply(T t, U u) throws Exception;
    }

    Compile() {
    }

    static Class<?> compile(String className, String content, CompileOptions compileOptions) {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        final ClassLoader cl = lookup.lookupClass().getClassLoader();
        try {
            return cl.loadClass(className);
        } catch (ClassNotFoundException e) {
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            try {
                ClassFileManager fileManager = new ClassFileManager(compiler.getStandardFileManager((DiagnosticListener) null, (Locale) null, (Charset) null));
                List<CharSequenceJavaFileObject> files = new ArrayList<>();
                files.add(new CharSequenceJavaFileObject(className, content));
                StringWriter out = new StringWriter();
                List<String> options = new ArrayList<>(compileOptions.options);
                if (!options.contains("-classpath")) {
                    StringBuilder classpath = new StringBuilder();
                    String separator = System.getProperty("path.separator");
                    String prop = System.getProperty("java.class.path");
                    if (prop != null) {
                        try {
                            if (!"".equals(prop)) {
                                classpath.append(prop);
                            }
                        } catch (ReflectException e2) {
                            throw e2;
                        } catch (Exception e3) {
                            e = e3;
                            throw new ReflectException("Error while compiling " + className, e);
                        }
                    }
                    if (cl instanceof URLClassLoader) {
                        URL[] uRLs = ((URLClassLoader) cl).getURLs();
                        try {
                            int length = uRLs.length;
                            int i = 0;
                            while (i < length) {
                                try {
                                    URL url = uRLs[i];
                                    if (classpath.length() > 0) {
                                        classpath.append(separator);
                                    }
                                    int i2 = length;
                                    String separator2 = separator;
                                    String separator3 = url.getProtocol();
                                    if ("file".equals(separator3)) {
                                        classpath.append(new File(url.toURI()));
                                    }
                                    i++;
                                    length = i2;
                                    separator = separator2;
                                } catch (ReflectException e4) {
                                    throw e4;
                                } catch (Exception e5) {
                                    e = e5;
                                    throw new ReflectException("Error while compiling " + className, e);
                                }
                            }
                        } catch (ReflectException e6) {
                            throw e6;
                        } catch (Exception e7) {
                            e = e7;
                        }
                    }
                    options.addAll(Arrays.asList("-classpath", classpath.toString()));
                }
                JavaCompiler.CompilationTask task = compiler.getTask(out, fileManager, (DiagnosticListener) null, options, (Iterable) null, files);
                if (!compileOptions.processors.isEmpty()) {
                    task.setProcessors(compileOptions.processors);
                }
                task.call();
                if (fileManager.isEmpty()) {
                    throw new ReflectException("Compilation error: " + out);
                }
                if (Reflect.CACHED_LOOKUP_CONSTRUCTOR == null) {
                    return null;
                }
                Class<?> result = fileManager.loadAndReturnMainClass(className, new ThrowingBiFunction() { // from class: org.joor.Compile$$ExternalSyntheticLambda0
                    @Override // org.joor.Compile.ThrowingBiFunction
                    public final Object apply(Object obj, Object obj2) {
                        return Compile.lambda$compile$0(cl, (String) obj, (byte[]) obj2);
                    }
                });
                return result;
            } catch (ReflectException e8) {
                throw e8;
            } catch (Exception e9) {
                e = e9;
            }
        }
    }

    static /* synthetic */ Class lambda$compile$0(ClassLoader cl, String name, byte[] bytes) throws Exception {
        return (Class) Reflect.on(cl).call("defineClass", name, bytes, 0, Integer.valueOf(bytes.length)).get();
    }

    static final class JavaFileObject extends SimpleJavaFileObject {
        final ByteArrayOutputStream os;

        JavaFileObject(String name, javax.tools.JavaFileObject.Kind kind) {
            super(URI.create("string:///" + name.replace('.', '/') + kind.extension), kind);
            this.os = new ByteArrayOutputStream();
        }

        byte[] getBytes() {
            return this.os.toByteArray();
        }

        public OutputStream openOutputStream() {
            return this.os;
        }

        public CharSequence getCharContent(boolean ignoreEncodingErrors) {
            return new String(this.os.toByteArray(), StandardCharsets.UTF_8);
        }
    }

    static final class ClassFileManager extends ForwardingJavaFileManager<StandardJavaFileManager> {
        private Map<String, byte[]> classes;
        private final Map<String, JavaFileObject> fileObjectMap;

        ClassFileManager(StandardJavaFileManager standardManager) {
            super(standardManager);
            this.fileObjectMap = new HashMap();
        }

        public JavaFileObject getJavaFileForOutput(JavaFileManager.Location location, String className, javax.tools.JavaFileObject.Kind kind, FileObject sibling) {
            JavaFileObject result = new JavaFileObject(className, kind);
            this.fileObjectMap.put(className, result);
            return result;
        }

        boolean isEmpty() {
            return this.fileObjectMap.isEmpty();
        }

        Map<String, byte[]> classes() {
            if (this.classes == null) {
                this.classes = new HashMap();
                for (Map.Entry<String, JavaFileObject> entry : this.fileObjectMap.entrySet()) {
                    this.classes.put(entry.getKey(), entry.getValue().getBytes());
                }
            }
            return this.classes;
        }

        Class<?> loadAndReturnMainClass(String mainClassName, ThrowingBiFunction<String, byte[], Class<?>> definer) throws Exception {
            Class<?> result = null;
            for (Map.Entry<String, byte[]> entry : classes().entrySet()) {
                Class<?> c = definer.apply(entry.getKey(), entry.getValue());
                if (mainClassName.equals(entry.getKey())) {
                    result = c;
                }
            }
            return result;
        }
    }

    static final class CharSequenceJavaFileObject extends SimpleJavaFileObject {
        final CharSequence content;

        public CharSequenceJavaFileObject(String className, CharSequence content) {
            super(URI.create("string:///" + className.replace('.', '/') + javax.tools.JavaFileObject.Kind.SOURCE.extension), javax.tools.JavaFileObject.Kind.SOURCE);
            this.content = content;
        }

        public CharSequence getCharContent(boolean ignoreEncodingErrors) {
            return this.content;
        }
    }
}
