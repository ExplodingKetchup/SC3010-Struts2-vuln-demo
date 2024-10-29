# Use a base image with Java 8 and Tomcat installed
FROM tomcat:8.5-jdk8

# Set the working directory to Tomcat's webapps directory
WORKDIR /usr/local/tomcat/webapps/

# Copy the Struts app's WAR file into the Tomcat webapps directory
# Replace `your-app.war` with the name of your .war file
COPY target/struts-vuln-demo-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/

# Expose port 8080 to allow access to the Tomcat server
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]