---
layout: post
title:  "Network protocols"
date:   2016-01-20 13:22:29 +0100
categories: network protocols
---

## Open Systems Interconnection, OSI Model

The bottom four layers—physical, data link, network and transport—define how data is transported through the physical medium, as well as through network devices (i.e., routers).

The upper three layers—session, presentation and application—know nothing about networking.


| Nr | Name         | Function  |
|:---|:-------------|:----------|
| 7  | Application  | Support for application and end-user processes
| 6  | Presentation | Data representation and translation, encryption, and compression
| 5  | Session      | Establishes, manages, and terminates sessions between applications
| 4  | Transport    | Data transfer between end systems and hosts; connections; segmentation and reassembly; acknowledgments and retransmissions; flow control and error recovery
| 3  | Network      | Switching and routing; logical addressing, error handling and packet sequencing
| 2  | Data link    | Logical link control layer; media access control layer; data framing; addressing; error detection and handling from physical layer
| 1  | Physical     | Encoding and signaling; physical transmission of data; defining medium specifications

Remember story:

**A**ll **P**oeple **S**eems **T**o **N**eed **D**ata **P**rocessing


## OSI Model communication in a network

![osimodelinanetwork](http://mycomsats.com/wp-content/uploads/2012/05/image21.png)



### The Functions of Each Layer in the OSI Model


| Name of layer | Unit of Data Type | Purpose | Common Protocols | Hardware  |
|:--------------|:------------------|:--------|:-----------------|:----------|
| Application   | User Data         | Application data | DNS, BOOTP, DHCP, SNMP, RMON, FTP, TFTP, SMTP, POP3, IMAP, NNTP, HTTP, Telnet, HTTPS, ping, NSLOOKUP, NTP, SFTP | Gateways , Proxy Servers, Application Switches, Content Filtering Firewalls |
| Presentation  | Encoded User Data | Application data representation | SSL, Shells and Redirectors, MIME,TLS | Gateways , Proxy Servers, Application Switches, Content Filtering Firewalls |
| Session | Session | Session between local or remote devices | NetBLOS, sockets, Named Pipes, RPC, RTP, SIP, PPTP | Gateways , Proxy Servers, Application Switches, Content Filtering Firewalls |
| Transport | Datagrams/ Segments | Communication between software process | TCP, UDP and SPX | Gateways, Proxy Servers, Application Switches, Content Filtering Firewalls |
| Network | Datagrams/ Packet | Messages between local or remote devices | IP, IPv6, IP NAT, IPsec, Mobile IP, ICMP, IPX, DLC, PLP, Routing protocols such as RIP and BGP, ICMP, IGMP, IP, IPSec | Routers, Layer 3 Switches, Firewalls, Gateways, Proxy Servers, Application Switches, Content Filtering Firewalls |
| Data Link | Frames | Low-level messages between local or remote devices | IEEE802.2LLC, IEEE802.3 (MAC)Ethernet Family, CDDI, IEEE802.11(WLAN, Wi-Fi), HomePNA, HomeRF, ATM, PPP ARP, HDLC, RARP | Bridges, Switches, Wireless access points, NICs, Modems, Cable Modems, DSL Modems, Gateways, Proxy Servers, Application Switches, Content Filtering Firewalls |
| Physical | Bits | Electrical or light signals sent between local devices | (Physical layers of most of the technologies listed for the data link layer) IEEE 802.5(Ethernet), 802.11(Wi-Fi), E1, T1, DSL | Hubs, Repeaters, NICs, Modems, Cable Modems, DSL Modems |


{% highlight bash %}


+-------------+---------------+------------+---------+-----------+
|             |               | Secure     | Secure  | Network   |
|Application  | E-mail        | Remote     | Web     | Management|
|             |               | Sessioons  | Sites   |           |
+-------------+---------------+------------+---------+-----------+
|             |               |            |         |           |
|Presentation | POP/SMTP      | SSH        | HTTPS   | SNMP      |
|             |               |            |         |           |
+-------------+---------------+------------+---------+-----------+
|             |               |            |         |           |
|Session      | 110/25        | 22         | 443     | 161,      |
|             |               |            |         | 162       |
+-------------+---------------+------------+---------+-----------+
|             |               |            |         |           |
|Transport    | TCP           | TCP        | TCP     | UDP       |
|             |               |            |         |           |
+-------------+---------------+------------+---------+-----------+
|             |               |            |         |           |
|Network      | IP            | IP         | IP      | IP        |
|             |               |            |         |           |
+-------------+---------------+------------+---------+-----------+
|             |               |            |         |           |
|Data Link    | PPP,Ethernet, |  - * -     | - * -   | - * -     |
|             | ATM,FDDI      |            |         |           |
+-------------+---------------+------------+---------+-----------+
|             | CAT 1-6, ISDN,|            |         |           |
|hysical      | ATM, FDDI,    |  - * -     | - * -   | - * -     |
|             | COAX          |            |         |           |
+-------------+---------------+------------+---------+-----------+



{% endhighlight %}


## Application Layer

![applicationlayer](http://mycomsats.com/wp-content/uploads/2012/05/image2.png)

The application layer interfaces between the program sending or receiving data. This layer supports end user applications. Application services are made for electronic mail (e-mail), Telnet, File Transfer Protocol (FTP) applications, and file transfers. Quality of service, user authentication, and privacy are considered at this layer due to everything being application-specific. When you send an e-mail, your e-mail program contacts the application layer.

The following are popular applications within the application layer:

* World Wide Web (WWW): Presents diverse formats—including multimedia such as graphics, text, sound, and video connecting servers—to end users.
* E-mail: Simple Mail Transfer Protocol (SMTP) and Post Office Protocol version 3 (POP3) protocols are used to allow sending and receiving, respectively, of e-mail messages between different e-mail applications.




## Presentation Layer

![presentationlayer](http://mycomsats.com/wp-content/uploads/2012/05/image31.png)


he presentation layer translates data, formats code, and represents it to the application layer. This layer identifies the syntax that different applications use, and encapsulates presentation data into session protocol data units and passes this to the session layer, ensuring that data transferred from the local application
layer can be read by the application layer at the remote system.


Examples of presentation layer standards include:

* Joint Photographic Experts Group (JPEG): Photo standards.
* Movie Picture Experts Group (MPEG) standard for compression and coding of motion video for CDs.
* Tagged Image File Format (TIFF): A high-resolution graphics format.
* Rich Text Format (RTF): A file format for exchanging text files from different word processors and operating systems.




## Session Layer

![sessionlayer](http://mycomsats.com/wp-content/uploads/2012/05/image41.png)


The session layer is responsible for establishing, managing, and terminating sessions between local and remote applications. This layer controls connections between end devices and offers three modes of communication: full-duplex, half-duplex, or simplex operation.


Examples of the session layer include:
* Structure Query Language (SQL): An IBM development designed to provide users with a way to define information requirements on local and remote systems.
* Remote Procedure Call (RPC): A client-server redirection tool used to disparate service environments.
* Network File System (NFS): A Sun Microsystems development that works with TCP/IP and UNIX desktops to allow access to remote resources.




## Transport Layer

![trans layer](http://mycomsats.com/wp-content/uploads/2012/05/image51.png)


The transport layer segments and reassembles data for the session layer. This layer provides end-to-end transport services. The network layer allows this layer to establish a logical connection between source and destination host on a network. The transport layer is responsible for establishing sessions and breaking down virtual circuits.


Reliable data
transport uses connection-oriented sessions between end systems. The following are some of the benefits:

* Acknowledgement sent from the receiver to the sender upon receipt of the segments.
* If a segment is not acknowledged, it will be retransmitted by the sender.
* Segments are reorganized into their proper order once received at the destination.
* Congestion, overloading, and data loss is avoided through flow control.






## Network Layer

![net layer](http://mycomsats.com/wp-content/uploads/2012/05/image61.png)

The network layer provides logical device addressing, determines the location of devices on the network, and calculates the best path to forward packets. Routers are network layer devices that provide routing within networks.


Network layer examples include routing protocols such as Open Shortest Path First (OSPF), Routing Information Protocol (RIP), Enhanced Interior Gateway Protocol (EIGRP), Border Gateway Routing Protocol (BGP), Internet Protocol Version 4/6 (IPv4/IPv6), Internet Group Management Protocol (IGMP), and Internet Control Message Protocol (ICMP).


## Data Link Layer

![data layer](http://mycomsats.com/wp-content/uploads/2012/05/image71.png)

The data link layer provides services to the layer above it (the network layer), and provides error handling and flow control. This layer must ensure that messages are transmitted to devices on a local area network (LAN) using physical hardware addresses.  It also converts packets sent from the network layer into frames to be sent out to the physical layer to transmit. The data link layer converts packets into frames, adding a header containing the device’s physical hardware source and destination addresses, flow control and checksum data (CRC).
Please note that devices at the data link layer do not care about logical addressing, only physical.
Routers do not care about the actual location of your end user devices, but the data link layer does. This layer is responsible for the identification of the unique hardware address of each device on the LAN.

The data link layer is separated into two sublayers:

* Media access control (MAC) 802.3: This layer is responsible for how packets are transmitted by devices on the network. Media access is first come/first served, meaning all the bandwidth is shared by everyone. Hardware addressing is defined here, as well as the signal path, through physical topologies, including error notification, correct delivery of frames, and flow control. Every network device, computer, server, IP camera, and phone has a MAC hardware address.

* Logical link control (LLC) 802.2: This layer defines and controls error checking and packet synchronization. LLC must locate network layer protocols and encapsulate the packets. The header of the LLC lets the data link layer know how to process a packet when a frame is received.

Examples of data link layer technologies include:

* Fiber Distributed Data Interface (FDDI): A legacy technology, but it may still be used in some networks today.
* Asynchronous Transfer Mode (ATM): A legacy technology, but it may still be used in some networks today.
* Institute of Electronic and Electrical Engineers (IEEE) 802.2 (LLC)
* IEEE 802.3 (MAC)
* Frame relay: A legacy technology, but it may still be used in some networks today.
* PPP (Point-to-Point Protocol)
* High-level Data Link Control (HDLC): A legacy technology, but it may still be used in some networks today.


## Physical Layer

![physical layer](http://mycomsats.com/wp-content/uploads/2012/05/image81.png)

The physical layer represents any medium—be it air, copper, glass, vacuum—that is used to transmit data over the given medium.
In the context of the OSI model, the physical layer receives frames from the data link layer and converts them into signals; ones and zeros to
be transmitted over the chosen medium.

In summary, the goals of a physical layer protocol are to specify the following:

* The medium of transmission
* The physical manifestation of energy for transmission (e.g., light)
* The channel characteristics (half duplex, full duplex, serial, parallel)
* The methods for error recovery
* The timing for synchronization
* The range of transmission
* The energy levels used for transmission



## What a package looks like

IP Package
* Version: IPv4 / IPv6
* IHL: Header length
* Type of service:
* Total length:
* Data: 64kb max

{% highlight bash %}
  .-------+-------+---------------+-------------------------------.
  |Version|  IHL  |Type of Service|          Total Length         |
  |-------+-------+---------------+-------------------------------|
  |         Identification        |Flags|      Fragment Offset    |
  |---------------+---------------+-------------------------------|
  |  Time to Live |    Protocol   |         Header Checksum       |
  |---------------+---------------+-------------------------------|
  |                       Source Address                          |
  |---------------------------------------------------------------|
  |                    Destination Address                        |
  |---------------------------------------------------------------|
  |                       Options (if any)                        |
  |---------------------------------------------------------------|
  |                    Data (can be TCP package)                  |
  `---------------------------------------------------------------'
{% endhighlight %}



TCP Package

{% highlight bash %}
  .-------------------------------+-------------------------------.
  |          Source Port          |       Destination Port        |
  |-------------------------------+-------------------------------|
  |                        Sequence Number                        |
  |---------------------------------------------------------------|
  |                    Acknowledgment Number                      |
  |-------------------+-+-+-+-+-+-+-------------------------------|
  |  Data |           |U|A|P|R|S|F|                               |
  | Offset| Reserved  |R|C|S|S|Y|I|            Window             |
  |       |           |G|K|H|T|N|N|                               |
  |-------+-----------+-+-+-+-+-+-+-------------------------------|
  |           Checksum            |         Urgent Pointer        |
  `---------------------------------------------------------------'
{% endhighlight %}
