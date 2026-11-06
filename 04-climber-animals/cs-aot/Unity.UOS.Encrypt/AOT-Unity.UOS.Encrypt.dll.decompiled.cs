using System;
using System.CodeDom.Compiler;
using System.ComponentModel;
using System.Diagnostics;
using System.IO;
using System.Reflection;
using System.Runtime.CompilerServices;
using System.Security.Cryptography;
using System.Text;
using UnityEngine;

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
			FilePathsData = new byte[100]
			{
				0, 0, 0, 1, 0, 0, 0, 40, 92, 65,
				115, 115, 101, 116, 115, 92, 85, 79, 83, 76,
				97, 117, 110, 99, 104, 101, 114, 69, 110, 99,
				114, 121, 112, 116, 92, 69, 110, 99, 114, 121,
				112, 116, 75, 101, 121, 46, 99, 115, 0, 0,
				0, 1, 0, 0, 0, 44, 92, 65, 115, 115,
				101, 116, 115, 92, 85, 79, 83, 76, 97, 117,
				110, 99, 104, 101, 114, 69, 110, 99, 114, 121,
				112, 116, 92, 69, 110, 99, 114, 121, 112, 116,
				77, 97, 110, 97, 103, 101, 114, 46, 99, 115
			},
			TypesData = new byte[70]
			{
				0, 0, 0, 0, 28, 85, 110, 105, 116, 121,
				46, 85, 79, 83, 46, 69, 110, 99, 114, 121,
				112, 116, 124, 69, 110, 99, 114, 121, 112, 116,
				75, 101, 121, 0, 0, 0, 0, 32, 85, 110,
				105, 116, 121, 46, 85, 79, 83, 46, 69, 110,
				99, 114, 121, 112, 116, 124, 69, 110, 99, 114,
				121, 112, 116, 77, 97, 110, 97, 103, 101, 114
			},
			TotalFiles = 2,
			TotalTypes = 2,
			IsEditorOnly = false
		};
	}
}
namespace Unity.UOS.Encrypt;

public class EncryptKey
{
	public static string Value = "5c5afa0ae2854ecd7514850cfe45cf41ea395cd2762e03900443ecfcc128c446";
}
public class EncryptManager
{
	private static string m_EncryptKey => EncryptKey.Value;

	public static string Encrypt(string plainText)
	{
		byte[] bytes = Encoding.UTF8.GetBytes(plainText);
		using Aes aes = Aes.Create();
		aes.Key = DeriveKeyFromPassword(m_EncryptKey);
		aes.IV = new byte[16];
		using MemoryStream memoryStream = new MemoryStream();
		using CryptoStream cryptoStream = new CryptoStream(memoryStream, aes.CreateEncryptor(), CryptoStreamMode.Write);
		cryptoStream.Write(bytes, 0, bytes.Length);
		cryptoStream.FlushFinalBlock();
		return Convert.ToBase64String(memoryStream.ToArray());
	}

	public static string Decrypt(string cipherText)
	{
		byte[] array = Convert.FromBase64String(cipherText);
		try
		{
			using Aes aes = Aes.Create();
			aes.Key = DeriveKeyFromPassword(m_EncryptKey);
			aes.IV = new byte[16];
			using MemoryStream memoryStream = new MemoryStream();
			using CryptoStream cryptoStream = new CryptoStream(memoryStream, aes.CreateDecryptor(), CryptoStreamMode.Write);
			cryptoStream.Write(array, 0, array.Length);
			cryptoStream.FlushFinalBlock();
			byte[] array2 = memoryStream.ToArray();
			return Encoding.UTF8.GetString(array2, 0, array2.Length);
		}
		catch (Exception ex)
		{
			Debug.Log((object)ex.Message);
		}
		return string.Empty;
	}

	private static byte[] DeriveKeyFromPassword(string password)
	{
		string s = "202401121404";
		int iterations = 1000;
		int cb = 16;
		return new Rfc2898DeriveBytes(Encoding.UTF8.GetBytes(password), Encoding.UTF8.GetBytes(s), iterations).GetBytes(cb);
	}
}
