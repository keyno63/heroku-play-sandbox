# heroku-play-sandbox

heroku に play-scala をデプロイするのに確認するようのレポジトリです

## deploy

### localhost

普通に play を起動
```
$ sbt run
```

### heroku

事前準備  
heroku の [scala-play](https://devcenter.heroku.com/articles/deploying-scala-and-play-applications-with-the-heroku-sbt-plugin) を参考に設定  
※ 日本語ドキュメントは情報が古く、デプロイに失敗するので注意
- `plugins.sbt` に heroku plugin を追加
- `build.sbt` に heroku app 名を追加  
  `heroku create -n` した際に出力された値を設定します
- `build.sbt` に heroku JDK の指定をします  
  `Compile / herokuJdkVersion` で設定します
  ※ heroku 側の JDK runtime と sbt 実行時のローカル Java のバージョンが揃っているか確認しましょう  
  デフォルトでは JDK 8 になっています
- application.conf に以下を追加
  - play.filters.hosts.allowed
  - play.http.secret.key
- `sbt stage deployHeroku` コマンドでデプロイを実行
