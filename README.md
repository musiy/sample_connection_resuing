### About
Sample application that helps to reveal the concept of connection pooling.<br>
The primary goal of connection pooling is ability to reuse connection that
was created at first usage for the following requests.<br>
Such reusing allows us to get rid of unnecessary initial TCP round trip.<br>
Sample application allows query resources in two modes - with connection pooling
and without connection pooling (see _reuse_ param). It makes ten request
to specified resource and prints the time of each request and overall time for all requests.

### Usage
java -jar app.jar -u _schema://host:port/resource_ -reuse (true|false)

### Results of running without connection reusing
% java -jar req.jar -u http://github.com -r false<br>
Staring with http://github.com<br>
req time: 500<br>
req time: 335<br>
req time: 335<br>
req time: 356<br>
req time: 348<br>
req time: 348<br>
req time: 332<br>
req time: 340<br>
req time: 334<br>
req time: 355<br>
Total time of all requests: 3588<br>

### Results of running with connection reusing
% java -jar req.jar -u http://github.com -r true<br>
Staring with http://github.com<br>
req time: 428<br>
req time: 101<br>
req time: 102<br>
req time: 107<br>
req time: 103<br>
req time: 106<br>
req time: 106<br>
req time: 108<br>
req time: 107<br>
req time: 104<br>
Total time of all requests: 1375<br>

### Building
JDK 11 or higher is required to compile and run code.<br>
To get uber-jar use _mvn package_.

