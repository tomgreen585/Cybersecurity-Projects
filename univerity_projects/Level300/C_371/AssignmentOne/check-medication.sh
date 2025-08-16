#!/bin/bash

#output prompt
echo "Enter what Patient File you want to Access"
echo -n "First Name: "
read FirstN
echo -n "Last Name: "
read LastN
echo -n "Year of Birth: "
read YearofBirth

filename="WellingtonClinic/patients/${FirstN}${LastN}${YearofBirth}.txt"

if [[ ! -f "$filename" ]]; then
  echo "File not Found."
  exit 1
fi

#read info in file
primary=$(head -n 1 "$filename" | cut -d ',' -f 5 | sed 's/~//g')
secondary=$(head -n 1 "$filename" | cut -d ',' -f 6 | sed 's/#//g' | tr ',' ' ')

# Convert primary doctor
case $primary in
    "drloun") primary="Dr Lou Ngevity" ;;
    "drstethosc") primary="Dr Stethos Cope" ;;
esac

# Convert secondary doctors
second=""
for doctor in $secondary; do
    case $doctor in
        "drloun") doctor="Dr Lou Ngevity" ;;
        "drstethosc") doctor="Dr Stethos Cope" ;;
	esac
    second+="$doctor, "
done
second=${second%, *} # Remove the trailing comma and space

#top info
echo "Patient             Primary Doctor           Secondary Doctor"
echo "${FirstN} ${LastN}        ${primary}           ${second}"
echo ' '

#bottom info
echo "Date of Visit 	     Attended Doctor 	  Medication  	       Dosage"
awk -F ',' 'NR>2{printf "%-20s %-20s %-20s %-20s\n", $1, $2, $4, $5}' "$filename"
