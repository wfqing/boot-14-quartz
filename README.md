# spring boot练习

## 1. gitk --all

## 2. git branch -va
`显示所有分支，包括拉下来远程分支`

## 3. git pull origin master
由两个命令组成
```
# 将远程仓库拉到本地仓库作为远程分支:remotes/origin/master
git fetch origin master

# 切回本地master分支，合并远程master分支
git merge origin/master
```

## 4. git revert
```
撤销某个commit
```

## 5. 更新fork到的他人的代码

### 5.1 查看远程分支

```bash
Administrator@DESKTOP-2K4KUED MINGW64 /d/luxile/boot-house (master)
$ git remote -v
origin  git@github.com:vincentlxl/boot-house.git (fetch)
origin  git@github.com:vincentlxl/boot-house.git (push)
```

### 5.2 添加原作者的远程分支

```bash
Administrator@DESKTOP-2K4KUED MINGW64 /d/luxile/boot-house (master)
$ git remote add luxilejn git@github.com:luxilejn/boot-house.git
```

### 5.3 再次查看远程分支

```bash
Administrator@DESKTOP-2K4KUED MINGW64 /d/luxile/boot-house (master)
$ git remote -v
luxilejn        git@github.com:luxilejn/boot-house.git (fetch)
luxilejn        git@github.com:luxilejn/boot-house.git (push)
origin  git@github.com:vincentlxl/boot-house.git (fetch)
origin  git@github.com:vincentlxl/boot-house.git (push)
```

### 5.4 拉取原作者更新的代码

```
Administrator@DESKTOP-2K4KUED MINGW64 /d/luxile/boot-house (master)
$ git fetch luxilejn
remote: Enumerating objects: 8, done.
remote: Counting objects: 100% (8/8), done.
remote: Compressing objects: 100% (2/2), done.
remote: Total 4 (delta 2), reused 3 (delta 2), pack-reused 0
Unpacking objects: 100% (4/4), 925 bytes | 26.00 KiB/s, done.
From github.com:luxilejn/boot-house

 * [new branch]      master     -> luxilejn/master
```

### 5.5 合并原作者更新的代码到自己的master分支

```
Administrator@DESKTOP-2K4KUED MINGW64 /d/luxile/boot-house (master)
$ git merge luxilejn/master
Updating fc35cd5..3a0e490
Fast-forward
 README.md | 1 +
 1 file changed, 1 insertion(+)
```

### 5.6 如果有冲突，解决冲突即可







