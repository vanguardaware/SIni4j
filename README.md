<img align="right" src="assets/logo.png" height="200" width="200">

# SIni4j
**Simple Ini Parser for Java** or **SIni4j** is a simple INI parse made in Java, built for provide a simple and easiest way to load INI files in Java

### Notes
- **SIni4j** don't parse/generate comments *(Maybe on a future update)*

## Summary
1. [Usage](#usage)
2. [Download](#download)
3. [License](#license)

## Usage

- How to create an INI file:

```java
//Create INI
Ini iniFile = new Ini();

//Creating a section with a key and value 
iniFile.addSection("Section", "Key", "Value");

//Saving the file
iniFile.store(new File(".", "exemple.ini"));
```

- How to load an INI file:

```java
//Create INI
Ini iniFile = new Ini(new File(".", "exemple.ini"));

//Getting a value from a section
String value = iniFile.getSection("Section").getString("Key");

//Modifying a value
iniFile.getSection("Section").add("Key", "NewValue");

//Saving the file
iniFile.store();
```

## Download

Latest Release: [GitHub Release](https://github.com/vanguardaware/SIni4j/releases/latest) <br>

[![](https://jitpack.io/v/vanguardaware/SIni4j.svg)](https://jitpack.io/#vanguardaware/SIni4j)


**Maven**
```xml
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>

<dependency>
	<groupId>com.github.vanguardaware</groupId>
		<artifactId>SIni4j</artifactId>
	    <version>VERSION</version>
	</dependency>
<dependency>
```

**Gradle**
```gradle
allprojects 
{
	repositories 
	{
		maven { url 'https://jitpack.io' }
	}
}

dependencies 
{
	implementation 'com.github.vanguardaware:SIni4j:VERSION'
}
```

## License
[MIT](https://choosealicense.com/licenses/mit/)
