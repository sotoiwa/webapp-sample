FROM websphere-liberty:19.0.0.6-webProfile8
USER 0
RUN apt-get update \
    && DEBIAN_FRONTEND=noninteractive apt-get install -y vim-tiny \
    && rm -rf /var/lib/apt/lists/*
USER 1001

COPY --chown=1001:0 server.xml /config/

COPY --chown=1001:0 mysql-*.jar /config/resources/mysql/
COPY --chown=1001:0 sample.war /config/apps/

RUN installUtility install --acceptLicense defaultServer
