FROM tomcat:9.0.65
EXPOSE 8080
COPY ./target/JavarushProject3.war /usr/local/tomcat/webapps
