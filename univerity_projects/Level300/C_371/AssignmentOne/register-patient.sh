#!/bin/bash

#output prompt
echo "Enter Patient Information:"
echo -n "First name: "
read FirstN
echo -n "Last name: "
read LastN
echo -n "Year of birth: "
read YearofBirth
echo -n "Specify a doctors (~primary,#secondary): "
read doctor

#check patient isnt doctor or nurse
name=("Lou Ngevity" "Stethos Cope" "Bea Shure" "Phil Paine")
#iterate through list
for n in "${name[@]}"; do
        #split the names
	read -r first last <<< "$n"
        if [ "$FirstN" = "$first" ] && [ "$LastN" = "$last" ]; then
                echo "Cannot add Doctors/Nurse as patients"
                exit 1
        fi
done

#check doctor is a doctor
d=$(echo "$doctor" | tr -d '~#'  | tr ',' ' ')
read -r -a specifiedDoc <<< "$d"

for doc in "${specifiedDoc[@]}"; do
	#check doctor is part of doctor group
	if groups "$doc" | grep -q "\<Doctor\>"; then
		echo "Doctors are doctors"
	else
		echo "Doctors are not doctors"
		exit 1
	fi
done

#create filename
filename="WellingtonClinic/patients/${FirstN}${LastN}${YearofBirth}.txt"

if [ -f "$filename" ]; then
	echo "Patient already exists"
	exit 1
fi

#rego date
regodate=$(date +"%d/%m/%Y")

#add patient information to file and set perms
echo "$FirstN,$LastN,$YearofBirth,$regodate,$doctor" > $filename
chmod 600 "$filename"

#set assigned doctor perms
if [[ ! -z "$doctor" ]]; then
	getSecondDoctor=$(echo "$doctor" | sed 's/~[^#]*//')
	getSecondDoctor=$(echo "$getSecondDoctor" | tr -d '#' | tr ',' ' ')
	for getDocUsername in $getSecondDoctor
	do
		setfacl -m u:"$getDocUsername":rw "$filename"
	done
fi

echo "File created at $filename"
