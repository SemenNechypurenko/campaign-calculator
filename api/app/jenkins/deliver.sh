#!/bin/bash

scp "$rpmArchivePath" "$yumRepo"
rm -f `repomanage --keep=${yumKeep} --old ${yumRepo}`
createrepo -q "${yumRepo}";
ssh root@${server} sudo yum clean all
ssh root@${server} sudo yum -y install $rpmName