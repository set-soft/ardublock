ArduBlock
======

ArduBlock is a Block Programming Language for Arduino. The language and functions model closely to [Arduino Language Reference](http://arduino.cc/en/Reference/HomePage)

Installation
----

The project is managed by Maven, so you need to install it. (i.e. apt get install maven)

This project depends on [OpenBlocks](https://github.com/taweili/openblocks), so first install it like this:

	$ git clone https://github.com/taweili/openblocks.git
	$ cd openblocks
	$ mvn clean package
	$ mvn install:install-file -DgroupId=edu.mit -DartifactId=openblocks -Dversion=1.0.2-SNAPSHOT -Dpackaging=jar -Dfile=target/openblocks-1.0.2-SNAPSHOT.jar

Then check out this project.

After checking out the source for the first time, one should run the following to install Arduino's pde.jar into the local repository.

	$ mvn validate

Usage
----

	$ mvn exec:java -Dexec.mainClass="com.ardublock.Main"

Development
----
To add new blocks to ArduBlock edit:

	src/main/resources/com/ardublock/block/ardublock.xml

The strings associated to the block must be defined here:

	src/main/resources/com/ardublock/block/ardublock.properties

The classes that implements the blocks must be in a subdir here:

	src/main/java/com/ardublock/translator/block/

To associate the blocks with the classes edit:

	src/main/resources/com/ardublock/block/block-mapping.properties

Then you can test it running:

	$ mvn clean package

	$ mvn compile exec:java -Dexec.mainClass="com.ardublock.Main"

The Visual Block environment should show up. Happy Hacking! ;) 

Deploy
----
Edit code of ardublock

	$ mvn clean package

copy the target/ardublock-all.jar to Arduino\tools\ArduBlockTool\tool

Authors
----
* David Li taweili@gmail.com
* HE Qichen heqichen@gmail.com


ToDo
----
* Integrate the [scripting engine](http://java.sun.com/developer/technicalArticles/J2SE/Desktop/scripting/) into the language blocks for code generation

License
----

Copyright (C) 2011 David Li and He Qichen

This file is part of ArduBlock.

ArduBlock is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

ArduBlock is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with ArduBlock.  If not, see <http://www.gnu.org/licenses/>.
