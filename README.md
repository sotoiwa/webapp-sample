# webapp-sample [![Build Status](https://travis-ci.com/sotoiwa/webapp-sample.svg?branch=master)](https://travis-ci.com/sotoiwa/webapp-sample)

## Eclipseのセットアップ

1. Eclipseを起動し、git cloneしたフォルダをワークスペースとして指定する。
1. Window > Preference > General > Workspaceを開き、エンコードを`UTF-8`、改行を`Unix`にする。
1. Existing Maven Projectsとしてインポートする。
1. プロジェクトの設定でコードフォーマッタとしてGoogleスタイルをインポートする。
1. プロジェクトの設定でXMLのフォーマッタでタブではなく半角スペース2つを指定する。

## 手動ビルド

```shell
mkdir -p build
cd sample
mvn clean package
cd ../build/
cp ../sample/Dockerfile .
cp ../sample/target/sample.war .
cp ../sample/target/liberty/wlp/usr/servers/defaultServer/server.xml .
cp ../sample/target/liberty/wlp/usr/shared/resources/mysql-*.jar .
docker build -t sample:1.0 .
cd ../
rm -rf build
```
