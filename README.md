# api-location-spring

## 動作確認
### 緯度経度(id=1)の登録
```
curl -XPOST -H "Content-Type: application/json"  http://localhost:8080/v1/api/location -d'{"id":1,"latitude":"35.71124100000004","longitude":"139.794231"}'
```

### 緯度経度(id=1)の上書き
```
curl -XPOST -H "Content-Type: application/json"  http://localhost:8080/v1/api/location -d'{"id":1,"latitude":"35.71124100000004","longitude":"139.794231"}'
```


### 指定の緯度経度から半径1000m以内の登録idのリストを取得
```
curl -XGET "http://localhost:8080/v1/api/location?latitude=35.71124100000004&longitude=139.794231&rangem=1000"
```

