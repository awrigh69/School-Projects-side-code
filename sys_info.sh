#!/bin/bash
#
# Lab Assignment #6
#
# Your name:
# 
# By turning in this code, I Pledge:
# That I have completed the programming assignment independently.
# I have not copied the code from a student or any source.
# I have not given my code to any study.


report_sys_uptime() {
    echo -e "       Current System Uptime\n"
    uptime
    echo
}

report_disk_space() {
    echo -e "       Current Disk Usage\n"
    df -h
    echo
}

report_home_space() {
    echo -e "       Home Directory Usage for $USER\n"
    du -sh "$HOME"
    echo
}


report_sys_uptime
report_disk_space
report_home_space
