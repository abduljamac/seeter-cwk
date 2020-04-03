# Module Title: Software Engineering Practice

## Assignment Title: Coursework 1 & 2

### Scenario 

Your team is developing Seeter, a very simple text-based tweeter application for in-house use by your organisation. The intent is to provide a lightweight messaging library that can be quickly integrated into other development projects, e.g., by running it from shell scripts, embedding it into other applications, and so on.   

Seeter uses a basic client-server architecture.  The server records a database of topics, and a list of seet messages published to each topic so far.  A seet contains just the username of the author, and a short line of text as the message body.  Clients connected to the server can fetch the existing seets for a topic, and publish new seets. Your teammates have developed the Server in Java and, notably, message classes for the client-server communication. 

They have specified the concepts mentioned above (topic, seet, etc.) in more detail in the Javadoc of this base framework – see the Javadoc for the sep.seeter.server package, and also the message classes. To test the server, they also wrote a makeshift Client in Java.  This Client supports some basic functionality, but it is buggy, incomplete and lacking any real design.  Instructions on running the Client can be found in the Javadoc of the sep.seeter.client.Client class. Ultimately, your organisation requires this prototype Client to be refactored and redesigned according to the following Specification.  

