(function() {
  "use strict";
  function define(target, name, value) {
    if (!target[name]) Object.defineProperty(target, name, { configurable: true, writable: true, value });
  }
  function replaceChildren() {
    var doc = this.ownerDocument || this, fragment = doc.createDocumentFragment();
    for (var i = 0; i < arguments.length; i++) {
      var child = arguments[i];
      fragment.appendChild(child instanceof Node ? child : doc.createTextNode(String(child)));
    }
    while (this.firstChild) this.removeChild(this.firstChild);
    this.appendChild(fragment);
  }
  [Element, DocumentFragment, Document].forEach(function(type) {
    define(type.prototype, "replaceChildren", replaceChildren);
  });
  define(Object, "hasOwn", function(o, k) {
    return Object.prototype.hasOwnProperty.call(o, k);
  });
  define(Array.prototype, "at", function(n) {
    n = Math.trunc(Number(n) || 0);
    return this[n < 0 ? this.length + n : n];
  });
  define(String.prototype, "replaceAll", function(search, replacement) {
    if (search instanceof RegExp) {
      if (!search.global) throw new TypeError("replaceAll requires a global expression");
      return this.replace(search, replacement);
    }
    return this.replace(new RegExp(String(search).replace(/[.*+?^${}()|[\]\\]/g, "\\$&"), "g"), replacement);
  });
  define(window, "structuredClone", function(value) {
    var seen = /* @__PURE__ */ new Map();
    function copy(v) {
      if (v === null || typeof v !== "object") return v;
      if (seen.has(v)) return seen.get(v);
      if (v instanceof Date) return new Date(v.getTime());
      if (v instanceof ArrayBuffer) return v.slice(0);
      if (ArrayBuffer.isView(v)) return v instanceof DataView ? new DataView(v.buffer.slice(v.byteOffset, v.byteOffset + v.byteLength)) : new v.constructor(v);
      var out = v instanceof Map ? /* @__PURE__ */ new Map() : v instanceof Set ? /* @__PURE__ */ new Set() : Array.isArray(v) ? [] : {};
      seen.set(v, out);
      if (v instanceof Map) v.forEach(function(x, k) {
        out.set(copy(k), copy(x));
      });
      else if (v instanceof Set) v.forEach(function(x) {
        out.add(copy(x));
      });
      else Object.keys(v).forEach(function(k) {
        out[k] = copy(v[k]);
      });
      return out;
    }
    return copy(value);
  });
  if (window.crypto) define(crypto, "randomUUID", function() {
    var b = new Uint8Array(16);
    crypto.getRandomValues(b);
    b[6] = b[6] & 15 | 64;
    b[8] = b[8] & 63 | 128;
    var s = Array.from(b, function(v) {
      return v.toString(16).padStart(2, "0");
    }).join("");
    return s.slice(0, 8) + "-" + s.slice(8, 12) + "-" + s.slice(12, 16) + "-" + s.slice(16, 20) + "-" + s.slice(20);
  });
  if (window.parent !== window) {
    let report = function(message) {
      parent.postMessage({ channel: "cotton-theatre", type: "load-error", payload: { message: String(message || "角色初始化失败").slice(0, 180) } }, "*");
    };
    window.addEventListener("error", function(e) {
      report(e.message);
    });
    window.addEventListener("unhandledrejection", function(e) {
      report(e.reason && e.reason.message || e.reason);
    });
  }
})();
(function() {
  "use strict";
  function add(o, k, v) {
    if (!o[k]) Object.defineProperty(o, k, { value: v, writable: true, configurable: true });
  }
  add(Object, "fromEntries", function(values) {
    var result = {};
    Array.from(values).forEach(function(row) {
      Object.defineProperty(result, row[0], { value: row[1], enumerable: true, configurable: true, writable: true });
    });
    return result;
  });
  add(Array.prototype, "flat", function(depth) {
    depth = depth === void 0 ? 1 : Number(depth) || 0;
    var result = [];
    this.forEach(function(v) {
      if (Array.isArray(v) && depth > 0) result.push.apply(result, Array.prototype.flat.call(v, depth - 1));
      else result.push(v);
    });
    return result;
  });
  add(Array.prototype, "flatMap", function(fn, owner) {
    return this.map(fn, owner).flat();
  });
  add(Promise.prototype, "finally", function(fn) {
    var C = this.constructor;
    return this.then(function(v) {
      return C.resolve(fn()).then(function() {
        return v;
      });
    }, function(e) {
      return C.resolve(fn()).then(function() {
        throw e;
      });
    });
  });
  add(Promise, "allSettled", function(values) {
    return Promise.all(Array.from(values).map(function(v) {
      return Promise.resolve(v).then(function(value) {
        return { status: "fulfilled", value };
      }, function(reason) {
        return { status: "rejected", reason };
      });
    }));
  });
  add(HTMLImageElement.prototype, "decode", function() {
    var im = this;
    return new Promise(function(resolve, reject) {
      if (im.complete) {
        if (im.naturalWidth) resolve();
        else reject(Error("图片未能解码"));
        return;
      }
      function done() {
        im.removeEventListener("load", ok);
        im.removeEventListener("error", fail);
      }
      function ok() {
        done();
        resolve();
      }
      function fail() {
        done();
        reject(Error("图片未能解码"));
      }
      im.addEventListener("load", ok);
      im.addEventListener("error", fail);
    });
  });
  if (!window.ResizeObserver) {
    window.ResizeObserver = function(callback) {
      this.callback = callback;
      this.nodes = [];
      this.timer = null;
    };
    ResizeObserver.prototype.observe = function(node) {
      var self = this;
      if (this.nodes.some(function(n) {
        return n.node === node;
      })) return;
      this.nodes.push({ node, w: -1, h: -1 });
      if (!this.timer) this.timer = setInterval(function() {
        var changed = [];
        self.nodes.forEach(function(v) {
          var r = v.node.getBoundingClientRect();
          if (v.w !== r.width || v.h !== r.height) {
            v.w = r.width;
            v.h = r.height;
            changed.push({ target: v.node, contentRect: r });
          }
        });
        if (changed.length) self.callback(changed, self);
      }, 200);
    };
    ResizeObserver.prototype.unobserve = function(node) {
      this.nodes = this.nodes.filter(function(v) {
        return v.node !== node;
      });
      if (!this.nodes.length) this.disconnect();
    };
    ResizeObserver.prototype.disconnect = function() {
      clearInterval(this.timer);
      this.timer = null;
      this.nodes = [];
    };
  }
  if (!window.requestIdleCallback) window.requestIdleCallback = function(cb) {
    return setTimeout(function() {
      cb({ didTimeout: false, timeRemaining: function() {
        return 5;
      } });
    }, 1);
  };
  if (!window.cancelIdleCallback) window.cancelIdleCallback = clearTimeout;
})();
(function() {
  "use strict";
  function read(blob, kind) {
    return new Promise(function(resolve, reject) {
      var r = new FileReader();
      r.onload = function() {
        resolve(r.result);
      };
      r.onerror = function() {
        reject(r.error || Error("文件无法读取"));
      };
      if (kind === "text") r.readAsText(blob);
      else r.readAsArrayBuffer(blob);
    });
  }
  if (!Blob.prototype.arrayBuffer) Blob.prototype.arrayBuffer = function() {
    return read(this, "buffer");
  };
  if (!Blob.prototype.text) Blob.prototype.text = function() {
    return read(this, "text");
  };
})();
(function() {
  "use strict";
  if (window.HTMLDialogElement && HTMLDialogElement.prototype.close) {
    var close = HTMLDialogElement.prototype.close;
    HTMLDialogElement.prototype.close = function() {
      if (!this.hasAttribute("open")) return;
      return close.apply(this, arguments);
    };
  }
})();
(function() {
  "use strict";
  if (!window.queueMicrotask) window.queueMicrotask = function(callback) {
    if (typeof callback !== "function") throw new TypeError("Callback must be a function");
    Promise.resolve().then(callback).catch(function(error) {
      setTimeout(function() {
        throw error;
      }, 0);
    });
  };
})();
(function() {
  "use strict";
  window.CottonCompat = window.CottonCompat || {};
  window.CottonCompat.afterAnimation = function(animation, duration, callback) {
    var ended = false, timer;
    function done() {
      if (ended) return;
      ended = true;
      clearTimeout(timer);
      if (animation && animation.removeEventListener) {
        animation.removeEventListener("finish", done);
        animation.removeEventListener("cancel", done);
      }
      if (animation && animation.cancel) {
        try {
          animation.cancel();
        } catch (e) {
        }
      }
      callback();
    }
    if (!animation) {
      done();
      return;
    }
    timer = setTimeout(done, Math.max(0, Number(duration) || 0) + 80);
    if (animation.addEventListener) {
      animation.addEventListener("finish", done);
      animation.addEventListener("cancel", done);
    }
    try {
      var finished = animation.finished;
      if (finished && typeof finished.then === "function") finished.then(done, done);
    } catch (e) {
    }
  };
})();
