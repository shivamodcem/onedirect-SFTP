FROM tomcat:9.0.2-jre8-alpine
MAINTAINER shivam.chaudhary@getonedirect.com
RUN ln -snf /usr/share/zoneinfo/Asia/Kolkata /etc/localtime
ENV JAVA_OPTS="-Duser.timezone=IST"

COPY sftpapi.war /usr/local/tomcat/webapps/

CMD ["catalina.sh", "run"]
