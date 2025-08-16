#!/bin/bash

#make sure can only be executed by root/sudo
chmod 770 setup-cybr371.sh

#create group
groupadd lecturer
groupadd tutor
groupadd student

#add lecturer
useradd -m -s /bin/bash arman
useradd -m -s /bin/bash mohammad
echo 'arman:vicunilect' | chpasswd
echo 'mohammad:vicunilect' | chpasswd
usermod -a -G lecturer arman
usermod -a -G lecturer mohammad

#add tutor
useradd -m -s /bin/bash ilona
useradd -m -s /bin/bash esther
useradd -m -s /bin/bash immaculata
echo 'ilona:vicunitut' | chpasswd
echo 'esther:vicunitut' | chpasswd
echo 'immaculata:vicunitut' | chpasswd
usermod -a -G tutor ilona
usermod -a -G tutor esther
usermod -a -G tutor immaculata

#adding students (maybe change to i for)
for ((i=0; i<=93; i++))
do
	student_number=$(printf "student%03d" $i)
	useradd -m -s /bin/bash $student_number
	echo "$student_number:cybr371pass" | sudo chpasswd
	usermod -a -G student $student_number
done

#create cybr directory
mkdir -p cybr371
chown root:lecturer cybr371
chmod 775 cybr371

#make grade xlsx file
touch cybr371/grades.xlsx
chown root:lecturer cybr371/grades.xlsx
chmod 760 cybr371/grades.xlsx
setfacl -R -m g:tutor:rw cybr371/grades.xlsx

#create question and solutions pdf
for dir in final midterm assignment1 assignment2 lab1 lab2 lab3 lab4 lab5
do
	mkdir -p cybr371/$dir
	chown root:lecturer cybr371/$dir
	chmod 775 cybr371/$dir

	touch cybr371/$dir/questions.pdf
	touch cybr371/$dir/solutions.pdf
	chown root:lecturer cybr371/$dir/questions.pdf
	chown root:lecturer cybr371/$dir/solutions.pdf
	chmod 764 cybr371/$dir/questions.pdf
	chmod 760 cybr371/$dir/solutions.pdf

	setfacl -R -m g:tutor:r cybr371/$dir/solutions.pdf
done

#create student directories
for ((i=0; i<=93; i++))
do
	student_number=$(printf "student%03d" $i)
	#loop through each directory
	for dir in final midterm assignment1 assignment2 lab1 lab2 lab3 lab4 lab5
	do
		mkdir -p cybr371/$dir/$student_number
		chown root:$student_number cybr371/$dir/$student_number
		chmod 770 cybr371/$dir/$student_number
		setfacl -R -m g:lecturer:rx cybr371/$dir/$student_number
		setfacl -R -m g:tutor:rx cybr371/$dir/$student_number

		touch cybr371/$dir/$student_number/answers.docx
		chown $student_number:$student_number cybr371/$dir/$student_number/answers.docx
		chmod 664 cybr371/$dir/$student_number/answers.docx
	done
done
