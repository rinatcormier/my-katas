FROM java:9-b149-jdk

ENV OPENLIBERTY_VERSION 20.0.0.1
ENV PG_JDBC_VERSION 9.4-1201-jdbc41

RUN wget https://repo1.maven.org/maven2/io/openliberty/openliberty-runtime/${OPENLIBERTY_VERSION}/openliberty-runtime-${OPENLIBERTY_VERSION}.zip \
    && unzip openliberty-runtime-${OPENLIBERTY_VERSION}.zip -d /opt \
    && rm openliberty-runtime-${OPENLIBERTY_VERSION}.zip

RUN wget https://repo1.maven.org/maven2/org/postgresql/postgresql/9.4-1201-jdbc41/postgresql-${PG_JDBC_VERSION}.jar \
    && cp postgresql-${PG_JDBC_VERSION}.jar /opt/wlp/lib/ \
    && rm postgresql-${PG_JDBC_VERSION}.jar

ENV DEPLOYMENT_DIR /opt/wlp/usr/servers/defaultServer/dropins/
ENV CONFIG_DIR /opt/wlp/usr/servers/defaultServer/

COPY server.xml $CONFIG_DIR

CMD ["/opt/wlp/bin/server", "run", "defaultServer"]
