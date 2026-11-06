(function() {
  "use strict";
  function rgbToHSV(hex2) {
    const a = [1, 3, 5].map((i) => parseInt(hex2.slice(i, i + 2), 16) / 255), max = Math.max(...a), min = Math.min(...a), d = max - min;
    let h = 0;
    if (d) {
      if (max === a[0]) h = ((a[1] - a[2]) / d + 6) % 6;
      else if (max === a[1]) h = (a[2] - a[0]) / d + 2;
      else h = (a[0] - a[1]) / d + 4;
    }
    return [h * 60, max ? d / max : 0, max];
  }
  function hex(h, s, v) {
    const c = v * s, x = c * (1 - Math.abs(h / 60 % 2 - 1)), m = v - c, k = Math.floor(h / 60) % 6, a = [[c, x, 0], [x, c, 0], [0, c, x], [0, x, c], [x, 0, c], [c, 0, x]][k];
    return "#" + a.map((n) => Math.round((n + m) * 255).toString(16).padStart(2, "0")).join("");
  }
  function attach(root, before, onChange) {
    let hsv = [270, 0.2, 0.8];
    const area = document.createElement("div");
    area.className = "paint-picker";
    area.innerHTML = '<div class="paint-square" role="slider" tabindex="0" aria-label="饱和度和明度"><i></i></div><input class="paint-hue" aria-label="色相" type="range" min="0" max="359" value="270">';
    before.before(area);
    const square = area.firstElementChild, mark = square.firstElementChild, hue = area.lastElementChild;
    function sync(color) {
      const next = rgbToHSV(color);
      if (next[1] > 1e-3) hsv[0] = next[0];
      hsv[1] = next[1];
      hsv[2] = next[2];
      hue.value = hsv[0];
      square.style.background = "linear-gradient(to top,#000,transparent),linear-gradient(to right,#fff,hsl(" + hsv[0] + ",100%,50%))";
      mark.style.left = hsv[1] * 100 + "%";
      mark.style.top = (1 - hsv[2]) * 100 + "%";
      square.setAttribute("aria-valuetext", color);
    }
    function apply() {
      const color = hex(...hsv);
      sync(color);
      onChange(color);
    }
    hue.oninput = () => {
      hsv[0] = Number(hue.value);
      apply();
    };
    function move(e) {
      const r = square.getBoundingClientRect();
      hsv[1] = Math.max(0, Math.min(1, (e.clientX - r.left) / r.width));
      hsv[2] = 1 - Math.max(0, Math.min(1, (e.clientY - r.top) / r.height));
      apply();
    }
    square.onpointerdown = (e) => {
      e.preventDefault();
      square.setPointerCapture(e.pointerId);
      move(e);
    };
    square.onpointermove = (e) => {
      if (square.hasPointerCapture(e.pointerId)) move(e);
    };
    square.onkeydown = (e) => {
      if (!["ArrowLeft", "ArrowRight", "ArrowUp", "ArrowDown"].includes(e.key)) return;
      e.preventDefault();
      hsv[1] = Math.max(0, Math.min(1, hsv[1] + (e.key === "ArrowLeft" ? -0.01 : e.key === "ArrowRight" ? 0.01 : 0)));
      hsv[2] = Math.max(0, Math.min(1, hsv[2] + (e.key === "ArrowDown" ? -0.01 : e.key === "ArrowUp" ? 0.01 : 0)));
      apply();
    };
    sync("#c4b4cd");
    return { sync };
  }
  const style = document.createElement("style");
  style.textContent = ".paint-square{height:175px;position:relative;border-radius:12px;touch-action:none;cursor:crosshair;overflow:hidden}.paint-square i{position:absolute;width:12px;height:12px;border-radius:50%;border:2px solid white;box-shadow:0 0 0 1px #687765;transform:translate(-50%,-50%);pointer-events:none}.paint-hue{appearance:none;-webkit-appearance:none;width:100%!important;height:17px;border-radius:20px;background:linear-gradient(to right,red,#ff0,#0f0,#0ff,#00f,#f0f,red);margin:12px 0;touch-action:pan-x}.paint-hue::-webkit-slider-thumb{appearance:none;-webkit-appearance:none;width:19px;height:23px;border-radius:10px;border:2px solid #fff;background:transparent;box-shadow:0 0 1px #333}.paint-picker{margin:12px 0}";
  document.head.append(style);
  let box, control, currentCallback, favorites = [];
  try {
    favorites = JSON.parse(localStorage.getItem("yuzu-saved-colors-v1") || "[]").filter((c) => /^#[a-f0-9]{6}$/i.test(c));
  } catch (e) {
  }
  function open(value, apply) {
    try {
      favorites = JSON.parse(localStorage.getItem("yuzu-saved-colors-v1") || "[]");
    } catch (e) {
    }
    if (!box) {
      box = document.createElement("dialog");
      box.className = "common-paint-dialog";
      box.innerHTML = '<header><strong>自由选色</strong><button type="button" data-close aria-label="关闭选色">×</button></header><small class="adjust-scroll-hint">可下滑</small><label>HEX<input class="paint-hex" maxlength="7"></label><div class="paint-saved"></div><footer><button type="button" data-save>保存颜色</button><button type="button" data-close>完成</button></footer>';
      document.body.append(box);
      control = attach(box, box.querySelector("label"), (v) => {
        box.querySelector("input.paint-hex").value = v;
        currentCallback(v);
      });
      box.querySelector("input.paint-hex").onchange = function() {
        if (/^#[a-f0-9]{6}$/i.test(this.value)) {
          control.sync(this.value);
          currentCallback(this.value);
        }
      };
      for (const b of box.querySelectorAll("[data-close]")) b.onclick = () => box.close();
      box.querySelector("[data-save]").onclick = () => {
        const value2 = box.querySelector("input.paint-hex").value;
        if (!/^#[a-f0-9]{6}$/i.test(value2)) return;
        favorites = [value2, ...favorites.filter((c) => c !== value2)];
        localStorage.setItem("yuzu-saved-colors-v1", JSON.stringify(favorites));
        drawSaved();
      };
      const s = document.createElement("style");
      s.textContent = ".common-paint-dialog{width:300px;max-width:calc(100vw - 32px);box-sizing:border-box;padding:20px;border:1px solid #d7e0d1;border-radius:20px;background:#faf9f2;color:#73866f;font:14px sans-serif}.common-paint-dialog::backdrop{background:#46534766}.common-paint-dialog header,.common-paint-dialog footer{display:flex;justify-content:space-between;gap:10px}.common-paint-dialog button{padding:9px 13px;border:1px solid #d6e0cf;border-radius:10px;background:#e8eedf;color:inherit;font:inherit}.paint-hex{margin:5px 10px;width:100px;border:1px solid #d9dfd3;border-radius:8px;padding:7px;color:inherit}.paint-saved{display:flex;flex-wrap:wrap;gap:8px;margin:12px 0}.paint-saved button{width:28px;height:28px;border-radius:50%;padding:0}";
      document.head.append(s);
    }
    currentCallback = apply;
    box.querySelector("input.paint-hex").value = value;
    control.sync(value);
    drawSaved();
    box.showModal();
  }
  function askDelete(color) {
    const ask = document.createElement("dialog");
    ask.className = "common-paint-dialog";
    ask.innerHTML = '<p>删除这个颜色？</p><footer><button type="button">取消</button><button type="button">删除</button></footer>';
    document.body.append(ask);
    const buttons = ask.querySelectorAll("button");
    buttons[0].onclick = () => ask.close();
    buttons[1].onclick = () => {
      var _a;
      if ((_a = window.CottonFreeColors) == null ? void 0 : _a.removeColor) CottonFreeColors.removeColor(color);
      favorites = favorites.filter((c) => c !== color);
      localStorage.setItem("yuzu-saved-colors-v1", JSON.stringify(favorites));
      drawSaved();
      ask.close();
    };
    ask.onclose = () => ask.remove();
    ask.showModal();
  }
  function drawSaved() {
    const el = box.querySelector(".paint-saved");
    el.replaceChildren();
    for (const color of favorites) {
      const b = document.createElement("button");
      b.type = "button";
      b.style.background = color;
      b.title = color;
      let timer = 0, held = false;
      b.onclick = () => {
        if (!held) {
          control.sync(color);
          box.querySelector("input.paint-hex").value = color;
          currentCallback(color);
        }
        held = false;
      };
      b.onpointerdown = () => {
        held = false;
        timer = setTimeout(() => {
          held = true;
          askDelete(color);
        }, 550);
      };
      for (const t of ["pointerup", "pointercancel", "pointerleave"]) b.addEventListener(t, () => clearTimeout(timer));
      el.append(b);
    }
  }
  window.CottonPaintPicker = { attach, open };
  document.addEventListener("click", (e) => {
    var _a;
    const input = e.target;
    if ((input == null ? void 0 : input.tagName) !== "INPUT" || input.type !== "color") return;
    e.preventDefault();
    const choose = ((_a = window.CottonFreeColors) == null ? void 0 : _a.open) || open;
    choose(input.value, (color) => {
      input.value = color;
      input.dispatchEvent(new Event("input", { bubbles: true }));
      input.dispatchEvent(new Event("change", { bubbles: true }));
    });
  }, true);
})();
