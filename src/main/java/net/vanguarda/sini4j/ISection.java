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

public interface ISection 
{

	void add(String key, Object value);
	
	void remove(String key);
	
	Object get(String key);	
	
	boolean has(String key);
	
	boolean hasValue(String key);
	
	String getString(String key);
	
	Character getChar(String key);
	
	Byte getByte(String key);
	
	Short getShort(String key);
	
	Boolean getBoolean(String key);
	
	Integer getInt(String key);
	
	Float getFloat(String key);
	
	Double getDouble(String key);
	
	Long getLong(String key);
	
	<T extends Enum<T>> T getEnumConstant(Class<T> enumType, String key);
	
}
