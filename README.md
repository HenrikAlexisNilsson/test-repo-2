# Vulnerable App

This project is for demonstrating and implementing solutions for the problems described in the talk [10 mistakes hackers want you to make](https://www.youtube.com/watch?v=0jFAGmEVT7Y).

### Mistake 1: Using dependencies with known vulnerabilities
Running an application that has dependencies which contains vulnerabilities might open up your application to hackers. An example of this is the data breach of Equifax hack where hackers came over credit reporting of 143 milion Americans.

The solution is to continously scan your application for out-of-date dependencies. Which can be made by running:
```sh
$ mvn versions:display-dependency-updates
```
This will give you a list of dependencies which has newer versions available.

You can also generate a HTML page with the same information using:
```sh
$ mvn site -DgenerateReports=false
$ mvn versions:dependency-updates-report
```
The resulting HTML file will be located in target/dependency-updates-report.html.

The best way would be to continuously scan your project for vulnerabilities. This can be done by using a service called [Snyk](https://snyk.io). This works by connecting your repo to Snyk and when a new vulnerability is detected they will automatically create a pull request with fixes for those vulnerabilities which you can then review and merge.

### Mistake 2: Unsanitized user input
Not yet implemented.

### Mistake 3: Unsafe regex
Unsafe regex also called Regular expression Denial of Service (ReDoS) is a Denial of Service attack, that exploits the fact that most Regular Expression implementations may reach extreme situations that cause them to work very slowly (exponentially related to input size). An attacker can then cause a program using a Regular Expression to enter these extreme situations and then hang for a very long time.

You can see an example of this by doing a request to http://localhost:8090/regex/validate-email?email=aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa!. This request will take a very long time to finish and by doing 10 of those request simultaneous the whole server will be unresponsive.

To mitigate this you can use [saferegex](https://github.com/jkutner/saferegex) to test your regular expression for the ReDoS vulnerability.
```sh
$ git clone https://github.com/jkutner/saferegex
$ cd saferegex
$ mvn package -DskipTests
$ java -jar target/saferegex-1.0.1-SNAPSHOT.jar "ENTER-YOUR-REGEX-HERE"
```

### Mistake 4: Failure to prevent abusive requests
Some malicious users might send a lot of requests to your services to try to find exploits. To prevent these behaviours (or atleast make it harder and more time consuming) we can block these requests when they reach a certain threshold. One type of attacks that this can be used agains is bruteforce attacks where a malicious user tries to bruteforce login passwords.

In Java applications we can use a tool called bucket4j to solve this problem. By using bucket4j you can configure how many requests are allowed in a certain timeframe for a certain endpoint. You can try this out by sending 6 requests to the endpoint http://localhost:8090/rate-limiter/current-date. The first 5 requests will go through without a problem, but the sixth request will throw an error saying that too many requests have been made.

### Mistake 5: Misconfiguring spring-security
Not yet implemented.

### Mistake 6: Secrets in your source code
Not yet implemented.

### Mistake 7: Allowing http requests
Not yet implemented.

### Mistake 8: Disabling certificate checking
Not yet implemented.

### Mistake 9: Lack of intrusion detection
Not yet implemented.

### Mistake 10: YOU!
Human error where you are not using two factor authentication, leaving your laptop unlocked and reusing passwords.

## Usage
Run the spring-boot application:
```sh
$ mvn spring-boot:run
```

You should now be able to navigate to http://localhost:8090 to view the index page.

## License
MIT License

Copyright (c) 2019 Henrik

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.