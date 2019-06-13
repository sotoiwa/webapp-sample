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

### Hazelcast Session Caching ###
# Copy the Hazelcast libraries from the Hazelcast Docker image
COPY --from=hazelcast/hazelcast --chown=1001:0 /opt/hazelcast/lib/*.jar /opt/ibm/wlp/usr/shared/resources/hazelcast/

# Instruct configure.sh to copy the client topology hazelcast.xml
#ARG HZ_SESSION_CACHE=client

# Instruct configure.sh to copy the embedded topology hazelcast.xml and set the required system property
ARG HZ_SESSION_CACHE=embedded
ENV JAVA_TOOL_OPTIONS="-Dhazelcast.jcache.provider.type=server ${JAVA_TOOL_OPTIONS}"

## This script will add the requested XML snippets and grow image to be fit-for-purpose
RUN configure.sh
