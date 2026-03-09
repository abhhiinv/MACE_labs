# Example ~/.bash_logout
echo "Goodbye, $USER — $(date)" >> ~/.session_log
history -a       # Append current session history to history file
clear            # Clear terminal screen on logout