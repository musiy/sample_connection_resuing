### About
Sample application that helps to reveal the concept of connection pooling.<br>
The primary goal of connection pooling is ability to reuse connection that
was created at first usage for the following requests.<br>
Such reusing allows us to get rid of unnecessary initial TCP round trip.<br>
Sample application allows query resources in two modes - with connection pooling
and without connection pooling (see _reuseConnection_ param). It makes 10 request
to specified resource and prints the time of each request and overall time for all requests.

### Usage
java -Durl=https://github.com/ -DreuseConnection=false -jar app.jar

### Results of running with connection reusing
Staring with https://github.com/ <br>
req time: 495<br>
req time: 97<br>
req time: 62<br>
req time: 59<br>
req time: 59<br>
req time: 65<br>
req time: 56<br>
req time: 54<br>
req time: 61<br>
req time: 58<br>
Total time of all requests: 1068<br>

### Results of running without connection reusing
Staring with https://github.com/ <br>
req time: 418<br>
req time: 330<br>
req time: 336<br>
req time: 346<br>
req time: 339<br>
req time: 340<br>
req time: 330<br>
req time: 337<br>
req time: 336<br>
req time: 334<br>
Total time of all requests: 3447<br>

### P.S.
Do not ask why I used spring or even spring-cloud it this sample.. There is no answer.
