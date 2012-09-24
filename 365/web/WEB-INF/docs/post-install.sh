#!/bin/sh

echo "export JAVA_HOME=/usr/local/java/jdk1.6.0_35
export ANT_HOME=/usr/local/ant/apache-ant-1.8.4
JBOSS_HOME=/usr/local/jboss/jboss-as-7.1.1.Final
export PATH=/usr/local/java/jdk1.6.0_35/bin:/usr/local/ant/apache-ant-1.8.4/bin:$PATH
export CLASSPATH=.:/usr/local/java/jdk1.6.0_35/jre/lib/rt.jar:/usr/local/java/jdk1.6.0_35/lib/dt.jar:/usr/local/java/jdk1.6.0_35/lib/tools.jar">>/etc/profile

tar zxvf apache-ant-1.8.4-bin.tar.gz

yum -y install postgresql postgresql-server sudo unzip

unzip jboss-as-7.1.1.Final.zip

chmod u+x jdk-6u35-linux-x64.bin  

sh jdk-6u35-linux-x64.bin

# ant
mkdir /usr/local/ant

mv apache-ant-1.8.4 /usr/local/ant

# Postgresql
adduser -m -p 123456 builder
echo "postgres user's password"
createuser -d -a -P postgres

sudo -u builder initdb -D /home/builder/data

#sudo -u builder postgres -D /home/builder/data
# jdk
mkdir /usr/local/java

mv jdk1.6.0_35 /usr/local/java

# jboss
mkdir /usr/local/jboss

mv jboss-as-7.1.1.Final /usr/local/jboss

reboot
