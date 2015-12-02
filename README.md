# Pronto-Auth
Pronto Auth can be used to in Authentication of VOLSBB network in VIT University.

### Features
---
 - Easy to use.
 - Faster Login than Browser Login.
 - All cases handled including - Not connected, Free Quota over, etc.
 - No need to wait for Browser to render Pronto Login page and then enter password to Login.


### How-to
---
 - Download this Repo as zip file. (Fork if you would like to :)
 - Extract this in your User home directory.
   - For Linux/Ubuntu users : Home Directory
   - For Windows : C:\Users\UrUsername
 - Open the file **pronto.java** in TextEditor
 - Edit the variables username and pass on line 19, 20.
```java
	private static final String username = "UrUsername";
	private static final String pass = "UrPassword";
```
 - Save the file and exit.
 - Open Terminal/cmd and
 - For the first time, compile it using 
```sh
    $ javac pronto.java
    $ java pronto
```
 - For later use simply use 
```sh
    $ java pronto
```

### Usage
---

Now that you have Run it the first time.For later use (when you want to show off in front of your friends ;P) just open the 
 - Terminal using shortcut -> Ctrl + Alt + T
 - CMD using -> Start -> Type "cmd" -> Press Enter

Type following command : (easy to rememeber)
```sh
    $ java pronto
```

That's all, you are logged in.

### Bugs and Features
---
If your problem or idea is not addressed yet, please [open a new issue][issue].

### Contributing and License
---

Contribute away.

Code released under the MIT license.



  [issue]: <https://github.com/MrL1605/Pronto-Auth/issues>


