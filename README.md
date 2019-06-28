# Banking

Banking is a android application allow loan money from the bank.

# Features!

  - Load loan offer from the bank
  - Create loan

### Tech

Banking uses a number of open source projects to work properly:

* [Gson](https://github.com/google/gson) - A Java serialization/deserialization library to convert Java Objects into JSON and back

* [Glide](https://github.com/bumptech/glide) - An image loading and caching library for Android focused on smooth scrolling https://bumptech.github.io/glide/
* [JaCoCo](https://github.com/jacoco/jacoco) Java Code Coverage Library

And of course Banking itself is open source with a [public repository][dill]
 on GitHub.

#### Building for source
  - Install android studio 3.3
  - Import project in android studio
```sh
File -> open
```
  - Run:
```sh
Build -> make project
```
#### Supported device
Android 5.0 and above

#### Unit test
- In android studio:
```sh
Build Varians -> Debug
```
```sh
right click on app/java/com(AndroidTest) -> Run 'Test in 'com''
```

#### Test coverage report
  - In android studio:
```sh
Gradle -> app -> verification -> createDebugCoverageReport
```
  - Please find Report folder at .app/build/reports

Noted : Databinding and mock data is not coverage in our unit testing
