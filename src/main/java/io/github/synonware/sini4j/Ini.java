/**
	MIT License
	
	Copyright (c) 2022 Synonware
	
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
package io.github.synonware.sini4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ini implements IIni
{

	public static final String COMMENT = ";#";
	public static final String SECTOR = "^\\[(.*?)\\]";
	public static final String VALUES = "(?:, )?([^=]+)\\=([^,]+)";

	private File iniFile;
	private InputStream iniInputStream;

	private Scanner iniScanner;
	
	private Map<String, IniSection> values = new LinkedHashMap<>();
	
	public Ini() 
	{
		super();
	}
	
	public Ini(InputStream iniStream) 
	{
		this.iniInputStream = iniStream;
		this.iniScanner = new Scanner(iniInputStream);
		this.reload();
	}
	
	public Ini(File iniFile) throws FileNotFoundException 
	{
		this.iniFile = iniFile;
		this.iniScanner = new Scanner(iniFile);
		this.reload();
	}
	
	@Override
	public void reload() 
	{
		if(iniScanner == null)
		{
			return;
		}
		
		Pattern sectionPattern = Pattern.compile(SECTOR);
	    Pattern valuesPattern = Pattern.compile(VALUES);
		
	    String sectionName = "";
	    
		while (iniScanner.hasNextLine()) 
		{			
			String ln = iniScanner.nextLine();
			
			if(ln.startsWith("" + COMMENT.charAt(0)) || ln.startsWith("" + COMMENT.charAt(1)))
			{
				//Skip Comments
			}
			else
			{
				Matcher sectionMatcher = sectionPattern.matcher(ln);
				Matcher valuesMatcher = valuesPattern.matcher(ln);
				
				//Find section
				if(sectionMatcher.find())
				{
					sectionName = sectionMatcher.group(1);
					
					//Init section
					this.values.put(sectionName, new IniSection());
				}
				
				//Add sections values to map
				while(!sectionMatcher.find()) 
				{	
				    //Add value to map
				    if(valuesMatcher.find())
				    {
				    	this.values.get(sectionName).add(valuesMatcher.group(1), valuesMatcher.group(2));
				    }
				    
					break;
				}
			}
		}
	}

	@Override
	public void store()
	{
		if(iniFile == null)
		{
			throw new IniException("Cannot modify an inputstream");
		}
		
		store(iniFile);
	}
	
	@Override
	public void store(File iniFile)
	{
		try 
		{
			FileWriter myWriter = new FileWriter(iniFile);			   
			
			for(String i : values.keySet())
			{
				myWriter.write("[" + i + "]");
				myWriter.write(System.lineSeparator());
				
				for(String keyName : values.get(i).getMap().keySet())
				{
					myWriter.write(keyName + "=" + values.get(i).get(keyName));
					myWriter.write(System.lineSeparator());
				}
				
				myWriter.write(System.lineSeparator());
			}
		    
		    myWriter.close();
		} 
		catch (IOException e) 
		{
			throw new IniException(e.getCause());
		}
	}

	public Map<String, IniSection> getSections()
	{
		return values;
	}
	
	public IniSection getSection(String name)
	{
		return values.get(name);
	}
	
	public void addSection(String name, IniSection section)
	{
		values.put(name, section);
	}
	
	public void addSection(String name, String key, Object value)
	{
		if(!values.containsKey(name))
		{
			IniSection iniSector = new IniSection();
			iniSector.add(key, value);
			values.put(name, iniSector);
		}
		else
		{
			values.get(name).add(key, value);
		}
	}
	
	public boolean hasSection(String section)
	{
		return getSections().containsKey(section);
	}
	
	public boolean hasKey(String section, String key)
	{
		if(hasSection(section))
		{
			return getSection(section).has(key);
		}
		
		return false;
	}
	
	public boolean hasValue(String section, String value)
	{
		if(hasSection(section))
		{
			return getSection(section).hasValue(value);
		}
		
		return false;
	}

	public File getFile() 
	{
		return iniFile;
	}

	public InputStream getStream() 
	{
		return iniInputStream;
	}
	
}
