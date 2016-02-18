Preference Abstraction
======================
Copyright 2016 by Ethan Ruffing. See the accompanying [`NOTICE.md`](NOTICE.md)
file.

This library provides an easy-to-use system for abstracting several different
potential methods of storing application preference data, including files stored
in the same directory as the application, files in a user's home directory, and
native system preference storage structures.

Project Website
---------------
The project website is located at
[http://www.ethanruffing.com/preference-abstraction/](http://www.ethanruffing.com/preference-abstraction/).

The JavaDocs for the library can be found at
[http://www.ethanruffing.com/preference-abstraction/apidocs](http://www.ethanruffing.com/preference-abstraction/apidocs).

Usage
-----
Simply include the project as a Maven dependency to use it in your project, or
download the
[latest release](https://github.com/ruffinge/preference-abstraction/releases)
and manually import it.

Abilities
---------
This abstraction system is currently limited to storing a single tier of 
preferences for any Java package (i.e., non-hierarchical). The focus in 
development has been to create a unified interface for storing and retrieving
preferences in a variety of mediums.
