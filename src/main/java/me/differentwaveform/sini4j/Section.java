/**
	MIT License
	
	Copyright (c) 2022 Different Waveform
	
	Permission is hereby granted, free of charge, to any person obtaining a copy
	of this software and associated documentation files (the "Software"), to deal
	in the Software without restriction, including without limitation the rights
	to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
	copies of the Software, and to permit persons to whom the Software is
	furnished to do so, subject to the following conditions:
	
	The above copyright notice and this permission notice shall be included in all
	copies or substantial portions of the Software.
	
	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
	SOFTWARE.
*/
package me.differentwaveform.sini4j;

import java.util.LinkedHashMap;
import java.util.Map;

public class Section implements ISection
{
	
	private Map<String, Object> sectorValues = new LinkedHashMap<>();

	@Override
	public void add(String key, Object value) 
	{
		if(sectorValues.containsKey(key))
		{
			remove(key);
		}
		
		sectorValues.put(key, value);
	}

	@Override
	public void remove(String key) 
	{
		sectorValues.remove(key);
	}

	@Override
	public Object get(String key) 
	{
		return sectorValues.get(key);
	}

	@Override
	public String getString(String key) 
	{
		return String.valueOf(get(key));
	}

	@Override
	public char getChar(String key) 
	{
		return getString(key).charAt(0);
	}

	@Override
	public byte getByte(String key) 
	{
		return Byte.parseByte(getString(key));
	}

	@Override
	public short getShort(String key) 
	{
		return Short.parseShort(getString(key));
	}
	
	@Override
	public boolean getBoolean(String key) 
	{
		return Boolean.parseBoolean(getString(key));
	}

	@Override
	public int getInt(String key) 
	{
		return Integer.parseInt(getString(key));
	}

	@Override
	public float getFloat(String key) 
	{
		return Float.parseFloat(getString(key));
	}

	@Override
	public double getDouble(String key) 
	{
		return Double.parseDouble(getString(key));
	}

	@Override
	public long getLong(String key)
	{
		return Long.parseLong(getString(key));
	}	
		
	@Override
	public <T extends Enum<T>> T getEnumConstant(Class<T> enumType, String key) 
	{
		return Enum.valueOf(enumType, getString(key));
	}
	
	@Override
	public boolean has(String key) 
	{
		return getMap().containsKey(key);
	}

	@Override
	public boolean hasValue(String key) 
	{
		return getMap().containsValue(key);
	}
	
	public Map<String, Object> getMap() 
	{
		return sectorValues;
	}
	
	@Override
	public String toString() 
	{
		return sectorValues.toString();
	}

}
