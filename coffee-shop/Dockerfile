FROM markhunt/my-openliberty:1

ENV JVM_ARGS="-Xmx512M"

COPY config $CONFIG_DIR/config
COPY target/coffee-shop.war $DEPLOYMENT_DIR
