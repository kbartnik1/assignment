FROM jenkins/jenkins
USER root
# COPY . /var/jenkins_home/workspace/gabi
# COPY jenkins_builds/config.xml /var/jenkins_home/workspace/jobs/gabi/config.xml
COPY . /var/jenkins_home/jobs/gabi/workspace/
COPY jenkins_builds/config.xml /var/jenkins_home/jobs/gabi/config.xml
RUN apt-get update && apt-get install libxss1 -y
RUN apt-get install libappindicator1 -y
RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN dpkg -i google-chrome*.deb; apt-get -fy install
RUN /usr/local/bin/install-plugins.sh thucydides 
# Install x11vnc.
RUN apt-get install -y x11vnc
# Install xvfb.
RUN apt-get install -y xvfb
# Install fluxbox.
RUN apt-get install -y fluxbox
# Install wget.
RUN apt-get install -y wget
# Install wmctrl.
RUN apt-get install -y wmctrl
RUN apt-get install -y maven
