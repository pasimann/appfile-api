# appfile-api

Simple Spring boot application, which tests task scheduling (consuming store); receives string items via REST API calls, and stores them; then consumes string items in a separate scheduled task loop.

#  git basic stuff

```
# clone repo
$ git clone https://github.com/pasimann/appfile-api.git
# change local branch
$ git checkout develop
# show local branches
$ git branch
# checkout to a new branch
$ git checkout -b new-feature
# show remote status vs. local
$ git remote show origin
# show local status
$ git status
# add to stage
$ git add file.txt
# commit
$ git commit -m "Implemented stuff."
# show changes
$ git diff
```
# git undo, rebase, merge
```
# oops, undo last commit and edit it
$ git reset --soft HEAD~1
# oops, permanently delete the last commit
$ git reset --hard HEAD~1
# push changes to remote server
$ git push origin develop:develop
# oops, last commit was bad, but already pushed to remote
$ git revert [commit-id]
# if multiple commits, must be done for each; in reverse order
# create a new commit cancelling previous changes and push to remote
# reverting is fast-forwardable unlike hard reset
# rebase changes from main branch
$ git fetch origin master:master
$ git rebase master
# merge feature branch
$ git checkout master
$ git merge feature
# cherry pick bug fix to branch (master)
$ git checkout master
$ git cherry-pick b527699
```
# git misc stuff
```
# show commit log
$ git reflog
# show commit count by author
$ git shortlog -s -n --all --no-merges
# find text from files
$ find . -name \*.java -exec grep -l IOException {} \;
```