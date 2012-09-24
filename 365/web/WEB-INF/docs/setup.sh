#!/bin/sh

git config --global user.name "builder"

git config --global user.email "builder@zmcloud.com"

sudo -u builder postgres -D /home/builder/data &

sh $JBOSS_HOME/bin/standalone.sh &
