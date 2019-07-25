# ToDo-List-Application
チームラボのインターンシップ事前課題の Spring Boot を用いた ToDo List アプリケーションです.

## 使用した技術要素
使用フレームワーク : Spring Boot (Ver 2.1.6)
JPA, Thymeleaf, MySQL, Web, DevTools を dependencies として指定.

## 全体の構成・設計
Spring Boot や java に関する知識が不足していたため, YouTube https://www.youtube.com/watch?v=qZs0885Mdm0 をもとにアプリケーションを作成しました.
MVC モデルに基づいて作成しており, コントローラでユーザからの処理を受け付け, その処理をモデルに渡して行います. ビューで処理結果の表示を行なっています.
レイヤは main, controller, service, service implements, repository, model, view で分けました.
main レイヤではアプリケーションの実行を, controller レイヤではユーザからのリクエストを受け付けます.  service レイヤでは扱うメソッドの宣言を, service implements レイヤでは service レイヤ内で宣言したメソッドの処理内容を記述しています. repository レイヤでは JPA にて用意されているデータの CRUD に必要なメソッドを使用できるように extends CrudRepository を行なっています. model レイヤでは主にデータの格納を, view レイヤでは html を用いて表示する画面の作成を行なっています.

また, ToDo の検索メソッドを期限内に作成できませんでした. さらに ToDo を登録する画面はあるのですが, save しようとすると以下のようなエラーが発生し, データベースへの登録ができていない状況です. 
```
This application has no explicit mapping for /error, so you are seeing this as a fallback.

Fri Jul 26 01:00:03 JST 2019
There was an unexpected error (type=Bad Request, status=400).
Failed to convert value of type 'java.lang.String' to required type 'com.example.ToDoList.model.ToDo'; nested exception is org.springframework.core.convert.ConversionFailedException: Failed to convert from type [java.lang.String] to type [java.lang.Long] for value 'abc'; nested exception is java.lang.NumberFormatException: For input string:"abc"
```

トップ画面では ToDo の作成, 現在ある ToDo の表示がされるようになっています. また, トップ画面の現在ある ToDo の横の鉛筆のボタンを押すと, ToDo の編集画面へ遷移し, 情報をアップデートできるようになっています. さらにトップ画面の現在ある ToDo の横のゴミ箱のボタンを押すと ToDo の削除ができるようになっています.

## 開発環境のセットアップ手順
java 12.0.1 がインストールされた状況で STS を使用しました.
STS にて file -> new -> spring starter project で spring initilizr を用いて上記の dependencies を設定し, プルダウンには gradle を選択し開発を行いました. 

