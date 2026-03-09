# ~/.bash_profile
export PATH="$HOME/bin:$PATH"
export EDITOR="nano"
alias ll="ls -la --color=auto"
echo "Welcome, $USER! Today is $(date +%A)."
[ -f ~/.bashrc ] && source ~/.bashrc   # Source .bashrc if present