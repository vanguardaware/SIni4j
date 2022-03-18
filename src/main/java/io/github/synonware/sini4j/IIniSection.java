/**
	MIT License
	
	Copyright (c) 2022 Synonware MEI.
	
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

/**
 * @author Gabriel (https://github.com/gbrlandrade)
 */
public interface IIniSection 
{

	void add(String key, Object value);
	
	void remove(String key);
	
	Object get(String key);	
	
	boolean has(String key);
	
	boolean hasValue(String key);
	
	String getString(String key);
	
	char getChar(String key);
	
	byte getByte(String key);
	
	short getShort(String key);
	
	boolean getBoolean(String key);
	
	int getInt(String key);
	
	float getFloat(String key);
	
	double getDouble(String key);
	
	long getLong(String key);
	
}
