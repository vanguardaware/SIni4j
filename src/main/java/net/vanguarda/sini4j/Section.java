/**
	MIT License
	
	Copyright (c) 2023 Vangurada.
	
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
package net.vanguarda.sini4j;

import java.util.LinkedHashMap;
import java.util.Map;

public class Section implements ISection 
{

	private Map<String, Object> sectorValues = new LinkedHashMap<>();

	@Override
	public void add(String key, Object value)
	{
		if (sectorValues.containsKey(key))
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
		Object o = get(key);
		
		if (o == null) 
		{
			System.err.println("Could not find '" + key + "' key");
			return null;
		}
		
		return String.valueOf(o);
	}

	@Override
	public Character getChar(String key) 
	{		
		String o = getString(key);
		if (o == null) 
		{
			return null;
		}
		
		return getString(key).charAt(0);
	}

	@Override
	public Byte getByte(String key) 
	{
		String o = getString(key);
		
		if (o == null) 
		{
			return null;
		}
		
		return Byte.parseByte(o);
	}

	@Override
	public Short getShort(String key) 
	{
		String o = getString(key);
		
		if (o == null) 
		{
			return null;
		}
		
		return Short.parseShort(o);
	}

	@Override
	public Boolean getBoolean(String key) 
	{
		String o = getString(key);
		
		if (o == null)
		{
			return null;
		}
		
		return Boolean.parseBoolean(o);
	}

	@Override
	public Integer getInt(String key) 
	{
		String o = getString(key);
		
		if (o == null) 
		{
			return null;
		}
		
		return Integer.parseInt(o);
	}

	@Override
	public Float getFloat(String key) 
	{
		String o = getString(key);
		
		if (o == null) 
		{
			return null;
		}
		
		return Float.parseFloat(o);
	}

	@Override
	public Double getDouble(String key) 
	{
		String o = getString(key);
		
		if (o == null)
		{
			return null;
		}
		
		return Double.parseDouble(o);
	}

	@Override
	public Long getLong(String key) 
	{
		String o = getString(key);
		
		if (o == null) 
		{
			return null;
		}
		
		return Long.parseLong(o);
	}

	@Override
	public <T extends Enum<T>> T getEnumConstant(Class<T> enumType, String key) 
	{
		String o = getString(key);
		
		if (o == null) 
		{
			return null;
		}
		
		return Enum.valueOf(enumType, o);
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
