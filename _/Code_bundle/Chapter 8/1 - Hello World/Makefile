# This Makefile automates the building of the project using gradle. It also has functionality for sending the code to the EV3 and running it on it using an SSH connection

NAME=LineFollower

BT_ADDR=XX:XX:XX:XX:XX:XX			# Replace with bluetooth address of your EV3
PAN_IP_ADDR=10.0.1.2


SRC=$(wildcard src/*.java) $(wildcard src/*/*.java)
JAR=build/libs/$(NAME).jar

DEST=/home/lejos/programs


.PHONY: default, build, run, connect, disconnect


default: build

build: $(JAR)

$(JAR):	$(SRC) build.gradle

	gradle build		
	touch $(JAR)


sync: $(JAR)

	scp $(JAR) ev3:$(DEST)
	touch sync


run: sync

	ssh ev3 "cd $(DEST) && jrun -jar $(NAME).jar"


connect:
	
	sudo pand --connect $(BT_ADDR) -n
	sudo ifconfig bnep0 $(PAN_IP_ADDR)


disconnect:

	sudo pand -K
