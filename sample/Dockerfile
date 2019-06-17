FROM websphere-liberty:19.0.0.3-webProfile8
USER 0
RUN apt-get update \
    && DEBIAN_FRONTEND=noninteractive apt-get install -y vim-tiny \
    && rm -rf /var/lib/apt/lists/*
USER 1001

COPY --chown=1001:0 server.xml /config/
RUN installUtility install --acceptLicense defaultServer
COPY --chown=1001:0 mysql-*.jar /config/resources/mysql/
COPY --chown=1001:0 sample.war /config/apps/

COPY --from=hazelcast/hazelcast --chown=1001:0 /opt/hazelcast/lib/*.jar /opt/ibm/wlp/usr/shared/resources/hazelcast/

COPY --chown=1001:0 hazelcast-sessioncache.xml /config/configDropins/overrides/
COPY --chown=1001:0 hazelcast.xml /opt/ibm/wlp/usr/share/config/hazelcast/
