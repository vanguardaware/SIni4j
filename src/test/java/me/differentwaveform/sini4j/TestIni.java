package me.differentwaveform.sini4j;

import net.vanguarda.sini4j.Ini;

public class TestIni 
{

	public static void main(String[] args) 
	{
		Ini ini = new Ini(TestIni.class.getResourceAsStream("/test.ini"));
		
		System.out.println(ini.getSection("First").getString("Value"));
		System.out.println(ini.getSection("Second").getString("Value"));		
	}
	
}
