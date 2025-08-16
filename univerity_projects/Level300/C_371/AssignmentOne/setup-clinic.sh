#!/bin/bash

#make WellingtonClinic directory
mkdir -p WellingtonClinic
mkdir -p WellingtonClinic/patients

#make administrator
useradd -g sudo -m -s /bin/bash administrator
echo 'administrator:vicunicybr' | chpasswd

#making groups
groupadd Doctor
groupadd Nurse

#making Doctors
useradd -g Doctor -m -s /bin/bash drloun
useradd -g Doctor -m -s /bin/bash drstethosc
echo 'drloun:vicunicybr' | chpasswd
echo 'drstethosc:vicunicybr' | chpasswd

#making Nurses
useradd -g Nurse -m -s /bin/bash drbeas
useradd -g Nurse -m -s /bin/bash philip
echo 'drbeas:vicunicybr' | chpasswd
echo 'philip:vicunicybr' | chpasswd

#set permissions for main dir
chown administrator:sudo WellingtonClinic
chmod 771 WellingtonClinic

#set permissions for patient dir
chown administrator:Doctor WellingtonClinic/patients
chmod 770 WellingtonClinic/patients

#set permissions on scripts
chown administrator:Doctor register-patient.sh
chmod 750 register-patient.sh

chown administrator:sudo check-medication.sh
chmod 770 check-medication.sh

chown administrator:sudo setup-clinic.sh
chmod 770 setup-clinic.sh

#allow nurse to be sudo for med script and set perms
echo '%Nurse ALL=(ALL) NOPASSWD: /opt/check-medication.sh' > /etc/sudoers.d/sudonurse
