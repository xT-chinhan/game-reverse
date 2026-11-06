using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Reflection;
using System.Runtime.CompilerServices;
using UnityEngine;
using UnityEngine.InputSystem;
using UnityEngine.InputSystem.Controls;
using UnityEngine.InputSystem.EnhancedTouch;

[assembly: CompilationRelaxations(8)]
[assembly: RuntimeCompatibility(WrapNonExceptionThrows = true)]
[assembly: Debuggable(DebuggableAttribute.DebuggingModes.IgnoreSymbolStoreSequencePoints)]
[assembly: AssemblyVersion("0.0.0.0")]
[CompilerGenerated]
[EditorBrowsable(EditorBrowsableState.Never)]
[GeneratedCode("Unity.MonoScriptGenerator.MonoScriptInfoGenerator", null)]
internal class UnitySourceGeneratedAssemblyMonoScriptTypes_v1
{
	private struct MonoScriptData
	{
		public byte[] FilePathsData;

		public byte[] TypesData;

		public int TotalTypes;

		public int TotalFiles;

		public bool IsEditorOnly;
	}

	[MethodImpl(MethodImplOptions.AggressiveInlining)]
	private static MonoScriptData Get()
	{
		return new MonoScriptData
		{
			FilePathsData = new byte[49]
			{
				0, 0, 0, 2, 0, 0, 0, 41, 92, 65,
				115, 115, 101, 116, 115, 92, 82, 117, 110, 116,
				105, 109, 101, 73, 110, 112, 117, 116, 92, 76,
				101, 103, 97, 99, 121, 73, 110, 112, 117, 116,
				67, 111, 109, 112, 97, 116, 46, 99, 115
			},
			TypesData = new byte[96]
			{
				0, 0, 0, 0, 38, 80, 114, 111, 106, 101,
				99, 116, 46, 82, 117, 110, 116, 105, 109, 101,
				73, 110, 112, 117, 116, 124, 76, 101, 103, 97,
				99, 121, 73, 110, 112, 117, 116, 67, 111, 109,
				112, 97, 116, 0, 0, 0, 0, 48, 80, 114,
				111, 106, 101, 99, 116, 46, 82, 117, 110, 116,
				105, 109, 101, 73, 110, 112, 117, 116, 46, 76,
				101, 103, 97, 99, 121, 73, 110, 112, 117, 116,
				67, 111, 109, 112, 97, 116, 124, 65, 120, 105,
				115, 83, 116, 97, 116, 101
			},
			TotalFiles = 1,
			TotalTypes = 2,
			IsEditorOnly = false
		};
	}
}
namespace Project.RuntimeInput;

public static class LegacyInputCompat
{
	private struct AxisState
	{
		public int frame;

		public float value;
	}

	private static readonly Dictionary<string, AxisState> axes = new Dictionary<string, AxisState>();

	public static int touchCount
	{
		get
		{
			//IL_0005: Unknown result type (might be due to invalid IL or missing references)
			//IL_000a: Unknown result type (might be due to invalid IL or missing references)
			EnableTouch();
			return Touch.activeTouches.Count;
		}
	}

	public static Vector3 mousePosition
	{
		get
		{
			//IL_0033: Unknown result type (might be due to invalid IL or missing references)
			//IL_0038: Unknown result type (might be due to invalid IL or missing references)
			//IL_0016: Unknown result type (might be due to invalid IL or missing references)
			//IL_001b: Unknown result type (might be due to invalid IL or missing references)
			//IL_001e: Unknown result type (might be due to invalid IL or missing references)
			//IL_0023: Unknown result type (might be due to invalid IL or missing references)
			//IL_000f: Unknown result type (might be due to invalid IL or missing references)
			if (Mouse.current == null)
			{
				if (touchCount <= 0)
				{
					return Vector3.zero;
				}
				Touch touch = GetTouch(0);
				return Vector2.op_Implicit(touch.position);
			}
			return Vector2.op_Implicit(((InputControl<Vector2>)(object)((Pointer)Mouse.current).position).ReadValue());
		}
	}

	[RuntimeInitializeOnLoadMethod(/*Could not decode attribute arguments.*/)]
	private static void Reset()
	{
		axes.Clear();
	}

	private static void EnableTouch()
	{
		if (!EnhancedTouchSupport.enabled)
		{
			EnhancedTouchSupport.Enable();
		}
	}

