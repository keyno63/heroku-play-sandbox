# heroku-play-sandbox

heroku に play-scala をデプロイするのに確認するようのレポジトリです

## Usage

### build

```shell
sbt compile
```

### test

```shell
sbt test
```

but, test is not implemented yet.

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
- 起動に必要な設定
  - application.conf に以下を追加する場合
    - play.filters.hosts.allowed
  - heroku 側に設定をする場合
    - Procfile にオプションを追加
      `-Dplay.filters.hosts.allowed=$ALLOW_HOST`
    - `https://dashboard.heroku.com/apps/<app_name>/settings` に設定を追加
  - secret key の設定 
    - application.conf に以下を追加する場合
      - play.http.secret.key
    - heroku 側に設定をする場合
      - Procfile にオプションを追加
        `-Dplay.http.secret.key=$SERCRET_KEY`
      - `https://dashboard.heroku.com/apps/<app_name>/settings` に設定を追加
  
- `sbt stage deployHeroku` コマンドでデプロイを実行

## LICENSE

This repository is Apache2 License.  
see [License](./LICENSE) file.
