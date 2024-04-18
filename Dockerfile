FROM alpine:latest

ENV WILDFLY_VERSION 31.0.1.Final

COPY wildfly-31.0.1.Final.tar.gz /opt/

RUN set -x \
    apk add --update && \
    apk add curl tar openjdk11 curl && \
    addgroup -g 101 -S wildfly && \
    adduser -S -D -H -u 101 -h /opt/wildfly -s /sbin/nologin -G wildfly -g wildfly wildfly && \
    cd /opt/ && \
    tar -zxvf wildfly-$WILDFLY_VERSION.tar.gz && \
    mv wildfly-$WILDFLY_VERSION wildfly
RUN chown -R wildfly:wildfly /opt/wildfly
RUN rm -rf /tmp/* /var/cache/apk/*
RUN rm -rf /opt/wildfly-$WILDFLY_VERSION.tar.gz

COPY build/libs/*.war /opt/wildfly/standalone/deployments/

EXPOSE 8080 9990
USER wildfly
WORKDIR /opt/wildfly/
CMD ["/opt/wildfly/bin/standalone.sh", "-c", "standalone-full.xml", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]docker build -t