	public static Touch GetTouch(int index)
	{
		//IL_0005: Unknown result type (might be due to invalid IL or missing references)
		//IL_000a: Unknown result type (might be due to invalid IL or missing references)
		//IL_000e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Unknown result type (might be due to invalid IL or missing references)
		//IL_0016: Unknown result type (might be due to invalid IL or missing references)
		//IL_002e: Unknown result type (might be due to invalid IL or missing references)
		//IL_003c: Unknown result type (might be due to invalid IL or missing references)
		//IL_004a: Unknown result type (might be due to invalid IL or missing references)
		//IL_008c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0091: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a2: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b9: Unknown result type (might be due to invalid IL or missing references)
		EnableTouch();
		Touch val = Touch.activeTouches[index];
		Touch result = default;
		result.fingerId = val.touchId;
		result.position = val.screenPosition;
		result.rawPosition = val.screenPosition;
		result.deltaPosition = val.delta;
		result.deltaTime = Time.unscaledDeltaTime;
		result.tapCount = val.tapCount;
		result.pressure = val.pressure;
		result.maximumPossiblePressure = 1f;
		Vector2 radius = val.radius;
		result.radius = radius.magnitude;
		result.phase = Phase(val.phase);
		result.type = (TouchType)0;
		return result;
	}

	private static TouchPhase Phase(TouchPhase phase)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0002: Unknown result type (might be due to invalid IL or missing references)
		//IL_001c: Expected I4, but got Unknown
		return (phase - 1) switch
		{
			0 => (TouchPhase)0, 
			1 => (TouchPhase)1, 
			4 => (TouchPhase)2, 
			2 => (TouchPhase)3, 
			_ => (TouchPhase)4, 
		};
	}

	private static ButtonControl MouseButton(int button)
	{
		Mouse current = Mouse.current;
		if (current == null)
		{
			return null;
		}
		return button switch
		{
			0 => current.leftButton, 
			1 => current.rightButton, 
			2 => current.middleButton, 
			_ => (ButtonControl)null, 
		};
	}

	public static bool GetMouseButton(int button)
	{
		//IL_0016: Unknown result type (might be due to invalid IL or missing references)
		//IL_001b: Unknown result type (might be due to invalid IL or missing references)
		//IL_001e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0024: Invalid comparison between Unknown and I4
		//IL_0027: Unknown result type (might be due to invalid IL or missing references)
		//IL_002c: Unknown result type (might be due to invalid IL or missing references)
		//IL_002f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0035: Invalid comparison between Unknown and I4
		ButtonControl val = MouseButton(button);
		if (val == null)
		{
			if (button == 0 && touchCount > 0)
			{
				Touch touch = GetTouch(0);
				if ((int)touch.phase != 3)
				{
					touch = GetTouch(0);
					return (int)touch.phase != 4;
				}
			}
			return false;
		}
		return val.isPressed;
	}

	public static bool GetMouseButtonDown(int button)
	{
		//IL_0016: Unknown result type (might be due to invalid IL or missing references)
		//IL_001b: Unknown result type (might be due to invalid IL or missing references)
		//IL_001e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0024: Invalid comparison between Unknown and I4
		ButtonControl val = MouseButton(button);
		if (val == null)
		{
			if (button == 0 && touchCount > 0)
			{
				Touch touch = GetTouch(0);
				return (int)touch.phase == 0;
			}
			return false;
		}
		return val.wasPressedThisFrame;
	}

	public static bool GetMouseButtonUp(int button)
	{
		//IL_0016: Unknown result type (might be due to invalid IL or missing references)
		//IL_001b: Unknown result type (might be due to invalid IL or missing references)
		//IL_001e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0024: Invalid comparison between Unknown and I4
		//IL_0027: Unknown result type (might be due to invalid IL or missing references)
		//IL_002c: Unknown result type (might be due to invalid IL or missing references)
		//IL_002f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0035: Invalid comparison between Unknown and I4
		ButtonControl val = MouseButton(button);
		if (val == null)
		{
			if (button == 0 && touchCount > 0)
			{
				Touch touch = GetTouch(0);
				if ((int)touch.phase != 3)
				{
					touch = GetTouch(0);
					return (int)touch.phase == 4;
				}
				return true;
			}
			return false;
		}
		return val.wasReleasedThisFrame;
	}

	private static ButtonControl KeyButton(KeyCode code)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Invalid comparison between Unknown and I4
		//IL_0008: Unknown result type (might be due to invalid IL or missing references)
		//IL_000e: Invalid comparison between Unknown and I4
		//IL_0026: Unknown result type (might be due to invalid IL or missing references)
		//IL_0010: Unknown result type (might be due to invalid IL or missing references)
		//IL_0016: Unknown result type (might be due to invalid IL or missing references)
		//IL_001c: Expected I4, but got Unknown
		//IL_007b: Unknown result type (might be due to invalid IL or missing references)
		//IL_007e: Invalid comparison between Unknown and I4
		//IL_0080: Unknown result type (might be due to invalid IL or missing references)
		//IL_0086: Invalid comparison between Unknown and I4
		//IL_0088: Unknown result type (might be due to invalid IL or missing references)
		//IL_008e: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ac: Expected I4, but got Unknown
		//IL_00e7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ed: Unknown result type (might be due to invalid IL or missing references)
		if ((int)code >= 323 && (int)code <= 325)
		{
			return MouseButton(code - 323);
		}
		Keyboard current = Keyboard.current;
		if (current == null || (int)code == 0)
		{
			return null;
		}
		string text = ((object)code/*cast due to constrained. prefix*/).ToString();
		if (text.StartsWith("Alpha", StringComparison.Ordinal))
		{
			text = "Digit" + text.Substring(5);
		}
		else if (text.StartsWith("Keypad", StringComparison.Ordinal))
		{
			text = "Numpad" + text.Substring(6);
		}
		if ((int)code != 13)
		{
			if ((int)code != 271)
			{
				switch (code - 305)
				{
				case 1:
					text = "LeftCtrl";
					break;
				case 0:
					text = "RightCtrl";
					break;
				case 5:
					text = "LeftMeta";
					break;
				case 4:
					text = "RightMeta";
					break;
				}
			}
			else
			{
				text = "NumpadEnter";
			}
		}
		else
		{
			text = "Enter";
		}
		if (!Enum.TryParse<Key>(text, true, out Key result) || (int)result == 0)
		{
			return null;
		}
		return (ButtonControl)(object)current[result];
	}

	public static bool GetKey(KeyCode key)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		ButtonControl val = KeyButton(key);
		if (val == null)
		{
			return false;
		}
		return val.isPressed;
	}

	public static bool GetKeyDown(KeyCode key)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		ButtonControl val = KeyButton(key);
		if (val == null)
		{
			return false;
		}
		return val.wasPressedThisFrame;
	}

	public static bool GetKeyUp(KeyCode key)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		ButtonControl val = KeyButton(key);
		if (val == null)
		{
			return false;
		}
		return val.wasReleasedThisFrame;
	}

	public static bool GetButton(string name)
	{
		switch (name)
		{
		case "Jump":
			if (!GetKey((KeyCode)32))
			{
				Gamepad current3 = Gamepad.current;
				if (current3 == null)
				{
					return false;
				}
				return current3.buttonSouth.isPressed;
			}
			return true;
		case "Fire1":
			if (!GetMouseButton(0))
			{
				Gamepad current4 = Gamepad.current;
				if (current4 == null)
				{
					return false;
				}
				return current4.rightTrigger.isPressed;
			}
			return true;
		case "Fire2":
			if (!GetMouseButton(1))
			{
				Gamepad current2 = Gamepad.current;
				if (current2 == null)
				{
					return false;
				}
				return current2.leftTrigger.isPressed;
			}
			return true;
		case "Fire3":
			if (!GetMouseButton(2))
			{
				return GetKey((KeyCode)304);
			}
			return true;
		case "Submit":
			if (!GetKey((KeyCode)13))
			{
				Gamepad current5 = Gamepad.current;
				if (current5 == null)
				{
					return false;
				}
				return current5.buttonSouth.isPressed;
			}
			return true;
		case "Cancel":
			if (!GetKey((KeyCode)27))
			{
				Gamepad current = Gamepad.current;
				if (current == null)
				{
					return false;
				}
				return current.buttonEast.isPressed;
			}
			return true;
		default:
			return false;
		}
	}

	public static bool GetButtonDown(string name)
	{
		switch (name)
		{
		case "Jump":
			if (!GetKeyDown((KeyCode)32))
			{
				Gamepad current3 = Gamepad.current;
				if (current3 == null)
				{
					return false;
				}
				return current3.buttonSouth.wasPressedThisFrame;
			}
			return true;
		case "Fire1":
			if (!GetMouseButtonDown(0))
			{
				Gamepad current4 = Gamepad.current;
				if (current4 == null)
				{
					return false;
				}
				return current4.rightTrigger.wasPressedThisFrame;
			}
			return true;
		case "Fire2":
			if (!GetMouseButtonDown(1))
			{
				Gamepad current5 = Gamepad.current;
				if (current5 == null)
				{
					return false;
				}
				return current5.leftTrigger.wasPressedThisFrame;
			}
			return true;
		case "Submit":
			if (!GetKeyDown((KeyCode)13))
			{
				Gamepad current2 = Gamepad.current;
				if (current2 == null)
				{
					return false;
				}
				return current2.buttonSouth.wasPressedThisFrame;
			}
			return true;
		case "Cancel":
			if (!GetKeyDown((KeyCode)27))
			{
				Gamepad current = Gamepad.current;
				if (current == null)
				{
					return false;
				}
				return current.buttonEast.wasPressedThisFrame;
			}
			return true;
		default:
			return false;
		}
	}

	public static float GetAxisRaw(string name)
	{
		Gamepad current = Gamepad.current;
		switch (name)
		{
		case "Horizontal":
		{
			float num3 = ((GetKey((KeyCode)100) || GetKey((KeyCode)275)) ? 1 : 0) - ((GetKey((KeyCode)97) || GetKey((KeyCode)276)) ? 1 : 0);
			float num4 = ((current != null) ? ((InputControl<float>)(object)((Vector2Control)current.leftStick).x).ReadValue() : 0f);
			if (!(Mathf.Abs(num4) > Mathf.Abs(num3)))
			{
				return num3;
			}
			return num4;
		}
		case "Vertical":
		{
			float num = ((GetKey((KeyCode)119) || GetKey((KeyCode)273)) ? 1 : 0) - ((GetKey((KeyCode)115) || GetKey((KeyCode)274)) ? 1 : 0);
			float num2 = ((current != null) ? ((InputControl<float>)(object)((Vector2Control)current.leftStick).y).ReadValue() : 0f);
			if (!(Mathf.Abs(num2) > Mathf.Abs(num)))
			{
				return num;
			}
			return num2;
		}
		case "RightStickHorizontal":
			if (current == null)
			{
				return 0f;
			}
			return ((InputControl<float>)(object)((Vector2Control)current.rightStick).x).ReadValue();
		case "RightStickVertical":
			if (current == null)
			{
				return 0f;
			}
			return ((InputControl<float>)(object)((Vector2Control)current.rightStick).y).ReadValue();
		case "Mouse X":
		{
			Mouse current4 = Mouse.current;
			return ((current4 != null) ? ((InputControl<float>)(object)((Vector2Control)((Pointer)current4).delta).x).ReadValue() : 0f) * 0.1f;
		}
		case "Mouse Y":
		{
			Mouse current2 = Mouse.current;
			return ((current2 != null) ? ((InputControl<float>)(object)((Vector2Control)((Pointer)current2).delta).y).ReadValue() : 0f) * 0.1f;
		}
		case "Mouse ScrollWheel":
		{
			Mouse current3 = Mouse.current;
			return ((current3 != null) ? ((InputControl<float>)(object)((Vector2Control)current3.scroll).y).ReadValue() : 0f) / 1200f;
		}
		default:
			return GetButton(name) ? 1 : 0;
		}
	}

	public static float GetAxis(string name)
	{
		float axisRaw = GetAxisRaw(name);
		if (name != "Horizontal" && name != "Vertical")
		{
			return axisRaw;
		}
		axes.TryGetValue(name, out var value);
		if (value.frame == Time.frameCount)
		{
			return value.value;
		}
		if (axisRaw != 0f && Mathf.Sign(axisRaw) != Mathf.Sign(value.value))
		{
			value.value = 0f;
		}
		value.value = Mathf.MoveTowards(value.value, axisRaw, 3f * Time.deltaTime);
		value.frame = Time.frameCount;
		axes[name] = value;
		return value.value;
	}
}
