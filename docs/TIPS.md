# PosgreSQLの停止

1. PowerShellを起動
2. 次のコマンドを実行
    - `pg_ctl stop`

# サンプル作成方法

1. PowerShellを起動
2. 次のコマンドを実行してカレントディレクトリを移動する
    - `cd C:\home\developer\workspace`
3. サンプル作成コマンド(※.1)を実行
4. Eclipseでインポート
    - 「ファイル」->「インポート」
    - 「Maven」->「既存 Mavenプロジェクト」
    - 「次へ」
    - ルートディレクトリーの「参照」でC:\home\developer\workspace\todoを選択
    - 「完了」

※.1 サンプル作成コマンド

```
mvn archetype:generate -B `
 -DarchetypeGroupId="org.terasoluna.gfw.blank" `
 -DarchetypeArtifactId="terasoluna-gfw-multi-web-blank-mybatis3-archetype" `
 -DarchetypeVersion="5.7.0.RELEASE" `
 -DgroupId="com.example.todo" `
 -DartifactId="todo" `
 -Dversion="1.0.0-SNAPSHOT"
```