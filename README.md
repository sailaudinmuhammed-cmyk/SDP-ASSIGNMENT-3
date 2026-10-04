# Assignment 3 - Bridge Pattern

Name: DINMUKHAMMED  
Surname: SAILAU  
Group: SE-2530  
Topic: B - Notifications  
Repository: <YOUR GITHUB URL>  
Base commit: afc9d76  

## Description

This project demonstrates the Bridge design pattern using a notification system.

The abstraction side contains:
- Notification
- Reminder
- UrgentAlert

The implementation side contains:
- MesseageChannel
- EmailChannel
- SMSChannel
- PushChannel

Notification stores a MesseageChannel reference. This reference connects the abstraction and implementation hierarchies.

## Expected checks

T1 - Reminder + EmailChannel  
T2 - Reminder + SMSChannel  
T3 - UrgentAlert + EmailChannel  
T4 - UrgentAlert + SMSChannel  
T5 - Switch EmailChannel to SMSChannel on the same Reminder object  
T6 - Reminder + PushChannel  
T7 - UrgentAlert + PushChannel  

Expected summary:

SUMMARY: 7/7 PASS

## Extension

The working I1/I2 version was committed as:

afc9d76

After that, PushChannel was added as I3.

The existing abstraction classes, interface, EmailChannel and SMSChannel were not changed.

The extension is shown in:

extension.diff
