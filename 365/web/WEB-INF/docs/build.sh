#!/bin/sh

git clone http://github.com/zople/365Project.git

sudo -u builder dropdb 365DB
sudo -u builder createdb 365DB

sudo -u builder psql 365DB < infile
#psql -h localhost -p 5432 -U postgres -W abcde postgres

cd 365Project

ant

copy ~/365Project/dist/Core.ear /usr/local/jboss/jboss-as-7.1.1.Final/standalone/deployments
