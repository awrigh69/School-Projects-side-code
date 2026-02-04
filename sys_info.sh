#!/bin/bash

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
