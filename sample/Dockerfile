FROM websphere-liberty:19.0.0.3-javaee8
USER 0
RUN apt-get update \
    && DEBIAN_FRONTEND=noninteractive apt-get install -y vim-tiny \
    && rm -rf /var/lib/apt/lists/*
USER 1001

COPY --chown=1001:0 server.xml /config/

COPY --chown=1001:0 mysql-*.jar /config/resources/mysql/
COPY --chown=1001:0 sample.war /config/apps/

ENV JAVA_TOOL_OPTIONS="-Dhazelcast.jcache.provider.type=server ${JAVA_TOOL_OPTIONS}"
COPY --from="hazelcast/hazelcast:3.11.4" --chown=1001:0 /opt/hazelcast/lib/*.jar /opt/ibm/wlp/usr/shared/resources/hazelcast/
COPY --chown=1001:0 hazelcast-sessioncache.xml /config/configDropins/overrides/
COPY --chown=1001:0 hazelcast.xml /opt/ibm/wlp/usr/shared/config/hazelcast/

RUN installUtility install --acceptLicense defaultServer
