
<!-- README TOP -->
<a name="readme-top"></a>

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <h3 align="center">Voice Calling over WLAN</h3>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#file-structure">File Structure</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#references">References</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project
Implementation of Wi-Fi Calling that uses IP Address over the Wireless Local Area Network (WLAN).


<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

These are the major frameworks & development environments that we used in the development of GoDelv.

  ![NetBeans IDE](https://img.shields.io/badge/NetBeansIDE-1B6AC6.svg?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white)
  ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
  ![Notepad++](https://img.shields.io/badge/Notepad++-90E59A.svg?style=for-the-badge&logo=notepad%2b%2b&logoColor=black)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

Listed in this section are the prerequisites and installation instructions for this project.

### Prerequisites

* JDK 1.8
* JMF 2.1.1.e
* RTP

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/piyush26c/Voice-Calling-over-WLAN
   ```
2. Open the repo as a Java project in NetBeans IDE or any other IDE

3. Follow below steps to execute the project.
   1. Connect both server and client machines to WLAN.
   2. Run the Server first. Enter the port number on which server will listen.
   3. Compile the Communication module.
   4. Run the Client module, specify the IP Address of the Server along with port number of the server. Set the mic level according the need.
   5. Click on the Connect button.
   6. Start Voice Calling.
  



<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- FILE STRUCTURE -->
## File Structure

The file structure of your project should look something like this:

```
.
├── Client
│   ├── build
│   │   ├── built-jar.properties
│   │   ├── classes
│   │   │   ├── AudioChannel.class
│   │   │   ├── Client.class
│   │   │   ├── GUI$1.class
│   │   │   ├── GUI$2.class
│   │   │   ├── GUI$3.class
│   │   │   ├── GUI$MicTester.class
│   │   │   ├── GUI.class
│   │   │   ├── GUI.form
│   │   │   └── MicThread.class
│   │   ├── empty
│   │   └── generated-sources
│   │       └── ap-source-output
│   ├── build.xml
│   ├── dist
│   │   ├── README.TXT
│   │   ├── VoiceChat_Client.jar
│   │   └── lib
│   │       └── VoiceChat_Comm.jar
│   ├── manifest.mf
│   ├── nbproject
│   │   ├── build-impl.xml
│   │   ├── genfiles.properties
│   │   ├── private
│   │   │   ├── config.properties
│   │   │   ├── private.properties
│   │   │   └── private.xml
│   │   ├── project.properties
│   │   └── project.xml
│   ├── src
│   │   ├── AudioChannel.java
│   │   ├── Client.java
│   │   ├── GUI.form
│   │   ├── GUI.java
│   │   └── MicThread.java
│   └── test
├── Communication
│   ├── build
│   │   ├── classes
│   │   │   ├── ErrorMessage.class
│   │   │   ├── Message.class
│   │   │   ├── SoundPacket.class
│   │   │   └── Utils.class
│   │   ├── empty
│   │   └── generated-sources
│   │       └── ap-source-output
│   ├── build.xml
│   ├── dist
│   │   ├── README.TXT
│   │   └── VoiceChat_Comm.jar
│   ├── manifest.mf
│   ├── nbproject
│   │   ├── build-impl.xml
│   │   ├── genfiles.properties
│   │   ├── private
│   │   │   ├── config.properties
│   │   │   ├── private.properties
│   │   │   └── private.xml
│   │   ├── project.properties
│   │   └── project.xml
│   └── src
│       ├── ErrorMessage.java
│       ├── Message.java
│       ├── SoundPacket.java
│       └── Utils.java
└── Server
    ├── build
    │   ├── built-jar.properties
    │   ├── classes
    │   │   ├── ClientConnection.class
    │   │   ├── GUI$1.class
    │   │   ├── GUI$2.class
    │   │   ├── GUI$3.class
    │   │   ├── GUI$4.class
    │   │   ├── GUI.class
    │   │   ├── GUI.form
    │   │   ├── Log.class
    │   │   ├── Server$BroadcastThread.class
    │   │   └── Server.class
    │   ├── empty
    │   └── generated-sources
    │       └── ap-source-output
    ├── build.xml
    ├── dist
    │   ├── README.TXT
    │   ├── VoiceChat_Server.jar
    │   └── lib
    │       ├── VoiceChat_Comm.jar
    │       ├── cling-core-1.0.5.jar
    │       ├── cling-support-1.0.5.jar
    │       └── teleal-common-1.0.13.jar
    ├── lib
    │   ├── cling-core-1.0.5.jar
    │   ├── cling-support-1.0.5.jar
    │   └── teleal-common-1.0.13.jar
    ├── manifest.mf
    ├── nbproject
    │   ├── build-impl.xml
    │   ├── genfiles.properties
    │   ├── private
    │   │   ├── config.properties
    │   │   ├── private.properties
    │   │   └── private.xml
    │   ├── project.properties
    │   └── project.xml
    ├── src
    │   ├── ClientConnection.java
    │   ├── GUI.form
    │   ├── GUI.java
    │   ├── Log.java
    │   └── Server.java
    └── test

36 directories, 80 files

```




<!-- CONTACT -->
## Contact
1. Piyush Chaudhari (piyushrc26@gmail.com)
2. Rohit Bangar (bangarrohit7057@gmail.com)
3. Mayuresh Dindorkar (Dmayuresh99@gmail.com)
<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- References -->
## References
1. Original Idea <a href="https://github.com/adolfintel">Federico Dossena</a>
2. <a href="https://www.oracle.com/java/technologies/javase/java-media-framework.html">JMF Docs</a>
3. <a href="https://docs.oracle.com/en/java/javase/19/docs/api/index.html">JMF Docs</a>
<p align="right">(<a href="#readme-top">back to top</a>)</p>
